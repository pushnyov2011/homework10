package ru.andersenlab.lesson;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {/*
        //  System.out.println( "Hello World!" );
       System.setProperty("webdriver.chrome.driver", "/chromdriver/chromedriver.exe");
       // System.setProperty("webdriver.chrome.driver", "C:\\chromdriver\\chromedriver.exe"); //C:\chromdriver
        WebDriver driver = new ChromeDriver();
        //driver.manage().window().maximize(); // отоборажаение на весь экран
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://yandex.ru");
        */
        System.setProperty("webdriver.chrome.driver", "/chromdriver/chromedriver.exe");
        //System.setProperty("webdriver.chrome.driver", "C:\\chromdriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize(); // отоборажаение на весь экран
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://diary.ru/user/registration");
        System.out.println( driver.getCurrentUrl());
    }
}
