package opg2;

import java.math.BigInteger;

public class Ex2 {
    public static void main(String[] args) {
        int n = 2;
        for (int p = 0; p <= 10; p++){
            System.out.printf("n: %1d    to the power of %2d = %,d\n", n, p, power(BigInteger.valueOf(n), BigInteger.valueOf(p)));
        }

        System.out.println(power(BigInteger.valueOf(2), BigInteger.valueOf(128)));
        System.out.println();
        System.out.println("Testing the second method:");
        for (int p = 0; p <= 10; p++){
            System.out.printf("n: %1d    to the power of %2d = %,d\n", n, p, power2(n, p));
        }
    }

    /** Calculates n^p for p >= 0. */
    public static BigInteger power(BigInteger n, BigInteger p){
        if (p.intValue() == 0){
            return BigInteger.valueOf(1);
        } else {
            return n.multiply(power(n, p.subtract(BigInteger.valueOf(1))));
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
