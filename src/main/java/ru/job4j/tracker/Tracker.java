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
        return Arrays.copyOf(items, size);
    }

    public Item[] finByName(String key) {
        Item[] itemsFindName = new Item[this.size];
        int size = 0;
        for (int i = 0; i < this.size; i++) {
            Item item = items[i];
            if (item.equals(key)) {
                itemsFindName[size] = item;
                size++;
            }
        }
        return Arrays.copyOf(itemsFindName, size);
    }

    public Item findById(int id) {
        int index = indexOf(id);
        return index != -1 ? items[index] : null;
    }

    private int indexOf(int id) {
        int rsl = -1;
        for (int index = 0; index < size; index++) {
            if (items[index].getId() == id) {
                rsl = index;
                break;
            }
        }
        return rsl;
    }

    public boolean replace(int id, Item item) {
        int findId = indexOf(id);
        if (findId != - 1) {
            item.setId(id);
            items[findId] = item;
        }
        return findId != -1;
    }

    public boolean delete(int id) {
        int index = indexOf(id);
        boolean rsl = index != -1;
        if (rsl) {
            int startPos = index++;
            int distPos = index;
            int length = size - index;
            System.arraycopy(items, startPos, items, distPos, length);
            items[size - 1] = null;
            size--;
        }
        return rsl;
    }
}