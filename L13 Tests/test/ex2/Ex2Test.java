package ex2;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class Ex2Test {

    @Test
    void calculateFine() {
        // arrange
        LocalDate calculatedDate = LocalDate.of(2023, 10, 14);

        // act
        int fine1 = Ex2.calculateFine(calculatedDate, LocalDate.of(2023, 10, 15), true);
        int fine2 = Ex2.calculateFine(calculatedDate, LocalDate.of(2023, 10, 15), false);
        int fine3 = Ex2.calculateFine(calculatedDate, LocalDate.of(2023, 10, 22), true);
        int fine4 = Ex2.calculateFine(calculatedDate, LocalDate.of(2023, 10, 22), false);
        int fine5 = Ex2.calculateFine(calculatedDate, LocalDate.of(2023, 10, 29), true);
        int fine6 = Ex2.calculateFine(calculatedDate, LocalDate.of(2023, 10, 29), false);

        // assert
        assertEquals(20, fine1);
        assertEquals(10, fine2);
        assertEquals(60, fine3);
        assertEquals(30, fine4);
        assertEquals(90, fine5);
        assertEquals(45, fine6);
    }
}