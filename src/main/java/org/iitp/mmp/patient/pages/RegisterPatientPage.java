package org.iitp.mmp.patient.pages;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
//import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;



public class RegisterPatientPage {
	
	private final WebDriver driver;
	Random rnd = new Random();
	HashMap <String, String> hmap = new HashMap<String, String>(); 
	
	public RegisterPatientPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public  HashMap<String,String> register(String username, String password) throws InterruptedException{
		////////////////////////////
		WebElement licenseTxtField =  driver.findElement(By.id("license"));
		long licenseValue = rnd.nextInt(99999999);
		licenseTxtField.sendKeys(""+licenseValue);
		hmap.put("license", licenseTxtField.getAttribute("value"));
		//----------------------------------
		WebElement ssnTxtField =  driver.findElement(By.id("ssn"));
		long ssnValue = rnd.nextInt(999999999);
		ssnTxtField.sendKeys(""+ssnValue);
		hmap.put("ssn", ssnTxtField.getAttribute("value"));
		//----------------------------------------
		WebElement stateTxtField =  driver.findElement(By.id("state"));
		stateTxtField.sendKeys("Gorgia");
		hmap.put("state", stateTxtField.getAttribute("value"));
		//----------------------------------------------
		WebElement cityTxtField =  driver.findElement(By.id("city"));
		cityTxtField.sendKeys("Atlanta");
		hmap.put("city", cityTxtField.getAttribute("value"));
		//-------------------------------------------------------
		WebElement addressTxtField =  driver.findElement(By.id("address"));
		addressTxtField.sendKeys("10 Street");
		hmap.put("address", addressTxtField.getAttribute("value"));
		//---------------------------------------------------------------
		WebElement zipcodeTxtField =  driver.findElement(By.id("zipcode"));
		int zipcodeValue = rnd.nextInt(99999);
		zipcodeTxtField.sendKeys(""+zipcodeValue);
		hmap.put("city", zipcodeTxtField.getAttribute("value"));
		//----------------------------------------------------------------------
		WebElement ageTxtField =  driver.findElement(By.id("age"));
		long ageValue = rnd.nextInt(99);
		ageTxtField.sendKeys(""+ageValue);
		hmap.put("age", ageTxtField.getAttribute("value"));
		//---------------------------------------------------------------
		WebElement heightTxtField = driver.findElement(By.id("height"));
        long heightValue = rnd.nextInt(90);
        heightTxtField.sendKeys(""+heightValue);
        hmap.put("height", heightTxtField.getAttribute(("value")));
         //------------------------------------------------------
        WebElement weightTxtField = driver.findElement(By.id("weight"));
        long weightValue = rnd.nextInt(99);
        weightTxtField.sendKeys(""+weightValue);
        hmap.put("weight", weightTxtField.getAttribute(("value")));
		//--------------------------------------------------------------
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/YYYY");
        WebElement datePickerTxtField = driver.findElement(By.id("datepicker"));
        datePickerTxtField.sendKeys(sdf.format(new Date()));
        hmap.put("datePicker", datePickerTxtField.getAttribute(("value")));
        //-----------------------------------------------------------------------
        Thread.sleep(2000);
        WebElement firstNameTxtField = driver.findElement(By.id("firstname"));
        firstNameTxtField.sendKeys("testFN"+(char)(65+rnd.nextInt(26))+(char)(65+rnd.nextInt(26)));
        hmap.put("firstname", firstNameTxtField.getAttribute(("value")));
        //----------------------------------------------------------------------------
        WebElement lastNameTxtField = driver.findElement(By.id("lastname"));
        lastNameTxtField.sendKeys("testLN"+(char)(65+rnd.nextInt(26))+(char)(65+rnd.nextInt(26)));
        hmap.put("lastname", lastNameTxtField.getAttribute(("value")));
        //--------------------------------------------------------------------------
        WebElement emailTxtField = driver.findElement(By.id("email"));
        emailTxtField.sendKeys("testemail"+(char)(65+rnd.nextInt(26))+(char)(65+rnd.nextInt(26))+"@gmail.com");
        hmap.put("email", emailTxtField.getAttribute(("value")));
        //-------------------------------------------------------------------------------
        WebElement usernameTxtField = driver.findElement(By.id("username"));
        usernameTxtField.sendKeys(username);
        hmap.put("username", usernameTxtField.getAttribute(("value")));
        //---------------------------------------------------------------------
        WebElement passwordTxtField = driver.findElement(By.id("password"));
        passwordTxtField.sendKeys(password);
        hmap.put("password", passwordTxtField.getAttribute(("value")));
        //------------------------------------------------------------------------
        WebElement confirmpasswordTxtField = driver.findElement(By.id("confirmpassword"));
        confirmpasswordTxtField.sendKeys(password);
        hmap.put("confirmpassword", confirmpasswordTxtField.getAttribute(("value")));
        //--------------------------------------------------------------------------------
        new Select((WebElement) driver.findElement(By.id("security"))).selectByVisibleText("what is your best friend name");
        WebElement answerTxtField = driver.findElement(By.id("answer"));
        answerTxtField.sendKeys(username);
        hmap.put("answer", answerTxtField.getAttribute(("value")));
        driver.findElement(By.xpath("//*[@id='container_body']/p/input")).click();
        //Return HashMap;
		return hmap;
	}
    //------------------------------------------------------------------------------
   
}
	

