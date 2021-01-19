package ru.job4j.tracker;

import java.util.*;

public class Tracker {
    private final List<Item> items = new ArrayList<>();
    //    private final Item[] items = new Item[100];
    private int ids = 1;
    private int size = 0;

    public Item add(Item item) {
        item.setId(ids++);
        items.add(size++, item);
        return item;
    }

    public List<Item> findAll() {
        return new ArrayList<>(items);
    }
//    public Item[] findAll() {
//        return Arrays.copyOf(new List[][]{new List[]{items}}, size);
//    }

    public List<Item> finByName(String key) {
        Item[] itemsFindName = new Item[this.size];
        int size = 0;
        for (int i = 0; i < this.size; i++) {
            Item item = items.get(i);
            if (item.getName().equals(key)) {
                itemsFindName[size] = item;
                size++;
            } else {
                System.out.println("Invalid name");
            }
        }
        return new ArrayList<>(items);
    }

    public Item findById(int id) {
        int index = indexOf(id);
        return index != -1 ? items.get(index) : null;
    }

    private int indexOf(int id) {
        int rsl = -1;
        for (int index = 0; index < size; index++) {
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
//            int startPos = index++;
//            int distPos = index;
//            int length = size - index;
//            System.arraycopy(items, startPos, items, distPos, length);
//            items.set(size - 1, null);
//            size--;
//            Iterator<Item> itemIterator = items.iterator();
//            while (itemIterator.hasNext()) {
//              Item nextItem = itemIterator.next();
//              if (nextItem.getId() == id) {
//                  itemIterator.remove();
//              }
            items.remove(id);
        }
        return rsl;
    }
}


