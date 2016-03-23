package org.movoto.selenium.example;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.MarionetteDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.assertTrue;

/**
 * Created by haozuo on 3/22/16.
 */
public class ChromeDriverUsage {

    private String testUrl;
    private WebDriver driver;

    @Before
    public void prepare() {
        //setup chromedriver
        System.setProperty(
                "webdriver.chrome.driver",
                "webdriver/chromedriver");

        testUrl = "http://leftstick.github.io/";

        // Create a new instance of the Chrome driver
        // Notice that the remainder of the code relies on the interface,
        // not the implementation.
        driver = new ChromeDriver();

        //set window size
        driver.manage().window().setSize(new Dimension(1300, 1000));

        // And now use this to visit myBlog
        // Alternatively the same thing can be done like this
        // driver.navigate().to(testUrl);
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
                (new WebDriverWait(driver, 3))
                        .until(new ExpectedCondition<Boolean>() {
                            public Boolean apply(WebDriver d) {
                                return d.getTitle().equals("以BDD手写依赖注入");
                            }
                        })
        );
    }

    @After
    public void teardown() throws IOException {
        driver.quit();
    }

}
