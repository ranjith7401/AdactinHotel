package org.tcs;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Sample {
	
	public static void main(String[] args) throws AWTException, InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://adactinhotelapp.com/");
		driver.findElement(By.id("username")).sendKeys("ranjith1095");
		driver.findElement(By.id("password")).sendKeys("B3NWVR");
		driver.findElement(By.id("login")).click();
		driver.findElement(By.xpath("(//td)//child::select[@id='location']")).click();
		Robot r = new Robot();
		for (int i = 0; i < 5; i++) {
			
			r.keyPress(KeyEvent.VK_DOWN);
			r.keyRelease(KeyEvent.VK_DOWN);
			
		}
		
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		
		WebElement hotel = driver.findElement(By.xpath("(//td)//child::select[@id='hotels']"));
		Select s = new Select(hotel);
		s.selectByValue("Hotel Creek");
		WebElement room = driver.findElement(By.xpath("(//td)//child::select[@id='room_type']"));
		Select s1 = new Select(room);
		s1.selectByIndex(2);
		WebElement submit = driver.findElement(By.xpath("(//td)//child::input[@id='Submit']"));
		Actions a = new Actions(driver);
		a.doubleClick(submit).perform();
		driver.findElement(By.id("radiobutton_0")).click();
		driver.findElement(By.id("continue")).click();
		WebElement firstName = driver.findElement(By.name("first_name"));
		WebElement lastName = driver.findElement(By.name("last_name"));
		JavascriptExecutor j = (JavascriptExecutor)driver;
		j.executeScript("arguments[0].setAttribute('value','Ranjith')", firstName);
		j.executeScript("arguments[0].setAttribute('value','Thiyagarajan')", lastName);
		driver.findElement(By.name("address")).sendKeys("Chennai");
		driver.findElement(By.name("cc_num")).sendKeys("1234567897569842");
		WebElement creditType = driver.findElement(By.name("cc_type"));
		Select s3 = new Select(creditType);
		s3.selectByIndex(2);
		WebElement expMonth = driver.findElement(By.name("cc_exp_month"));
		Select s4 = new Select(expMonth);
		s4.selectByIndex(4);
		WebElement expYear = driver.findElement(By.name("cc_exp_year"));
		Select s5 = new Select(expYear);
		s5.selectByValue("2020");
		driver.findElement(By.name("cc_cvv")).sendKeys("321");
		driver.findElement(By.name("book_now")).click();
		Thread.sleep(6000);
		WebElement order = driver.findElement(By.name("order_no"));
		String orderNumber = order.getAttribute("value");
		System.out.println("Hotel Booking is Confirmed and The orderID is "+orderNumber);
		
		
		
		
		
		
		
		
		
		
		
	}

}
