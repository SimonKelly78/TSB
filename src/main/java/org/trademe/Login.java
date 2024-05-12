package org.trademe;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.List;

public class Login {
    WebDriver driver;
    WebElement linkMyTradeMe;
    WebElement linkRegisterNow;
    WebElement Email;
    WebElement Password;
    WebElement btnLogin;

    public Login(WebDriver browserDriver) {
        this.driver = browserDriver;
    }

    public void clickMyTradeMe() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        this.linkMyTradeMe = this.driver.findElement(By.linkText("My Trade Me"));
        this.linkMyTradeMe.click();
    }
    public void enterLogin(String loginEmail, String pword) {
        // Enter user name and password
        this.setEmail(loginEmail);
        this.setPassword(pword);
        this.clickRecaptcha();
        this.clickLogin();
    }
    public boolean loginTest(String scenario, String loginEmail, String pword) {
        System.out.println(scenario);
        this.enterLogin(loginEmail,pword);
        List<WebElement> invalidEmail = this.driver.findElements(By.cssSelector("div[class='validation-summary-errors'] ul li"));
        if (invalidEmail.isEmpty()) {
            System.out.println("WARNING: Validation failed");
            return false;  // Validation errors not found, something went wrong
        } else {
            System.out.println("Validation passed");
            return true; // Validation errors found, this is what we are looking for
        }
    }



    public void setEmail(String emailAddress){
        this.Email = this.driver.findElement(By.id("Email"));
        this.Email.clear();
        this.Email.sendKeys(emailAddress);
    }
    public void setPassword(String pword) {
        this.Password = this.driver.findElement(By.id("Password"));
        this.Password.clear();
        this.Password.sendKeys(pword);
    }
    public void clickRecaptcha() {
        // Wait for manual intervention

        // Should really wait until the recaptcha checkbox is displayed. This will be a future enhancement
        try {
            Thread.sleep(15000);  // 10 seconds to allow for manually clicking the I am not a robot checkbox and picture selection
        }
        catch(InterruptedException ie) {
        }
    }
    public void clickLogin() {
        this.btnLogin = this.driver.findElement(By.id("SignIn"));
        this.btnLogin.click();
    }
    public void clickLinkRegisterNow() {
        this.linkRegisterNow = this.driver.findElement(By.linkText("Register now"));
        this.linkRegisterNow.click();
    }
    public void gotoHomepage() {
        WebElement siteHeader = this.driver.findElement(By.id("SiteHeader_SiteTabs_kevin"));
        siteHeader.click();
    }
}
