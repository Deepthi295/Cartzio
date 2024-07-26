package SubCate;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;

public class AddSubCate {
	WebDriver driver;
	Actions action;
	WebDriverWait wait;
	WebElement Webelement;

	@Test(priority = 1, enabled = true)
	public void VerifyLogin() {
		driver.findElement(By.id("usernameID")).sendKeys("Ecommerce");
		driver.findElement(By.xpath("//input[@id='PasswordID']")).sendKeys("123");
		driver.findElement(By.xpath("//button[@type='submit']")).click();

	}

	@Test(priority = 2, enabled = true)
	public void Verifyhome() throws InterruptedException {
		// driver.findElement(By.xpath("//ul[@class='nav navbar-nav side-nav
		// nicescroll-bar']")).click();

		WebElement ele = driver.findElement(By.xpath("//ul[@class='nav navbar-nav side-nav nicescroll-bar']"));
		Actions act = new Actions(driver);
		act.moveToElement(ele);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[@class][text()='Settings']")).click();
		driver.findElement(By.linkText("Create Vendor")).click();
		Thread.sleep(2000);

	}

	@Test(priority = 3, enabled = true)
	public void CreateVender() throws InterruptedException {
		driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();
		driver.findElement(By.id("Company_Name")).sendKeys("SRI LAKSHMI ENTERPRISES");
		driver.findElement(By.name("Shop_Website")).sendKeys("www.Srilakshmienterprises.com");
		new Select(driver.findElement(By.name("OwnersType"))).selectByValue("3");
		new Select(driver.findElement(By.name("BusinessType"))).selectByValue("2");
		driver.findElement(By.name("AadhaarNo")).sendKeys("123456789101");
		driver.findElement(By.name("VendorsName")).sendKeys("Mounika");
		driver.findElement(By.name("PhoneNumber")).sendKeys("9849434480");
		driver.findElement(By.name("EmailID")).sendKeys("deepthireddy295@gmail.com");
		driver.findElement(By.name("POC_Name")).sendKeys("Mounika");
		driver.findElement(By.name("POC_Number")).sendKeys("9701446092");
		new Select(driver.findElement(By.name("Country"))).selectByValue("1");
		Thread.sleep(2000);
		action.sendKeys(Keys.PAGE_DOWN).build().perform();
		new Select(driver.findElement(By.xpath("//form[@class='Vendor']//select[@name='State']"))).selectByValue("4");
		new Select(driver.findElement(By.name("City"))).selectByValue("3");
		driver.findElement(By.name("Location")).sendKeys("Moulali");
		driver.findElement(By.name("FriendlyAddress"))
				.sendKeys("3/119,Reddy gari street Venkateswera Nagar,secundrabad,pincode:516349");
		driver.findElement(By.name("AccountNumber")).sendKeys("675483124579");
		driver.findElement(By.name("IFSCCode")).sendKeys("INDE000PDEP");
		driver.findElement(By.name("BankName")).sendKeys("IndianBank");
		driver.findElement(By.name("BankBranch")).sendKeys("GandhiRoad");
		new Select(driver.findElement(By.name("AccountType"))).selectByValue("1");
		driver.findElement(By.xpath("//button[text()=' Save']")).click();
		driver.findElement(By.xpath("//div[text()='Successfully Created']")).click();
		driver.switchTo().alert().accept();

		// assertTrue(text.contains("Successfully Created"), "failed to create the
		// vender" );
		// System.out.println("Successfully created to vender");
	}

	@Test(priority = 4, enabled = false)
	public static void verifyInventry() {

	}

	@BeforeTest
	public void SetUp() {
		driver = new EdgeDriver();
		driver.get("http://49.207.10.149:8080/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		action = new Actions(driver);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	}

	@AfterTest
	public void quit() {
		// driver.quit();
	}
}
