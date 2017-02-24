package Software;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.server.handler.html5.Utils;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import static Software.Utility.clickOnElement;

import static Software.Utility.enterText;

/**
 * Created by Mehul on 04/12/2016.
 */
public class RegistrationPage extends DriverManager
{
    @FindBy(linkText = "Register" )
//         @FindBy(xpath =   "//a[@href='/register']")
    private WebElement _RegisterLink;

    @FindBy (name = "Gender")
    private   WebElement _GenderMale;

    @FindBy (name = "FirstName")
    private WebElement _UserName;

    @FindBy( name = "LastName")
    private   WebElement _UserLastName ;

    @FindBy (name = "DateOfBirthDay")
    private WebElement _DateOfBrithDay;

    @FindBy ( name ="DateOfBirthMonth" )
    private   WebElement _MonthOfBrith;

    @FindBy (name ="DateOfBirthYear" )
    private   WebElement _YearOfBrith;

    @FindBy (name = "Email")
    private WebElement _UserEmail;

    @FindBy (className = "ico-account")
    private WebElement _getTextEmail;        // email location

    @FindBy (id ="Company" )
    private WebElement _Company ;

    @FindBy ( id ="Password" )
    private   WebElement _Password;


    @FindBy (id = "ConfirmPassword")
    private WebElement _ConformPassword;

    @FindBy ( id = "register-button")
    private WebElement _RegisterButunFinal;
    @FindBy ( xpath = "//div[@class='result']")   // this is for asserting location ""Registration Completed Successfully  ". actual
    private WebElement _AssertText;

    public  static String acText=null;      //this is null string which will save username which will be
                                            // used later for login. String is out side of the method so we can use
                                                // it in other methods


    public void registrationFoam()
    {
        LoadProp loadProp = new LoadProp();
        Utility.clickOnElement( _RegisterLink);   // calling method   by utility class name


        enterText( _UserName , loadProp.getProperty("firstname"));
        enterText( _UserLastName , "lastnmae");


        Utility.selectbyValue(_DateOfBrithDay,loadProp.getProperty("date"));

        Utility.selectbyIndex(_MonthOfBrith, Integer.parseInt((loadProp.getProperty("month"))));

        new Select(_YearOfBrith).selectByVisibleText(loadProp.getProperty("year"));


        String email = "mehulbhimani19" + Utility.randomDate()+ "@yahoo.com";

        enterText(_UserEmail, email);
        System.out.println(email);

        enterText( _Company ,loadProp.getProperty("companynmae"));
        enterText( _Password ,loadProp.getProperty("password"));
        enterText( _ConformPassword ,loadProp.getProperty("conformpassword"));
        clickOnElement( _RegisterButunFinal);

        System.out.println("Registration Successful");

        Assert.assertEquals(_AssertText.getText(),"Your registration completed"," Registration is Fail");
        System.out.println("ASSERT PASS , Your registration completed");

        acText = new String();
        acText= Utility.get_Text(_getTextEmail);
//        getText( _AssertText);
//        String actual = driver.findElement(By.xpath("//div[@class='result']")).getText();
//        String expected = "Your registration completed";
//        Assert.assertEquals(_AssertText,expected, " Fail");
//        System.out.println("Test is pass");
    }



}
