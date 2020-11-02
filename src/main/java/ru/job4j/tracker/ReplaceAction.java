package ru.job4j.tracker;

public class ReplaceAction implements UserAction {
    private final Output out;

    public ReplaceAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Replace";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println("=== Replace item ====");
        int id = input.askInt("Enter ID editable element: ");
        Item itemId = new Item(id);
        String newMeaning = input.askStr("Entre a new Item name: ");
        Item itemMeaning = new Item(newMeaning);
        if (tracker.replace(id, itemMeaning)) {
            out.println("Edit passed");
        } else {
            out.println("Edit failed");
        }
        return true;
    }
}
