import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Main {

    @Test(dataProvider = "testCases")
    public void testCalculate(double a, double b, double c, double d, double expected) {
        double result = calculate(a, b, c, d);
        Assert.assertEquals(result, expected);
    }

    @DataProvider(name = "testCases")
    public Object[][] testData() {
        return new Object[][]{
                {3, 4, 1, 2, 2.3333333333333335},
                {0, 0, 0, 0, Double.NaN}, // Undefined (division by zero)
                {1, 2, -2, 2, Double.NaN}, // Denominator zero
                {-3, -5, 2, 3, -1.6},
                {1.5, 2.25, 0.5, 0.75, 3},
                {10000, 20000, 5000, 10000, 2},
                {0, 5, 3, 2, 1},
                {10, 5, 3, 2, 3},
                {5, 3, -3, -2, -1.6},
                {0, 3, 1, 2, 1},
                {3, 2, 0, 0, Double.NaN}, // Denominator zero
                {1.23456789, 2.34567891, 3.45678912, 4.56789123, 0.44642857142857145},
                {-2, 4, -3, 5, 1},
                {123456789.123, 987654321.987, 11111.111, 22222.222, 33333.33307442849},
                {5, 3, 2, 1, 2.6666666666666665}
        };
    }

    public static double calculate(double a, double b, double c, double d) {
        return (a + b) / (c + d);
    }
}
