package opg3;

public class Ex3 {
    public static void main(String[] args) {
        System.out.println("3 * 5 is " + prod(3, 5));
        System.out.println("12 * 8 is " + prod(12, 8));
        System.out.println("7 * 6 is " + prod(7, 6));
        System.out.println("18 * 5 is " + prod(18, 5));

        System.out.println();
        System.out.println("Testing the second method:");

        System.out.println("3 * 5 is " + prodRus(3, 5));
        System.out.println("12 * 8 is " + prodRus(12, 8));
        System.out.println("7 * 6 is " + prodRus(7, 6));
        System.out.println("18 * 5 is " + prodRus(18, 5));
    }

    /** Calculates a * b for a and b >= 0. */
    public static int prod(int a, int b){
        if (a == 0){
            return 0;
        } else if (a == 1){
            return b;
        } else {
            return prod(a - 1, b) + b;
        }
    }

    public static int prodRus(int a, int b){
        if (a == 0){
            return 0;
        } else if (a % 2 == 0 && a >= 2){
            return prodRus(a / 2, 2 * b);
        } else {
            return prodRus(a - 1, b) + b;
        }
    }
}
