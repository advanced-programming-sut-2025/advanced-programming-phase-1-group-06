package models.buildings;

import models.Animals.Animal;
import models.Game.Coordinates;

public class Barn extends Building {
    private int capacity;
    private int currentStorage;
    private Animal[] animals;

    public Barn(Coordinates balaChap, Coordinates doorCoordinates) {
        super(balaChap, doorCoordinates);
    }

    public void addAnimal(Animal animal) {
    }

    public void removeAnimal(Animal animal) {
    }
}
