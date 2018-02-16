package com.shipt.stuff;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import static java.lang.Thread.sleep;
import static org.hamcrest.core.Is.is;

public class ShiptCodingTest {

    @Test
    public void shiptCodingTest() throws IOException, Exception {

        String url = "http://www.shipt.com";
        String email = "qatest@shipt.com";
        String passwd = "Sh1pt123!";
        String item = "milk";
        String productName1;
//        String productName2

 //       int count = 0;
//       while (count <= 20) {
//            System.out.println(count);
            System.setProperty("webdriver.chrome.driver", "c://SeleniumDrivers//chromedriver.exe");
            WebDriver driver = new ChromeDriver();
//            driver.manage().window().maximize();
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
            WebElement page = driver.findElement(By.xpath("//*[@id=\"homeIonContent\"]/div/div/div/div[1]/div[2]"));

            sleep(3000);
            page.click();

            WebElement coke = driver.findElement(By.xpath("//*[@id=\"homeIonContent\"]/div/div/div/div[1]/div[2]/div/div[1]/ion-item/div[1]/div[2]/button[2]"));
            String dietCoke = coke.getText();  //it's failing here!!!!!!!!!!!!!!
            System.out.println("This is the end " + dietCoke);

            WebElement name = driver.findElement(By.xpath("//*[@id=\"homeIonContent\"]/div/div/div/div[1]/div[2]/div/div[1]/ion-item/div[1]/p"));
            productName1 = name.getText();
            System.out.println(productName1);
            coke.click();
            sleep(5000);

            WebElement cart = driver.findElement(By.xpath("//*[@id=\"homeIonContent\"]/div/div/shipt-web-header/div/div/web-cart-button/button"));
            System.out.println(cart.getText());
            cart.click();
            sleep(5000);

            WebElement name2 = driver.findElement(By.cssSelector("body > ion-nav-view > ion-side-menus > ion-side-menu-content > ion-nav-view > ion-view.web-shopping-cart.pane > ion-content > div > div > div.col.col-67 > div.cart-items-area > div > div.item.item-thumbnail-left.item-button-right.cart-list-item > div.row > div > p"));
            String productName2 = name2.getText();
            System.out.println(productName2);

            Assert.assertThat("confirm names are same in inventory and checkout", productName1, is(productName2));
            sleep(5000);
//            driver.quit();
 //           count++;

        //**************************************************************************************************
            WebElement home = driver.findElement(By.className("button.button-icon.icon.shipt-logo-button"));
            home.click();
        }
}
