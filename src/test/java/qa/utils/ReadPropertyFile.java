package qa.utils;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ReadPropertyFile {

    public static void main(String[] args) throws IOException {
        FileReader fr = new FileReader("/Users/kunduzsydykova/Documents/RCV_framework/src/main/java/qa/configfiles/config.properties");
        Properties pr = new Properties();
        pr.load(fr);

        System.out.println(pr.getProperty("browser"));
        System.out.println(pr.get("testurl"));


    }
}
