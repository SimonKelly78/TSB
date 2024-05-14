package org.trademe;

import java.util.ArrayList;
import java.util.List;

public class trademeListing {
    String Category = "6911";  // Computer Category
    String Title = "Laptop Computer";
    String Duration = "7";  // 7 days
    String Pickup = "1";    // Pickup Allowed - The buyer can pickup if they so choose.
    List<String> Description = new ArrayList<String>();
    List<ShippingOption> ShippingOptions = new ArrayList<ShippingOption>();
    List<String> PaymentMethods =  new ArrayList<String>();
    Double StartPrice = 50.00;
    Double ReservePrice = 75.00;
    Double ByNowPrice = 90.00;
    Boolean SendPaymentInstructions = false;


    public trademeListing() {
    }

    // public get methods for Serialisation
    public String getCategory() {
        return Category;
    }
    public String getTitle() {
        return Title;
    }
    public List getDescription() {
        return Description;
    }
    public void setDescription(String description) {
        Description.add(description);
    }
    public List getPaymentMethods() {
        return PaymentMethods;
    }
    public void setPaymentMethods(String payment) {
        PaymentMethods.add(payment);
    }
    public List<ShippingOption> getShippingOptions() {
        return ShippingOptions;
    }
    public void setShippingOptions(String shipping) {
        ShippingOption shippingoption = new ShippingOption();
        shippingoption.setType(shipping);
        ShippingOptions.add(shippingoption);
    }
    public Double getStartPrice() {
        return StartPrice;
    }
    public Double getReservePrice() {
        return ReservePrice;
    }
    public Double getByNowPrice() {
        return ByNowPrice;
    }
    public String getDuration() {
        return Duration;
    }
    public Boolean getSendPaymentInstructions() {
        return SendPaymentInstructions;
    }
    public String getPickup() {
        return Pickup;
    }
}
