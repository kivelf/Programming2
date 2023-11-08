package ex1;

public class Ex1App {
    public static void main(String[] args) {
//        Queue23Y<String> queue = new SingleLinkedQueue23Y<>();
//        Queue23Y<String> queue = new DoubleLinkedQueue23Y<>();
        Queue23Y<String> queue = new ArrayQueue23Y<>();

        queue.add("Tom");
        queue.add("Diana");
        queue.add("Harry");
        queue.add("Thomas");
        queue.add("Bob");
        queue.add("Brian");
        System.out.println(queue.element());
        System.out.println(queue.isEmpty() + " " + queue.size());
        System.out.println();

        System.out.println(queue.toString());
        System.out.println();
        while (!queue.isEmpty()) {
            System.out.println(queue.remove());
        }
        System.out.println();

        System.out.println(queue.isEmpty() + " " + queue.size());
        System.out.println();

        // -------- test of reverse --------
        // reverse should actually _not_ reverse the numbers,
        // since we're adding at the back and removing at the front of the queue
        // so if the queue works, we should get the exact same list of numbers back

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
//        Queue23Y<E> queue = new SingleLinkedQueue23Y<>();
//        Queue23Y<E> queue = new DoubleLinkedQueue23Y<>();
        Queue23Y<E> queue = new ArrayQueue23Y<>();
        for (E e : table) {
            queue.add(e);
        }
        int i = 0;
        while (!queue.isEmpty()) {
            table[i] = queue.remove();
            i++;
        }
    }
}
