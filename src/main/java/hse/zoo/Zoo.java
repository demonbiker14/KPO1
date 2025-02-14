package hse.zoo;

import hse.zoo.animals.Animal;
import hse.zoo.animals.Herbo;
import hse.zoo.things.Thing;

import java.util.ArrayList;
import java.util.List;

public class Zoo {

    private final List<Animal> animals = new ArrayList<>();
    private final List<Thing> things = new ArrayList<>();
    private final Clinics clinics;

    public Zoo(Clinics clinics) {
        this.clinics = clinics;
    }

    public boolean addAnimal(Animal animal) {
        if (clinics.checkHealth(animal)) {
            animals.add(animal);
            return true;
        }
        return false;
    }


    public int getTotalFood() {
        return animals.stream().mapToInt(Animal::getFood).sum();
    }

    public List<Herbo> getInteractiveAnimals() {
        List<Herbo> interactiveAnimals = new ArrayList<>();
        for (Animal animal : animals) {
            if (animal instanceof Herbo herbo) {
                if (herbo.getKindness() > 5) {
                    interactiveAnimals.add(herbo);
                }
            }
        }
        return interactiveAnimals;
    }

    public void printInventory() {
        for (Thing thing : things) {
            System.out.println("Thing: " + thing.getClass().getSimpleName() + ", Number: " + thing.getNumber());
        }
        for (Animal animal : animals) {
            System.out.println("Animal: " + animal.getClass().getSimpleName() + ", Food: " + animal.getFood());
        }
    }
}