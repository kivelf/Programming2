package ex2;

import ex1.SortedList23Y;
import ex1.SortedSingleList23Y;

public class SortedDoubleList23Y<E extends Comparable<E>> implements SortedList23Y<E> {
    // uses a head (first) pointer
    private Node<E> header = new Node<>(null);
    private Node<E> trailer = new Node<>(null);

    // constructor
    public SortedDoubleList23Y() {
        header.next = trailer;
        trailer.prev = header;
    }

    /**
     * Add the element to the list.
     * The list is still sorted after the element is added.
     */
    @Override
    public void add(E element){
        if (header.next == null){
            Node<E> newNode = new Node<>(element);
            header.next = newNode;
            newNode.prev = header;
            trailer.prev = newNode;
            newNode.next = trailer;
        } else {
            Node<E> newNode = new Node<>(element);

            Node<E> current = header.next;
            while (current != trailer && element.compareTo(current.element) > 0) {
                current = current.next;
            }
            newNode.prev = current.prev;
            newNode.next = current;
            current.prev.next = newNode;
            current.prev = newNode;
        }
    }

    /**
     * Remove the first element in the list.
     * The list is still sorted after the element is removed.
     * Return true, if the element was removed.
     */
    @Override
    public boolean removeFirst(){
        if (header.next == trailer) {
            return false;
        } else {
            header.next = header.next.next;
            header.next.prev = header;
            return true;
        }
    }

    /**
     * Remove the last element in the list.
     * The list is still sorted after the element is removed.
     * Return true, if the element was removed.
     */
    @Override
    public boolean removeLast() {
        if (trailer.prev == header) {
            return false;
        } else {
            trailer.prev = trailer.prev.prev;
            trailer.prev.next = trailer;
            return true;
        }
    }

    /**
     * Remove the first instance of the element from the list.
     * The list is still sorted after the element is removed.
     * Return true, if the element was removed.
     */
    @Override
    public boolean remove(E element){
        if (header.next == null) {
            return false;
        } else {
            Node<E> current = header.next;

            while (current != trailer && !element.equals(current.element)) {
                current = current.next;
            }
            if (current != trailer) {
                current.prev.next = current.next;
                current.next.prev = current.prev;
                return true;
            }
            // the element was not found in the list
            return false;
        }
    }

    /**
     * Return the number of elements in the list.
     * Do NOT use a size field in your implementation!!
     */
    @Override
    public int size(){
        int count = 0;
        Node<E> current = header.next;
        while (current != trailer) {
            count++;
            current = current.next;
        }
        return count;
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

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("[");
        if (header != null){
            Node<E> current = header.next;
            while (current != trailer) {
                result.append(current.element);
                if (current.next != trailer) {
                    result.append(", ");
                }
                current = current.next;
            }
        }
        result.append("]");
        return result.toString();
    }
}
