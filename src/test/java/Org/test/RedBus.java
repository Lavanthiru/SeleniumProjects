package Org.test;

import java.io.IOException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class RedBus {

	public static void main(String[] args) throws InterruptedException, IOException {
		System.setProperty(
	            "webdriver.chrome.driver",
				"C:\\Users\\S\\eclipse-workspace\\Selenium\\src\\main\\resources\\chromedriver.exe");
	
		ChromeOptions p = new ChromeOptions();
		p.addArguments("--disable-notifications");
		
		WebDriver driver = new ChromeDriver(p);
		driver.get("https://www.redbus.in/");
		
		driver.manage().window().maximize();
		
		WebElement source = driver.findElement(By.id("src"));
		source.sendKeys("Chennai",Keys.ENTER);
		
		WebElement destination = driver.findElement(By.id("dest"));
		destination.sendKeys("Trichy",Keys.ENTER);
		
		driver.findElement(By.xpath("//button[@id='alertButton']")).click();
		
		WebElement date = driver.findElement(By.id("onward_cal"));
		date.sendKeys("28-04-2023");
		
	}
}
