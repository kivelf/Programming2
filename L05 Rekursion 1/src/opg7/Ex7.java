package opg7;

public class Ex7 {
    public static void main(String[] args) {
        int num = 5;
        System.out.println("Number of ways to cover a 2 * " + num
                + " strip with domino blocks with size 2 * 1: " + coverWithDominoes(num));
    }

    // f(0) = 1, f(1) = 1 -- base cases
    // f(n) = f(n - 1) + f(n - 2)
    /** n >= 0. */
    public static int coverWithDominoes(int n){
        if (n <= 1){
            return 1;
        } else {
            return coverWithDominoes(n - 1) + coverWithDominoes(n - 2);
        }
    }
}
