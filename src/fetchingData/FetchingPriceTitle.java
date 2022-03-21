package fetchingData;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FetchingPriceTitle {
	
	
	@Test
	public void appleSearch() {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://www.flipkart.com/");
		
		if(driver.findElement(By.cssSelector("button[class='_2KpZ6l _2doB4z']")).isDisplayed()) {
			
			driver.findElement(By.cssSelector("button[class='_2KpZ6l _2doB4z']")).click();
			
		}
		
		driver.findElement(By.cssSelector("input[type='text']")).sendKeys("apple");
		driver.findElement(By.cssSelector("button[type='submit']")).click();
		
		List<WebElement> products =driver.findElements(By.cssSelector("div[class*='_1YokD2'] div[class*='_1AtVbE'] div[class*='_13oc-S']"));
		
		for(WebElement product: products) {
			
			System.out.println(product.findElement(By.cssSelector("div[class='_4rR01T']")).getText());
			System.out.println(product.findElement(By.cssSelector("div[class='_30jeq3 _1_WHN1']")).getText());
			
		}
		driver.close();
	}

}
