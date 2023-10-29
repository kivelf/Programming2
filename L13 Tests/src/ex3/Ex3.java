package ex3;

public class Ex3 {
    public static double totalPayment(int small, int big) {
        int daycarePrice = 2000;
        int sfaPrice = 1000;

        double total = 0;

        int totalChildren = small + big;

        if (totalChildren >= 4) {
            if (small == 0) {
                total = sfaPrice + (sfaPrice * 2 * 0.75) + ((totalChildren - 3) * sfaPrice * 0.5);
            } else if (small == 1) {
                total = daycarePrice + (sfaPrice * 2 * 0.75) + ((totalChildren - 3) * sfaPrice * 0.5);
            } else if (small == 2) {
                total = daycarePrice + daycarePrice * 0.75 + (sfaPrice * 0.75) + ((totalChildren - 3) * sfaPrice * 0.5);
            } else if (small == 3) {
                total = daycarePrice + daycarePrice * 2 * 0.75 + (big * sfaPrice * 0.5);
            } else {
                // more than 3 small children + unknown number of big children
                total = daycarePrice + daycarePrice * 2 * 0.75 + ((small - 3) * daycarePrice * 0.5) + (big * sfaPrice * 0.5);
            }
        } else if (totalChildren > 1 && totalChildren <= 3) {
            if (small == 1) {
                total = daycarePrice + ((totalChildren - 1) * sfaPrice * 0.75);
            } else if (small == 2) {
                total = daycarePrice + daycarePrice * 0.75 + ((totalChildren - 2) * sfaPrice * 0.75);
            } else if (small == 3) {
                total = daycarePrice + daycarePrice * 2 * 0.75;
            } else {
                total = sfaPrice + ((totalChildren - 1) * sfaPrice * 0.75);
            }
        } else if (totalChildren == 1) {
            if (small == 1) {
                total += daycarePrice;
            } else {
                total += sfaPrice;
            }
        }

        return total;
    }
}
