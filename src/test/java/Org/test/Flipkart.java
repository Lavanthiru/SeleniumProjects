package Org.test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver.WindowType;


public class Flipkart	 {

	private static CharSequence KeystoSend;

	public static void main(String[] args) throws InterruptedException, IOException {
		System.setProperty(
	            "webdriver.chrome.driver",
				"C:\\Users\\S\\eclipse-workspace\\Selenium\\src\\main\\resources\\chromedriver.exe");
	
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.flipkart.com/");
		
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//button[text()='✕']")).click();
	
		driver.findElement(By.name("q")).sendKeys("Redmi Mobiles",Keys.ENTER);
		Thread.sleep(3000);
		
		List<WebElement>mobilename = driver.findElements(By.xpath("//div[@class='_4rR01T']"));
		File F = new File("C:\\Users\\S\\eclipse-workspace\\MarBatch\\src\\test\\java\\Org\\test\\F.xlsx");
		Workbook w = new XSSFWorkbook();
		Sheet s = w.createSheet("FlipKart");
		for (int i = 0; i < mobilename.size(); i++) {
			WebElement header = mobilename.get(i);
			String names = header.getText();
			System.out.println(names);
			Row r = s.createRow(i);
			Cell c = r.createCell(0);
			c.setCellValue(names);
			
			List<WebElement>mobileprices = driver.findElements(By.xpath("//div[@class='_30jeq3 _1_WHN1']"));
			for (int j = i; j==i; j++) {
			WebElement headers = mobileprices.get(i);
			String price = headers.getText();
		   Cell c1 = r.createCell(1);
		   c1.setCellValue(price);	
			System.out.println(price); 
			
			Map<String, String> values = new HashMap<String, String>();
			values.put(names, price);
			Set<Entry<String, String>> entry = values.entrySet();
			for(Entry<String, String> S : entry){
				System.out.println(S);
			}
			
		}
			
		 }
			
		FileOutputStream f2 = new FileOutputStream(F);
		w.write(f2);
		f2.close();		
	}
			 }
	
	
	
	

