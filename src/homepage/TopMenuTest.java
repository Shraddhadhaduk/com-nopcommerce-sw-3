package homepage;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

public class TopMenuTest extends Utility {

    String baseUrl = " https://demo.nopcommerce.com/";

    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }
    //1.1 create method with name "selectMenu" it has one parameter name "menu" of type string
    public void selectMenu(By by, String menu){
        WebElement click = driver.findElement(by);
        click.sendKeys(menu);
    }
    @Test
    public void  verifyPageNavigation() {
        //1.3. create the @Test method name verifyPageNavigation.use selectMenu method to select the Menu and click on it and verify the page navigation
    clickOnElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[1]/a[1]"));
    }

    @After
    public void tearDown(){
        closeBrowser();
    }
}
