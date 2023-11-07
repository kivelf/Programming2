package ex5;

import java.util.NoSuchElementException;

public class LinkedDropOutStack<E> implements DropOutStack<E> {
    // top of stack is at head of list
    private Node<E> head = null;
    // the number of element in the stack
    int size = 0;
    // default max size: 4
    private int maxSize = 4;

    // constructors
    public LinkedDropOutStack() {
        // default maxSize = 4
    }

    public LinkedDropOutStack(int size) {
        this.size = size;
    }

    /**
     * Add the element at the top of this stack.
     */
    @Override
    public void push(E entry) {
        if (size == 0) {
            Node<E> newNode = new Node<>(entry);
            head = newNode;
            size++;
        } else if (size == maxSize) {
            Node<E> newNode = new Node<>(entry);
            Node<E> temp = head;
            head = newNode;
            head.next = temp;
            // getting rid of the final element
            Node<E> current = head;
            for (int i = 1; i < maxSize - 1; i++) {
                current = current.next;
            }
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
        if (size == 0) {
            throw new NoSuchElementException("Stack is empty!");
        } else {
            Node<E> poppedItem = head;
            if (size == 1) {

            } else {
                head = head.next;
            }
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
        if (size == 0) {
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

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("[");
        Node<E> currentNode = head;

        if (head != null){
            for (int i = 0; i < size; i++){
                result.append(currentNode.element);
                currentNode = currentNode.next;
                if (i != size - 1){
                    result.append(", ");
                }
            }
        }
        return result.toString() + "]";
    }

    //-------------------------------------------------------------------------
    private static class Node<T> {
        private T element;
        private Node<T> next;

        public Node(T element) {
            this.element = element;
            this.next = null;
        }
    }
}
