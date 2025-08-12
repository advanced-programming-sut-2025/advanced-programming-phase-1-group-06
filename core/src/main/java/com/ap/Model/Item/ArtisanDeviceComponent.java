package com.ap.Model.Item;

import com.ap.Main;
import com.ap.Model.Recipe;
import com.ap.View.Clock;

import java.util.*;

/**
 * Artisan device component that works with an ArrayList<Recipe>.
 * Each Recipe represents a possible OUTPUT for this device (itemId = outputId),
 * and its ingredients map contains { inputId -> count }. Category placeholders
 * use the "cat:*" prefix and are satisfied from any leftover inputs.
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
     * Picks the first recipe whose requirements can be satisfied.
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

    // --- helper: check counts with category support ---
    private boolean canSatisfy(Map<String,Integer> provided, Map<String,Integer> required) {
        Map<String,Integer> remaining = new HashMap<String,Integer>(provided);

        // First, consume concrete ids
        for (Map.Entry<String,Integer> e : required.entrySet()) {
            String id = e.getKey();
            int need = e.getValue() == null ? 0 : e.getValue();
            if (need <= 0) continue;
            if (id.startsWith("cat:")) continue;

            int have = remaining.getOrDefault(id, 0);
            if (have < need) return false;

            int left = have - need;
            if (left <= 0) remaining.remove(id);
            else remaining.put(id, left);
        }

        // Then, satisfy category placeholders using any leftover counts
        int neededCats = 0;
        for (Map.Entry<String,Integer> e : required.entrySet()) {
            String id = e.getKey();
            if (!id.startsWith("cat:")) continue;
            int need = e.getValue() == null ? 0 : e.getValue();
            if (need > 0) neededCats += need;
        }

        int totalLeft = 0;
        for (int v : remaining.values()) totalLeft += v;

        return totalLeft >= neededCats;
    }
}
