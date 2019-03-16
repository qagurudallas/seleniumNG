package demopkg;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class ElementsNG {
	WebDriver driver;

	@BeforeClass
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "/Applications/chromedriver");
		driver = new ChromeDriver();
		driver.get("http://demo.guru99.com/test/ajax.html");
	}

	@Test(priority = 1)
	public void testRadioYes() {

		// List<WebElement> elements = driver.findElements(By.name("name"));
		driver.findElement(By.id("yes")).click();
		driver.findElement(By.id("buttoncheck")).click();
		String mesg = driver.findElement(By.className("radiobutton")).getText();

		Assert.assertTrue(mesg.contains("it's value is Yes"));

	}

	@Test(priority = 2)
	public void testRadioNo() {

		driver.get("http://demo.guru99.com/test/ajax.html");
		driver.findElement(By.id("no")).click();
		driver.findElement(By.id("buttoncheck")).click();
		String mesg = driver.findElement(By.className("radiobutton")).getText();

		Assert.assertTrue(mesg.contains("it's value is No"));

	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}
}
