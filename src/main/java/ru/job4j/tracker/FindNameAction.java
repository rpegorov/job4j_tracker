package ru.job4j.tracker;

public class FindNameAction implements UserAction {
    @Override
    public String name() {
        return "=== Find items by name ===";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String name = input.askStr("Enter name to find: ");
        Item[] item = tracker.finByName(name);
        for (Item find : item) {
            System.out.println("Find ID is: " + find.getId());
        }
        return true;
    }
}
