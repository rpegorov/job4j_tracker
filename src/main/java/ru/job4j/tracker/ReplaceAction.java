package ru.job4j.tracker;

public class ReplaceAction implements UserAction {
    @Override
    public String name() {
        return "===Edit item====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        int id = input.askInt("Enter ID editable element: ");
        Item itemId = new Item(id);
        String newMeaning = input.askStr("Entre a new Item name: ");
        Item itemMeaning = new Item(newMeaning);
        if (tracker.replace(id, itemMeaning)) {
            System.out.println("Edit passed");
        } else {
            System.out.println("Edit failed");
        }
        return true;
    }
}
