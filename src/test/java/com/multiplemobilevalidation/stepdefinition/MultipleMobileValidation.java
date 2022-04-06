package com.multiplemobilevalidation.stepdefinition;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class MultipleMobileValidation {
	
 static WebDriver driver;
 static String galaxy;
 static String mobile;
@Given("user launch browser with flipkart")
public void user_launch_browser_with_flipkart() {
	WebDriverManager.chromedriver().setup();
    driver = new ChromeDriver();
	driver.get("https://www.flipkart.com/");
	driver.manage().window().maximize();
}

@Given("enter the valid data credentials")
public void enter_the_valid_data_credentials() {
	try {
		driver.findElement(By.xpath("//button[text()='✕']")).click();
	}catch(Exception e){
		System.out.println(e);
	}
}

@When("serach multiple mobile")
public void serach_multiple_mobile() {
	mobile = "iPhone";
	WebElement search = driver.findElement(By.xpath("//input[@name='q']"));
	search.sendKeys(mobile);
	driver.findElement(By.xpath("//button[@type='submit']")).click();
	
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
}

@When("click the mobile")
public void click_the_mobile() {
	WebElement f23 =driver.findElement(By.xpath("(//div[contains(text(),'"+mobile+"')])[2]"));
	f23.click();
   galaxy =  f23.getText();
	System.out.println(galaxy);
	
}

@When("validate the mobile details")
public void validate_the_mobile_details() {
	String window = driver.getWindowHandle();
	Set<String> windows = driver.getWindowHandles();
	for( String x : windows) {
		if(!window.equals(x)) {
			driver.switchTo().window(x);
		}
	}
}

@Then("cheack mobile")
public void cheack_mobile() {
	 WebElement ch = driver.findElement(By.xpath("(//span[contains(text(),'"+mobile+"')])[1]"));
	 String cm = ch.getText();
	 System.out.println(cm);
	 boolean resultcheack = cm.equals(galaxy);
	 System.out.println(resultcheack);
}

@Then("result")
public void result() throws Exception {
	TakesScreenshot ss = (TakesScreenshot)driver;
	File ssf = ss.getScreenshotAs(OutputType.FILE);
	File fssf = new File("C:\\Users\\NK\\eclipse-workspace\\MultipleMobileValitaion\\result ss\\flipsam.png");
	FileUtils.copyFile(ssf, fssf);
	driver.quit();
}

@When("serach multiple mobile one diamontinal list")
public void serach_multiple_mobile_one_diamontinal_list(DataTable multiple) {

   List<String> iphone = multiple.asList();
   WebElement search = driver.findElement(By.xpath("//input[@name='q']"));
   mobile = iphone.get(2);
	search.sendKeys(mobile);
	driver.findElement(By.xpath("//button[@type='submit']")).click();
	
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
}
@When("serach multiple mobiles {string}")
public void serach_multiple_mobiles(String Mobiles) {
	mobile = Mobiles;
	WebElement ml = driver.findElement(By.xpath("//input[@name='q']"));
	ml.sendKeys(mobile);
driver.findElement(By.xpath("//button[@type='submit']")).click();
	
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
   }


}
