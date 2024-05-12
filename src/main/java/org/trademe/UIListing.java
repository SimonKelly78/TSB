package org.trademe;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class UIListing {
    WebDriver driver;
    WebElement linkListAnItem;
    WebElement listingTitle;
    WebElement category;
    WebElement chooseCategoryOne;
    WebElement chooseCategoryTwo;
    WebElement chooseCategoryThree;
    WebElement chooseCategoryFour;
    WebElement description;
    WebElement startPrice;
    WebElement buyNow;
    WebElement shipping;

    public UIListing(WebDriver driver) {
        this.driver = driver;
    }

    public void clickBtnNext() {
        this.driver.findElement(By.id("submit1")).click();
    }

    public void clicklinkListAnItem() {
        this.linkListAnItem = this.driver.findElement(By.id("SiteHeader_SideBar_Quicklinks_ListAnItemLink"));
        this.linkListAnItem.click();
    }

    public void setListingTitle(String title) {
        this.listingTitle = this.driver.findElement(By.name("title"));
        this.listingTitle.sendKeys(title);
    }
    public void setDescription(String description) {
        this.description = this.driver.findElement(By.name("body"));
        this.description.sendKeys(description);
    }

    public void setCategory(String category1,String category2,String category3,String category4) {
        this.category = this.driver.findElement(By.className("dropdown-select"));
        this.category.click(); // Click to dropdown the object
        this.driver.findElement(By.xpath("//span[normalize-space()='Browse categories']")).click();

        this.chooseCategoryOne = this.driver.findElement(By.id("selector_0"));
        Select selectorone = new Select(this.chooseCategoryOne);
        selectorone.selectByVisibleText(category1);

        this.chooseCategoryTwo = this.driver.findElement(By.id("selector_1"));
        Select selectortwo = new Select(this.chooseCategoryTwo);
        selectortwo.selectByVisibleText(category2);

        this.chooseCategoryThree = this.driver.findElement(By.id("selector_2"));
        Select selectorthree = new Select(this.chooseCategoryThree);
        selectorthree.selectByVisibleText(category3);

        this.chooseCategoryFour = this.driver.findElement(By.id("selector_3"));
        Select selectorfour = new Select(this.chooseCategoryFour);
        selectorfour.selectByVisibleText(category4);

        WebElement listSingleCategory = this.driver.findElement(By.xpath("//span[normalize-space()='List in only one category']"));
        listSingleCategory.click();

        this.driver.findElement(By.id("submit_button")).click();
    }

    public void setStartPrice(String price) {
        this.startPrice = this.driver.findElement(By.id("startPriceInput"));
        this.startPrice.sendKeys(price);
    }
    public void setBuyNow(String price) {
        this.buyNow = this.driver.findElement(By.name("buynowprice"));
        this.buyNow.sendKeys(price);
    }
    public void setShipping() {
        this.shipping = this.driver.findElement(By.id("gh_1"));  // Free shipping within NZ
        this.shipping.click();
    }
    public void setPaymentMethods() {
        this.driver.findElement(By.id("payment_cash_on_pickup")).click();
        this.driver.findElement(By.id("payment_bank_deposit")).click();
    }

    public void listingGeneral() {
        System.out.println("UI Test 3 Listing an item");
        this.clicklinkListAnItem();  // Click the List an item on the left hand page
        this.clickBtnNext();    // General Item is already selected, so click Next
        this.setCategory("Computers >","Laptops >","Laptops >", "HP");
        this.setListingTitle("HP Pavilion 8236");
        this.setDescription("This is a good laptop previously used at TSB");
        this.clickBtnNext();
        this.setStartPrice("100.00");
        this.setBuyNow("150.00");
        this.clickBtnNext();
        this.setShipping();
        this.setPaymentMethods();
        this.clickBtnNext();
        this.driver.findElement(By.id("ContinueUpload")).click();
        this.driver.findElement(By.id("basic-selector")).click();
        this.driver.findElement(By.id("promo-submit")).click();
        this.driver.findElement(By.id("submit_sell")).click();
        System.out.println("Your auction has started");
    }
}
