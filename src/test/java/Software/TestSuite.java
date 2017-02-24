package Software;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by Mehul on 04/12/2016.
 */
public class TestSuite extends DriverManager
{

    @Test
    public void registration ()

    {
        RegistrationPage registrationPage = new RegistrationPage();
        registrationPage.registrationFoam();
    }
    @Test
    public void login()
    {   RegistrationPage registrationPage = new RegistrationPage();
        registrationPage.registrationFoam();

        LoginPage loginPage = new LoginPage();
        loginPage.login();
    }

    @Test
    public void productSelection ()
    {
        RegistrationPage registrationPage = new RegistrationPage();
        registrationPage.registrationFoam();

        LoginPage loginPage = new LoginPage();
        loginPage.login();

        ProductSelectionPage productSelectionPage = new ProductSelectionPage();
        productSelectionPage.selectItemIcam();

    }
    @Test
    public void billingaddresh ()
    {
        RegistrationPage registrationPage = new RegistrationPage();
        registrationPage.registrationFoam();

        LoginPage loginPage = new LoginPage();
        loginPage.login();

        ProductSelectionPage productSelectionPage = new ProductSelectionPage();
        productSelectionPage.selectItemIcam();

        BillingAddreshPage billingAddreshPage = new BillingAddreshPage();
        billingAddreshPage.BillinAddresh();
    }
    @Test

    public void paymnetCreditcard()
    {
        RegistrationPage registrationPage = new RegistrationPage();
        registrationPage.registrationFoam();

        LoginPage loginPage = new LoginPage();
        loginPage.login();

        ProductSelectionPage productSelectionPage = new ProductSelectionPage();
        productSelectionPage.selectItemIcam();

        BillingAddreshPage billingAddreshPage = new BillingAddreshPage();
        billingAddreshPage.BillinAddresh();

        PaymentPage paymentPage = new PaymentPage();
        paymentPage.Payment();
    }




}
