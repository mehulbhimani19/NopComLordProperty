package Software;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by Mehul on 04/12/2016.
 */
public class LoadProp extends DriverManager
{

    static Properties prop ;
   //    static String fileNmae = "";
   //    static  String fileLocation = " ";

  static FileInputStream input ;


    public static String getProperty(String key)
    {
        prop = new Properties();

        try
        {
            input = new FileInputStream("src\\test\\Resources\\Properties\\TestDataConfing.properties");
            prop.load(input);
            input.close();
        }

        catch (IOException e)

        {
            e.printStackTrace();
        }
       return prop.getProperty(key);
    }

}
