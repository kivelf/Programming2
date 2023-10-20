package ex1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarInsuranceTest {
    private CarInsurance insurance;
    @BeforeEach
    void setUp(){
        insurance = new CarInsurance(1000);
    }

    @Test
    void calculatePremium() {
        // arrange

        // act
        double premiumTC1 = insurance.calculatePremium(26, true, 0);
        double premiumTC2 = insurance.calculatePremium(24, false, 0);
        double premiumTC3 = insurance.calculatePremium(25, false, 0);
        double premiumTC4 = insurance.calculatePremium(25, true, 3);
        double premiumTC5 = insurance.calculatePremium(24, false, 6);

        // assert
        assertEquals(950, premiumTC1, 0.0001);
        assertEquals(1250, premiumTC2, 0.0001);
        assertEquals(1000, premiumTC3, 0.0001);
        assertEquals(807.5, premiumTC4, 0.0001);
        assertEquals(937.5, premiumTC5, 0.0001);
    }

    @Test
    void calculatePremiumThrowsExceptionDueToAge(){
        // arrange

        // act + assert
        // expected to throw an error since age < 18
        Exception exception = assertThrows(InvalidInputException.class,
                () -> insurance.calculatePremium(17, true, 0));
        assertEquals(exception.getMessage(), "Invalid years input!");
    }

    @Test
    void calculatePremiumThrowsExceptionDueToYearsWithoutDamage(){
        // arrange

        // act + assert
        // expected to throw an error since yearsWithoutDamage < 0
        Exception exception = assertThrows(InvalidInputException.class,
                () -> insurance.calculatePremium(21, true, -1));
        assertEquals(exception.getMessage(), "Invalid years input!");
    }
}