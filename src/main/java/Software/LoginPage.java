package Software;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static Software.Utility.clickOnElement;
import static Software.Utility.enterText;

/**
 * Created by Mehul on 05/12/2016.
 */
public class LoginPage extends DriverManager
{
    @FindBy (linkText = "Log out")
    private WebElement _logout;

    @FindBy (linkText = "Log in")
    private WebElement _loginButten;

    @FindBy (id= "Email")
    private  WebElement _email;
    @FindBy  (id = "Password")
    private WebElement _password;
    @FindBy (className = "buttons")
    private WebElement _logInsubmitButten;

    public  void login ()
    {
        RegistrationPage registrationPage = new RegistrationPage();
//        registrationPage.registrationFoam();
        clickOnElement(_logout);
        clickOnElement(_loginButten);
        enterText(_email,registrationPage.acText);
        enterText(_password,"123456");
        clickOnElement(_logInsubmitButten);



    }


}
