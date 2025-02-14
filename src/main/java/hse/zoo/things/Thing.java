package hse.zoo.things;

import hse.zoo.IInventory;
import hse.zoo.INamed;

public class Thing implements INamed, IInventory {
    private final int number;
    private final String name;

    public Thing(int number, String name) {
        this.number = number;
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getNumber() {
        return this.number;
    }
}
