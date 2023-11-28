package electronics;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

import java.util.Random;

public class ElectronicsTest extends Utility {
    String baseUrl = " https://demo.nopcommerce.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void  verifyUserShouldNavigateToCellPhonesPageSuccessfully() {
        //1.1 Mouse Hover on “Electronics” Tab
        mouseHoverToElement(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Electronics']"));
        //1.2  Mouse Hover on “Cell phones” and click
        mouseHoverAndClick(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Cell phones']"));
        //1.3 verify text Cell phones
        verifyTextFromElement(By.xpath("//h1[normalize-space()='Cell phones']"), "Cell phones");
    }

    @Test
    public void verifyThatTheProductAddedSuccessfullyAndPlaceOrderSuccessfully() throws InterruptedException {
        //2.1 Mouse Hover on “Electronics” Tab
        mouseHoverToElement(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Electronics']"));
        //2.2  Mouse Hover on “Cell phones” and click
        mouseHoverAndClick(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Cell phones']"));
        //2.3 verify text Cell phones
        verifyTextFromElement(By.xpath("//h1[normalize-space()='Cell phones']"), "Cell phones");
        //2.4 click on list view tab
        clickOnElement(By.xpath("//a[@title='List']"));
        //2.5 Click on product name “Nokia Lumia 1020” link
        Thread.sleep(1000);
        clickOnElement(By.xpath("(//a[contains(text(),'Nokia Lumia 1020')])"));
        //2.6 Verify the text “Nokia Lumia 1020”
        verifyTextFromElement(By.xpath("//h1[normalize-space()='Nokia Lumia 1020']"), "Nokia Lumia 1020");
        //2.7 Verify the price “$349.00
        verifyTextFromElement(By.xpath("//span[@id='price-value-20']"), "$349.00");
        //2.8 change quantity to 2
        clearTest(By.xpath("//input[@id='product_enteredQuantity_20']"));
        sendTextToElement(By.xpath("//input[@id='product_enteredQuantity_20']"), "2");
        //2.9 click on add to cart
        clickOnElement(By.xpath("//button[@id='add-to-cart-button-20']"));
        //2.10 Verify the Message "The product has been added to your shopping cart" on Top green Bar
        verifyTextFromElement(By.xpath("//p[@class='content']"), "The product has been added to your shopping cart");
        clickOnElement(By.xpath("//span[@title='Close']"));
        //2.11 Then MouseHover on "Shopping cart" and Click on "GO TO CART" button
        mouseHoverToElement(By.xpath("//span[@class='cart-label']"));
        clickOnElement(By.xpath("//button[normalize-space()='Go to cart']"));
        //2.12 verify the message shopping cart
        verifyTextFromElement(By.xpath("//h1[normalize-space()='Shopping cart']"), "Shopping cart");
        //2.13 verify the quality
        Thread.sleep(1000);
       // verifyTextFromElement(By.xpath("/html[1]/body[1]/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/div[1]/form[1]/div[1]/table[1]/tbody[1]/tr[1]/td[5]/input[1]"), "2");
        //2.14  Verify the Total $698.00
        verifyTextFromElement(By.xpath("//span[@class='product-subtotal']"), "$698.00");
        //2.15 click on checkbox
        clickOnElement(By.xpath("//input[@id='termsofservice']"));
        //2.16 click on checkout
        clickOnElement(By.xpath("//button[@id='checkout']"));
        //2.17 verify text
        verifyTextFromElement(By.xpath("//h1[contains(text(),'Welcome, Please Sign In!')]"),"Welcome, Please Sign In!");
        //2.18 Click on “REGISTER” tab
        clickOnElement(By.xpath("//button[contains(text(),'Register')]"));
        //2.19 Verify the text “Register”
        verifyTextFromElement(By.xpath("//h1[contains(text(),'Register')]"),"Register");
        //2.20 Fill the mandatory fields
        clickOnElement(By.xpath("//input[@id='gender-male']"));
        sendTextToElement(By.xpath("//input[@id='FirstName']"),"shraddha");
        sendTextToElement(By.xpath("//input[@id='LastName']"),"dhaduk");
        sendTextToElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/form[1]/div[1]/div[2]/div[4]/div[1]/select[1]"),"2");
        sendTextToElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/form[1]/div[1]/div[2]/div[4]/div[1]/select[2]"),"February");
        sendTextToElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/form[1]/div[1]/div[2]/div[4]/div[1]/select[3]"),"1989");
        Random randomGenerator = new Random();
        int randomInt = randomGenerator.nextInt(1000);
        sendTextToElement(By.xpath("//input[@id='Email']"),"happy_0250" +randomInt + "@yahoo.co.in");
        sendTextToElement(By.xpath("//input[@id='Company']"),"kbbrotherltd");
        clickOnElement(By.xpath("//input[@id='Newsletter']"));
        sendTextToElement(By.xpath("//input[@id='Password']"),"Vivek241990");
        sendTextToElement(By.xpath("//input[@id='ConfirmPassword']"),"Vivek241990");
        //2.21 Click on “REGISTER” Button
        clickOnElement(By.xpath("//button[@id='register-button']"));
        //2.22 Verify the message “Your registration completed”
      //  verifyTextFromElement(By.xpath("//div[contains(text(),'Your registration completed')]"),"Your registration completed");
        Thread.sleep(1500);
        //2.23 Click on “CONTINUE” tab
        clickOnElement(By.xpath("//a[contains(text(),'Continue')]"));
        //2.24 Verify the text “Shopping card”
        verifyTextFromElement(By.xpath("//h1[contains(text(),'Shopping cart')]"),"Shopping cart");
        //2.25 click on checkbox “I agree with the terms of service”
        clickOnElement(By.xpath("//input[@id='termsofservice']"));
        //2.26 Click on “CHECKOUT”
        clickOnElement(By.xpath("//button[@id='checkout']"));
        //2.27 Fill the Mandatory fields
        sendTextToElement(By.xpath("//select[@id='BillingNewAddress_CountryId']"),"Albania");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_City']"),"london");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_City']"),"115a");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_Address1']")," manor drive north");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_ZipPostalCode']"),"kt3 5pd");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_PhoneNumber']"),"07534568520");
        //2.28 Click on “CONTINUE”
        clickOnElement(By.xpath("//div[@id='billing-buttons-container']"));
        //2.29 Click on Radio Button “2nd Day Air ($0.00)”
        clickOnElement(By.xpath("//input[@id='shippingoption_1']"));
        //2.30 Click on “CONTINUE”
        clickOnElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[3]/div[2]/form[1]/div[2]/button[1]"));
        //2.31 Select Radio Button “Credit Card”
        clickOnElement(By.xpath("//input[@id='paymentmethod_1']"));
        //2.32 Select “Visa” From Select credit card dropdown
        clickOnElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[4]/div[2]/div[1]/button[1]"));
        //2.33 Fill all the details
        sendTextToElement(By.xpath("//select[@id='CreditCardType']"),"Visa");
        sendTextToElement(By.xpath("//input[@id='CardholderName']"),"kishan  malabiay");
        sendTextToElement(By.xpath("//input[@id='CardNumber']"),"5555555555554444");
        sendTextToElement(By.xpath("//select[@id='ExpireMonth']"),"02");
        sendTextToElement(By.xpath("//select[@id='ExpireYear']"),"2025");
        sendTextToElement(By.xpath("//input[@id='CardCode']"),"235");
        //2.34 Click on “CONTINUE”
        clickOnElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[5]/div[2]/div[1]/button[1]"));
        //2.35 Verify “Payment Method” is “Credit Card”
        verifyTextFromElement(By.xpath("//h2[contains(text(),'Payment method')]"),"Payment method");
        //2.36 Verify “Shipping Method” is “2nd Day Air”
        //verifyTextFromElements(By.xpath("//h2[contains(text(),'Shipping method')]"),"Next Day Air ($0.00)");
        //2.38 Click on “CONFIRM”
        clickOnElement(By.xpath("//button[contains(text(),'Confirm')]"));
        //2.39 Verify the Text “Thank You”
        verifyTextFromElement(By.xpath("//h1[contains(text(),'Thank you')]"),"Thank you");
        //2.40 Verify the message “Your order has been successfully processed!”
        verifyTextFromElement(By.xpath("//strong[contains(text(),'Your order has been successfully processed!')]"),"Your order has been successfully processed!");
        //2.41 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[contains(text(),'Continue')]"));
        //2.42 Verify the text “Welcome to our store”
        Thread.sleep(1500);
        // verifyTextFromElements(By.xpath("2.42 Verify the text “Welcome to our store”"),"Welcome to our store");
        //2.43 Click on “Logout” link
        clickOnElement(By.xpath("//a[contains(text(),'Log out')]"));
        //2.44 Verify the URL is “https://demo.nopcommerce.com/”
        //String actualURl=driver.getCurrentUrl();
        //Assert.assertEquals("https://demo.nopcommerce.com/",actualURl);
    }

    @After
    public void tearDown(){
        closeBrowser();
    }

}
