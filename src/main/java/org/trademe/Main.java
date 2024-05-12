package org.trademe;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello and welcome!");

        // Setup variables
        String loginEmail = "sdpkelly+8@live.com";
        String pword = "TSBapplication";

        WebDriver driver = new EdgeDriver();
        driver.get("https://www.tmsandbox.co.nz/");
        driver.manage().window().maximize();
        Login TradeMeLogin = new Login(driver);
        TradeMeLogin.clickMyTradeMe();

        // First Scenario: Account not found
        TradeMeLogin.loginTest("Login Scenario 1: Account does not exist",loginEmail,pword);

        // Setup new account to test remaining scenarios
        TradeMeLogin.clickLinkRegisterNow();
        Register RegisterNow = new Register(driver);
        RegisterNow.setupAccount(loginEmail,pword);

        // Second Scenario: Invalid Password
        TradeMeLogin.loginTest("Login Scenario 2: Invalid Password",loginEmail,"This is not the correct password");

        // Third Scenario: Successful Login
        System.out.println("Login Scenario 3: Successful Login");
        TradeMeLogin.enterLogin(loginEmail,pword);

        // Basic Search Functionality within the 'Computers' category
        System.out.println("Basic Search Functionality Test");
        TradeMeLogin.clickMyTradeMe();  // Go to the My Trademe section which allows filtering by category
        SearchListings computerSearch = new SearchListings(driver);
        computerSearch.testSearch("laptop","Computers");

        // Listing an item
        TradeMeLogin.clickMyTradeMe();
        UIListing newListing = new UIListing(driver);
        newListing.listingGeneral();


        // Close drivers
        driver.quit();

        System.out.println("This is the API test section.");
        System.out.println("Using the API, retrieve the latest listings");
        new APIRetrieveLatestListings();

        System.out.println("List an item under Selling methods");  // this section is still under development
        new APIListItem();
    }
}