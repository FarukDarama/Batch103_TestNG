package techproed.utilities;

import org.testng.annotations.DataProvider;

public class DataProviderUtils {

    @DataProvider
    public Object[][] musteriVerileri(){
        Object[][] musteriGirisBilgiler={
                {"manejer1","12345","beşiktas"},
                {"manejer2","98765","bayrampasa"},
                {"menejer3","5678","karsiyaka"}
        };
        return musteriGirisBilgiler;
    }

    @DataProvider
    public Object[][] musteriHizmetleriVerileri(){
        Object[][] musteriHizmetleriGirisBilgileri={
                {"ada1","23456"},{"ali2","1234"},{"nancy3","7890"}
        };
        return musteriHizmetleriGirisBilgileri;
    }

    @DataProvider
    public Object[][] personelVerileri(){
        Object [][] personelGirisBilgileri = {
                {"rukiye1","abc1"},
                {"mehmet2","123r"},
                {"emin3","3edc"},
                {"baran3","3asd"},
                {"okumus3","6e45"}
        };
        return personelGirisBilgileri;
    }


    //Excelden dataprovider a data gelecek bu dataları burdan testcase gonderecegiz.
    @DataProvider
    public Object[][] customerData(){
    //DataProviderTest2 ile bu metot arasindaki tek fark bu metotda datalar Excelden gelir.
    //Bu kullanim daha guzeldir
        String path="./src/test/java/resources/mysmoketestdata.xlsx";
        String sheetName = "customer_info";
        ExcelUtils excelUtils = new ExcelUtils(path,sheetName);
        Object[][] musteriBilgileri = excelUtils.getDataArrayWithoutFirstRow();
        return musteriBilgileri;
    }











}
