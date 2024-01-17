package org.Hepsiburada.methods;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.Hepsiburada.base.HookImp;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.time.Duration;
import java.util.Random;


public class Methods extends HookImp
{

    AppiumDriver driver;
    FluentWait<AppiumDriver> wait;
    
    public Logger logger = LoggerFactory.getLogger(getClass());

    public Methods()
    {
        driver = appiumDriver;
        wait = new FluentWait<>(driver);
        wait.withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofMillis(300))
                .ignoring(NoSuchElementException.class);
    }

    public MobileElement findElement(By by) {
        return (MobileElement) wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }
    public MobileElement findElementBykey(String key, String selector) {
        if (selector.equals("xpath")) {
            return findElement(By.xpath(key));
        } else {
            return findElement(By.id(key));
        }
    }
    public void click(String key, String selector) {

        findElementBykey(key, selector).click();
        logger.info(key + " Butonuna tiklandi");
    }

    public void sendKeys(String key, String text, String selector) {

        logger.info(key + " ya " + text + " yazildi");
        findElementBykey(key, selector).sendKeys(text);
    }
    public void selectRandomGraphicsCard(int numberOfCards) {
        Random rand = new Random();
        int randomCardIndex = rand.nextInt(numberOfCards) + 1;
        String graphicCardList = "(//android.widget.LinearLayout[@resource-id=\"com.pozitron.hepsiburada:id/multiSelectionView\"])[" + randomCardIndex + "]";
        click(graphicCardList, "xpath");
    }
    public void selectRandomPrice(int numberOfPrice) {
        Random rand = new Random();
        int randomCardIndex = rand.nextInt(numberOfPrice) + 1;
        String priceList = "(//android.view.ViewGroup[@resource-id=\"com.pozitron.hepsiburada:id/rootLayout\"])[" + randomCardIndex + "]";
        click(priceList, "xpath");
    }
    public void selectRandomProduct(int numberOfProducts) {
        Random rand = new Random();
        int randomCardIndex = rand.nextInt(numberOfProducts) + 1;
        String priceList = "(//android.widget.ImageView[@resource-id=\"com.pozitron.hepsiburada:id/ivProduct\"])[" + randomCardIndex + "]";
        click(priceList, "xpath");
    }


    public void waitForElementVisible(String locator, String selectorType, int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        By by = selectorType.equals("xpath") ? By.xpath(locator) : By.id(locator);
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        logger.info(locator + " elementi gorunur oldu.");
    }
    public void tapByCoordinates(int x, int y) {
        new TouchAction<>(driver)
                .tap(PointOption.point(x, y))
                .perform();
        logger.info("Koordinatlara tiklandi: X=" + x + " Y=" + y);
    }
    public void scrollDown() {
        Dimension size = driver.manage().window().getSize();
        int startX = size.width / 2;
        int startY = (int) (size.height * 0.8);
        int endY = (int) (size.height * 0.2);

        new TouchAction<>(driver)
                .press(PointOption.point(startX, startY))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
                .moveTo(PointOption.point(startX, endY))
                .release()
                .perform();

        logger.info("Ekran asagi kaydirildi.");
    }

}


