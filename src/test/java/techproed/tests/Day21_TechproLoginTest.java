package techproed.tests;

import org.testng.annotations.Test;
import techproed.pages.TechproHomePage;
import techproed.pages.TechproLoginPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;

public class Day21_TechproLoginTest {

    //https://testcenter.techproeducation.com/index.php?page=form-authentication
    //Page object Model kullanarak sayfaya giriş yapildigini test edin
    //Sayfadan cikis yap ve cikis yapildigini test et
    //techproed
    //SuperSecretPassword


    @Test(groups ="regression-tests")
    public void techproTest() {

        Driver.getDriver().get(ConfigReader.getProperty("techpro_test_url"));
        TechproLoginPage techproLoginPage = new TechproLoginPage();
        techproLoginPage.username.sendKeys(ConfigReader.getProperty("techpro_test_username"));
        techproLoginPage.password.sendKeys(ConfigReader.getProperty("techpro_test_password"));
        techproLoginPage.submit.click();
        TechproHomePage techproHomePage = new TechproHomePage();
        assert techproHomePage.homeHeader.isDisplayed();
        techproHomePage.homeLogoutButton.click();
        assert techproLoginPage.submit.isDisplayed();
        Driver.closeDriver();

    }


}
