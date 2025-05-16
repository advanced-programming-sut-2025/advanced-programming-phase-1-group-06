package models.buildings;

import models.Animals.Animal;
import models.Game.Coordinates;
import models.Tiles.OverlayTiles.OverlayTile;

import java.util.ArrayList;

public class Coop extends Building {
    private int capacity;
    private int currentStorage;
    private Animal[] animals;

    public Coop(Coordinates balaChap, Coordinates doorCoordinates) {

        name = "Coop";

    }

    public void addAnimal(Animal animal) {
    }

    public void removeAnimal(Animal animal) {
    }
}
