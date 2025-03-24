package listeners.testng;

import driverfactory.Driver;
import org.testng.IExecutionListener;
import org.testng.ITestListener;
import org.testng.ITestResult;
import utilties.ScreenshotManager;
import java.lang.reflect.Field;

public class TestNGListener implements IExecutionListener, ITestListener
{
    @Override
    public void onExecutionStart() {
        System.out.println("Welcome to Selenium Framework");
    }
    @Override
    public void onExecutionFinish()
    {
       System.out.println("End of Execution");
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
    }
}