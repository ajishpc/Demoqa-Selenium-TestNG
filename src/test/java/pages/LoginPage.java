package pages;

import base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;


public class LoginPage {

    public Base base;
    public WebDriver driver;
    public WebDriverWait wait;

    String loginButton="//*[@id=\"login\"]";
    String usernameTxt="//*[@id=\"userName\"]";
    String passwordTxt="//*[@id=\"password\"]";

    public void loadURL() throws IOException {
        base=new Base();
        driver= base.getDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        String URL;
        URL=base.getConfigValue("bookApplicationURL");
        driver.get(URL);
        driver.manage().window().maximize();

    }
    public void addUsername() throws IOException {
        base=new Base();
        wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        String username;
        username=base.getConfigValue("username");
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(loginButton))));
        driver.findElement(By.xpath(loginButton)).click();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(usernameTxt))));
        driver.findElement(By.xpath(usernameTxt)).sendKeys(username);

    }
    public void addPassword() throws IOException {

        base=new Base();
        String password;
        password=base.getConfigValue("password");
        driver.findElement(By.xpath(passwordTxt)).sendKeys(password);

    }



}
