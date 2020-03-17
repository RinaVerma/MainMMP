package Com.iit.test;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class US_004_ScheduleAppointment {

	public static void main(String[] args) throws InterruptedException {
		HashMap<String, String> hmap = new HashMap();
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("http://96.84.175.78/MMP-Release2-Integrated-Build.6.8.000/portal/sheduleappointments.php");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		driver.findElement(By.xpath("//h4[text() = 'Dr.Beth']/ancestor::ul/following-sibling::button")).click();
		hmap.put("Doctor", "Dr.Beth");
		driver.switchTo().frame(0);
		driver.findElement(By.id("datepicker")).sendKeys("02/27/2020");
		hmap.put("Date", "02/27/2020");
		Select timee = new Select( driver.findElement(By.id("time")));
		timee.selectByValue("11Am");
		hmap.put("Time", "11Am");
		driver.findElement(By.xpath("//button[@id='ChangeHeatName']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//textarea[@id='sym']")).sendKeys("fever");
		hmap.put("Symptoms", "fever");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		String tableRowData = driver.findElement(By.xpath("//table[@class='table']/tbody/tr[1]")).getText();
		System.out.println(tableRowData);
		String tr[] = tableRowData.split(" ");
		System.out.println(tr[0]+"==="+tr[1]+"==="+tr[2]+"==="+tr[3]);
		if(hmap.get("Date").equals(tr[0])){
			System.out.println("Date matching from home page");
		}else{
			System.out.println("Date is not matching from home page");
		}
		driver.findElement(By.xpath("//li[4]/a/span")).click();
		Thread.sleep(2000);
		String date = driver.findElement(By.xpath("(//h3[@class='panel-title'])[2]")).getText();
		String time = driver.findElement(By.xpath("(//a[@class='list-group-item'])[1]")).getText();
		String time1[] = time.split("//:");
		String sym = driver.findElement(By.xpath("(//a[@class='list-group-item'])[3]")).getText();
		String Dr = driver.findElement(By.xpath("(//a[@class='list-group-item'])[2]")).getText();
		/*System.out.println(date);
		System.out.println(time1[0]);
		System.out.println(Dr);
		System.out.println(sym);*/
		if(hmap.get("Date").equals(date)){
			System.out.println("Date matching is from Schdule appointment page");
		}else{
			System.out.println("Date matching not is from Schdule appointment page");
		}
	}

}
