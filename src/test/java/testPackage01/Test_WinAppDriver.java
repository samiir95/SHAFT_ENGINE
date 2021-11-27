package testPackage01;

import com.shaft.driver.DriverFactory;
import com.shaft.gui.element.ElementActions;
import com.shaft.gui.element.TouchActions;
import com.shaft.validation.ValidationEnums;
import com.shaft.validation.Validations;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Test_WinAppDriver {

    private WebDriver driver;

    @BeforeMethod
    private void beforeMethod() {

        driver = DriverFactory.getDriver();
    }

    @Test
    public void testCalculatorApp(){

        new ElementActions(driver)
                .click(AppiumBy.accessibilityId("num7Button"))
                .click(AppiumBy.accessibilityId("plusButton"))
                .click(AppiumBy.accessibilityId("num7Button"))
                .click(AppiumBy.accessibilityId("equalButton"));

        Assert.assertEquals(ElementActions.getAttribute(driver, AppiumBy.accessibilityId("CalculatorResults"), "Name" ), "Display is 14");

//      String attr =   ElementActions.getAttribute(driver, AppiumBy.accessibilityId("CalculatorResults"), "Name" );

//        Validations.assertThat()
//                .element(driver, AppiumBy.accessibilityId("CalculatorResults"))
//                .attribute(attr)
//                .equalsIgnoringCaseSensitivity("Display is 14")
//                .perform();

//        driver.findElement(AppiumBy.accessibilityId("num7Button")).click();
//        driver.findElement(AppiumBy.accessibilityId("plusButton")).click();
//        driver.findElement(AppiumBy.accessibilityId("num7Button")).click();
//        driver.findElement(AppiumBy.accessibilityId("equalButton")).click();
    }

    @AfterMethod
    public void teardown() {
        DriverFactory.closeAllDrivers();
    }
}
