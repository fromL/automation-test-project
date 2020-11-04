package testcalculator;

import calculator.Calculator;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

public class TestCalculator extends BaseTestCalculator { // Do not extend it from parent Calculator class

    //  Calculator calc = new Calculator(); // Not really effective implementation, better to instantiate object in @BeforeMethod
    private Calculator calc; // Declaring variable of Calculator class

    @BeforeMethod(groups = "failedgroup")
    // If to remove "(groups = "failedgroup")" from here, all tests from testng2.xml with specified group will fail, the same is true for other annotations
    public void setUp() {
        calc = new Calculator();
        System.out.println("This is method executed before running Method");
    }

    @Test(groups = "passedgroup", priority = 1) //Test with parameters from testng.xml
    @Parameters({"a", "b"})
    public void testAdd(@Optional("19") int x, @Optional("7") int y) {
        int expectedResult = 20;
        Assert.assertEquals(Calculator.add(x, y), expectedResult, "Error: Sum is incorrect!");
        System.out.println("Test 'testAdd' successfully passed");
    }

    @Test(groups = "failedgroup", priority = 4) //Test with parameters from parent calculator.Calculator class
    public void testSubtract() {
        int expectedResult = 11;
        Assert.assertEquals(calc.subtract(calc.getA(), calc.getB()), expectedResult, "Error: a - b !=4");
    }

    @Test(groups = "passedgroup", priority = 2) //Test with parameters from parent calculator.Calculator class
    public void testArithmeticOrder() {
        int expectedResult = 8;
        Assert.assertEquals(calc.getA() - calc.getB() * calc.getC(), expectedResult, "Error: Arithmetic order is incorrect!");
        System.out.println("Test 'testArithmeticOrder' successfully passed");
    }

    @Test(groups = "failedgroup", priority = 5) //Test with constant parameters
    public void testMultiply() {
        int expectedResult = 21;
        Assert.assertEquals(calc.multiply(21, 2), expectedResult, "Error: x * y !=21");
    }


    @Test(groups = "failedgroup", dataProvider = "myDataProvider", priority = 6)
    //Test with parameters from DataProvider
    public void testDivide(int z, int x) {
        int expectedResult = 21;
        Assert.assertEquals(calc.divide(z, x), expectedResult, "Data Provider Test Failed");
    }

    @Test(groups = "passedgroup", priority = 3, expectedExceptions = IllegalArgumentException.class)
    public void testDivideByZero() {
        calc.divide(calc.getA(), 0);
    }

    @Test(priority = 7)
    public void testHardAsserts() {
        Assert.assertEquals(2 + 2, 4, "Error: 2 + 2 != 4");
        System.out.println("2 + 2 = 4");
        Assert.assertEquals(3 + 3, 6, "Error: 3 + 3 != 6");
        System.out.println("3 + 3 = 6");
        Assert.assertEquals(4 + 4, 4, "Error: 4 + 4 != 4");
        System.out.println("4 + 4 = 4");
        Assert.assertEquals(5 + 5, 10, "Error: 5 + 5 != 10");
        System.out.println("5 + 5 = 10");
        Assert.assertEquals(6 + 6, 14, "Error: 6 + 6 != 14");
        System.out.println("6 + 6 = 12");
    }

    @Test(priority = 8)
    public void testSoftAssert() {
        SoftAssert softassertobject = new SoftAssert();
        softassertobject.assertEquals(2 + 2, 4, "case 1 failed");
        softassertobject.assertEquals(3 + 3, 6, "case 2 failed");
        softassertobject.assertEquals(4 + 4, 4, "case 3 failed");
        softassertobject.assertEquals(5 + 5, 10, "case 4 failed");
        softassertobject.assertEquals(6 + 6, 13, "case 5 failed");
        softassertobject.assertAll();
    }

}
