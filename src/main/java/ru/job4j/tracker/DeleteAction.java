package ru.job4j.tracker;

public class DeleteAction implements UserAction {
    @Override
    public String name() {
        return "===Delete item====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        int id = input.askInt("Enter ID to delete: ");
        if (tracker.delete(id)) {
            System.out.println("Delete passed");
        } else {
            System.out.println("Invalid item ID");
        }
        return true;
    }
}
