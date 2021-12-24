package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Base {

    public static WebDriver driver;

    public void initializeBrowser(){
        final WebDriver driver;
        ChromeOptions chromeOptions=new ChromeOptions();
        chromeOptions.addArguments("--headless");
        chromeOptions.addArguments("--window-size=1920,1080");
        chromeOptions.addArguments("--ignore-certificate-errors");
        chromeOptions.addArguments("--no-sandbox");
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver(chromeOptions);
        setDriver(driver);
    }
    public void setDriver(WebDriver driver){
        this.driver=driver;
    }


}
