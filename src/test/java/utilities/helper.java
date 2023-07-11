package utilities;

import org.testng.Assert;
import org.testng.Reporter;

public class helper {
    public static void logEvent(String message) {
        Reporter.log(message);
        System.out.println(message);
    }

    public static void assertWithLog(String variableName, String actual, String expected) {
        Reporter.log("\nAsserting value of " + variableName + ": \nExpected: " + expected + " \nActual: " + actual);
        System.out.println("\nAsserting value of " + variableName + ": \nExpected: " + expected + " \nActual: " + actual);
        Assert.assertEquals(actual, expected);
    }
}