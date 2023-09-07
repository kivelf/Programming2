package opg1;

public class Ex1 {
    public static void main(String[] args) {
        System.out.println(" m  0    1    2    3    4    5    6    7");
        System.out.println("n -----------------------------------------");
        for (int n = 0; n <= 7; n++){
            System.out.print(n + " | ");
            for (int m = 0; m <= 7; m++){
                if (m <= n){
                    System.out.printf("%-5d", binomial(n, m));
                } else {
                    System.out.print("     ");
                }
                if (m == 7){
                    System.out.println();
                }
            }
        }
    }

    /** Pre: 0 <= m <= n. */
    public static int binomial(int n, int m){
        if (m == 0 || m == n){
            return 1;
        } else {
            return binomial(n - 1, m) + binomial(n - 1, m - 1);
        }
    }
}
