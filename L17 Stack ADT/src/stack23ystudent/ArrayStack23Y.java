package stack23ystudent;

import java.util.Arrays;
import java.util.NoSuchElementException;

// OPGAVE 1 med array.

public class ArrayStack23Y<E> implements Stack23Y<E> {
    // top is the index of the top element in the stack,
    // top is -1 if the stack is empty
    private int top = -1;
    // items contains the elements in the stack at index 0..top and null else
    @SuppressWarnings("unchecked")
    private E[] items = (E[]) new Object[4];

    /**
     * Add the element at the top of this stack.
     */
    @Override
    public void push(E entry) {
        if (top == items.length - 1) {
            items = Arrays.copyOf(items, items.length * 2);
        }
        top++;
        items[top] = entry;
    }

    /**
     * Remove and return this stack's top element.
     * Throw NoSuchElementException, if the stack is empty.
     */
    @Override
    public E pop() {
        if (top == -1){
            throw new NoSuchElementException("Stack is empty!");
        } else {
            E poppedItem = items[top];
            items[top] = null;
            top--;
            return poppedItem;
        }
    }

    /**
     * Return this stack's top element.
     * Throw NoSuchElementException, if the stack is empty.
     */
    @Override
    public E peek() {
        if (top == -1){
            throw new NoSuchElementException("Stack is empty!");
        } else {
            return items[top];
        }
    }

    /**
     * Return true, if this stack is empty.
     */
    @Override
    public boolean isEmpty() {
        return top == -1;
    }

    /**
     * Remove all elements from this stack.
     */
    @Override
    public void clear() {
        top = -1;
        E[] items = (E[]) new Object[4];
    }

    /**
     * Return the number of elements in this stack.
     */
    @Override
    public int size() {
        return top + 1;
    }
}
