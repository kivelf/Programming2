package ex2;

import stack23ystudent.ArrayStack23Y;
import stack23ystudent.Stack23Y;

public class Ex2 {
    public static void main(String[] args) {
        String stringToTest1 = "(3+{5[99 {*}]}[23[{67}67]])";
        String stringToTest2 = "(}){";

        System.out.println("Does string '(3+{5[99 {*}]}[23[{67}67]])' contain matching brackets? "
                + checkMatchingBrackets(stringToTest1));     // true
        System.out.println("Does string '(}){' contain matching brackets? "
                + checkMatchingBrackets(stringToTest2));     // false
    }

    public static boolean checkMatchingBrackets(String stringToTest){
        Stack23Y stack = new ArrayStack23Y();
        boolean keepGoing = true;

        while (keepGoing){
            for (int i = 0; i < stringToTest.length(); i++){
                if (stringToTest.charAt(i) == 40 || stringToTest.charAt(i) == 91 || stringToTest.charAt(i) == 123){
                    stack.push(stringToTest.charAt(i));
                } else if (stringToTest.charAt(i) == 41){
                    if ((char) stack.peek() == 40){
                        stack.pop();
                    } else {
                        return false;
                    }
                } else if (stringToTest.charAt(i) == 93 || stringToTest.charAt(i) == 125){
                    if ((char) stack.peek() == (stringToTest.charAt(i) - 2)){
                        stack.pop();
                    } else {
                        return false;
                    }
                }
                if (i == stringToTest.length() - 1){
                    keepGoing = false;
                }
            }
        }
        return stack.isEmpty();
    }
}
