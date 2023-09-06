package opg6;

public class Ex6 {
    public static void main(String[] args) {
        System.out.println("GCD of 25 and 100 is: " + gcd(25, 100));
        System.out.println("GCD of 100 and 25 is: " + gcd(100, 25));
        System.out.println("GCD of 100 and 1000 is: " + gcd(100, 1000));
        System.out.println("GCD of 75 and 60 is: " + gcd(75, 60));
        System.out.println("GCD of 13 and 17 is: " + gcd(13, 17));
    }

    /** Both a and b are >= 2. */
    public static int gcd(int a, int b){
        if (b <= a && a % b == 0){
            return b;
        } else if (a < b){
            return gcd(b, a);
        } else {
            return gcd(b, a % b);
        }
    }
}
