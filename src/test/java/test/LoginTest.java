package test;


import base.Base;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.LoginPage;

import java.io.IOException;

public class LoginTest{

    public LoginPage loginPage;
    public Base base;

    @BeforeTest
    public void setUp(){
        base=new Base();
        base.initializeBrowser();
    }

    @Test
    public void loginToDemoQA() throws IOException {
        loginPage=new LoginPage();
        loginPage.loadURL();
        loginPage.addUsername();
        loginPage.addPassword();
    }

    @AfterTest
    public void tearDownTest()   {
        base.tearDown();
    }

}
