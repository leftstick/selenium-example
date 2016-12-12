package org.movoto.selenium.example;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Mouse;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;

/**
 * Created by haozuo on 3/22/16.
 */
public class SafariTest {

    private String testUrl;
    private WebDriver driver;

    @Before
    public void prepare() {

        testUrl = "https://leftstick.github.io/";

        driver = new SafariDriver();
        driver.manage().window().maximize();
        driver.get(testUrl);
    }

    @Test
    public void testTitle() throws IOException {

        // Find elements by attribute lang="READ_MORE_BTN"
        List<WebElement> elements = driver
                .findElements(By.cssSelector("[lang=\"READ_MORE_BTN\"]"));

        //Click the selected button
        elements.get(0).click();


        assertTrue("The page title should be chagned as expected",
                (new WebDriverWait(driver, 5))
                        .until(new ExpectedCondition<Boolean>() {
                            public Boolean apply(WebDriver d) {
                                return d.getTitle().equals("我眼中软件工程人员该有的常识");
                            }
                        })
        );

    }

    @After
    public void teardown() throws IOException {
        driver.quit();
    }

}
