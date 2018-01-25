package com.shipt.stuff;


import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.sikuli.script.App;

import org.sikuli.script.FindFailed;

import org.sikuli.script.Pattern;

import org.sikuli.script.Screen;


import java.io.IOException;
import java.util.List;

import static java.lang.Thread.sleep;
import static javax.swing.text.html.CSS.getAttribute;

public class ShiptCodingTest {

    @Test
    public void shiptCodingTest() throws IOException, Exception {

        String url = "http://www.shipt.com";
        String email = "qatest@shipt.com";
        String passwd= "Sh1pt123!";
        String item = "coke zero";

        System.setProperty("webdriver.chrome.driver","c://SeleniumDrivers//chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.navigate().to(url);

        driver.findElement(By.cssSelector(".button-secondary")).click();

        WebElement userAddressBox = driver.findElement(By.cssSelector("input.ng-valid-email"));
        userAddressBox.click();
        userAddressBox.sendKeys(email);

        WebElement passwdBox = driver.findElement(By.cssSelector("input.ng-invalid-required"));
        passwdBox.click();
        passwdBox.sendKeys(passwd);

        driver.findElement(By.cssSelector("#start_shopping_login_button")).click();
        sleep(5000);
        WebElement search = driver.findElement(By.cssSelector("#search"));
        search.click();

        search.sendKeys(item);
        search.sendKeys(Keys.ENTER);

  //      WebElement image = driver.findElement(By.tagName("//*[@id=\"homeIonContent\"]/div/div/div/div[1]/div[2]/div/div[1]/ion-item/div[1]/div[1]/img"));
        List<WebElement> images = driver.findElements(By.tagName("img"));
        System.out.println("Number of images: " + images.size());
 //       for(WebElement temp: images){
 //           System.out.println(temp);


/*        for(int i = 0; i <= images.size(); i++) {
            if (!(images.get(i).getAttribute("src").equals("")) && !(images.get(i).getAttribute("src")== null))  {
                System.out.println(images.get(i).getAttribute("src"));
            }
        }

*/
     //   WebElement image = driver.findElement(By.tagName("src"));

//        List links=driver.findElements(By.tagName("img"));
        // this will display list of all images exist on page
//        for(WebElement ele:links){
//            System.out.println(ele.getAttribute("src"));
     //   }
//        String picture = image.getAttribute("src");

//        String test = images.getAttribute("img");                            //problem here
//        System.out.println(test);

    }
/*        @Test
        public void testsikuli()    {

            System.setProperty("webdriver.chrome.driver","c://SeleniumDrivers//chromedriver.exe");
            WebDriver driver = new ChromeDriver();
            driver.navigate().to("http://www.google.com");

            //Create and initialize an instance of Screen object
            Screen screen = new Screen();

            screen.find()

            //Add image path
            Pattern image = new Pattern("C:\\temp\\searchButton.png");

            //Wait 10ms for image
            try {
                screen.wait(image, 10);
//Click on the image
                screen.click(image);
            }
            catch(Exception e){
                System.out.println("ERROR- problem with sikuli");
            }
        }
*/
}
//How to get the link copy
//<p class="wrap grid-product-name ng-binding" ng-class="product.on_sale ? 'grid-product-name-sale':''"> Coca-Cola </p>
//<img class="img-products-list" ng-src="https://shipt-staging.s3.amazonaws.com/images/products/thumb_397999-09173012.JPG" src="https://shipt-staging.s3.amazonaws.com/images/products/thumb_397999-09173012.JPG">
//<img class="img-products-list//" ng-src="https://shipt-staging.s3.amazonaws.com/images/products/thumb_397999-09173012.JPG" src="https://shipt-staging.s3.amazonaws.com/images/products/thumb_397999-09173012.JPG">
//<p class="wrap grid-product-name ng-binding grid-product-name-sale" ng-class="product.on_sale ? 'grid-product-name-sale':''"> Diet Coke Fridge Pack </p>