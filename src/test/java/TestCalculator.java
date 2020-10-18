import org.junit.After;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

public class TestCalculator  { // Do not extend it from parent Calculator class

//    Calculator calc = new Calculator(); // Not really effective implementation, better to instantiate object in @BeforeMethod
    private Calculator calc; // Declaring variable of Calculator class

    @DataProvider(name = "myDataProvider")
    public static Object[][] getData(){
        return new Object[][]{
                {14, 7},
                {8, 0}
        };
    }

    @BeforeSuite
    public void beforeSuiteMethod(){
        System.out.println("This is method executed before running Test Suite");
    }

    @BeforeGroups
    public void beforeGroupsMethod(){
        System.out.println("This is method executed before running Groups");
    }

    @BeforeTest
    public void beforeTestMethod(){
        System.out.println("This is method executed before running Test");
    }

    @BeforeClass
    public void beforeClassMethod(){
        System.out.println("This is method executed before running Class");
    }

    @BeforeMethod (groups = "failedgroup") // If to remove "(groups = "failedgroup")" from here, all tests from testng2.xml will fail
    public void setUp(){
        calc = new Calculator();
        System.out.println("This is method executed before running Method");
    }

    @AfterSuite
    public void afterSuiteMethod(){
        System.out.println("This is method executed after running Test Suite");
    }

    @AfterGroups
    public void afterGroupsMethod(){
        System.out.println("This is method executed after running Groups");
    }

    @AfterTest
    public void afterTestMethod(){
        System.out.println("This is method executed after running Test");
    }

    @AfterClass
    public void afterClassMethod(){
        System.out.println("This is method executed after running Class");
    }

    @AfterMethod
    public void tearDown(){
        System.out.println("This is method executed after running Method");
    }

    @Test (groups = "passedgroup", priority = 1) //Test with parameters from testng.xml
    @Parameters ({"a", "b"})
    public void testAdd(int x, int y){
        int expectedResult = 20;
        Assert.assertEquals(Calculator.add(x, y), expectedResult);
        System.out.println("Test successfully passed");
    }

    @Test (groups = "failedgroup", priority = 4) //Test with parameters from parent Calculator class
    public void testSubtract(){
        int expectedResult = 11;
        Assert.assertEquals(calc.subtract(calc.getA(), calc.getB()), expectedResult, "Error: a - b !=4");
    }

    @Test (groups = "passedgroup", priority = 2) //Test with parameters from parent Calculator class
    public void testArithmeticOrder(){
        int expectedResult = 8;
        Assert.assertEquals(calc.getA() - calc.getB() * calc.getC(), expectedResult);
        System.out.println("Test successfully passed");
    }

    @Test (groups = "failedgroup", priority = 5) //Test with constant parameters
    public void testMultiply(){
        int expectedResult = 21;
        Assert.assertEquals(calc.multiply(21,2), expectedResult, "Error: x * y !=21");
    }


    @Test (groups = "failedgroup", dataProvider = "myDataProvider", priority = 6) //Test with parameters from DataProvider
    public void testDivide(int z, int x){
        int expectedResult = 21;
        Assert.assertEquals(calc.divide(z, x), expectedResult, "Data Provider Test Failed");
    }

    @Test (groups = "passedgroup", priority = 3, expectedExceptions = IllegalArgumentException.class)
    public void testDivideByZero(){
        calc.divide(calc.getA(), 0);
    }

    @Test (priority = 7)
    public void testHardAsserts(){
        Assert.assertEquals(2 + 2, 4);
        System.out.println("2 + 2 = 4");
        Assert.assertEquals(3 + 3, 6);
        System.out.println("3 + 3 = 6");
        Assert.assertEquals(4 + 4, 4);
        System.out.println("4 + 4 = 4");
        Assert.assertEquals(5 + 5, 10);
        System.out.println("5 + 5 = 10");
        Assert.assertEquals(6 + 6, 12);
        System.out.println("6 + 6 = 12");
    }

    @Test (priority = 8)
    public void testSoftAssert(){
        SoftAssert softassertobject = new SoftAssert();
        softassertobject.assertEquals(2 + 2, 4, "case 1 failed");
        softassertobject.assertEquals(3 + 3, 6, "case 2 failed");
        softassertobject.assertEquals(4 + 4, 4, "case 3 failed");
        softassertobject.assertEquals(5 + 5, 10, "case 4 failed");
        softassertobject.assertEquals(6 + 6, 13, "case 5 failed");
        softassertobject.assertAll();
    }




}
