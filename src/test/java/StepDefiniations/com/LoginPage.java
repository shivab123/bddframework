package StepDefiniations.com;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
//import junit.framework.Assert;

public class LoginPage 
{
  
	WebDriver driver;
	@Given("User on Login Page.")
	public void user_on_login_page() 
	{
	   	 driver=new ChromeDriver();
	   	 driver.manage().window().maximize();
	   	 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(35));
	   	 driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	
	}
	@When("User Enter Valid User Name and Password.")
	public void user_enter_valid_user_name_and_password() {
		driver.findElement(By.name("username")).sendKeys("Admin");
		driver.findElement(By.name("password")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[text()=' Login ']")).click();
		
		
	   	}
	@Then("User On Home Page.")
	public void user_on_home_page() 
	{
	  String ActualTitle= driver.getTitle();
	  Assert.assertEquals(ActualTitle, "OrangeHRM");
	   
	}



}
