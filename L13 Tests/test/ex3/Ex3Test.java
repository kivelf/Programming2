package ex3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Ex3Test {

    @Test
    void totalPayment() {
        // arrange

        // act
        double amount1 = Ex3.totalPayment(0, 0);
        double amount2 = Ex3.totalPayment(1, 0);
        double amount3 = Ex3.totalPayment(0, 1);

        double amount4 = Ex3.totalPayment(0, 2);
        double amount5 = Ex3.totalPayment(0, 3);
        double amount6 = Ex3.totalPayment(1, 1);
        double amount7 = Ex3.totalPayment(1, 2);
        double amount8 = Ex3.totalPayment(2, 0);
        double amount9 = Ex3.totalPayment(2, 1);
        double amount10 = Ex3.totalPayment(3, 0);

        double amount11 = Ex3.totalPayment(0, 6);
        double amount12 = Ex3.totalPayment(5, 2);


        // assert
        assertEquals(0, amount1, 0.0001);
        assertEquals(2000, amount2, 0.0001);
        assertEquals(1000, amount3, 0.0001);

        assertEquals(1750, amount4, 0.0001);
        assertEquals(2500, amount5, 0.0001);
        assertEquals(2750, amount6, 0.0001);
        assertEquals(3500, amount7, 0.0001);
        assertEquals(3500, amount8, 0.0001);
        assertEquals(4250, amount9, 0.0001);
        assertEquals(5000, amount10, 0.0001);

        assertEquals(4000, amount11, 0.0001);
        assertEquals(8000, amount12, 0.0001);
    }
}