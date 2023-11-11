package ex1;

public class SortedSingleList23Y<E extends Comparable<E>> implements SortedList23Y<E> {
    // uses a head (first) pointer
    private Node<E> first = null;

    // constructor
    public SortedSingleList23Y() {
    }

    /**
     * Add the element to the list.
     * The list is still sorted after the element is added.
     */
    @Override
    public void add(E element) {
        if (first == null || element.compareTo(first.element) < 0) {
            Node<E> newNode = new Node<>(element);
            newNode.next = first;
            first = newNode;
        } else {
            Node<E> newNode = new Node<>(element);
            Node<E> current = first;

            while (current.next != null && element.compareTo(current.next.element) > 0) {
                current = current.next;
            }

            // inserting the new node in the correct position
            newNode.next = current.next;
            current.next = newNode;
        }
    }

    /**
     * Remove the first element in the list.
     * The list is still sorted after the element is removed.
     * Return true, if the element was removed.
     */
    @Override
    public boolean removeFirst() {
        if (first == null) {
            return false;
        }

        first = first.next;
        return true;
    }

    /**
     * Remove the last element in the list.
     * The list is still sorted after the element is removed.
     * Return true, if the element was removed.
     */
    @Override
    public boolean removeLast() {
        if (first == null) {
            return false;
        } else if (first != null && first.next == null) {
            first = null;
            return true;
        } else {
            Node<E> current = first;

            while (current.next.next != null) {
                current = current.next;
            }
            current.next = null;
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
        if (first == null) {
            return false;
        } else if (element.equals(first.element)) {
            first = first.next;
            return true;
        } else {
            Node<E> current = first;
            while (current.next != null && !element.equals(current.next.element)) {
                current = current.next;
            }

            if (current.next != null) {
                current.next = current.next.next;
                return true;
            }

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
        Node<E> current = first;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
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

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("[");
        Node<E> current = first;
        while (current != null) {
            result.append(current.element);
            if (current.next != null) {
                result.append(", ");
            }
            current = current.next;
        }
        result.append("]");
        return result.toString();
    }
}
