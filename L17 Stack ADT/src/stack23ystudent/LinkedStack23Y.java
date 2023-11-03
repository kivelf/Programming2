package stack23ystudent;

import java.util.NoSuchElementException;

// OPGAVE 1 med single-linked liste.
public class LinkedStack23Y<E> implements Stack23Y<E> {
    // top of stack is at head of list
    private Node<E> head = null;
    // the number of element in the stack
    int size = 0;

    /**
     * Add the element at the top of this stack.
     */
    @Override
    public void push(E entry) {
        if (size == 0){
            Node<E> newNode = new Node<>(entry);
            head = newNode;
            size++;
        } else {
            Node<E> newNode = new Node<>(entry);
            Node<E> temp = head;
            head = newNode;
            head.next = temp;
            size++;
        }
    }

    /**
     * Remove and return this stack's top element.
     * Throw NoSuchElementException, if the stack is empty.
     */
    @Override
    public E pop() {
        if (size == 0){
            throw new NoSuchElementException("Stack is empty!");
        } else {
            Node<E> poppedItem = head;
            head = head.next;
            size--;
            return poppedItem.element;
        }
    }

    /**
     * Return this stack's top element.
     * Throw NoSuchElementException, if the stack is empty.
     */
    @Override
    public E peek() {
        if (size == 0){
            throw new NoSuchElementException("Stack is empty!");
        } else {
            return head.element;
        }
    }


    /**
     * Return true, if this stack is empty.
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Removes all elements from this stack.
     */
    @Override
    public void clear() {
        head = null;
        size = 0;
    }

    /**
     * Return the number of elements in the stack.
     */
    @Override
    public int size() {
        return size;
    }

    //-------------------------------------------------------------------------

    private static class Node<T> {
        private final T element;
        private Node<T> next;

        public Node(T element) {
            this.element = element;
            this.next = null;
        }
    }
}
