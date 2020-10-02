package ru.job4j.tracker;

public class StartUI {
    public static void main(String[] args) {
        Tracker tracker = new Tracker();
        Item item = new Item("Ros");
        tracker.add(item);
        Item findId = tracker.findById(1);
        System.out.println(findId);
    }
}
