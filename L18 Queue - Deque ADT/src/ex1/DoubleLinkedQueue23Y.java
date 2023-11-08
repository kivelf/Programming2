package ex1;

import java.util.NoSuchElementException;

public class DoubleLinkedQueue23Y<E> implements Queue23Y<E> {
    // uses both header and tailer pointers
    // insert before trailer, remove after header
    private Node<E> header = new Node<>(null);
    private Node<E> trailer = new Node<>(null);
    // the number of element in the queue
    int size = 0;

    // constructor
    public DoubleLinkedQueue23Y() {
        header.next = trailer;
        trailer.prev = header;
    }


    /**
     * Add the element at the back of the queue.
     */
    @Override
    public void add(E element){
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
     * Remove and return the element at the front of the queue.
     * Throw a NoSuchElementException(), if the queue is empty.
     */
    @Override
    public E remove(){
        if (size == 0){
            throw new NoSuchElementException("Stack is empty!");
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
     * Return the element at the front of the queue.
     * Throw a NoSuchElementException(), if the queue is empty.
     */
    @Override
    public E element(){
        if (size == 0){
            throw new NoSuchElementException("Stack is empty!");
        } else {
            return header.next.element;
        }
    }

    /**
     * Return true, if the queue is empty.
     */
    @Override
    public boolean isEmpty(){
        return header.next == trailer;
    }

    /**
     * Remove all elements from the queue.
     */
    @Override
    public void clear(){
        header.next = trailer;
        trailer.prev = header;
        size = 0;
    }

    /**
     * Return the number of elements in the queue.
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