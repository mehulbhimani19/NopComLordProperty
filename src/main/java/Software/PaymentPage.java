package Software;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import static Software.DriverManager.driver;
import static Software.DriverManager.loadProp;

/**
 * Created by Mehul on 08/12/2016.
 */
public class PaymentPage extends DriverManager

{

//    @FindBy(linkText = "Credit Card")
//    private WebElement _CreditCard1;
    @FindBy (id = "paymentmethod_1")
    private WebElement _CreditCard;


    @FindBy (xpath = ".//*[@id='payment-method-buttons-container']/input")
    private WebElement _continuepayment;

    @FindBy (id ="CreditCardType")
    private WebElement _cardTypeSelection;
    @FindBy (id ="CardholderName")
    private WebElement _NameOfCardHolder;
    @FindBy (id = "CardNumber")
    private WebElement _CardNumber;
    @FindBy (name= "ExpireMonth")
    private WebElement _ExpireMonth;
    @FindBy( id = "ExpireYear")
    private WebElement _ExpireYear;
    @FindBy (id ="CardCode")
    private WebElement _CcsCod;
    @FindBy (id = "payment-info-buttons-container")
    private WebElement _continuePayment1 ;

    @FindBy (xpath = ".//*[@id='confirm-order-buttons-container']/input")
    private WebElement _conformOrder;



    public  void Payment()
    {
     LoginPage loginPage = new LoginPage();


        Utility.clickOnElement( _CreditCard);
        System.out.println(" Visa card select ");
        Utility.clickOnElement( _continuepayment);

        Assert.assertEquals(driver.findElement(By.xpath(".//*[@id='checkout-payment-info-load']/div/div/div[1]/table/tbody/tr[2]" +
                "/td[1]/label")).getText(), "Cardholder name");
        System.out.println("TEST PSSS , You r in Payment information page ");

//        new Select(_cardTypeSelection).selectByVisibleText("Visa");
        Utility.selectbyVisibleText(_cardTypeSelection,loadProp.getProperty("cardSelectin"));

        Utility.enterText(_NameOfCardHolder ,loadProp.getProperty( "NameofCardHolder"));

        Utility.enterText(_CardNumber,loadProp.getProperty("CreditCardNumber"));
//        new Select(_ExpireMonth).selectByVisibleText("05");
        Utility.selectbyVisibleText(_ExpireMonth,loadProp.getProperty("ExpirMOnth"));
//        new Select(_ExpireYear).selectByVisibleText("2017");
        Utility.selectbyVisibleText(_ExpireYear,loadProp.getProperty("ExpieYear"));

        Utility.enterText(_CcsCod, loadProp.getProperty("cssNumber"));
        Utility.clickOnElement(_continuePayment1);

        Assert.assertEquals(driver.findElement(By.xpath(".//*[@id='checkout-confirm-order-load']/div/div/div/div/div[2]/div[2]/div/ul" +
                "/li[2]/span[1]")).getText(),"Shipping Method:", "Fail");
        System.out.println("TEST PASS , Payment information match ");

        Utility.clickOnElement(_conformOrder);


        String actual = driver.findElement(By.xpath("html/body/div[5]/div[3]/div/div/div/div[2]/div/div[1]/strong")).getText();
        String expected = "Your order has been successfully processed!";
        Assert.assertEquals(actual,expected, " Fail");
        System.out.println(" Final Test is pass , Your order has been successfully processed!");

    }
}
