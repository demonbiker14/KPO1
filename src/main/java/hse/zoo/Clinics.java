package hse.zoo;

import hse.zoo.animals.Animal;

public class Clinics {
    public boolean checkHealth(Animal animal) {
        return animal.hashCode() % 2 == 0;
    }
}
