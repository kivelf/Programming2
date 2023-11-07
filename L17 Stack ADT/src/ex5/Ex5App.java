package ex5;

public class Ex5App {
    public static void main(String[] args) {
//        DropOutStack<String> stack = new ArrayDropOutStack<>();
//        DropOutStack<String> stack = new LinkedDropOutStack<>();
        DropOutStack<String> stack = new DoubleLinkedDropOutStack<>();

        stack.push("Tom");
        stack.push("Diana");
        stack.push("Harry");
        stack.push("Thomas");
        stack.push("Bob");
        stack.push("Brian");
        System.out.println(stack.peek());
        System.out.println(stack.isEmpty() + " " + stack.size());
        System.out.println();

        System.out.println(stack.toString());
        System.out.println();
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
        System.out.println();

        System.out.println(stack.isEmpty() + " " + stack.size());
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
//        DropOutStack<E> stack = new ArrayDropOutStack<>();
//        DropOutStack<E> stack = new LinkedDropOutStack<>();
        DropOutStack<E> stack = new DoubleLinkedDropOutStack<>();
        for (E e : table) {
            stack.push(e);
        }
        int i = 0;
        while (!stack.isEmpty()) {
            table[i] = stack.pop();
            i++;
        }
    }
}
