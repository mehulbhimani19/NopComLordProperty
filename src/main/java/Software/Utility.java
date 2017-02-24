package Software;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by Mehul on 04/12/2016.
 */
public class Utility extends DriverManager
{
   public static void enterText(WebElement element, String text)

   {
       element.sendKeys(text);
   }
   public static void  clickOnElement(WebElement element)
   {
      element.click();
   }

   public static String randomDate()
   {
       SimpleDateFormat formet = new SimpleDateFormat("ddmmyyHHmmss");
       return formet.format(new Date());
   }

   public static String get_Text (WebElement element)
    {
        return element.getText();
    }


    public static boolean isEliment_Presant (WebElement element){
        return element.isDisplayed();
    }

    public static void selectbyValue(WebElement element, String value)
    {
        Select select = new Select( element);
        select.selectByValue(value);
    }
    public static void selectbyIndex (WebElement element  , int IndexNumber )
    {
         Select select1 = new Select( element);
         select1.selectByIndex(IndexNumber);
    }

    public static void selectbyVisibleText(WebElement element, String text) {

        Select select2 = new Select(element);
        select2.selectByVisibleText(text);

    }
    public static void sizeChack (WebElement element)  // this method will check in size of avalble options
    {Select select = new Select(element);
        List Osize =  select.getOptions();
        System.out.println("Total number of visible options "+Osize.size()+" in dropdown manu." );

    }


    public static void selectbyVisibleText(WebElement countrySelection) {
    }
}
