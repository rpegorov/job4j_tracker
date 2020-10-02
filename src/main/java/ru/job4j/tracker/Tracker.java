package ru.job4j.tracker;

import java.util.Arrays;

public class Tracker {
    private final Item[] items = new Item[100];
    private int ids = 1;
    private int size = 0;

    public Item add(Item item) {
        item.setId(ids++);
        items[size++] = item;
        return item;
    }

    public Item[] findAll() {
        Item[] itemsWithOutNull = new Item[items.length];
        int size = 0;
        for (int i = 0; i < items.length; i++) {
            Item item = items[i];
            if (item != null) {
                itemsWithOutNull[size] = item;
                size++;
                itemsWithOutNull = Arrays.copyOf(itemsWithOutNull, size);
            }
        }
        return itemsWithOutNull;
    }

    public Item[] finByName(String key) {
        Item[] itemsFindName = new Item[items.length];
        int size = 0;
        for (int i = 0; i < items.length; i++) {
            Item item = items[i];
            if (item.equals(key)) {
                itemsFindName[size] = item;
                size++;
                itemsFindName = Arrays.copyOf(itemsFindName, size);
            }
        }
        return itemsFindName;
    }

    public Item findById(int id) {
        Item rsl = null;
        for (int index = 0; index < size; index++) {
            Item item = items[index];
            if (item.getId() == id) {
                rsl = item;
                break;
            }
        }
        return rsl;
    }
}