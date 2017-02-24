package Software;

import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.awt.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import static Software.SampleSaurceLab.SampleSauceTest.ACCESS_KEY;

/**
 * Created by Mehul on 04/12/2016.
 */
public class DriverManager
{
    protected static WebDriver driver;

    public DriverManager()
    {
        PageFactory.initElements(driver,this );
    }
    static LoadProp loadProp =new LoadProp();

    @BeforeMethod
    public static void openBrowser()
    {
//        String USERNAME = "mehulbhimani19";
//         String ACCESS_KEY = "f9b14373-a4d1-4b3e-beb5-22b31528a633";
//         String URL = "https://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.saucelabs.com:443/wd/hub";
//
//
//
//        DesiredCapabilities caps = DesiredCapabilities.chrome();
//        caps.setCapability("platform", "Windows XP");
//        caps.setCapability("version", "43.0");
//
//        WebDriver driver = new RemoteWebDriver(new URL(URL), caps);
//
////             * Goes to Sauce Lab's guinea-pig page and prints title
//
//
//        driver.get("https://saucelabs.com/test/guinea-pig");
//        System.out.println("title of page is: " + driver.getTitle());
//
//        driver.get("http://demo.nopcommerce.com/");
//        System.out.println("title of page is: " + driver.getTitle());



//        String browser = loadProp.getProperty("browser");
        String browser = System.getProperty("browser");

        if (browser.equalsIgnoreCase("chrome"))
        {
            System.setProperty("webdriver.chrome.driver", "src\\test\\Resources\\BrowserDriver\\chromedriver.exe");
            driver = new ChromeDriver();
        }
        else if (browser.equalsIgnoreCase("ie"))
        {
            System.setProperty("webdriver.ie.driver", "src\\test\\Resources\\BrowserDriver\\IEDriverServer.exe");
            driver = new InternetExplorerDriver();
        }
        else if (browser.equalsIgnoreCase("opera"))
        {
            System.setProperty("webdriver.opera.driver", "src\\test\\Resources\\BrowserDriver\\operadriver.exe");
            driver = new OperaDriver();
        }
        else
        {
            driver = new FirefoxDriver();
        }

        driver.manage().window().maximize();
//       Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
//        Dimension maxWindowSize = new Dimension((int) screenSize.getHeight(), (int)
//                screenSize.getWidth());
//        driver.manage().window().setSize(maxWindowSize);


        driver.manage().deleteAllCookies();


        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//       driver.manage().timeouts().setScriptTimeout(10,TimeUnit.SECONDS);


      driver.get(LoadProp.getProperty("url"));

    }
    @AfterMethod
    public static void closeBrowser()
    {
       // driver.quit();
    }
}
