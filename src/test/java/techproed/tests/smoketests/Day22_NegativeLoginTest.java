package techproed.tests.smoketests;

import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.pages.BlueRentalHomePage;
import techproed.pages.BlueRentalLoginPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ReusableMethods;

public class Day22_NegativeLoginTest {

    //•Name:
    //	•US100208_Negative_Login
    //	•Description:
    //	•Kullanimda olmayan kullanıcı adi ve şifre ile giriş yapilamamali
    //	•Acceptance Criteria
    //	•
    //	•Customer email: fake@bluerentalcars.com
    //	•Customer password: fakepass
    //	•
    //	•Error: User with email fake@bluerentalcars.com not found
    BlueRentalHomePage blueRentalHomePage;
    BlueRentalLoginPage blueRentalLoginPage;


    @Test
    public void testName() throws InterruptedException {
        Driver.getDriver().get(ConfigReader.getProperty("app_url"));
        blueRentalHomePage = new BlueRentalHomePage();
        blueRentalLoginPage = new BlueRentalLoginPage();
        blueRentalHomePage.loginLink.click();
        blueRentalLoginPage.emailBox.sendKeys(ConfigReader.getProperty("fake_email"));
        blueRentalLoginPage.passwordBox.sendKeys(ConfigReader.getProperty("fake_pass"));
        blueRentalLoginPage.loginButton.click();
        Thread.sleep(3000);
        Assert.assertEquals(blueRentalLoginPage.error_massage_1.getText(),"User with email fake@bluerentalcars.com not found");

    }

    @Test
    public void dogruMailYanlisPass() throws InterruptedException {

        Driver.getDriver().get(ConfigReader.getProperty("app_url"));
        blueRentalHomePage = new BlueRentalHomePage();
        blueRentalLoginPage = new BlueRentalLoginPage();
        blueRentalHomePage.loginLink.click();
        blueRentalLoginPage.emailBox.sendKeys(ConfigReader.getProperty("admin_email"));
        blueRentalLoginPage.passwordBox.sendKeys(ConfigReader.getProperty("fake_pass"), Keys.ENTER);
        Thread.sleep(3000);
        Assert.assertEquals("Bad credentials",blueRentalLoginPage.error_massage_2.getText());

    }

    @Test
    public void gecersizMailTest() throws InterruptedException {
        Driver.getDriver().get(ConfigReader.getProperty("app_url"));
        blueRentalHomePage = new BlueRentalHomePage();
        blueRentalLoginPage = new BlueRentalLoginPage();
        blueRentalHomePage.loginLink.click();
        blueRentalLoginPage.emailBox.sendKeys(ConfigReader.getProperty("false_mail"));//Faruk@com
        Thread.sleep(2000);
        Assert.assertEquals(blueRentalLoginPage.false_Mail_Massage.getText(),"email must be a valid email");
        Thread.sleep(2000);
        blueRentalLoginPage.emailBox.sendKeys(Keys.BACK_SPACE);
        blueRentalLoginPage.emailBox.sendKeys(Keys.BACK_SPACE);
        blueRentalLoginPage.emailBox.sendKeys(Keys.BACK_SPACE);
        blueRentalLoginPage.emailBox.sendKeys(Keys.BACK_SPACE);
        blueRentalLoginPage.emailBox.sendKeys(Keys.BACK_SPACE);
        blueRentalLoginPage.emailBox.sendKeys(Keys.BACK_SPACE);
        blueRentalLoginPage.emailBox.sendKeys(Keys.BACK_SPACE);
        blueRentalLoginPage.emailBox.sendKeys(Keys.BACK_SPACE);
        blueRentalLoginPage.emailBox.sendKeys(Keys.BACK_SPACE);
        blueRentalLoginPage.emailBox.sendKeys(Keys.BACK_SPACE);

        Thread.sleep(2000);
        blueRentalLoginPage.emailBox.sendKeys(ConfigReader.getProperty("admin_email"));
        Assert.assertFalse(blueRentalLoginPage.false_Mail_Massage.isDisplayed());

    }


    @Test
    public void continueReservationTest() {
        Driver.getDriver().get(ConfigReader.getProperty("app_url"));
        blueRentalHomePage = new BlueRentalHomePage();
        blueRentalLoginPage = new BlueRentalLoginPage();
        Select select = new Select(blueRentalHomePage.dropDown);
        select.selectByValue("9");//Audi   "q8
        blueRentalHomePage.pickUp.sendKeys("Pennsylvania Penn Hills",Keys.TAB,"Almanya",Keys.TAB,"12.12.2023",Keys.TAB,"100",
                Keys.TAB,"14.12.2023",Keys.TAB,"100",Keys.TAB,Keys.ENTER);
        Assert.assertTrue(blueRentalHomePage.firstLoginMassage.isDisplayed());
        ReusableMethods.waitFor(6);

        blueRentalHomePage.loginLink.click();
        blueRentalLoginPage.emailBox.sendKeys(ConfigReader.getProperty("admin_email"));
        blueRentalLoginPage.passwordBox.sendKeys(ConfigReader.getProperty("admin_sifre"));
        blueRentalLoginPage.loginButton.click();
        select.selectByValue("9");//Audi   "q8
        blueRentalHomePage.pickUp.sendKeys("Pennsylvania Penn Hills",Keys.TAB,"Almanya",Keys.TAB,"12.12.2023",Keys.TAB,"100",
        Keys.TAB,"14.12.2023",Keys.TAB,"100",Keys.TAB,Keys.ENTER);
        Assert.assertFalse(blueRentalHomePage.firstLoginMassage.isDisplayed());




    }





}
