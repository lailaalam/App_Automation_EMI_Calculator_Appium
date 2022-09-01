package base;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Setup {
    public AndroidDriver driver;
    public static final String PACKAGE_ID="com.google.android.calculator";
    @BeforeTest
    public AndroidDriver Setup() throws MalformedURLException {

        DesiredCapabilities cap=new DesiredCapabilities();
        cap.setCapability("deviceName","MyDevice");
        // cap.setCapability("uuid", "ZY3227PBBN");
        cap.setCapability("platformName", "Android");
        cap.setCapability("appPackage", "com.continuum.emi.calculator");
        cap.setCapability("appActivity", "com.finance.emicalci.activity.Splash_screnn");
        cap.setCapability("autoGrantPermissions", true);
        URL url=new URL("http://192.168.1.107:4723/wd/hub");//127.0.0.1
        driver=new AndroidDriver(url,cap);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        return driver;
    }

    @AfterTest
    public void closeDriver()
    {
        driver.quit();
    }
}
