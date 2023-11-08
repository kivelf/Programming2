package ex1;

import java.util.NoSuchElementException;

public class SingleLinkedQueue23Y <E> implements Queue23Y<E> {
    // uses both head (first) and tail (last) pointers
    // insert after last, remove at first
    private Node<E> first = null;
    private Node<E> last = null;
    // the number of element in the queue
    int size = 0;

    // constructor
    public SingleLinkedQueue23Y() {
    }


    /**
     * Add the element at the back of the queue.
     */
    @Override
    public void add(E element){
        if (size == 0) {
            Node<E> newNode = new Node<>(element);
            first = newNode;
            first.next = last;
            size++;
        } else if (size == 1){
            Node<E> newNode = new Node<>(element);
            last = newNode;
            first.next = last;
            size++;
        } else {
            Node<E> newNode = new Node<>(element);
            last.next = newNode;
            last = newNode;
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
            Node<E> poppedItem = first;
            if (size == 1){
                first = first.next;
                last = null;
                size--;
            } else {
                first = first.next;
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
            return first.element;
        }
    }

    /**
     * Return true, if the queue is empty.
     */
    @Override
    public boolean isEmpty(){
        return first == null;
    }

    /**
     * Remove all elements from the queue.
     */
    @Override
    public void clear(){
        first.next = last;
        first = null;
        last = null;
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

        public Node(T element) {
            this.element = element;
            this.next = null;
        }
    }

    //-------------------------------------------
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("[");
        Node<E> currentNode = first;

        if (size != 0){
            currentNode = first;
            for (int i = 0; i < size; i++){
                result.append(currentNode.element);
                if (currentNode.next != null){
                    currentNode = currentNode.next;
                }
                if (i != size - 1){
                    result.append(", ");
                }
            }
        }
        return result.toString() + "]";
    }
}
