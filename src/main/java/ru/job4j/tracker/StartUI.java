package ru.job4j.tracker;

import java.util.Scanner;

public class StartUI {
    public void init(Scanner scanner, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu();
            System.out.println("Select: ");
            int select = Integer.valueOf(scanner.nextLine());
            if (select == 0) {
                System.out.println("=== Create a new Item ===");
                System.out.print("Enter name: ");
                String name = scanner.nextLine();
                Item item = new Item(name);
                tracker.add(item);
            } else if (select == 1) {
                System.out.println("===Show all item===");
                Item[] all = tracker.findAll();
                System.out.println(all);
            } else if (select == 2) {
                System.out.println("===Edit item====");
                System.out.println("Enter ID editable element: ");
                int id = Integer.valueOf(scanner.nextLine());
                Item itemId = new Item(id);
                System.out.println("Entre new Item: ");
                String newMeaning = scanner.nextLine();
                Item itemMeaning = new Item(newMeaning);
                tracker.replace(id, itemMeaning);

            } else if (select == 3) {
                System.out.println("===Delete item====");
                System.out.println("Enter ID to delete: ");
                int id = Integer.valueOf(scanner.nextLine());
                tracker.delete(id);

            } else if (select == 4) {
                System.out.println("===Find item by ID===");
                System.out.println("Enter ID to find: ");
                int id = Integer.valueOf(scanner.nextLine());
                Item item = tracker.findById(id);
                System.out.println(item);

            } else if (select == 5) {
                System.out.println("===Find items by name===");
                System.out.println("Enter name to find: ");
                String name = scanner.nextLine();
                Item[] item = tracker.finByName(name);
                System.out.println(item);
            } else if (select == 6) {
                run = false;
                System.out.println("Exit program");
            }
        }
    }

    private void showMenu() {
        System.out.println("Menu");
        System.out.println("0. Add new Item");
        System.out.println("1. Show all items");
        System.out.println("2. Edit item");
        System.out.println("3. Delete item");
        System.out.println("4. Find item by Id");
        System.out.println("5. Find items by name");
        System.out.println("6. Exit Program");
        System.out.println("Select");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Tracker tracker = new Tracker();
        new StartUI().init(scanner, tracker);
    }
}
