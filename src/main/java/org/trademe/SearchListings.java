package org.trademe;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class SearchListings {
    WebDriver driver;
    WebElement searchString;
    WebElement searchType;
    WebElement btnSearch;
    WebElement searchResults;

    public SearchListings(WebDriver driver) {
        this.driver = driver;
    }
    public void setSearchString(String searchString) {
        this.searchString = this.driver.findElement(By.id("searchString"));
        this.searchString.sendKeys(searchString);
    }
    public void selectSearchType(String category) {
        this.searchType = this.driver.findElement(By.id("SearchType"));
        Select dropdown = new Select(this.searchType);
        dropdown.selectByVisibleText(category);
    }
    public void clickSearch() {
        this.btnSearch = this.driver.findElement(By.className("icon-search-large"));
        this.btnSearch.click();
    }
    public boolean checkResults() {
        this.searchResults = this.driver.findElement(By.xpath("//li[normalize-space()='Search results']"));
        if(this.searchResults.isDisplayed()) {
            return true;
        } else {
            return false;
        }
    }
    public void testSearch(String searchString, String searchType) {
        this.setSearchString(searchString);
        this.selectSearchType(searchType);
        this.clickSearch();
        if(this.checkResults()) {
            System.out.println("Test passed");
        } else {
            System.out.println("WARNING: Basic Search Functionality test failed");
        }
    }
}
