package ex1;

public class SortedSingleList23Y<E extends Comparable<E>> implements SortedList23Y<E> {
    // uses a head (first) pointer
    private Node<E> first = null;

    // constructor
    public SortedSingleList23Y() {
    }

    // getter method
    public Node<E> getFirst() {
        return first;
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

    // Exercise 3
    /**
     * Add all elements in the given list to the current list.
     * The current list is still sorted after the elements are added.
     * Make an implementation that only traverses the lists once.
     */
    public void addAll(SortedSingleList23Y<E> list) {
        Node<E> currentThisList = first;
        Node<E> currentOtherList = list.first;

        while (currentOtherList != null && currentOtherList != null) {
            E elementToAdd = currentOtherList.element;

            // Find the correct position to insert the element in the current list
            while (currentThisList.next != null && elementToAdd.compareTo(currentThisList.next.element) > 0) {
                currentThisList = currentThisList.next;
            }

            // Insert the element in the correct position
            Node<E> newNode = new Node<>(elementToAdd);
            newNode.next = currentThisList.next;
            currentThisList.next = newNode;

            // Move to the next element in the other list
            currentOtherList = currentOtherList.next;
        }
    }


    /**
     * Add all elements in the given list to the current list.
     * The current list is still sorted after the elements are added.
     * Alt implementation that can traverse the lists more than once.
     */
    public void addAll2(SortedSingleList23Y<E> list) {
        Node<E> node = list.first;
        while (node != null){
            this.add(node.element);
            node = node.next;
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

    // exercise 4
    // Implement another version of the size() method that uses recursion.
    /**
     * Return the number of elements in the list.
     * Do NOT use a size field in your implementation!!
     */
    public int sizeUsingRecursion(){
        return recursiveSize(first);
    }

    private int recursiveSize(Node<E> firstNode) {
        if (firstNode == null) {
            return 0;
        }
        return 1 + recursiveSize(firstNode.next);
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
