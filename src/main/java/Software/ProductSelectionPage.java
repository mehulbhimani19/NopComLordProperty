package Software;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static Software.Utility.clickOnElement;

/**
 * Created by Mehul on 05/12/2016.
 */
public class ProductSelectionPage extends DriverManager
{
    @FindBy(linkText = "Electronics")
    private   WebElement _Electronics ;
    @FindBy (linkText = "Camera & photo")
    private WebElement _Camera;

    @FindBy (xpath ="html/body/div[5]/div[3]/div[2]/div[2]/div/div[2]/div[3]/div/div[2]/div/div[2]/div[3]/div[2]/input[1]")
    private   WebElement _product1;
    @FindBy (xpath = ".//*[@id='bar-notification']/p")
    private WebElement _assertProduct1;

    @FindBy(xpath = ".//*[@id='bar-notification']/p/a")
    private  WebElement _contiToCraft;



    @FindBy(id ="termsofservice")
    private WebElement _TandCSelection;

    @FindBy (xpath =".//*[@id='checkout']")
    private WebElement _ChechOut;

    public void selectItemIcam()

    {
        RegistrationPage registrationPage = new RegistrationPage();
        registrationPage.registrationFoam();

        clickOnElement(_Electronics);
        clickOnElement(_Camera);
        clickOnElement(_product1);
        Utility.isEliment_Presant(_assertProduct1);  // assert for product 1
        System.out.println( "Assert pass ");

        clickOnElement(_contiToCraft);





        clickOnElement( _TandCSelection);
        System.out.println("T and C selected ");

        clickOnElement( _ChechOut);


    }



}
