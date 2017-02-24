package Software;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Mehul on 06/12/2016.
 */
public class BillingAddreshPage extends DriverManager
{
    //@FindBy ( id="BillingNewAddress_CountryId")
    @FindBy(name = "BillingNewAddress.CountryId")
    private WebElement _CountrySelection;

    @FindBy (id="BillingNewAddress_StateProvinceId")
    private WebElement _statSelection;
    @FindBy  (id="BillingNewAddress_City")
    private  WebElement _cityName;
    @FindBy (id="BillingNewAddress_Address1")
    private WebElement _AddreshLine1;
    @FindBy(id="BillingNewAddress_ZipPostalCode")
    private WebElement  _postCode;
    @FindBy (id  ="BillingNewAddress_PhoneNumber")
    private WebElement  _phoneNumbe;
    @FindBy (xpath = ".//*[@id='billing-buttons-container']/input")
    private  WebElement _continueButten;

    @FindBy (xpath = ".//*[@id='shipping-method-buttons-container']/input")
    private  WebElement _contShopingMethod;


    public void BillinAddresh(){
        LoadProp loadProp = new LoadProp();

        Utility.selectbyVisibleText(_CountrySelection,loadProp.getProperty("countryname"));
        Utility.enterText(_cityName,loadProp.getProperty("cityname"));
        Utility.enterText(_AddreshLine1,loadProp.getProperty("1stlineofAddresh"));
        Utility.enterText(_postCode,loadProp.getProperty("postcode"));
        Utility.enterText(_phoneNumbe,loadProp.getProperty("phoneNumber"));
        Utility.clickOnElement(_continueButten);
        driver.findElement(By.name("shippingoption")).click();
        Utility.clickOnElement(_contShopingMethod);



    }


}
