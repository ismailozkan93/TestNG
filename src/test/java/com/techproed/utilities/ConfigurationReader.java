package com.techproed.utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigurationReader {
    // ConfigurationReader class'ını projemizin heryerinden
    // nesne üretmeden, miras almadan kullanabilecek şekilde tasarlayalım.
    // static : program çalışır çalışmaz, bellekte yer tutmaya yarayan keyword

    static Properties properties;
    static{
                                                        // okumak istediğimiz configuration.properties file'ın dosya yolu
                                                        // C:\Users\isimsiz\IdeaProjects\TestNGProje\configuration.properties
        String path = "configuration.properties";
                                                        // dene - hata varsa yakala.// bu işlemi DENE eğer hata alırsan, PROGRAMI DURDURMA
        try{
                                                         // okumak istediğiniz dosyanın path(adres)'ini yazıyorsun
            FileInputStream file = new FileInputStream(path);
            properties = new Properties();
            properties.load(file);                         // fileInputStream'dan ürettiğim file dosyası burada, bunu kullanabilirsin
        }catch (Exception e){
        }
    }
    //  properties.getProperty("username")  --> manager2
    public static String getProperty(String key){
        return properties.getProperty(key);
    }


}
