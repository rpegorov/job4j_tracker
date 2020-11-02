package ru.job4j.tracker;

public class FindIdAction implements UserAction {
    private final Output out;

    public FindIdAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Find by ID";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println("=== Find item by ID ===");
        int id = input.askInt("Enter ID to find: ");
        Item item = tracker.findById(id);
        if
        (item == null) {
            out.println("Invalid item ID");
        } else {
            out.println("Find item is: " + item.getName());
        }
        return true;
    }
}
