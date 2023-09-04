package opg1;

public class Ex1 {
    public static void main(String[] args) {
        for (int n = 1; n <= 10; n++){
            System.out.printf("i: %2d    factorial = %,d\n", n, factorial(n));
        }

        System.out.println();

        for (int n = 1; n <= 10; n++){
            System.out.printf("i: %2d    factorial = %,d\n", n, factorialShort(n));
        }
    }

    /** Return n! for the given n > 0. */
    public static long factorial(int n){
        long result;
        if (n == 1){
            result = 1;
        } else {
            result = n * factorial(n - 1);
        }
        return result;
    }

    /** Return n! for the given n > 0. */
    public static long factorialShort(int n){
        if (n == 1) return 1;
        else return n * factorialShort(n - 1);
    }
}
