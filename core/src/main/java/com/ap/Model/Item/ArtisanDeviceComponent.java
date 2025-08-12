package com.ap.Model.Item;

import com.ap.Main;
import com.ap.Model.Recipe;
import com.ap.View.Clock;

import java.util.*;

/**
 * Artisan device component that works with an ArrayList<Recipe>.
 * Each Recipe represents a possible OUTPUT for this device (itemId = outputId),
 * and its ingredients map contains { inputId -> count }. Category placeholders
 * use "cat:<categoryKey>" (e.g., "cat:any_fruit") and are satisfied ONLY by
 * items that carry that category (from ItemData.json).
 *
 * Timing uses the game's total hours: clock.getTotalHours().
 */
public class ArtisanDeviceComponent extends Component {

    public enum Status { IDLE, RUNNING, COMPLETE, CANCELED }

    private final Item owner;
    private Status status = Status.IDLE;

    // The recipes this device can run (each recipe's itemId is the output item id)
    private ArrayList<Recipe> recipes = new ArrayList<Recipe>();

    // Processing hours per output item id
    private Map<String,Integer> processingHoursByOutput = new HashMap<String,Integer>();

    private String currentOutputId;
    private Map<String,Integer> currentInputs; // snapshot of consumed inputs (by id -> count)
    private long finishHour;                   // absolute in-game hour when this run completes

    // Need factory for category lookups
    private final Factory factory = Factory.getInstance();

    public ArtisanDeviceComponent(Item owner) {
        this.owner = owner;
    }

    public Status getStatus() { return status; }

    /** Provide the device's recipe list (ArrayList<Recipe>) */
    public void setRecipesList(ArrayList<Recipe> list) {
        this.recipes = (list != null) ? list : new ArrayList<Recipe>();
    }

    /** Back-compat setter: legacy signatures may still call this from Factory. */
    public void setRecipes(java.util.HashMap<Item, java.util.ArrayList<Item>> ignoredLegacy) {
        // no-op; legacy path retained so existing code compiles/runs
    }

    /** Provide per-output processing hours. */
    public void setProcessingHours(Map<String,Integer> map) {
        this.processingHoursByOutput = (map != null) ? map : new HashMap<String,Integer>();
    }

    /**
     * Try to start a process given a bag of provided item counts (id -> count).
     * Picks the first recipe whose requirements can be satisfied (with category-awareness).
     */
    public boolean tryStart(Map<String,Integer> providedItemsCounts) {
        if (recipes == null || recipes.isEmpty()) return false;

        String chosenOutput = null;
        Map<String,Integer> required = null;

        for (Recipe r : recipes) {
            Map<String,Integer> req = r.getIngredients();
            if (req == null) continue;
            if (canSatisfy(providedItemsCounts, req)) {
                chosenOutput = r.getItemId();  // Recipe.itemId is the OUTPUT id
                required = req;
                break;
            }
        }

        if (chosenOutput == null) return false;

        // Determine hours (default 1 if missing)
        int hours = 1;
        Integer h = processingHoursByOutput.get(chosenOutput);
        if (h != null) hours = h;

        // Record consumption snapshot (caller should actually deduct from inventory)
        currentInputs = new HashMap<String,Integer>(required);
        currentOutputId = chosenOutput;
        status = Status.RUNNING;

        // Use game's total hours
        Clock clock = Main.getInstance().getClock();
        long now = clock.getTotalHours();
        finishHour = now + hours;

        return true;
    }

    public void cancel() {
        status = Status.CANCELED;
        currentInputs = null;
        currentOutputId = null;
    }

    public void update() {
        if (status != Status.RUNNING) return;
        Clock clock = Main.getInstance().getClock();
        long now = clock.getTotalHours();
        if (now >= finishHour) {
            status = Status.COMPLETE;
        }
    }

    public String collectOutputIfReady() {
        if (status == Status.COMPLETE) {
            status = Status.IDLE;
            String out = currentOutputId;
            currentOutputId = null;
            currentInputs = null;
            return out;
        }
        return null;
    }

    // --- helper: category-aware check & consume simulation ---
    private boolean canSatisfy(Map<String,Integer> provided, Map<String,Integer> required) {
        // Work on a mutable copy of provided counts
        Map<String,Integer> remaining = new HashMap<String,Integer>(provided);

        // 1) Consume all concrete ids first (exact id matches)
        for (Map.Entry<String,Integer> e : required.entrySet()) {
            String id = e.getKey();
            int need = e.getValue() == null ? 0 : e.getValue();
            if (need <= 0) continue;
            if (isCategoryKey(id)) continue; // skip categories here

            int have = remaining.getOrDefault(id, 0);
            if (have < need) return false;

            int left = have - need;
            if (left <= 0) remaining.remove(id);
            else remaining.put(id, left);
        }

        // 2) For each category requirement, consume matching remaining items
        //    Items must be members of that category as per Factory's category index
        for (Map.Entry<String,Integer> e : required.entrySet()) {
            String key = e.getKey();
            if (!isCategoryKey(key)) continue;
            int need = e.getValue() == null ? 0 : e.getValue();
            if (need <= 0) continue;

            String cat = categoryFromKey(key);
            if (cat == null) return false;

            need = consumeForCategory(remaining, cat, need);
            if (need > 0) return false; // not enough category-matching items left
        }

        return true;
    }

    private boolean isCategoryKey(String id) {
        return id != null && id.startsWith("cat:");
    }

    private String categoryFromKey(String id) {
        if (!isCategoryKey(id)) return null;
        return id.substring("cat:".length()); // e.g., "any_fruit"
    }

    /**
     * Consume items from 'remaining' that belong to category 'cat'.
     * Returns how many units are still needed after consumption (0 means satisfied).
     */
    private int consumeForCategory(Map<String,Integer> remaining, String cat, int need) {
        if (need <= 0) return 0;

        // Iterate over a snapshot of keys to allow modifications
        ArrayList<String> keys = new ArrayList<String>(remaining.keySet());
        for (String itemId : keys) {
            if (need <= 0) break;
            if (!factory.isItemInCategory(itemId, cat)) continue;

            int have = remaining.getOrDefault(itemId, 0);
            if (have <= 0) continue;

            int used = Math.min(have, need);
            int left = have - used;
            need -= used;

            if (left <= 0) remaining.remove(itemId);
            else remaining.put(itemId, left);
        }
        return need;
    }
}
