package ex4;

import stack23ystudent.ArrayStack23Y;
import stack23ystudent.Stack23Y;

public class Ex4 {
    public static void main(String[] args) {
        System.out.println("The result of '3 4 5 + *' is: " + evaluate("3 4 5 + *"));   // 3 * (4 + 5) = 27
        System.out.println("The result of '3 4 5 * +' is: " + evaluate("3 4 5 * +"));   // 3 + (4 * 5) = 23
        System.out.println("The result of '3 4 + 5 *' is: " + evaluate("3 4 + 5 *"));   // (3 + 4) * 5 = 35
        System.out.println("The result of '12 2 5 + - 4 * 2 /' is: " + evaluate("12 2 5 + - 4 * 2 /"));   // 10
    }

    public static int evaluate(String postfixInput) {
        int result = 0;
        try {
            Stack23Y stack = new ArrayStack23Y();
            String[] input = postfixInput.split(" ");

            for (String i : input) {
                if (i.charAt(0) >= 48 && i.charAt(0) <= 57) {
                    // it's a number thus we add it to the stack
                    stack.push(Integer.parseInt(i));
                } else {
                    if (stack.size() < 2) {
                        throw new RuntimeException("Invalid postfix expression!");
                    } else {
                        int operand2 = (Integer) stack.pop();
                        int operand1 = (Integer) stack.pop();

                        result = switch (i) {
                            case "+" -> operand1 + operand2;
                            case "-" -> operand1 - operand2;
                            case "*" -> operand1 * operand2;
                            case "/" -> {
                                if (operand2 == 0) {
                                    throw new ArithmeticException("Division by 0");
                                }
                                yield operand1 / operand2;
                            }

                            default -> throw new IllegalStateException("Unexpected value: " + i);
                        };

                        stack.push(result);
                    }
                }
            }
        } catch (RuntimeException e) {
            System.out.println(e);
            System.out.println("The input is not a valid postfix expression!");
        }
        return result;
    }
}