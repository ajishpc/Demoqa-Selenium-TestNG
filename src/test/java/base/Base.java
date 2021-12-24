package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.*;
import java.util.Properties;

public class Base {

    public static WebDriver driver;
    public String configFileName = "config.properties";

    public void initializeBrowser(){
        final WebDriver driver;
        ChromeOptions chromeOptions=new ChromeOptions();
        //chromeOptions.addArguments("--headless");
        chromeOptions.addArguments("--window-size=1920,1080");
        chromeOptions.addArguments("--ignore-certificate-errors");
        chromeOptions.addArguments("--no-sandbox");
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver(chromeOptions);
        setDriver(driver);
    }
    public String getConfigValue(String value) throws IOException {
        //GET URL FROM CONFIG FILE

        Properties prop = new Properties();
        File configFile = new File(configFileName);
        InputStream stream = new FileInputStream(configFile);
        prop.load(stream);
        System.out.println(prop.getProperty(value));
        return (prop.getProperty(value));
    }
    public void setDriver(WebDriver driver){
        this.driver=driver;
    }
    public WebDriver getDriver(){
        return driver;
    }
    public void tearDown(){
        driver.quit();
    }

}
