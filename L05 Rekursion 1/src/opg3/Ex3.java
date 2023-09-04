package opg3;

public class Ex3 {
    public static void main(String[] args) {

    }

    /** Calculates a * b for a and b >= 0. */
    public static int prod(int a, int b){
        if (a == 0){
            return 0;
        } else if (a == 1){
            return b;
        } else {
            return prod(a - 1, b);
        }
    }
}
