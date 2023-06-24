import data.StaticProvider;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class CalculatorTest extends BaseTest{
    @Test
    public void sumTest_1(){
        int expectedValue = 5;
        int actualValue = calculator.sum(2, 3);

        Assert.assertEquals(actualValue,expectedValue, "Values are not equals");
    }

    @Test(enabled = false)
    public void sumTest_2(){
        int expectedValue = 5;
        int actualValue = calculator.sum(2, 3);

        Assert.assertEquals(actualValue,expectedValue, "Values are not equals");
    }

    @Test(description = "Test with description")
    public void sumTest_3(){
        int expectedValue = 5;
        int actualValue = calculator.sum(2, 3);

        Assert.assertEquals(actualValue,expectedValue, "Values are not equals");
    }

    @Test(testName = "Test with name")
    public void sumTest_4(){
        int expectedValue = 5;
        int actualValue = calculator.sum(2, 3);

        Assert.assertEquals(actualValue,expectedValue, "Values are not equals");
    }

    @Test(timeOut = 1000)
    public void sumTest_5() throws InterruptedException {
        Thread.sleep(1000);
        int expectedValue = 5;
        int actualValue = calculator.sum(2, 3);

        Assert.assertEquals(actualValue,expectedValue, "Values are not equals");
    }

    @Test(invocationCount = 3, invocationTimeOut = 1000, threadPoolSize = 3)
    public void invocationCountTest() throws InterruptedException {
        Thread.sleep(500);
        int expectedValue = 5;
        int actualValue = calculator.sum(2, 3);

        Assert.assertEquals(actualValue,expectedValue, "Values are not equals");
    }

    @Test(expectedExceptions = NullPointerException.class)
    public void exceptionTest(){
        List list = null;
        int size = list.size();
    }

    @Test(dataProvider = "Data for SumTest", dataProviderClass = StaticProvider.class, threadPoolSize = 2)
    public void dataProviderTest(int a, int b, int expectedValue) throws InterruptedException {
        Thread.sleep(1000);
        Assert.assertEquals(calculator.sum(a, b),expectedValue, "Values are not equals");
    }
}
