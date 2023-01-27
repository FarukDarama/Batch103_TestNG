package techproed.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;

public class day20_Driver_Config_Test {

    @Test
    public void firstTest() {
       // Driver.getDriver().get("https://www.amazon.com");
        Driver.getDriver().get(ConfigReader.getProperty("amazon_url"));
        Assert.assertTrue(Driver.getDriver().getTitle().contains("Amazon"));
        //driver ı kapattık
        Driver.closeDriver();


    }




}
