package Com.test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DatePicker_2 {

	public static void main(String[] args) throws InterruptedException {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DATE, 15);

		SimpleDateFormat format = new SimpleDateFormat("MMMM yyyy,dd");
		String dateToStr = format.format(calendar.getTime());
		
		String month = dateToStr.split(",")[0];
		String day = dateToStr.split(",")[1];
		
		System.out.println("#### Month Year: " + month + "####");
		System.out.println("#### Date: " + day + "####");
		
		//int current_date = Calendar.DATE;

		System.setProperty("webdriver.chrome.driver", "C:/Users/Pankaj/Desktop/assignments/chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("http://96.84.175.78/MMP-Release2-Integrated-Build.6.8.000/portal/sheduleappointments.php");
		Thread.sleep(2000);
		// driver.findElement(By.xpath("//input[@name='submit']")).click();;
		driver.findElement(By.xpath("//span[contains(text(),'Schedule Appointment')]")).click();
		driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div[2]/div/div/div[3]/a/input")).click();
		driver.findElement(By.xpath("//h4[text() = 'Dr.Beth']/ancestor::ul/following-sibling::button")).click();
		driver.switchTo().frame(0);
		driver.findElement(By.id("datepicker")).click();
		while (true) {
			String MonthAndYear = driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/div/div")).getText();
			if (MonthAndYear.equals(month)) {
				break;
			} else {
				driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();
			}
		}

		Thread.sleep(2000);
		List<WebElement> allDates = driver.findElements(By.xpath("//tr//td//a[1]"));
		for (WebElement ele : allDates) {
			String date = ele.getText();
			if (date.equals(day)) {
				ele.click();
				break;
			}
		}
		Thread.sleep(2000);
		String newDate = driver.findElement(By.xpath("//*[@id='datepicker']")).getText();
		Thread.sleep(2000);
		
	}
}
