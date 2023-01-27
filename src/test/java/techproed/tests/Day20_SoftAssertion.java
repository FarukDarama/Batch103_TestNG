package techproed.tests;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Day20_SoftAssertion {

    @Test
    public void softAssertTest() {
        //1.Adım :Soft Assert object olustur
        SoftAssert softAssert = new SoftAssert();
        System.out.println("Satır 12");
        softAssert.assertEquals(2,5);//fail
        System.out.println("Satır 14");
        softAssert.assertTrue("JAVA".contains("U"));
        System.out.println("Satır 16");
        softAssert.assertTrue(true);
        System.out.println("Satır 18");
        softAssert.assertAll();


    }
}
