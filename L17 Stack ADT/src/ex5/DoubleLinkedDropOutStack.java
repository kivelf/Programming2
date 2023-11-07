package ex5;

import java.util.NoSuchElementException;

public class DoubleLinkedDropOutStack<E> implements DropOutStack<E> {
    // top of stack is at head of list
    private final Node<E> header = new Node<>(null);
    private final Node<E> trailer = new Node<>(null);
    // the number of element in the stack
    int size = 0;
    // default max size: 4
    private int maxSize = 4;

    // constructors
    public DoubleLinkedDropOutStack() {
        header.next = trailer;
        trailer.prev = header;
    }

    public DoubleLinkedDropOutStack(int maxSize) {
        header.next = trailer;
        trailer.prev = header;
        this.maxSize = maxSize;
    }

    /**
     * Add the element at the top of this stack (so right after header).
     */
    @Override
    public void push(E entry) {
        if (size == 0) {
            Node<E> newNode = new Node<>(entry);
            header.next = newNode;
            trailer.prev = newNode;
            newNode.prev = header;
            newNode.next = trailer;
            size++;
        } else if (size == maxSize) {
            Node<E> newNode = new Node<>(entry);
            Node<E> temp = header.next;
            header.next = newNode;
            header.next.next = temp;
            newNode.prev = header;
            newNode.next = temp;
            // getting rid of the final element
            Node<E> current = header.next;
            for (int i = 1; i < maxSize; i++) {
                current = current.next;
            }
            trailer.prev = current;
            current.next = trailer;
        } else {
            Node<E> newNode = new Node<>(entry);
            Node<E> temp = header.next;
            header.next = newNode;
            header.next.next = temp;
            newNode.prev = header;
            newNode.next = temp;
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
            Node<E> poppedItem = header.next;
            if (size == 1) {
                clear();
            } else {
                header.next = header.next.next;
                size--;
            }
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
            return header.next.element;
        }
    }

    @Override
    public boolean isEmpty() {
        return header.next == trailer;
    }

    /**
     * Removes all elements from this stack.
     */
    @Override
    public void clear() {
        header.next = trailer;
        trailer.prev = header;
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
        private Node<T> prev;

        public Node(T t) {
            this.element = t;
            this.next = null;
            this.prev = null;
        }
    }

    //-------------------------------------------
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("[");
        Node<E> currentNode = header;

        if (header.next != trailer){
            currentNode = header.next;
            for (int i = 1; i <= size; i++){
                result.append(currentNode.element);
                currentNode = currentNode.next;
                if (currentNode.next != null){
                    result.append(", ");
                }
            }
        }
        return result.toString() + "]";
    }
}
