package testcalculator;

import org.testng.annotations.*;

public class BaseTestCalculator {

    @DataProvider(name = "myDataProvider")
    public static Object[][] getData() {
        return new Object[][]{
                {14, 7},
                {8, 0}
        };
    }

    @BeforeSuite
    public void beforeSuiteMethod() {
        System.out.println("This is method executed before running Test Suite");
    }

    @BeforeGroups(groups = "failedgroup")
    public void beforeGroupsMethod() {
        System.out.println("This is method executed before running Groups");
    }

    @BeforeTest
    public void beforeTestMethod() {
        System.out.println("This is method executed before running Test");
    }

    @BeforeClass
    public void beforeClassMethod() {
        System.out.println("This is method executed before running Class");
    }

    @AfterSuite
    public void afterSuiteMethod() {
        System.out.println("This is method executed after running Test Suite");
    }

    @AfterGroups(groups = "failedgroup")
    public void afterGroupsMethod() {
        System.out.println("This is method executed after running Groups");
    }

    @AfterTest
    public void afterTestMethod() {
        System.out.println("This is method executed after running Test");
    }

    @AfterClass
    public void afterClassMethod() {
        System.out.println("This is method executed after running Class");
    }

    @AfterMethod
    public void tearDown() {
        System.out.println("This is method executed after running Method");
    }

}
