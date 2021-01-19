package ru.job4j.tracker;

import java.util.List;

public class FindNameAction implements UserAction {
    private final Output out;

    public FindNameAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Find by name";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println("=== Find items by name ===");
        String name = input.askStr("Enter name to find: ");
        List<Item> item = tracker.finByName(name);
        for (Item find : item) {
            out.println("Find ID is: " + find.getId());
        }
        return true;
    }
}
