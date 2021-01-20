package ru.job4j.tracker;

import java.util.*;

public class Tracker {
    private final List<Item> items = new ArrayList<>();
    private int ids = 1;

    public Item add(Item item) {
        item.setId(ids++);
        items.add(item);
        return item;
    }

    public List<Item> findAll() {
        return new ArrayList<>(items);
    }

    public List<Item> finByName(String key) {
        Item[] itemsFindName = new Item[items.size()];
        int size = 0;
        for (Item item : items) {
            if (item.getName().equals(key)) {
                itemsFindName[size] = item;
                size++;
            } else {
                System.out.println("Invalid name");
            }
        }
        return Arrays.asList(itemsFindName);
    }

    public Item findById(int id) {
        int index = indexOf(id);
        return index != -1 ? items.get(index) : null;
    }

    private int indexOf(int id) {
        int rsl = -1;
        for (int index = 0; index < items.size(); index++) {
            if (items.get(index).getId() == id) {
                rsl = index;
                break;
            }
        }
        return rsl;
    }

    public boolean replace(int id, Item item) {
        int findId = indexOf(id);
        if (findId != -1) {
            item.setId(id);
            items.set(findId, item);
        }
        return findId != -1;
    }

    public boolean delete(int id) {
        int index = indexOf(id);
        boolean rsl = index != -1;
        if (rsl) {
            items.remove(index);
        }
        return rsl;
    }
}


