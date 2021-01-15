package animal;

import animal.model.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Main {

    static ArrayList<Animal> animals = new ArrayList<>();
    static HashMap<Long, Integer> animalsInOrder = new HashMap<>();

    public static WalletBalance wb = new WalletBalance();

    public static Scanner input = new Scanner(System.in);
    public static String again;
    public static int choice, quantity;
    public static double total, walletBalance;

    public static void main(String[] args) {
        initData();
        chooseBalance();
        menu();
        order();
        printOrder();
    }

    public static void menu() {
        System.out.println("\t\t\t\t=================================");
        System.out.println("\t\t\t\t            PetShop Menu         ");
        System.out.println("\t\t\t\t          today you can buy:");
        System.out.println("\t\t\t\t    1. Cat Tom - 22.5$");
        System.out.println("\t\t\t\t    2. Cat Matroskin - 0.5$");
        System.out.println("\t\t\t\t    3. Dog Jim - 30$");
        System.out.println("\t\t\t\t    4. Dog Sausage - 25$");
        System.out.println("\t\t\t\t    5. Parrot Radio - 50$");
    }

    public static void chooseBalance() {
        System.out.println("\t please choose amount of money, \n you wish to take with you to the pet shop! \n please use the following format: 100,5");
        while (!input.hasNextDouble()) {
            System.out.println("That's not a number!");
            input.next();
        }

        walletBalance = input.nextDouble();

        wb.setBalance(walletBalance);

    }

    public static void order() {
        Order order = new Order();
        List<Long> animalIds = new ArrayList<>();
        System.out.println();
        System.out.println("\t  press a digit to select a pet, and push enter to confirm.");

        while (!input.hasNextInt()) {
            System.out.println("That's not a number!");
            input.next();
        }

        choice = input.nextInt();

        long animalId = 0L;

        if (choice == 1) {
            animalId = 100001L;
        } else if (choice == 2) {
            animalId = 100002L;
        } else if (choice == 3) {
            animalId = 100003L;
        } else if (choice == 4) {
            animalId = 100004L;
        } else if (choice == 5) {
            animalId = 100005L;
        } else {
            System.out.println("no such option, try again");
            order();
        }
        orderActions(animalIds, animalId, order);

    }

    public static Animal getAnimalById(long animalId) {
        Animal current = null;
        for (Animal animal : animals) {
            if (animal.getAnimalId() == animalId) {
                current = animal;
            }
        }

        return current;
    }

    public static void initData() {
        Cat Tom = new Cat(100001, 22.5, "Tom");
        Cat Matroskin = new Cat(100002, 0.5, "Matroskin");
        Dog Jim = new Dog(100003, 30, "Jim");
        Dog Sausage = new Dog(100004, 25, "Sausage");
        Parrot Radio = new Parrot(100005, 50, "Radio");

        animals.add(Tom);
        animals.add(Matroskin);
        animals.add(Jim);
        animals.add(Sausage);
        animals.add(Radio);

    }

    public static void orderActions(List<Long> animalIds, Long animalId, Order order) {

        animalIds.add(animalId);
        System.out.print("Your choice: "
                + getAnimalById(animalId).getName()
                + " at " + getAnimalById(animalId).getPrice()
                + "$ cost. how many of those do you want to buy?");
        while (!input.hasNextInt()) {
            System.out.println("That's not a number!");
            input.next();
        }
        quantity = input.nextInt();
        total += (quantity * (getAnimalById(animalId).getPrice()));
        order.setTotal(total);
        order.setAnimalsInOrder(animalIds);

        System.out.println("\t Do you want to buy anything else?"
                + "\n Press 'Y' if Yes, and any other key if No."
                + "\n To change existing items, select the same digit as before and change it`s quantity.");
        if (animalsInOrder.containsKey(animalId)) {
            quantity = animalsInOrder.get(animalId) + quantity;
            animalsInOrder.put(animalId, quantity);
        } else {
            animalsInOrder.put(animalId, quantity);
        }
        again = input.next();
        if (again.equalsIgnoreCase("y")) {
            order();
        } else {
            System.out.println("Total price is " + order.getTotal() + " $");
        }
        //TODO add condition if total <= balance, call printOrder here. otherwise print - police is called

        if (order.getTotal() > walletBalance) {
            System.out.println("seems you can`t afford that.");
            System.out.println("time to call the police to imprison this hobo");
            System.exit(-1);

        }
    }

    public static void printOrder() {
        for (Long animalId : animalsInOrder.keySet()) {
            Long key = animalId;
            Integer value = animalsInOrder.get(animalId);
            if (value > 0) {
                System.out.println(getAnimalById(key).getName() + ": " + value + " units at "
                        + getAnimalById(key).getPrice()
                        + "$ each, sum cost: " + getAnimalById(key).getPrice() * value);
            }
        }
    }
}
