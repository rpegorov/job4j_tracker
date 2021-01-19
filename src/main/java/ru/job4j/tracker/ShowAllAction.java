package ru.job4j.tracker;

import java.util.List;

public class ShowAllAction implements UserAction {
    private final Output out;

    public ShowAllAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Show All";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println("=== Show all item ===");
        List<Item> all = tracker.findAll();
        for (Item item : all) {
           out.println("Item ID: " + item.getId() + " | "
                    + " Name: " + item.getName());
        }
        return true;
    }
}
