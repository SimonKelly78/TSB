package org.trademe;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Register {
    WebDriver driver;
    WebElement email;
    WebElement password;
    WebElement confirmPassword;
    WebElement userName;
    WebElement firstName;
    WebElement lastName;
    WebElement genderMale;
    WebElement genderFemale;
    WebElement genderDiverse;
    WebElement dobDay;
    WebElement dobMonth;
    WebElement dobYear;
    WebElement phonePrefix;
    WebElement phoneNumber;
    WebElement address;
    WebElement closestDistrict;
    WebElement over18;
    WebElement btnCreate;
    WebElement loginLink;

    public Register(WebDriver browserDriver){
        this.driver = browserDriver;
        this.email = this.driver.findElement(By.id("LoginDetails_EmailAddressTextBox"));
        this.password = this.driver.findElement(By.id("LoginDetails_PasswordTextBox"));
        this.confirmPassword = this.driver.findElement(By.id("LoginDetails_ConfirmPasswordTextBox"));
        this.userName = this.driver.findElement(By.id("LoginDetails_UserNameTextBox"));
        this.firstName = this.driver.findElement(By.id("ContactDetails_FirstNameTextBox"));
        this.lastName = this.driver.findElement(By.id("ContactDetails_LastNameTextBox"));
        this.genderMale = this.driver.findElement(By.xpath("//label[normalize-space()='Male']"));
        this.genderFemale = this.driver.findElement(By.id("ContactDetails_GenderFemale"));
        this.genderDiverse = this.driver.findElement(By.id("ContactDetails_GenderDiverse"));
        this.dobDay = this.driver.findElement(By.id("ContactDetails_DobDay"));
        this.dobMonth = this.driver.findElement(By.id("ContactDetails_DobMonth"));
        this.dobYear = this.driver.findElement(By.id("ContactDetails_DobYear"));
        this.phonePrefix = this.driver.findElement(By.id("ContactDetails_ContactPhoneAreaCodeDropDown"));
        this.phoneNumber = this.driver.findElement(By.id("ContactDetails_ContactPhoneTextBox"));
        this.address = this.driver.findElement(By.className("js-txt-search-address"));
        this.over18 = this.driver.findElement(By.id("TnCCheckbox"));
        this.btnCreate = this.driver.findElement(By.id("SubmitButton"));
    }
    public void setDob(String day, String month, String year) {
        this.dobDay.sendKeys(day);
        this.dobMonth.sendKeys(month);
        this.dobYear.sendKeys(year);
    }
    public void setPhoneNumber(String prefix, String number) {
        this.phonePrefix.sendKeys(prefix);
        this.phoneNumber.sendKeys(number);
    }
    public void setAddress(String address) {
        this.address.sendKeys(address);
        WebElement element = this.driver.findElement(By.cssSelector("div[id='ContactDetails_StreetAddress_address_section'] span:nth-child(3)"));
        element.click();
    }
    public void selectClosestDistrict(String district) {
        this.closestDistrict = this.driver.findElement(By.id("ContactDetails_ClosestSuburbDropDown"));
        Select dropdown = new Select(this.closestDistrict);
        try {
            Thread.sleep(2000);
        }
        catch(Exception e) {
        }
        dropdown.selectByVisibleText(district);
    }
    public void clickLoginLink() {
        this.loginLink = this.driver.findElement(By.id("LoginLink"));
        this.loginLink.click();
    }

    public void setupAccount(String loginEmail, String pword) {
        this.email.sendKeys(loginEmail);
        this.password.sendKeys(pword);
        this.confirmPassword.sendKeys(pword);
        this.userName.sendKeys("Simon10");

        this.firstName.sendKeys("Simon");
        this.lastName.sendKeys("Kelly");
        this.genderMale.click();
        this.setDob("31","October","1978");
        this.setPhoneNumber("027","5159639");
        this.setAddress("38 Waipuna Road, Waerenga");
        this.selectClosestDistrict("Auckland - Auckland City");
        this.over18.click();
        this.btnCreate.click();
        this.clickLoginLink();
    }
}
