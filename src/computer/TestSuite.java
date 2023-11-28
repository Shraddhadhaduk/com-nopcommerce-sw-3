package computer;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

import java.util.Random;

public class TestSuite extends Utility {
    String baseUrl = " https://demo.nopcommerce.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void verifyProductArrangeInAlphabeticalOrder() {
        //1.1 click on computer menu
        clickOnElement(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Computers']"));

        //1.2 click on desktop
        clickOnElement(By.xpath("//a[@title='Show products in category Desktops'][normalize-space()='Desktops']"));

        //1.3 Select Sort By position "Name: Z to A"
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='products-orderby']"), "Name: Z to A");

        //1.4  Verify the Product will arrange in Descending order.
        //verifyTextFromElement("error", "Name: Z to A", By.xpath("//option[contains(text(),'Name: Z to A')]"));

    }

    @Test
    public void verifyProductAddedToShoppingCartSuccessFully() throws InterruptedException {
        //2.1 click on computer menu
        clickOnElement(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Computers']"));
        //2.2 click on desktop
        clickOnElement(By.xpath("//a[@title='Show products in category Desktops'][normalize-space()='Desktops']"));
        //2.3 select Sort By position "Name: A to Z"
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='products-orderby']"), "Name: A to Z");
        //2.4 click on add to cart
        Thread.sleep(1000);
        clickOnElement(By.xpath("(//button[@type='button'][normalize-space()='Add to cart'])[1]"));
        //2.5 Verify the Text "Build your own computer"
        verifyTextFromElement(By.xpath("//h1[normalize-space()='Build your own computer']"), "Build your own computer");
        //2.6 Select "2.2 GHz Intel Pentium Dual-Core E2200" using Select class
        selectByVisibleTextFromDropdown(By.id("product_attribute_1"), "2.2 GHz Intel Pentium Dual-Core E2200");
        //2.7 Select "8GB [+$60.00]" using Select class.
        selectByVisibleTextFromDropdown(By.id("product_attribute_2"), "8GB [+$60.00]");
        //2.8 Select HDD radio "400 GB [+$100.00]"
        clickOnElement(By.id("product_attribute_3_7"));
        //2.9 Select OS radio "Vista Premium [+$60.00]"
        clickOnElement(By.id("product_attribute_4_9"));
        Thread.sleep(1000);
        //2.10 Check Two Check boxes "Microsoft Office [+$50.00]" and "Total Commander [+$5.00]"
        clickOnElement(By.id("product_attribute_5_12"));
        //2.11 Verify the price "$1,475.00"
        verifyTextFromElement(By.xpath("//span[@id='price-value-1']"), "$1,475.00");
        //2.12 Click on "ADD TO CARD" Button.
        clickOnElement(By.id("add-to-cart-button-1"));
        //2.13 Verify the Message "The product has been added to your shopping cart" on Top green Bar After that close the bar clicking on the cross button.
        verifyTextFromElement(By.xpath("//p[@class='content']"), "\"The product has been added to your shopping cart");
        clickOnElement(By.xpath("//span[@title='Close']"));
        Thread.sleep(1000);
        //2.14 Then MouseHover on "Shopping cart" and Click on "GO TO CART" button.
        mouseHoverToElement(By.xpath("//span[@class='cart-label']"));
        clickOnElement(By.xpath("//button[@class='button-1 cart-button']"));
        Thread.sleep(1000);
        //2.15 Verify the message "Shopping cart"
        verifyTextFromElement(By.xpath("//span[@class='value-summary']//strong[contains(text(),'$2,950.00')]"), "shopping cart");
        Thread.sleep(2000);
        //2.16 Change the Qty to "2" and Click on "Update shopping cart"
        clearTest(By.xpath("//input[@id='itemquantity11228']"));
        sendTextToElement(By.xpath("//input[@id='itemquantity11228']"), "2");
        Thread.sleep(2000);
        //2.17 Verify the Total"$2,950.00"
        verifyTextFromElement(By.xpath("//span[@class='value-summary']//strong[contains(text(),'$2,950.00')]"), "$2,950.00");
        //2.18 click on checkbox “I agree with the terms of service”
        clickOnElement(By.id("termsofservice"));
        //2.19 Click on "CHECKOUT"
        clickOnElement(By.id("checkout"));
        //2.20 Verify the Text “Welcome, Please Sign In!”
        verifyTextFromElement(By.xpath("//h1[contains(text(),'Welcome, Please Sign In!')]"), "Welcome, Please Sign In!");
        //2.21 Click on “CHECKOUT AS GUEST” Tab
        clickOnElement(By.xpath("//button[contains(text(),'Checkout as Guest')]"));
        //2.22 Fill the all mandatory field
        sendTextToElement(By.id("FirstName"), "Shraddha");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_LastName']"), "Dhaduk");
        Random randomGenerator = new Random();
        int randomInt = randomGenerator.nextInt(1000);
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_Email']"), "People" + randomInt + "@gmail.com");
        selectByVisibleTextFromDropdown(By.xpath("//select[@id='BillingNewAddress_CountryId']"), "Germany");
        selectByVisibleTextFromDropdown(By.xpath("//input[@id='BillingNewAddress_City']"), "Other");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_City']"), "Munich");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_Address1']"), "449A kingstone road");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_ZipPostalCode']"), "kt190DB");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_ZipPostalCode']"), "0987654321");
        //2.23 click on element
        clickOnElement(By.xpath("//button[@onclick='Billing.save()']"));
        //2.24 click on radio button
        clickOnElement(By.xpath("//label[@for='shippingoption_1']"));
        //2.25 click on continue
        clickOnElement(By.xpath("//button[@class='button-1 shipping-method-next-step-button']"));
        //2.26 select radio button credit card
        clickOnElement(By.xpath("//input[@id='paymentmethod_1']"));
        //2.27 select master card
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='CreditCardType']"), "Master card");
        //2.28 fill all details
        sendTextToElement(By.id("CardholderName"),"john");
        sendTextToElement(By.id("CardNumber"),"1645123456121212");
        selectByVisibleTextFromDropdown(By.id("ExpireMonth"),"02");
        selectByVisibleTextFromDropdown(By.id("ExpireYear"),"2027");
        sendTextToElement(By.id("CardCode"),"231");
        //2.29 click on continue
        clickOnElement(By.xpath("//button[@class='button-1 shipping-method-next-step-button']"));
        //2.30 Verify “Payment Method” is “Credit Card”
        clickOnElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[5]/div[2]/div[1]/button[1]"));
        //2.32 Verify “Shipping Method” is “Next Day Air”
        verifyTextFromElement(By.xpath("//li[@class='payment-method']"), "Payment Method: Credit Card");
        Thread.sleep(1500L);
        //2.33 Verify Total is “$2,950.00”
        verifyTextFromElement(By.xpath("//tr[@class='order-total']/td[2]"), "$2,950.00");
        //2.34 Click on “CONFIRM”
        clickOnElement(By.xpath("//button[@class='button-1 confirm-order-next-step-button']"));
        //2.35 Verify the Text “Thank You”
        verifyTextFromElement(By.xpath("//h1[contains(text(),'Thank you')]"), "Thank you");
        //2.36  Verify the message “Your order has been successfully processed!
        verifyTextFromElement(By.xpath("//strong[contains(text(),'Your order has been successfully processed!')]"), "Your order has been successfully processed!");
        //2.37  Click on “CONTINUE”
        clickOnElement(By.xpath("//button[@class='button-1 order-completed-continue-button']"));
        //2.38 Verify the text “Welcome to our store”
        verifyTextFromElement(By.xpath("//h2[contains(text(),'Welcome to our store')]"), "Welcome to our store");
    }

    @After
    public void tearDown(){
        closeBrowser();
    }
}