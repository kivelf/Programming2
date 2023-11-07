package ex5;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class ArrayDropOutStack<E> implements DropOutStack<E>{
    // top is the index of the top element in the stack,
    // top is -1 if the stack is empty
    private int top = -1;
    // items contains the elements in the stack at index 0..top and null else
    @SuppressWarnings("unchecked")
    private int maxSize = 4;
    // default size: 4
    private E[] items = (E[]) new Object[maxSize];

    // constructors
    public ArrayDropOutStack() {
        // creates a default stack with maxSize = 4
    }

    // maxSize is a positive integer
    public ArrayDropOutStack(int maxSize) {
        this.maxSize = maxSize;
        E[] items = (E[]) new Object[maxSize];
    }
    //_____________________________________________


    /**
     * Add the element at the top of this stack.
     */
    @Override
    public void push(E entry) {
        if (top == maxSize - 1) {
            for (int i = 0; i < maxSize - 1; i++){
                items[i] = items[i + 1];
            }
            items[top] = entry;
        } else {
            top++;
            items[top] = entry;
        }
    }

    /**
     * Remove and return this stack's top element.
     * Throw NoSuchElementException, if the stack is empty.
     */
    @Override
    public E pop(){
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
    public E peek(){
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

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("[");

        for (int i = 0; i < top + 1; i++){
            result.append(items[i]);
            if (i < top){
                result.append(", ");
            }
        }
        return result.toString() + "]";
    }
}
