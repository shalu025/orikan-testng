package Test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class UserRegistrationTest {

	WebDriver driver;

	@BeforeTest
	public void setUp() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://orikan-ui-automation-test.azurewebsites.net/");

	}

	@DataProvider(name = "emailaddresses")
	public Object[][] getEmailAddresses() {
		return new Object[][] { { "test@gmail.com." }, { "test@.com" }, { "test@gmailcom." }, { "user@example" },
				{ "test123@Example.com" }, { "user@ex@mple.com" }, { "  test@gmail.com  " } };
	}

	// Print the email address
	@Test(dataProvider = "emailaddresses", priority = 1)
	public void testEmailAddressFields(String emailAddress) {
		driver.findElement(By.id("emailAddress")).clear();
		driver.findElement(By.id("emailAddress")).sendKeys(emailAddress);
		System.out.println("Email address entered: " + emailAddress);

	}

	@DataProvider(name = "passwords")
	public Object[][] getPasswords() {
		return new Object[][] { { "ab" }, { "a" }, { "@$" }, { "&a" }, { " 123 " }, { "  123 " }, { "123  " }, { "   " }

		};
	}

	@Test(dataProvider = "passwords", priority = 2)
	public void testPasswordFields(String password) {
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys(password);

		// Print the password
		System.out.println("Password entered: " + password);

	}

	@DataProvider(name = "Confirmpasswords")
	public Object[][] getConfirmpasswords() {
		return new Object[][] { { " 123 " }, { "  123 " }, { "123  " }, { "   " }

		};
	}

	@Test(dataProvider = "Confirmpasswords", priority = 3)
	public void testConfirmpasswordField(String password) {
		driver.findElement(By.id("confirmPassword")).clear();
		driver.findElement(By.id("confirmPassword")).sendKeys(password);

		// Print the Confirm password
		System.out.println("Confirmpassword entered: " + password);

	}

	@Test(priority = 4)
	public void ClickOnNextbuttonTest() {
		driver.findElement(By.xpath("//button[@class='wizard-button primary' and text()='Next']")).click();
	}

	@DataProvider(name = "Firstnamedata")
	public Object[][] getFirstnamedata() {
		return new Object[][] { { "   " }, { "te  st" }, { "  test" }, { "test   " } };
	}

	@Test(dataProvider = "Firstnamedata", priority = 5)
	public void FirstnamedataDrivenMethod(String data) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5L)); // Wait for up to 10 seconds
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[formcontrolname='firstName']")))
				.click();
		driver.findElement(By.cssSelector("input[formcontrolname='firstName']")).clear();
		driver.findElement(By.cssSelector("input[formcontrolname='firstName']")).sendKeys(data);
		// Test method logic using data from the data provider
		System.out.println("Test method with data: " + data);
	}

	@DataProvider(name = "Middlenamedata")
	public Object[][] getMiddlenamedata() {
		return new Object[][] { { "   " }, { "ab  st" }, { "  abst" }, { "next   " } };
	}

	@Test(dataProvider = "Middlenamedata", priority = 6)
	public void MiddlenamedataDrivenMethod(String data) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(0L)); // Wait for up to 10 seconds
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[formcontrolname='middleName']")))
				.click();
		driver.findElement(By.cssSelector("input[formcontrolname='middleName']")).clear();
		driver.findElement(By.cssSelector("input[formcontrolname='middleName']")).sendKeys(data);
		// Test method logic using data from the data provider
		System.out.println("Test method with Middlenamedata: " + data);

	}

	@DataProvider(name = "Lastnamedata")
	public Object[][] getLastnamedata() {
		return new Object[][] { { "   " }, { "te  st" }, { "  test" }, { "text   " } };
	}

	@Test(dataProvider = "Lastnamedata", priority = 7)
	public void LastnamedataDrivenMethod(String data) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(0L)); // Wait for up to 10 seconds
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[formcontrolname='lastName']")))
				.click();
		driver.findElement(By.cssSelector("input[formcontrolname='lastName']")).clear();
		driver.findElement(By.cssSelector("input[formcontrolname='lastName']")).sendKeys(data);
		// Test method logic using data from the data provider
		System.out.println("Test method with Lastnamedata: " + data);

	}

	@DataProvider(name = "AddressLine1data")
	public Object[][] getAddressLine1() {
		return new Object[][] { { "   " }, };
	}

	@Test(dataProvider = "AddressLine1data", priority = 8)
	public void AddressLine2DrivenMethod(String data) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(0L)); // Wait for up to 10 seconds
		wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[formcontrolname='addressLine1']")))
				.click();
		driver.findElement(By.cssSelector("input[formcontrolname='addressLine1']")).clear();
		driver.findElement(By.cssSelector("input[formcontrolname='addressLine1']")).sendKeys(data);
		// Test method logic using data from the data provider
		System.out.println("Test method with AddressLine1data: " + data);

	}

	@Test(priority = 9)
	public void AddressLine2() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(0L)); // Wait for up to 10 seconds
		wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[formcontrolname='addressLine2']")))
				.sendKeys("       ");

	}

	@Test(priority = 10)
	public void AddressLine3() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(0L)); // Wait for up to 10 seconds
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[id='addressLine3']")))
				.sendKeys("     ");
	}

	@DataProvider(name = "Postcodedata")
	public Object[][] getPostcodedata() {
		return new Object[][] { { "   " }, { "4@&dfb" }, { "23t" }, { "test" }, { "@%-%" }, { "test23455@&" } };
	}

	@Test(dataProvider = "Postcodedata", priority = 11)
	public void PostcodedataDrivenMethod(String data) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(0L)); // Wait for up to 10 seconds
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[formcontrolname='postcode']")))
				.click();
		driver.findElement(By.cssSelector("input[formcontrolname='postcode']")).clear();
		driver.findElement(By.cssSelector("input[formcontrolname='postcode']")).sendKeys(data);
		// Test method logic using data from the data provider
		System.out.println("Test method with Postcodedata: " + data);
	}

	@Test(priority = 12)
	public void Citydata() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(0L)); // Wait for up to 10 seconds
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[formcontrolname='city']")))
				.sendKeys("    ");

	}

	@Test(priority = 13)

	public void selectstate()

	{
		WebElement staticDropdown = driver.findElement(By.xpath("//*[@id=\"state\"]"));
		Select dropdown = new Select(staticDropdown);
		dropdown.selectByIndex(4);
		System.out.println(dropdown.getFirstSelectedOption().getText());
	}

	@Test(priority = 14)
	public void xclicknextbutton1()

	{
		driver.findElement(By.xpath("//button[@class='wizard-button primary' and text()='Next']")).click();
	}

	@DataProvider(name = "cardHolderNamedata")
	public Object[][] Cardholdernamedata() {
		return new Object[][] { { "   " }, { "12345$%" }, { "512.34@436" }, { "test@123-47" }, { "534@6,tet@1-7" },
				{ "5555555555555555555555555555555555555555555555555555555555" }, { "ab" } };
	}

	@Test(dataProvider = "cardHolderNamedata", priority = 15)

	public void cardHolderNamedataDrivenMethod(String data) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(0L)); // Wait for up to 10 seconds
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.cssSelector("input[formcontrolname='cardHolderName']"))).click();
		driver.findElement(By.cssSelector("input[formcontrolname='cardHolderName']")).clear();
		driver.findElement(By.cssSelector("input[formcontrolname='cardHolderName']")).sendKeys(data);
		// Test method logic using data from the data provider
		System.out.println("Test method with cardHolderNamedata: " + data);
	}

	@DataProvider(name = "CardNumber")
	public Object[][] CardNumber() {
		return new Object[][] { { "   " }, { "433-666-55" }, { "4234567891234" }, { "47346324693469347489" },
				{ "473463246934693474899" }, { "048574987594547" }, { "621538394++75675" }, { "5889987654321123" },
				{ "47354378578845" } };
	}

	@Test(dataProvider = "CardNumber", priority = 16)

	public void CardNumberDrivenMethod(String data) {
		driver.findElement(By.id("cardTypeVISA")).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(0L)); // Wait for up to 10 seconds
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[formcontrolname='cardNumber']")))
				.click();
		driver.findElement(By.cssSelector("input[formcontrolname='cardNumber']")).clear();
		driver.findElement(By.cssSelector("input[formcontrolname='cardNumber']")).sendKeys(data);
		// Test method logic using data from the data provider
		System.out.println("Test method with CardNumber: " + data);

	}

	@Test(priority = 17)
	public void selectmastercardandnumberenter() {
		driver.findElement(By.id("cardTypeMastercard")).click();
		driver.findElement(By.cssSelector("input[formcontrolname='cardNumber']")).sendKeys("4XXXXXXXXXXXXXXX");

	}

	@DataProvider(name = "CVVNumber")
	public Object[][] CVVNumber() {
		return new Object[][] { { "   " }, { "3++" }, { "12" }, { "3253" }, { "1" } };
	}

	@Test(dataProvider = "CVVNumber", priority = 18)

	public void CVVNumberDrivenMethod(String data) {
		driver.findElement(By.id("cardTypeVISA")).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(0L)); // Wait for up to 10 seconds
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[formcontrolname='cardCVV']")))
				.click();
		driver.findElement(By.cssSelector("input[formcontrolname='cardCVV']")).clear();
		driver.findElement(By.cssSelector("input[formcontrolname='cardCVV']")).sendKeys(data);
		// Test method logic using data from the data provider
		System.out.println("Test method with CVVNumber: " + data);

	}

	@Test(priority = 19)

	public void selectExpirymonth()

	{
		WebElement staticDropdown = driver.findElement(By.id("cardExpiryMonth"));
		Select dropdown = new Select(staticDropdown);
		dropdown.selectByIndex(4);
		System.out.println(dropdown.getFirstSelectedOption().getText());
	}

	@DataProvider(name = "ExpiryYear")
	public Object[][] ExpiryYear() {
		return new Object[][] { { "2023" }, { "87++" }, { "2022" }, { "2024" }, { "2025" }, { "202" },
				{ "2767678678" } };
	}

	@Test(dataProvider = "ExpiryYear", priority = 20)

	public void ExpiryYearDrivenMethod(String data) {
		// driver.findElement(By.id("ExpiryYear")).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(0L)); // Wait for up to 10 seconds
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.cssSelector("input[formcontrolname='cardExpiryYear']"))).click();
		driver.findElement(By.cssSelector("input[formcontrolname='cardExpiryYear']")).clear();
		driver.findElement(By.cssSelector("input[formcontrolname='cardExpiryYear']")).sendKeys(data);
		// Test method logic using data from the data provider
		System.out.println("Test method with ExpiryYear " + data);
	}

	@AfterTest
	public void clcikonnextbutton()

	{
		driver.findElement(By.xpath("//button[@class='wizard-button primary' and text()='Next']")).click();

	}

}
