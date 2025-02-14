package hse.zoo;

import hse.zoo.animals.Animal;
import hse.zoo.animals.Herbo;
import hse.zoo.animals.Rabbit;

import java.util.Scanner;

public class CommandParser {
    private final Zoo zoo;

    public CommandParser(Zoo zoo) {
        this.zoo = zoo;
    }

    private void addAnimal(String[] tokens) {
        try {
            int food = Integer.parseInt(tokens[2]);
            int number = Integer.parseInt(tokens[3]);

            String name = tokens[3];
            Animal animal;
            switch (tokens[1]) {
                case "Rabbit":
                    animal = new Rabbit(food, number, name);
            }

            Animal animal = new Animal(food, number, name);
            if (!zoo.addAnimal(animal)) {
                System.out.println("Animal is not healthy");
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid command");
        }
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Enter command: ");
            String command = System.console().readLine();
            // split to tokens
            String[] tokens = command.split(" ");
            if (tokens.length == 0) {
                System.out.println("Invalid command");
                continue;
            }
            switch (tokens[0]) {
                case "addAnimal":
                    if (tokens.length < 3 || tokens.length > 4) {
                        System.out.println("Invalid command");
                        continue;
                    }
                    this.addAnimal(tokens);
                    break;
                case "getTotalFood":
                    if (tokens.length != 1) {
                        System.out.println("Invalid command");
                        continue;
                    }
                    System.out.println(zoo.getTotalFood());
                    break;
                case "getInteractiveAnimals":
                    if (tokens.length != 1) {
                        System.out.println("Invalid command");
                        continue;
                    }
                    for (Herbo herbo : zoo.getInteractiveAnimals()) {
                        System.out.println(herbo.getName());
                    }
                    break;
                case "printInventory":
                    if (tokens.length != 1) {
                        System.out.println("Invalid command");
                        continue;
                    }
                    zoo.printInventory();
                    break;
                case "exit":
                    return;
                default:
                    System.out.println("Invalid command");
            }
        }
    }

}
