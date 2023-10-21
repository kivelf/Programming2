package ex2;

import java.time.LocalDate;
import java.time.Period;

public class Ex2 {
    /*
Return the fine according to the table above.
Pre: calculatedDate < actualDate
(calculatedDate is the expected return date and
actualDate is the day you actually return the book)
*/
    public static int calculateFine(LocalDate calculatedDate, LocalDate actualDate, boolean adult){
        int fine = 0;
        Period period = Period.between(calculatedDate, actualDate);
        int days = Math.abs(period.getDays());
        if (days <= 7){
            fine = 10;
        } else if (days <= 14){
            fine = 30;
        } else {
            fine = 45;
        }
        if (adult){
            fine *= 2;
        }
        return fine;
    }
}
