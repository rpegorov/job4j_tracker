package ru.job4j.tracker;

public class FindIdAction implements UserAction {
    @Override
    public String name() {
        return "===Find item by ID===";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        int id = input.askInt("Enter ID to find: ");
        Item item = tracker.findById(id);
        if
        (item == null) {
            System.out.println("Invalid item ID");
        } else {
            System.out.println("Find item is: " + item.getName());
        }
        return true;
    }
}
