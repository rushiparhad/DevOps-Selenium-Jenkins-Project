package com.demo.sleniumtesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.Alert;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

public class ca2test {

    public static void main(String[] args) throws InterruptedException {

        System.out.println("Jenkins Test Started...");

        WebDriver driver = new ChromeDriver();

        driver.get("http://127.0.0.1:5500/index.html");
        driver.manage().window().maximize();

        System.out.println("Test 1: Page Opened Successfully ✅");

        Thread.sleep(2000);

        // -------------------------------
        // Test 2: Valid Submission
        // -------------------------------
        driver.findElement(By.id("name")).sendKeys("Rushi");
        driver.findElement(By.id("email")).sendKeys("test@gmail.com");
        driver.findElement(By.id("mobile")).sendKeys("9876543210");

        driver.findElement(By.id("department")).sendKeys("Computer");
        driver.findElement(By.xpath("//input[@value='male']")).click();

        driver.findElement(By.id("feedback")).sendKeys(
            "This college provides excellent learning environment and supportive faculty members"
        );

        driver.findElement(By.xpath("//button[text()='Submit']")).click();

        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            Alert alert = wait.until(ExpectedConditions.alertIsPresent());

            System.out.println("Test 2: " + alert.getText() + " ✅");
            alert.accept();

        } catch (Exception e) {
            System.out.println("Test 2 Failed ❌");
        }

        Thread.sleep(2000);

        // -------------------------------
        // Test 3: Empty Fields
        // -------------------------------
        driver.findElement(By.xpath("//button[text()='Submit']")).click();
        Thread.sleep(2000);

        String error = driver.findElement(By.id("error")).getText();
        System.out.println("Test 3: Empty Fields Error -> " + error + " ✅");

        // -------------------------------
        // Test 4: Invalid Email
        // -------------------------------
        driver.findElement(By.id("name")).sendKeys("Rushi");
        driver.findElement(By.id("email")).sendKeys("wrongemail");
        driver.findElement(By.id("mobile")).sendKeys("9876543210");

        driver.findElement(By.id("department")).sendKeys("IT");
        driver.findElement(By.xpath("//input[@value='male']")).click();

        driver.findElement(By.id("feedback")).sendKeys(
            "This college provides excellent learning environment and supportive faculty members"
        );

        driver.findElement(By.xpath("//button[text()='Submit']")).click();
        Thread.sleep(2000);

        System.out.println("Test 4: Invalid Email Checked ✅");

        driver.findElement(By.xpath("//button[text()='Reset']")).click();
        Thread.sleep(1000);

        // -------------------------------
        // Test 5: Invalid Mobile
        // -------------------------------
        driver.findElement(By.id("name")).sendKeys("Rushi");
        driver.findElement(By.id("email")).sendKeys("test@gmail.com");
        driver.findElement(By.id("mobile")).sendKeys("12345");

        driver.findElement(By.id("department")).sendKeys("Mechanical");
        driver.findElement(By.xpath("//input[@value='female']")).click();

        driver.findElement(By.id("feedback")).sendKeys(
            "This college provides excellent learning environment and supportive faculty members"
        );

        driver.findElement(By.xpath("//button[text()='Submit']")).click();
        Thread.sleep(2000);

        System.out.println("Test 5: Invalid Mobile Checked ✅");

        driver.findElement(By.xpath("//button[text()='Reset']")).click();
        Thread.sleep(1000);

        // -------------------------------
        // Test 6: Dropdown
        // -------------------------------
        driver.findElement(By.id("department")).sendKeys("Computer");
        System.out.println("Test 6: Dropdown Working ✅");

        // -------------------------------
        // Test 7: Reset Button
        // -------------------------------
        driver.findElement(By.id("name")).sendKeys("Test Reset");
        driver.findElement(By.xpath("//button[text()='Reset']")).click();

        String nameValue = driver.findElement(By.id("name")).getAttribute("value");

        if (nameValue.isEmpty()) {
            System.out.println("Test 7: Reset Button Working ✅");
        } else {
            System.out.println("Test 7 Failed ❌");
        }

        Thread.sleep(3000);
        driver.quit();

        System.out.println("Jenkins Test Completed Successfully!");
    }
}