package techproed.tests.dataprovider;

import org.testng.annotations.Test;
import techproed.utilities.DataProviderUtils;

public class Day25_DataProviderTest4 {
    //  Data Provider methodumuz Util classda olacak

// musteri verileri
    @Test(dataProvider = "musteriVerileri",dataProviderClass = DataProviderUtils.class)
    public void musteriVerileriTesti(String username,String password ,String sube) {
        System.out.println("Username: "+username+" .Password: "+password+". sube: "+sube);

    }

    //musteriHizmetleri Verileri


    @Test(dataProvider = "musteriHizmetleriVerileri",dataProviderClass = DataProviderUtils.class)
    public void musteriHizmetleriVerileriTest(String username,String password) {
        System.out.println(username+"  |  "+password);

    }


    @Test(dataProvider = "customerData",dataProviderClass = DataProviderUtils.class)
    public void customerDataTest(String email,String password) {
        System.out.println("Excel Datalari");
        System.out.println(email+" |||| "+password);


    }
}
