package ex3;

import java.util.NoSuchElementException;

public class Ring<E> {
    private Node<E> first = null;
    private Node<E> current;
    private int count;
    private int size;

    // constructor with current set to null
    public Ring(int count) {
        this.count = count;
        current = null;
        size = 0;
    }

    // get methods
    public int getSize() {
        return size;
    }

    /** Add an element after the current node,
     update current to the added node. */
    public void add(E element){
        if (first == null){
            Node<E> newNode = new Node<>(element);
            first = newNode;
            first.next = newNode;
            current = newNode;
            current.next = newNode;
            size++;
        } else {
            Node<E> newNode = new Node<>(element);
            Node<E> temp = current;
            temp.next = newNode;
            current = newNode;
            current.next = first;
            size++;
        }
    }

    /** Remove and return the first element (randomly selected),
     update current to the node before the removed node. */
    public E removeFirst(){
        if (size == 0){
            throw new NoSuchElementException("Deque is empty!");
        } else {
            if (size == 1){
                Node<E> eaten = current;
                current = null;
                first = null;
                size = 0;
                return eaten.element;
            } else {
                int randomNum = getRandomNumber(0, size);
                for (int i = 0; i < randomNum - 1; i++){
                    current = current.next;
                }
                Node<E> eaten = current.next;
                current.next = current.next.next;
                size--;
                return eaten.element;
            }
        }
    }

    /** Remove and return the first element (randomly selected),
     update current to the node before the removed node. */
    public E removeNext(){
        if (size == 0){
            throw new NoSuchElementException("Deque is empty!");
        } else {
            if (size == 1){
                Node<E> eaten = current;
                current = null;
                first = null;
                size = 0;
                return eaten.element;
            } else {
                for (int i = 0; i < count - 1; i++){
                    current = current.next;
                }
                Node<E> eaten = current.next;
                current.next = current.next.next;
                size--;
                return eaten.element;
            }
        }
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

    private int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }

    /** Return all persons in the ring starting with
     * the element in the node _after_ the current node. */
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("[");
        Node<E> currentNode = current;
        if (current == null){
            return result.toString() + "]";
        }

        if (current.next != null){
            for (int i = 0; i < size; i++){
                currentNode = currentNode.next;
                result.append(currentNode.element);
                if (i != size - 1){
                    result.append(", ");
                }
            }
        }
        return result.toString() + "]";
    }
}
