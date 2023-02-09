package com.gestao.testscript;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class CreatePromote {
	static {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
	}
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.get("http://192.168.204.128:8080/crm/HomePage.do");
		driver.manage().window().maximize();

		driver.findElement(By.id("userName")).sendKeys("rashmi@dell.com");
		driver.findElement(By.id("passWord")).sendKeys("123456");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@alt='Sign In']")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.findElement(By.xpath("//a[text()='Campaigns']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@value='New Campaign']")).click();
		Thread.sleep(2000);
		driver.findElement(By.name("property(Campaign Name)")).sendKeys("HPlaptops");
		Thread.sleep(2000);

		driver.findElement(By.name("property(Expected Revenue)")).sendKeys("500000");
		Thread.sleep(2000);
		driver.findElement(By.name("property(Actual Cost)")).sendKeys("250000");
		Thread.sleep(2000);

		WebElement type = driver.findElement(By.name("property(Type)"));
		Select s =new Select(type);
		s.selectByValue("Advertisement");
		Thread.sleep(2000);

		WebElement status= driver.findElement(By.name("property(Status)"));
		Select ss=new Select(status);
		ss.selectByValue("Planning");

		driver.findElement(By.name("property(Budgeted Cost)")).sendKeys("300000");
		Thread.sleep(2000);
		driver.findElement(By.name("property(Expected Response)")).sendKeys("2000");
		Thread.sleep(2000);
		driver.findElement(By.name("property(Description)")).sendKeys("Give terms and conditions");
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//input[@value='Save'])[1]")).click();
		driver.close();
	}
}
