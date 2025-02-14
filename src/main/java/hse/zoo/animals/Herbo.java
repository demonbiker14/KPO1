package hse.zoo.animals;

public abstract class Herbo extends Animal {
    private final int kindness;

    public Herbo(int food, int number, String name, int kindness) {
        super(food, number, name);
        this.kindness = kindness;
    }

    public int getKindness() {
        return this.kindness;
    }
}
