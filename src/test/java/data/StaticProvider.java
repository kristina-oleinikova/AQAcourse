package data;

import org.testng.annotations.DataProvider;

public class StaticProvider {

    @DataProvider(name = "Data for SumTest", parallel = true, indices = 2)
    public static Object[][] dataForSumTest(){
        return new Object[][]{
                {-2, -3, -5},
                {0, 0, 0},
                {2, 3, 5},
                {-1, 2, 1}
        };
    }
}
