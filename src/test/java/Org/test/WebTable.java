package Org.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTable {
	
	public static void main(String args[]) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\S\\eclipse-workspace\\MarBatch\\src\\main\\resources\\chromedriver.exe");
	
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://demo.guru99.com/test/web-table-element.php");
		
		driver.manage().window().maximize();
		
		int rowSize = driver.findElements(By.xpath("//table[@class='dataTable']//tbody//tr")).size();
		
	     System.out.println("RowSize = "+ rowSize);
	     
	    int columnSize = driver.findElements(By.xpath("//table[@class='dataTable']//tbody//tr[1]//td")).size(); 
	    
	    System.out.println("ColumnSize = "+ columnSize);
	    
	    
	    for(int i = 1; i<= rowSize; i++){

	    	for(int j = 1; j<= columnSize; j++){
	    	WebElement element = driver.findElement(By.xpath("//table[@class='dataTable']//tbody//tr["+i+"]//td["+j+"]"));
	         //String text = element.getText();
	    	//System.out.println(text);
	    	
	    	if(i==3) {
	    			//System.out.println("Row Value: " + text);
	    		WebElement element1 = driver.findElement(By.xpath("//table[@class='dataTable']//tbody//tr["+i+"]//td["+(columnSize - 1)+"]"));
	    		String text = element1.getText();
	    		System.out.println("Last before value: " +text);
	    		break;
	    	}
				
			}
			
		}
		
	}

}

