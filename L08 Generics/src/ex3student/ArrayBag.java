package ex3student;

import java.util.Arrays;

public class ArrayBag<E> implements Bag<E> {
    // the array to hold the items
    private final E[] items;
    // current number of items in the bag,
    // items are at index 0..size-1
    private int size;

    /** Create a bag with the given capacity. */
    public ArrayBag(int capacity) {
        @SuppressWarnings("unchecked")
        E[] empty = (E[]) new Object[capacity];
        items = empty;
        size = 0;
    }

    /** Create a bag with capacity 10. */
    public ArrayBag() {
		this(10);
    }

    @Override
    public int getCurrentSize() {
        return size;
    }

    @Override
    public boolean isFull() {
        return size == items.length;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean add(E newEntry) {
        if (!isFull()){
            items[size] = newEntry;
            size++;
            return true;
        } else
            return false;
    }

    @Override
    public E remove() {
        if (!isEmpty()){
            E removedEntry = items[size - 1];
            items[size - 1] = null;
            size--;
            return removedEntry;
        }
        else
            return null;
    }

    @Override
    public boolean remove(E anEntry) {
        boolean removed = false;
        if (!isEmpty()){
            for (int i = 0; i < size && !removed; i++){
                if (items[i].equals(anEntry)){
                    for (int j = i; j < size - 1; j++){
                        items[j] = items[j + 1];
                    }
                    size--;
                    removed = true;
                }
            }
        }
        return removed;
    }

    @Override
    public void clear() {
        if (!isEmpty()){
            for (int i = 0; i < size; i++){
                items[i] = null;
            }
            size = 0;
        }
    }

    @Override
    public int getFrequencyOf(E anEntry) {
        int frequency = 0;
        if (!isEmpty() && contains(anEntry)){
            for (int i = 0; i < size; i++){
                if (items[i].equals(anEntry)){
                    frequency++;
                }
            }
        }
        return frequency;
    }

    @Override
    public boolean contains(E anEntry) {
        boolean found = false;
        if (!isEmpty()){
            for (int i = 0; i < size && !found; i++){
                if (items[i].equals(anEntry)){
                    found = true;
                }
            }
        }
        return found;
    }

    @Override
    public E[] toArray() {
        if (isEmpty()){
            return null;
        } else {
            E[] newArray = (E[])new Object[size];
            for (int i = 0; i < size; i++){
                newArray[i] = items[i];
            }
            return newArray;
        }
    }
}
