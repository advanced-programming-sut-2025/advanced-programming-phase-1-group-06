package models.Crafting;

import models.App;
import models.Game.Recipe;
import models.ItemFaces.InventoryItem;
import models.Player.Player;

import java.util.ArrayList;

public class ArtisanDevice {
   private long startTime;
   private int craftingTime;
   private boolean status;
   private boolean ready;
   private ArrayList<Recipe> recipes;
   private ArrayList<InventoryItem> craftedItems;

   public ArtisanDevice(long startTime, int craftingTime, boolean status, boolean ready, ArrayList<Recipe> recipes, ArtisanGood[] craftedItems) {
      this.startTime = startTime;
      this.craftingTime = craftingTime;
      this.status = status;
      this.ready = ready;
      this.recipes = recipes;
      this.craftedItems = craftedItems;
   }

    ArtisanDevice(ArrayList<Recipe> recipes, )

    public void craft(Recipe recipe, Player player) {
        // Implement crafting logic
    }



    public int handleTime(){
       long remainingTime = craftingTime - (App.getPreciseTime() - startTime);
       if (remainingTime> 0){
          return (int) remainingTime;
       }
       status = true;
       return 0;
    }
}
