package hse.zoo;

import hse.zoo.animals.*;

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
            int kindness = tokens.length == 5 ? Integer.parseInt(tokens[4]) : -1;

            String name = tokens[3];
            Animal animal;
            switch (tokens.length) {
                case 4:
                    switch (tokens[1]) {
                        case "Wolf":
                            animal = new Wolf(food, number, name);
                            break;
                        case "Tiger":
                            animal = new Tiger(food, number, name);
                            break;
                        default:
                            System.out.println("Invalid command");
                            return;
                    }
                case 5:
                    switch (tokens[1]) {
                        case "Rabbit":
                            animal = new Rabbit(food, number, name, kindness);
                            break;
                        case "Monkey":
                            animal = new Monkey(food, number, name, kindness);
                            break;
                        default:
                            System.out.println("Invalid command");
                            return;
                    }
                    break;
                default:
                    System.out.println("Invalid command");
                    return;
            }

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
            String command = scanner.nextLine();
            String[] tokens = command.split(" ");
            if (tokens.length == 0) {
                System.out.println("Invalid command");
                continue;
            }
            switch (tokens[0]) {
                case "addAnimal":
                    if (tokens.length < 4 || tokens.length > 5) {
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
