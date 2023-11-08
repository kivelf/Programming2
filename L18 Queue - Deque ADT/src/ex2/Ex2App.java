package ex2;

public class Ex2App{
    public static void main(String[] args) {
//        Queue23Y<String> queue = new SingleLinkedQueue23Y<>();
//        Queue23Y<String> queue = new DoubleLinkedQueue23Y<>();
        Deque23Y<String> deque = new DoubleLinkedDeque23Y<>();

        deque.addLast("Tom");
        deque.addLast("Diana");
        deque.addLast("Harry");
        deque.addLast("Thomas");
        deque.addLast("Bob");
        deque.addLast("Brian");
        System.out.println(deque.getFirst());
        System.out.println(deque.getLast());
        System.out.println(deque.isEmpty() + " " + deque.size());
        System.out.println();

        System.out.println(deque.toString());
        System.out.println();
        while (!deque.isEmpty()) {
            System.out.println(deque.removeFirst());
        }
        System.out.println();

        System.out.println(deque.isEmpty() + " " + deque.size());
        System.out.println();

        deque.addFirst("Tom");
        deque.addFirst("Diana");
        deque.addFirst("Harry");
        deque.addFirst("Thomas");
        deque.addFirst("Bob");
        deque.addFirst("Brian");
        System.out.println(deque.toString() + ", size: " + deque.size());
        deque.clear();
        System.out.println(deque.isEmpty() + " " + deque.size());
        System.out.println();

        // -------- test of reverse --------

        Integer[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        reverse(numbers);
        for (Integer number : numbers) {
            System.out.print(number + " ");
        }
    }

    /**
     * Reverse the table.
     */
    public static <E> void reverse(E[] table) {
        Deque23Y<E> deque = new DoubleLinkedDeque23Y<>();
        for (E e : table) {
            deque.addLast(e);
        }
        int i = 0;
        while (!deque.isEmpty()) {
            table[i] = deque.removeLast();
            i++;
        }
    }
}
