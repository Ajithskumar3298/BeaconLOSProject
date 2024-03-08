package Maventest;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GoldMarketValue_Admin {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		String name = "adminuser";
		String password = "spe$1234";

		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.get("http://192.168.32.23:44369/");
		driver.manage().window().maximize();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='User Name']")));
		driver.findElement(By.xpath("//input[@placeholder='User Name']")).click();
		driver.findElement(By.xpath("//input[@placeholder='User Name']")).sendKeys(name);
		driver.findElement(By.xpath("//input[@placeholder='Password']")).click();
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys(password);
		driver.findElement(By.cssSelector("button[type='submit']")).click();

//		boolean window = driver.findElement(By.xpath("//div[@role='dialog']")).isDisplayed();
//
//		if (window == true) {
//			WebElement popup = driver.findElement(By.xpath("//input[@class='btn btn-primary rounded-pill']"));
//			Thread.sleep(1000);
//			popup.click();
//			driver.findElement(By.cssSelector("button[type='submit']")).click();
//		}
//	      expander
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.cssSelector("i[class='toggle tgleclass'] span[class='material-symbols-outlined']")));
		driver.findElement(By.cssSelector("i[class='toggle tgleclass'] span[class='material-symbols-outlined']"))
				.click();

//	      Master configuration
		Thread.sleep(2000);
		WebElement master = driver.findElement(By.xpath("(//a[@id='dropdownMenuButton1'])[4]"));
		master.click();

//	      gold market value
		Thread.sleep(2000);
		WebElement goldmarketvalue = driver.findElement(By.xpath("(//a[@class='dropdown-item'])[16]"));
		goldmarketvalue.click();

//		  add market value
		driver.findElement(By.linkText("Add Market Value")).click();

//		  Item Group
		WebElement Itemgroup = driver.findElement(By.xpath(
				"/html[1]/body[1]/div[1]/div[2]/div[1]/div[2]/form[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]"));
		Itemgroup.click();
		String Itemvalue = "Diamond";
		List<WebElement> Items = driver.findElements(By.cssSelector("ul[role='listbox']"));

		for (WebElement webElement : Items) {

			if (webElement.getText().trim().equals(Itemvalue)) {
				System.out.println(Itemvalue);
				webElement.click();

				break;
			}
		}

//		   Purity
		WebElement Purity = driver.findElement(By.cssSelector("#HE5LtHGjPE"));
		Purity.click();
		String Purityvalue = "15k";
		List<WebElement> PurityItems = driver.findElements(By.cssSelector("ul[role='listbox']"));

		for (WebElement webElement : PurityItems) {

			if (webElement.getText().trim().equals(Purityvalue)) {
				System.out.println(Purityvalue);
				webElement.click();

				break;
			}
		}

//		  current market value
		WebElement value = driver.findElement(By.name("Current market value"));
		value.click();
		value.sendKeys("7000");

//		   Save Button
		driver.findElement(By.cssSelector("input[value='Save']")).click();

		Thread.sleep(15000);
		driver.close();

	}

}
