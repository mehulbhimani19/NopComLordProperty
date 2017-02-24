package Software;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;

/**
 * Created by Mehul on 06/12/2016.
 */
public class SampleSaurceLab

{

    public static class SampleSauceTest
    {

        public static final String USERNAME = "mehulbhimani19";
        public static final String ACCESS_KEY = "f9b14373-a4d1-4b3e-beb5-22b31528a633";
        public static final String URL = "https://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.saucelabs.com:443/wd/hub";

        public static void main(String[] args) throws Exception
        {
            DesiredCapabilities caps = DesiredCapabilities.chrome();
            caps.setCapability("platform", "Windows XP");
            caps.setCapability("version", "43.0");

            WebDriver driver = new RemoteWebDriver(new URL(URL), caps);

//             * Goes to Sauce Lab's guinea-pig page and prints title


            driver.get("https://saucelabs.com/test/guinea-pig");
            System.out.println("title of page is: " + driver.getTitle());

            driver.get("http://demo.nopcommerce.com/");
            System.out.println("title of page is: " + driver.getTitle());

//            driver.quit();
        }

}   }
