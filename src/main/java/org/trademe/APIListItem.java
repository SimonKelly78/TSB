package org.trademe;

import com.google.gson.Gson;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;

public class APIListItem {
    public APIListItem() {
        RestAssured.baseURI = "https://api.tmsandbox.co.nz/v1";
        String consumerKey = "7E97D08892B530CE919899385C2D8334";
        String consumerSecret = "B1C514AE4AE7AEBFBA3CAE620CD0707D";
        String token = "7E8A393B5552A6EB4FB98740C6B8E5F6";
        String tokenSecret = "4F52D04CA0AB5E219DD479C4FFC8A2BE";

        String oauthHeader = "OAuth oauth_consumer_key=\"" + consumerKey + "\", "
                + "oauth_token=\"" + token + "\", "
                + "oauth_signature_method=\"PLAINTEXT\", "
                + "oauth_signature=\"" + consumerSecret + "%26" + tokenSecret + "\"";

        // Create a Trademe Listing object using the default values
        trademeListing ListingDetails = new trademeListing();

        Gson gson = new Gson();
        String jsonListing = gson.toJson(ListingDetails);

        Response response = RestAssured.given()
                .header("Content-Type", "application/x-www-form-urlencoded")
                .header("Authorization", oauthHeader)
                .contentType(ContentType.JSON)
                .body(jsonListing)
                .when()
                .post("/Selling.json?file_format=json");

        ResponseBody body = response.getBody();
        System.out.println("Response Body is: " + body.asString());
    }
}