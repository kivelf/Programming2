package ex1;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class ArrayQueue23Y <E> implements Queue23Y<E> {
    // back = size = the first unused index in the queue
    // insert at back, remove at front
    @SuppressWarnings("unchecked")
    private E[] data = (E[]) new Object[4];
    // the number of element in the queue
    int size = 0;

    // constructor
    public ArrayQueue23Y() {
    }


    /**
     * Add the element at the back of the queue.
     */
    @Override
    public void add(E element){
        if (size == data.length) {
            data = Arrays.copyOf(data, data.length * 2);
        }
        data[size] = element;
        size++;
    }

    /**
     * Remove and return the element at the front of the queue.
     * Throw a NoSuchElementException(), if the queue is empty.
     */
    @Override
    public E remove(){
        if (size == 0){
            throw new NoSuchElementException("Stack is empty!");
        } else {
            E poppedItem = data[0];
            for (int i = 0; i < size - 1; i++) {
                data[i] = data[i + 1];
            }
            size--;
            return poppedItem;
        }
    }

    /**
     * Return the element at the front of the queue.
     * Throw a NoSuchElementException(), if the queue is empty.
     */
    @Override
    public E element(){
        if (size == 0){
            throw new NoSuchElementException("Stack is empty!");
        } else {
            return data[0];
        }
    }

    /**
     * Return true, if the queue is empty.
     */
    @Override
    public boolean isEmpty(){
        return size == 0;
    }

    /**
     * Remove all elements from the queue.
     */
    @Override
    public void clear(){
        for (int i = 0; i < size; i++) {
            data[i] = null;
        }
        size = 0;
    }

    /**
     * Return the number of elements in the queue.
     */
    @Override
    public int size(){
        return size;
    }


    //-------------------------------------------
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("[");

        for (int i = 0; i < size; i++){
            result.append(data[i]);
            if (i < size - 1){
                result.append(", ");
            }
        }
        return result.toString() + "]";
    }
}