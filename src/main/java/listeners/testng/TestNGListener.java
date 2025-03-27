package listeners.testng;

import driverfactory.Driver;
import io.qameta.allure.Allure;
import org.apache.commons.io.FileUtils;
import org.testng.IExecutionListener;
import org.testng.ITestListener;
import org.testng.ITestResult;
import utilties.AllureReportHelper;
import utilties.ScreenshotManager;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;

import static utilties.PropertiesManager.initializeProperties;

public class TestNGListener implements IExecutionListener, ITestListener
{
    @Override
    public void onExecutionStart() {
        System.out.println("Welcome to Selenium Framework");
        initializeProperties();
        System.out.println("Cleaning results....");
        AllureReportHelper.cleanAllureReport();
    }
    @Override
    public void onExecutionFinish()
    {
       System.out.println("End of Execution");
       System.out.println("Generating Report......");

        try {    System.out.println("Opening Allure Report");    Runtime.getRuntime().exec("reportGeneration.bat");} catch (IOException e) {    System.out.println("Unable to Generate Allure Report, may be there's an issue in the batch file/commands");}

    }
    @Override
    public void onTestStart(ITestResult result)
    {
        System.out.println("Starting of test" + result.getName());
    }
    @Override
    public void onTestSuccess(ITestResult result)
    {
        System.out.println("Success of test" + result.getName());
    }
    @Override
    public void onTestFailure(ITestResult result)
    {
        System.out.println("Test failed...");
        System.out.println("Taking screenshot......");

        Driver driver = null;
        ThreadLocal<Driver> driverThreadLocal;
        Object currentClass = result.getInstance();
        Field[] fields = result.getTestClass().getRealClass().getDeclaredFields();

        try
        {
            for(Field field: fields)
            {
                if(field.getType() == Driver.class)
                {
                    driver =(Driver) field.get(currentClass);
                }
                if(field.getType() == ThreadLocal.class)
                {
                    driverThreadLocal = (ThreadLocal<Driver>) field.get(currentClass);
                    driver = driverThreadLocal.get();
                }
            }
        }
        catch (IllegalAccessException e)
        {
            System.out.println("Unable to get field, Field Should be public");
        }

        assert driver != null;
        ScreenshotManager.captureScreenShot(driver.get(), result.getName());


        String fullPath = System.getProperty("user.dir") + result.getName();
        try
        {    Allure.addAttachment(result.getMethod().getConstructorOrMethod().getName(),FileUtils.openInputStream(new File(fullPath)));}
        catch (IOException e)
        {    System.out.println("Attachment isn't Found");}
    }
}