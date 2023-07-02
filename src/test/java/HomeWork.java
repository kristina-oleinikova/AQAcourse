import data.StaticProvider;
import org.testng.Assert;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class HomeWork extends BaseTest{

    @Test(groups = "smoke",priority = 1)
    public void simpleTest() {
        int expectedResult= 3;
        Assert.assertEquals(calculator.div(6,2), expectedResult, "Values don't match");
    }

    @Test(description = "Divide integer", testName = "Division integer numbers", enabled = true)
    public void descriptionTest() {
        int expectedResult= 3;
        Assert.assertEquals(calculator.div(6,2), expectedResult, "Values don't match");
    }

    @Test(testName = "Test with timeout", timeOut = 3000, dependsOnMethods = "simpleTest")
    public void TimeOutTest() throws InterruptedException {
        Thread.sleep(2500);
        int expectedResult= 3;
        Assert.assertEquals(calculator.div(6,2), expectedResult, "Values don't match");
    }

    @Test(invocationCount = 2, invocationTimeOut = 1000)
    public void invocationCountTest() throws InterruptedException {
        Thread.sleep(500);
        int expectedResult= 3;
        Assert.assertEquals(calculator.div(6,2), expectedResult, "Values don't match");
    }

    @Test(groups = "smoke", testName = "Divide Integer", dataProvider = "Data for division integer", dataProviderClass = StaticProvider.class)
    public void divideInteger(int a, int b, int expectedResult){
        Assert.assertEquals(calculator.div(a,b), expectedResult, "Values don't match");
    }

    @Test(testName = "Divide Double", dataProvider = "Data for division double", dataProviderClass = StaticProvider.class)
    public void divideDouble(double a, double b, double expectedResult){
        Assert.assertEquals(calculator.div(a,b), expectedResult, "Values don't match");
    }

    @Test(groups = "regression", testName = "Division Integer by zero")
    public void divideByZero() throws ArithmeticException{
        Assert.assertEquals(calculator.div(12, 0), ArithmeticException.class, "Values don't match");
    }

    @Test(groups = "regression", testName = "Double.POSITIVE_INFINITY test")
    public void divideByZeroDoublePositive(){
        Assert.assertEquals(calculator.div(12.2, 0), Double.POSITIVE_INFINITY, "Values don't match");
    }

    @Test(groups = "regression", testName = "Double.NEGATIVE_INFINITY test")
    public void divideByZeroDoubleNegative(){
        Assert.assertEquals(calculator.div(-12.2, 0), Double.NEGATIVE_INFINITY, "Values don't match");
    }

    @Test(testName = "Double.NaN test")
    public void divideByZeroNaN(){
        double expectedResult = calculator.div(0.0,0);

        Assert.assertEquals(Double.NaN, expectedResult);
    }

    @Test(expectedExceptions = ArithmeticException.class)
    public void exceptionTest(){
        int expectedResult = calculator.div(2,0);
    }

    @Test
    @Parameters({"a","b"})
    public void parameterTest(@Optional("Default value") int c,@Optional("Default value") int d){
        int expectedResult = 3;
        Assert.assertEquals(calculator.div(c,d), expectedResult, "Values don't match");
    }
}
