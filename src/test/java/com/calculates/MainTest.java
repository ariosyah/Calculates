package test.java.com.calculates;

import main.java.com.calculates.Main;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class MainTest {

    @Test(dataProvider = "testCases")
    public void testCalculate(double a, double b, double c, double d, double expected) {
        double result = Main.calculate(a, b, c, d);
        if (Double.isNaN(expected)) {
            Assert.assertTrue(Double.isNaN(result), "Expected NaN, but got: " + result);
            System.out.println("Test case: (" + a + " + " + b + ") / (" + c + " + " + d + ") - Expected: NaN, Result: NaN - Correct");
        } else {
            Assert.assertEquals(result, expected, "Calculation result is incorrect");
            System.out.println("Test case: (" + a + " + " + b + ") / (" + c + " + " + d + ") - Expected: " + expected + ", Result: " + result + " - " + (result == expected ? "Correct" : "Incorrect"));
        }
    }

    @DataProvider(name = "testCases")
    public Object[][] testData() {
        return new Object[][]{
                // TC 1: Basic positive numbers
                {3, 4, 1, 2, 2.3333333333333335},
                // TC 2: All zeros (division by zero)
                {0, 0, 0, 0, Double.NaN},
                // TC 3: Zero denominator (zero sum)
                {1, 2, -2, 2, Double.NaN},
                // TC 4: Negative numbers
                {-3, -5, 2, 3, -1.6},
                // TC 5: Decimal numbers
                {1.5, 2.25, 0.5, 0.75, 3},
                // TC 6: Numbers of moderate magnitude
                {10000, 20000, 5000, 10000, 2},
                // TC 7: Mixed positive and negative numbers
                {0, 5, 3, 2, 1},
                // TC 8: Another mix of positive and negative numbers
                {10, 5, 3, 2, 3},
                // TC 9: Denominator zero with negative numbers
                {5, 3, -3, -2, -1.6},
                // TC 10: Numerator zero
                {0, 3, 1, 2, 1},
                // TC 11: Both numerator and denominator zero
                {3, 2, 0, 0, Double.NaN},
                // TC 12: Decimal numbers with precision
                {1.23456789, 2.34567891, 3.45678912, 4.56789123, 0.44642857142857145},
                // TC 13: Negative numbers with negative result
                {-2, 4, -3, 5, 1},
                // TC 14: Very large numbers with precision
                {123456789.123, 987654321.987, 11111.111, 22222.222, 33.33333307442849},
                // TC 15: Large and small values
                {Double.MAX_VALUE, Double.MIN_VALUE, Double.MAX_VALUE, Double.MIN_VALUE, 1.0},
                // TC 16: Large numbers with negative result
                {Double.MAX_VALUE, -Double.MAX_VALUE, Double.MIN_VALUE, Double.MIN_VALUE, -1.0},
                // TC 17: Boundary check with maximum values
                {Double.MAX_VALUE, Double.MAX_VALUE, Double.MAX_VALUE, Double.MAX_VALUE, 1.0},
                // TC 18: Boundary check with minimum values
                {Double.MIN_VALUE, Double.MIN_VALUE, Double.MIN_VALUE, Double.MIN_VALUE, Double.NaN},
                // TC 19: Boundary check with one zero and other non-zero values
                {0, Double.MAX_VALUE, Double.MIN_VALUE, Double.MIN_VALUE, Double.NaN},
                // TC 20: Boundary check with one zero and other maximum values
                {0, Double.MAX_VALUE, Double.MAX_VALUE, Double.MAX_VALUE, 0.0},
                // TC 21: Boundary check with one zero and other minimum values
                {0, Double.MIN_VALUE, Double.MIN_VALUE, Double.MIN_VALUE, Double.NaN},
                // TC 22: Boundary check with all zeros except one non-zero value
                {0, 0, 0, Double.MIN_VALUE, Double.NaN},
                // TC 23: Error handling - division by very small non-zero value
                {1, 2, 0, Double.MIN_VALUE, Double.POSITIVE_INFINITY},
                // TC 24: Error handling - division by very small negative non-zero value
                {1, 2, 0, -Double.MIN_VALUE, Double.NEGATIVE_INFINITY},
                // TC 25: Error handling - division by very large non-zero value
                {1, 2, 0, Double.MAX_VALUE, 0.0},
                // TC 26: Error handling - division by very large negative non-zero value
                {1, 2, 0, -Double.MAX_VALUE, -0.0}
        };
    }
}
