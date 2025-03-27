package utilties;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesManager
{
    public static Properties webConfig;

    public PropertiesManager()
    {

    }

    public static void initializeProperties()
    {
        FileInputStream webConfigFile = null;
        try {
            webConfigFile = new FileInputStream("src/main/resources/WebConfigurations.properties");
            webConfig = new Properties();
            webConfig.load(webConfigFile);

        } catch (FileNotFoundException e) {
            System.out.println("property File is not found");
        } catch (IOException e) {
            System.out.println("File is not readable");
        }


    }
}
