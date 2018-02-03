package com.shipt.stuff;

import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import java.io.IOException;
import java.util.List;
import static java.awt.SystemColor.info;
import static java.lang.Thread.sleep;
import static javax.swing.text.html.CSS.getAttribute;

public class ShiptCodingTest {

    @Test
    public void shiptCodingTest() throws IOException, Exception {

        String url = "http://www.shipt.com";
        String email = "qatest@shipt.com";
        String passwd = "Sh1pt123!";
        String item = "coke zero";
        String productName1;

        System.setProperty("webdriver.chrome.driver", "c://SeleniumDrivers//chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.navigate().to(url);

//        driver.manage().window().maximize();
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
        String dietCoke = coke.getText();
        System.out.println(dietCoke);

        WebElement name = driver.findElement(By.xpath("//*[@id=\"homeIonContent\"]/div/div/div/div[1]/div[2]/div/div[1]/ion-item/div[1]/p"));
        productName1 = name.getText();
        System.out.println(productName1);
        coke.click();
        sleep(5000);

       WebElement cart = driver.findElement(By.xpath("//*[@id=\"homeIonContent\"]/div/div/shipt-web-header/div/div/web-cart-button/button"));
       cart.click();

       sleep(5000);

//        WebElement cartName = driver.findElement(By.xpath("/html/body/ion-nav-view/ion-side-menus/ion-side-menu-content/ion-nav-view/ion-view[2]/ion-content/div/div/div[1]/div[1]/div/div[2]/div[3]/div/p"));
//        System.out.println(cartName.getText());

    }
}
