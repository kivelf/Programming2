package ex2;

public interface Deque23Y<E> {
    /**
     * Add the element at the front of the deque.
     */
    public void addFirst(E element);

    /**
     * Add the element at the back of the deque.
     */
    public void addLast(E element);

    /**
     * Remove and return the element at the front of the deque.
     * Throw a NoSuchElementException(), if the deque is empty.
     */
    public E removeFirst();

    /**
     * Remove and return the element at the back of the deque.
     * Throw a NoSuchElementException(), if the deque is empty.
     */
    public E removeLast();

    /**
     * Return the element at the front of the deque.
     * Throw a NoSuchElementException(), if the deque is empty.
     */
    public E getFirst();

    /**
     * Return the element at the back of the deque.
     * Throw a NoSuchElementException(), if the deque is empty.
     */
    public E getLast();

    /**
     * Return true, if the deque is empty.
     */
    public boolean isEmpty();

    /**
     * Remove all elements from the deque.
     */
    public void clear();

    /**
     * Return the number of elements in the deque.
     */
    public int size();
}
