package ru.job4j.tracker;

public class StartUI {

//    public static void createItem(Input input, Tracker tracker) {
//        System.out.println("=== Create a new Item ===");
//        msg = "Enter name: ";
//        String name = input.askStr(msg);
//        Item item = new Item(name);
//        tracker.add(item);
//    }

//    public static void showAllItem(Input input, Tracker tracker) {
//        System.out.println("===Show all item===");
//        Item[] all = tracker.findAll();
//        for (int i = 0; i < all.length; i++) {
//            System.out.println("Item ID: " + all[i].getId() + " | "
//                    + " Name: " + all[i].getName());
//        }
//    }

//    public static void editItem(Input input, Tracker tracker) {
//        System.out.println("===Edit item====");
//        msg = "Enter ID editable element: ";
//        int id = Integer.valueOf(input.askStr(msg));
//        Item itemId = new Item(id);
//        msg = "Entre a new Item name: ";
//        String newMeaning = input.askStr(msg);
//        Item itemMeaning = new Item(newMeaning);
//        if (tracker.replace(id, itemMeaning)) {
//            System.out.println("Edit passed");
//        } else {
//            System.out.println("Edit failed");
//        }
//    }

//    public static void deleteItem(Input input, Tracker tracker) {
//        System.out.println("===Delete item====");
//        msg = "Enter ID to delete: ";
//        int id = Integer.valueOf(input.askStr(msg));
//        if (tracker.delete(id)) {
//            System.out.println("Delete passed");
//        } else {
//            System.out.println("Invalid item ID");
//        }
//    }

//    public static void findById(Input input, Tracker tracker) {
//        System.out.println("===Find item by ID===");
//        msg = "Enter ID to find: ";
//        int id = Integer.valueOf(input.askStr(msg));
//        Item item = tracker.findById(id);
//        if
//        (item == null) {
//            System.out.println("Invalid item ID");
//        } else {
//            System.out.println("Find item is: " + item.getName());
//        }
//    }

//    public static void findByName(Input input, Tracker tracker) {
//        System.out.println("===Find items by name===");
//        msg = "Enter name to find: ";
//        String name = input.askStr(msg);
//        Item[] item = tracker.finByName(name);
//        for (int i = 0; i < item.length; i++) {
//            Item find = item[i];
//            System.out.println("Find ID is: " + find.getId());
//        }
//    }

    public void init(Input input, Tracker tracker, UserAction[] actions) {
        boolean run = true;
        while (run) {
            this.showMenu();
            int select = input.askInt("Select: ");
            UserAction action = actions[select];
            run = action.execute(input, tracker);

//            if (select == 0) {
//                StartUI.createItem(input, tracker);
//
//            } else if (select == 1) {
//                StartUI.showAllItem(input, tracker);
//
//            } else if (select == 2) {
//                StartUI.editItem(input, tracker);
//
//            } else if (select == 3) {
//                StartUI.deleteItem(input, tracker);
//
//            } else if (select == 4) {
//                StartUI.findById(input, tracker);
//
//            } else if (select == 5) {
//                StartUI.findByName(input, tracker);
//
//            } else if (select == 6) {
//                run = false;
//                System.out.println("Exit program");
//            }
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
    }

    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new CreateAction(),
                new ShowAllAction(),
                new EditAction(),
                new DeleteAction(),
                new FindIdAction(),
                new FindNameAction()
        };
        new StartUI().init(input, tracker, actions);

    }
}
