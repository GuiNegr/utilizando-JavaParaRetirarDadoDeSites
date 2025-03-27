package org.example.selenium;

import org.example.selenium.interfaces.SeleniumSelectorInterfaces;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.*;

public class SeleniumSelector  implements SeleniumSelectorInterfaces {

    public  String pegarInformacao(String linkText, String path){
        System.setProperty("webdriver.chrome.driver", "/home/guilherme/Downloads/chromedriver-linux64/chromedriver");
        ChromeOptions options = new ChromeOptions();
        WebDriver driver = new ChromeDriver(options);
        driver.get(path);
        WebElement link = driver.findElement(By.linkText(linkText));
        String pdfUrl = link.getAttribute("href");
        driver.quit();
        return pdfUrl;
    }
}
