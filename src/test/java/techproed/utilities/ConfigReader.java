package techproed.utilities;
import java.io.FileInputStream;
import java.util.Properties;
public class ConfigReader {
    //Bu sınıf configuration.properties file i okumak icin kullanılır
    //property file i okumak icin property objesi kullanılır
    private static Properties properties;
    static {
        //data cekmek istediğim dosyanın path i
        String path="configuration.properties";
        try {
            //configuration.property dosyasini acar
            FileInputStream fileInputStream = new FileInputStream(path);
            //properties objesini instanate ediyoruz
            properties = new Properties();
            //configuration.property dosyasındaki dataları yükler
            properties.load(fileInputStream);
            //file input stream'i kapattık
            fileInputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //ConfigReader.getProperty("browser");-->chrome
    //ConfigReader.getProperty("amazon_url");-->https://www.amazon.com

    public static String getProperty(String key){
        String value=properties.getProperty(key);
        return value;
    }
}
