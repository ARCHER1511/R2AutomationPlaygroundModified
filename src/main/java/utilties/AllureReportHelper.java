package utilties;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;

public class AllureReportHelper
{
    private AllureReportHelper()
    {

    }
    public static void cleanAllureReport()
    {
        try {
            FileUtils.deleteDirectory(new File("target/allure-results"));
        } catch (IOException e) {
            System.out.println("Allure Directory already clean");
        }
    }
}
