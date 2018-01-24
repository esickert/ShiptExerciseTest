package com.shipt.stuff;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static java.lang.Thread.sleep;

public class ShiptCodingTest {

    @Test
    public void shiptCodingTest() throws Exception {

        String url = "http://www.shipt.com ";
        String email = "qatest@shipt.com";
        String passwd= "Sh1pt123!";
        String item = "coke";

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

        WebElement name = driver.findElement(By.className("wrap grid-product-name ng-binding grid-product-name-sale"));
        name.getAttribute("title");

        System.out.println(name);

    }


}
//How to get the link copy
//<p class="wrap grid-product-name ng-binding" ng-class="product.on_sale ? 'grid-product-name-sale':''"> Coca-Cola </p>
//<img class="img-products-list" ng-src="https://shipt-staging.s3.amazonaws.com/images/products/thumb_397999-09173012.JPG" src="https://shipt-staging.s3.amazonaws.com/images/products/thumb_397999-09173012.JPG">
//<img class="img-products-list//" ng-src="https://shipt-staging.s3.amazonaws.com/images/products/thumb_397999-09173012.JPG" src="https://shipt-staging.s3.amazonaws.com/images/products/thumb_397999-09173012.JPG">
//<p class="wrap grid-product-name ng-binding grid-product-name-sale" ng-class="product.on_sale ? 'grid-product-name-sale':''"> Diet Coke Fridge Pack </p>