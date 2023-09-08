package opg3;

public class Ex3 {
    public static void main(String[] args) {
        System.out.println("Testing the recursive method:");
        for (int n = 3; n <=6; n++){
            System.out.printf("n = %d, no%d = %d\n", n, n, calcNo(n));
        }
        System.out.println("Testing the iterative method:");
        for (int n = 3; n <=6; n++){
            System.out.printf("n = %d, no%d = %d\n", n, n, calcNoIteratively(n));
        }
    }

    /** Pre: n >= 0. */
    public static int calcNo(int n){
        if (n == 0){
            return 2;
        } else if (n == 1){
            return 1;
        } else if (n == 2){
            return 5;
        } else if (n % 2 == 0){
            return 2 * calcNo(n - 3) - calcNo(n - 1);
        } else {
            return calcNo(n - 1) + calcNo(n - 2) + 3 * calcNo(n - 3);
        }
    }

    /** Pre: n >= 0. */
    public static int calcNoIteratively(int n){
        if (n == 0) return 2;
        if (n == 1) return 1;
        if (n == 2) return 5;

        int noMinus3 = 2;
        int noMinus2 = 1;
        int noMinus1 = 5;
        int result = 0;

        for (int i = 3; i <= n; i++){
            if (i % 2 == 0){
                result = 2 * noMinus3 - noMinus1;
            } else {
                result = noMinus1 + noMinus2 + 3 * noMinus3;
            }
            noMinus3 = noMinus2;
            noMinus2 = noMinus1;
            noMinus1 = result;
        }

        return result;
    }
}
