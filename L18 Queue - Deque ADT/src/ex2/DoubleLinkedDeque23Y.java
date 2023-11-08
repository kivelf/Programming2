package ex2;

import java.util.NoSuchElementException;

public class DoubleLinkedDeque23Y<E> implements Deque23Y<E> {
    // uses both header and tailer sentinels
    // insert/remove can happen at both ends
    private Node<E> header = new Node<>(null);
    private Node<E> trailer = new Node<>(null);
    // the number of element in the dequeue
    int size = 0;

    // constructor
    public DoubleLinkedDeque23Y() {
        header.next = trailer;
        trailer.prev = header;
    }

    /**
     * Add the element at the front of the deque.
     */
    @Override
    public void addFirst(E element){
        if (size == 0) {
            Node<E> newNode = new Node<>(element);
            header.next = newNode;
            newNode.prev = header;
            trailer.prev = newNode;
            newNode.next = trailer;
            size++;
        } else {
            Node<E> newNode = new Node<>(element);
            Node<E> firstNode = header.next;
            header.next = newNode;
            newNode.prev = header;
            newNode.next = firstNode;
            firstNode.prev = newNode;
            size++;
        }
    }

    /**
     * Add the element at the back of the deque.
     */
    @Override
    public void addLast(E element){
        if (size == 0) {
            Node<E> newNode = new Node<>(element);
            header.next = newNode;
            newNode.prev = header;
            trailer.prev = newNode;
            newNode.next = trailer;
            size++;
        } else {
            Node<E> newNode = new Node<>(element);
            Node<E> currentNode = header;
            for (int i = 0; i < size; i++){
                currentNode = currentNode.next;
            }
            currentNode.next = newNode;
            newNode.prev = currentNode;
            newNode.next = trailer;
            trailer.prev = newNode;
            size++;
        }
    }

    /**
     * Remove and return the element at the front of the deque.
     * Throw a NoSuchElementException(), if the deque is empty.
     */
    @Override
    public E removeFirst(){
        if (size == 0){
            throw new NoSuchElementException("Deque is empty!");
        } else {
            Node<E> poppedItem = header.next;
            if (size == 1){
                clear();
            } else {
                Node<E> temp = header.next.next;
                header.next = temp;
                temp.prev = header;
                size--;
            }
            return poppedItem.element;
        }
    }

    /**
     * Remove and return the element at the back of the deque.
     * Throw a NoSuchElementException(), if the deque is empty.
     */
    @Override
    public E removeLast(){
        if (size == 0){
            throw new NoSuchElementException("Deque is empty!");
        } else {
            Node<E> currentNode = header.next;
            for (int i = 1; i < size; i++){
                currentNode = currentNode.next;
            }
            Node<E> poppedItem = currentNode;
            currentNode.prev.next = trailer;
            trailer.prev = currentNode.prev;
            size--;
            return poppedItem.element;
        }
    }

    /**
     * Return the element at the front of the deque.
     * Throw a NoSuchElementException(), if the deque is empty.
     */
    @Override
    public E getFirst(){
        if (size == 0){
            throw new NoSuchElementException("Deque is empty!");
        } else {
            return header.next.element;
        }
    }

    /**
     * Return the element at the back of the deque.
     * Throw a NoSuchElementException(), if the deque is empty.
     */
    @Override
    public E getLast(){
        if (size == 0){
            throw new NoSuchElementException("Deque is empty!");
        } else {
            Node<E> currentNode = header.next;
            for (int i = 1; i < size; i++){
                currentNode = currentNode.next;
            }
            return currentNode.element;
        }
    }

    /**
     * Return true, if the deque is empty.
     */
    @Override
    public boolean isEmpty(){
        return header.next == trailer;
    }

    /**
     * Remove all elements from the deque.
     */
    @Override
    public void clear(){
        header.next = trailer;
        trailer.prev = header;
        size = 0;
    }

    /**
     * Return the number of elements in the deque.
     */
    @Override
    public int size(){
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

        if (size != 0){
            currentNode = header;
            for (int i = 0; i < size; i++){
                currentNode = currentNode.next;
                result.append(currentNode.element);
                if (!(currentNode.next == trailer)){
                    result.append(", ");
                }
            }
        }
        return result.toString() + "]";
    }
}