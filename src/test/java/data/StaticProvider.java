package data;

import org.testng.annotations.DataProvider;

public class StaticProvider {

    @DataProvider(name = "Data for SumTest", parallel = true, indices = 2)
    public static Object[][] dataForSumTest() {
        return new Object[][]{
                {-2, -3, -5},
                {0, 0, 0},
                {2, 3, 5},
                {-1, 2, 1}
        };
    }

    @DataProvider(name = "Data for division integer", parallel = true)
    public static Object[][] dataForDivInteger() {
        return new Object[][]{
                {6, 2, 3},
                {9, 3, 3},
                {1, 3, 0},
                {-2, -1, 2}
        };
    }

    @DataProvider(name = "Data for division double", parallel = true)
    public static Object[][] dataforDivDouble() {
        return new Object[][]{
                {-2.2, -1.1, 2},
                {1.0, 4.0, 0.25},
                {0.0, 1.2, 0}
        };
    }
}
