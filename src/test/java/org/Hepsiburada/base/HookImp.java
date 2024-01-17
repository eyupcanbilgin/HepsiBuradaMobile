package org.Hepsiburada.base;

import com.thoughtworks.gauge.AfterScenario;
import com.thoughtworks.gauge.BeforeScenario;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.net.MalformedURLException;
import java.net.URL;

public class HookImp {

    public static AppiumDriver<MobileElement> appiumDriver;
    public Logger logger = LoggerFactory.getLogger(getClass());

    protected boolean localAndroid = true;


    @BeforeScenario

    public void setUp() throws MalformedURLException {

        if (Constant.IS_LOCAL_ANDROID) {

            System.out.println("...Hepsiburada Android Testi Basliyor...");
            DesiredCapabilities desiredCapabilities = new DesiredCapabilities();

            desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
            desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, Constant.DEVICE_NAME);
            desiredCapabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, Constant.START_APP_ACTIVITY);
            desiredCapabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, Constant.APP_PACKAGE);
            desiredCapabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, Constant.NEW_COMMAND_TIMEOUT);
            desiredCapabilities.setCapability(AndroidMobileCapabilityType.AUTO_GRANT_PERMISSIONS, true);

            URL url = new URL(Constant.URL);
            appiumDriver = new AndroidDriver(url, desiredCapabilities);


        } else {

            System.out.println("...IOS Testi Basladi...");
        }
    }

    @AfterScenario

    public void tearDown() {

        if (appiumDriver != null) {
            appiumDriver.quit();
            System.out.println("...Test bitti...");
        }
    }
}