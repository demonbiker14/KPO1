package hse.zoo.animals;

import hse.zoo.IAlive;
import hse.zoo.IInventory;
import hse.zoo.INamed;

public class Animal implements IAlive, IInventory, INamed {
    private final int food;
    private final int number;
    private final String name;

    public Animal(int food, int number, String name) {
        this.food = food;
        this.number = number;
        this.name = name;
    }

    public int getFood() {
        return food;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public String getName() {
        return this.name;
    }

}
