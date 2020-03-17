package Com.iit.test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumValidation {
	@Test
	public void Validation() throws InterruptedException{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.yahoo.com/");
		
		driver.findElement(By.xpath("//input[@id='header-search-input']")).sendKeys("Selenium");
		WebDriverWait wait = new WebDriverWait(driver, 50);
		List <WebElement> list= wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//ul[@role='listbox']/li/span")));
		for(int i=0;i<list.size();i++)
		{
			String text = list.get(i).getText();
			System.out.println(text);
			Thread.sleep(2000);
			if(text.contains("selenium interview questions")){
				list.get(i).click();
				break;
			}
		}
		List<WebElement> hlink = driver.findElements(By.xpath("//div[@id=web]/ol/li"));
		for(int i=1;i<=6;i++)
		{
			System.out.println("****************validating links in the page ::::" + i +"*************************");
			for(int j=1;j<=hlink.size();j++)
			{
				System.out.println(hlink.get(j).getText().contains("selenium interview questions"));
						{
							if(!(hlink.get(j).getText().contains("selenium interview questions")))
							{
							
							System.out.println("The link text :::"+hlink.get(j).getText()+ "Result ::: ");
							
						    }
				         }
			}
			driver.findElement(By.linkText((i+1)+ "")).click();
			//waitFortitle("selenium iterview questions");
			hlink = driver.findElements(By.xpath("//div[@id=web]/ol/li"));
			}

	}}
