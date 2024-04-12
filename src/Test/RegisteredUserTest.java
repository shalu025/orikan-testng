package Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class RegisteredUserTest {

	WebDriver driver;

	@BeforeClass
	public void setUp() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://orikan-ui-automation-test.azurewebsites.net/");
	}

	@Test(priority =1)
	public void registrationwithregisteredemail() {
		// Locate email, password, and confirm password fields
		driver.findElement(By.id("emailAddress")).sendKeys("adam@orikan.com");
		driver.findElement(By.id("password")).sendKeys("Test123");
		driver.findElement(By.id("confirmPassword")).sendKeys("Test123");

		// Click the button five times
		for (int i = 0; i < 5; i++) {
			driver.findElement(By.xpath("//button[@class='wizard-button primary' and text()='Next']")).click();
			
		}
		}
		
		@Test(priority =2)

		public void verifyNextButtononMultipleclick()

		{
			driver.findElement(By.id("emailAddress")).sendKeys("test@gmail.com");
			driver.findElement(By.id("password")).sendKeys("Test123");
			driver.findElement(By.id("confirmPassword")).sendKeys("Test123");
			for (int i = 0; i < 2; i++) {
				driver.findElement(By.xpath("//button[@class='wizard-button primary' and text()='Next']")).click();
			
		}
		}
}