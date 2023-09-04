package opg2;

public class Ex2 {
    public static void main(String[] args) {
        int n = 2;
        for (int p = 0; p <= 10; p++){
            System.out.printf("n: %1d    to the power of %2d = %,d\n", n, p, power(n, p));
        }

        System.out.println();
        System.out.println("Testing the second method:");
        for (int p = 0; p <= 10; p++){
            System.out.printf("n: %1d    to the power of %2d = %,d\n", n, p, power2(n, p));
        }
    }

    /** Calculates n^p for p >= 0. */
    public static int power(int n, int p){
        if (p == 0){
            return 1;
        } else {
            return n * (power(n, p - 1));
        }
    }

    /** Calculates n^p for p >= 0. */
    public static int power2(int n, int p){
        if (p == 0){
            return 1;
        } else if (p % 2 == 1){
            return n * (power2(n, p - 1));
        } else {
            return power2((n * n), p / 2);
        }
    }
}
