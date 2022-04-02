package ru.andersenlab.lesson;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;

import java.sql.Time;
import java.util.concurrent.TimeUnit;

public class FirstTest {
    /*
    @FindBy(xpath = "//*[contains(@id, 'signupform-email')]")
    private static WebElement email_filed;

     */
  private static WebDriver driver;
   private static WebElement email_filed;
   private static  WebElement btn_restration;
   private static WebElement login_fild;
   private  static WebElement pass_field;
    @BeforeClass
    public static void setup()
    {
        System.setProperty("webdriver.chrome.driver", "/chromdriver/chromedriver.exe");
        //System.setProperty("webdriver.chrome.driver", "C:\\chromdriver\\chromedriver.exe");
        driver = new ChromeDriver();
        //driver.manage().window().maximize(); // отоборажаение на весь экран
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://diary.ru/user/registration");
        pass_field = driver.findElement(By.xpath("//*[contains(@id, 'signupform-password')]")); // pass
        login_fild = driver.findElement(By.xpath("//*[contains(@id, 'signupform-username')]")); // login
        email_filed = driver.findElement(By.xpath("//*[contains(@id, 'signupform-email')]")); // находим поле почты
        btn_restration = driver.findElement(By.xpath("//*[contains(@id, 'signup_btn')]")); // находим кнопку регистрации по id
    }
@Test
public void check_field() // при открытие страницы текст-боксы должны быть пустые
{
    Assert.assertEquals( "", email_filed.getAttribute("value"));
    Assert.assertEquals( "", login_fild.getAttribute("value"));
    Assert.assertEquals( "", pass_field.getAttribute("value"));

}

    @Test
    public void enter_email ()
    {
       //email_filed = driver.findElement(By.xpath("//*[contains(@id, 'signupform-email')]"));
        String email = "Test@ya.ru";
       email_filed.sendKeys(email);
              Assert.assertEquals( email, email_filed.getAttribute("value"));

    }

    @Test
    public void try_regisrtration_whith_out_login()
    {
        String web_before = driver.getCurrentUrl().toString();
     btn_restration.click();
     String web_after = driver.getCurrentUrl().toString();

    Assert.assertEquals(  web_before, web_after); // проверяю , что мы остались на этой странице . если остались прошли
    }
    @Test
    public void enter_login ()
    {
        String login = "test523";
        login_fild.sendKeys("");
        Assert.assertEquals( login,  login_fild.getAttribute("value"));

    }



    @AfterClass
    public static void finsh_test()
    {
        driver.quit();
    }






}
