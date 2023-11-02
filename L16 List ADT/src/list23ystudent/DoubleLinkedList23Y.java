package list23ystudent;
import java.util.Iterator;

/** A double-linked nodes based implementation of the List ADT. */
public class DoubleLinkedList23Y<E> implements List23Y<E> {
    private final Node<E> header = new Node<>(null);
    private final Node<E> trailer = new Node<>(null);
    private int size = 0;

    public DoubleLinkedList23Y() {
        header.next = trailer;
        trailer.prev = header;
    }

    /**
     * Add the element to the end of this list.
     */
    @Override
    public void add(E e) {
        Node<E> newNode = new Node<>(e);
        // insert newNode between trailer.prev and trailer
        newNode.prev = trailer.prev;
        newNode.next = trailer;
        trailer.prev.next = newNode;
        trailer.prev = newNode;
        size++;
    }

    /**
     * Remove the element from this list.
     * Return true, if this list is modified.
     */
    @Override
    public boolean remove(E e) {
        if (size == 0){
            return false;
        } else {
            Node<E> node = header;
            for (int i = 0; i < size; i++){
                node = node.next;
                if (node.element.equals(e)){
                    node.prev.next = node.next;
                    node.next.prev = node.prev;
                    size--;
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Return true, if this list contains the element.
     */
    @Override
    public boolean contains(E e) {
        if (size == 0){
            return false;
        }

        Node<E> node = header;
        while (node.next != trailer){
            if (node.next.element.equals(e)){
                return true;
            } else {
                node = node.next;
            }
        }
        return false;
    }

    /**
     * Remove all elements from this list.
     */
    @Override
    public void clear() {
        header.next = trailer;
        trailer.prev = header;
        size = 0;
    }

    /**
     * Return the size of this list.
     */
    public int size() {
        return size;
    }

    /**
     * Return true, if this list is empty.
     */
    @Override
    public boolean isEmpty() {
        return header.next == trailer;
    }

    /**
     * Return the element at the index.
     * Throw IndexOutOfBoundsException, if index < 0 or index >= size().
     */
    @Override
    public E get(int index) {
        if (index < 0 || index >= this.size) {
            throw new IndexOutOfBoundsException("Invalid index!");
        } else {
            Node<E> node = header;
            for (int i = 0; i <= index; i++){
                node = node.next;
            }
            return node.element;
        }
    }

    /**
     * Add the element to this list at the index.
     * Throw IndexOutOfBoundsException, if index < 0 or index > size().
     * Note: The element can be added at an index equal to size().
     */
    @Override
    public void add(int index, E e) {
        if (index < 0 || index > this.size) {
            throw new IndexOutOfBoundsException("Invalid index!");
        }

        // append at index 0 as the first item
        if (index == 0){
            Node<E> newNode = new Node<>(e);
            newNode.next = header.next;
            header.next.prev = newNode;
            newNode.prev = header;
            header.next = newNode;
            size++;
        } else {
            Node<E> newNode = new Node<>(e);
            Node<E> node = header;
            for (int i = 0; i < index; i++){
                node = node.next;
            }
            Node<E> temp = node.next;
            node.next = newNode;
            newNode.prev = node;
            newNode.next = temp;
            temp.prev = newNode;
            size++;
        }
    }

    /**
     * Remove and return the element at the index.
     * Throw IndexOutOfBoundsException, if index < 0 or index >= size().
     */
    @Override
    public E remove(int index) {
        if (index < 0 || index >= this.size) {
            throw new IndexOutOfBoundsException("Invalid index!");
        }
        else if (index == 0){
            // remove the element right after header
            Node<E> removedNode = header.next;
            header.next = header.next.next;
            header.next.prev = header;
            size--;
            return removedNode.element;
        } else {
            Node<E> current = header;
            for (int i = 0; i < index; i++){
                current = current.next;
            }
            Node<E> nodeToBeRemoved = current.next;
            current.next = nodeToBeRemoved.next;    // a.k.a. current.next.next
            current.next.prev = current;
            size--;
            return nodeToBeRemoved.element;
        }
    }

    /**
     * Return the index of the element in this list.
     * Return -1, if this list does not contain the element.
     */
    @Override
    public int indexOf(E e) {
        if (header.next != trailer){
            if (header.next.element.equals(e)){
                return 0;
            } else {
                Node<E> current = header.next;
                for (int i = 1; i < size; i++) {
                    current = current.next;
                    if (current.element.equals(e)) {
                        return i;
                    }
                }
            }
        }
        return -1;
    }

    /**
     * Return an iterator over this list.
     * Note: While the list is traversed by this iterator,
     * adding or removing an element is not allowed.
     */
    @Override
    public Iterator<E> iterator() {
        return new DoubleLinkedListIterator();
    }

    private class DoubleLinkedListIterator implements Iterator<E>{
        private Node<E> current = header.next;

        @Override
        public boolean hasNext(){
            return current.next != null;
        }

        @Override
        public E next(){
            E e = current.element;
            current = current.next;
            return e;
        }
    }

    //-------------------------------------------

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
            for (int i = 0; i < size; i++){
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
