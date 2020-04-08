package Com.iit.test;

import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ScheduleAppointment_DatePicker {
	WebDriver driver;
	@Test
	public void validation() throws InterruptedException
	{
		launchbrowser();
		SoftAssert sa = new SoftAssert();
		HashMap<String, String> hmap = bookanAppointment("Beth","07/25/2020","11Am","Fever");
		sa.assertTrue(validateApptDetailsinHomePage(hmap));
		sa.assertTrue(validateApptDetailsinScheduleApptPage(hmap));
		sa.assertAll();
	}
	public void launchbrowser()
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://96.84.175.78/MMP-Release2-Integrated-Build.6.8.000/portal/sheduleappointments.php");
	}
	public HashMap<String, String> bookanAppointment(String doctor,String date,String time,String sym) throws InterruptedException
	{
		HashMap<String, String> hmap = new HashMap();
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		driver.findElement(By.xpath("//h4[text() = 'Dr."+doctor+"']/ancestor::ul/following-sibling::button")).click();
		hmap.put("Doctor", doctor);
		driver.switchTo().frame(0);
		DatePicker("July 2020","25");
		hmap.put("Date",date);
		Select timee = new Select( driver.findElement(By.id("time")));
		timee.selectByValue(time);
		hmap.put("Time", time);
		driver.findElement(By.xpath("//button[@id='ChangeHeatName']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//textarea[@id='sym']")).sendKeys(sym);
		hmap.put("Symptoms", sym);
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		return hmap;
	}
	public String DatePicker(String month, String day) throws InterruptedException{
		driver.findElement(By.id("datepicker")).click();
		while(true)
		{
			String MonthAndYear = driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/div/div")).getText();
			if(MonthAndYear.equals(month))
			{
				break;
			}
			else
			{
				driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();
			}
		}
	   				
		List <WebElement> allDates = driver.findElements(By.xpath("//tr//td//a[1]"));
   		for(WebElement ele: allDates)
   		{
   			String date=ele.getText();
   			if (date.equals(day))
   			{
   				ele.click();
   				break;
   			}
   		}
   		Thread.sleep(2000);
   		String date = driver.findElement(By.id("datepicker")).getText();
   	   		return date;
	}
	public boolean validateApptDetailsinHomePage(HashMap hmap){
		boolean result = false;
		String tableRowData = driver.findElement(By.xpath("//table[@class='table']/tbody/tr[1]")).getText();
		System.out.println(tableRowData);
		String tr[] = tableRowData.split(" ");
		System.out.println(tr[0]+"==="+tr[1]+"==="+tr[2]+"==="+tr[3]);
		if(hmap.get("Date").equals(tr[0])&&
				hmap.get("Time").equals(tr[1])&&
				hmap.get("Symptoms").equals(tr[2])&&
				hmap.get("Doctor").equals(tr[3]))
		{
			System.out.println("Date matching from home page");
			result= true;
		}else{
			System.out.println("Date is not matching from home page");
			result= false;
		}
		return result;
	}
	public boolean validateApptDetailsinScheduleApptPage(HashMap hmap) throws InterruptedException{
		boolean result = false;
		//Click on Schedule Appointment tab
		driver.findElement(By.xpath("//li[4]/a/span")).click();
		Thread.sleep(2000);
		String date = driver.findElement(By.xpath("(//h3[@class='panel-title'])[2]")).getText();
		String time = driver.findElement(By.xpath("//a[contains(text(),'Time : 11Am')]")).getText().split("\\:")[1].trim();
		String doctor = driver.findElement(By.xpath("//a[contains(text(),'Provider:Beth')]")).getText().split("\\:")[1].trim();
		String sym = driver.findElement(By.xpath("//a[contains(text(),'Symptoms:Fever')]")).getText().split("\\:")[1].trim();
		if(hmap.get("Date").equals(date)&&
				hmap.get("Time").equals(time)&&
				hmap.get("Symptoms").equals(sym)&&
				hmap.get("Doctor").equals(doctor)){
			System.out.println("Date matching is from Schdule appointment page");
			result = true;
		}else{
			System.out.println("Date is not matching from Schdule appointment page");
			result= false;
		}
		return result;
	}
}




