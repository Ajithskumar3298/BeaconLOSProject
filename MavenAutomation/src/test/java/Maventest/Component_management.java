package Maventest;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Component_management {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub

		WebDriver driver;

		driver = new FirefoxDriver();

		driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(2));

		driver.get("http://192.168.32.23:44369/");

		driver.manage().window().maximize();

		String file = "./testdata/Demoexcell.xlsx";

		XSSFWorkbook wb = new XSSFWorkbook(file);

		XSSFSheet sheet = wb.getSheetAt(0);

		XSSFRow row = sheet.getRow(1);

		XSSFCell cell = row.getCell(0);

		String name = cell.getStringCellValue();

		System.out.println(name);

		driver.findElement(By.xpath("//input[@placeholder='User Name']")).sendKeys(name);

		XSSFCell cell1 = row.getCell(1);

		String name1 = cell1.getStringCellValue();

		System.out.println(name1);

		Thread.sleep(1000);

		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys(name1);

		Thread.sleep(1000);

		driver.findElement(By.xpath("//button[@type='submit']")).click();

		if (driver.findElement(By.xpath("//div[@role='dialog']")).isDisplayed()) {

			WebElement popup = driver.findElement(By.xpath("//input[@class='btn btn-primary rounded-pill']"));

			Thread.sleep(1000);

			popup.click();

		}

		driver.findElement(By.xpath("//button[@type='submit']")).click();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		Thread.sleep(2000);

//		      expander
		driver.findElement(By.xpath("(//span[@class='material-symbols-outlined'])[1]")).click();

//		      product
		Thread.sleep(2000);
		WebElement product = driver.findElement(By.xpath("(//a[@id='dropdownMenuButton1'])[5]"));

		product.click();

//		      category configuration
		driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(1));
		Thread.sleep(2000);
		WebElement categoryconfig = driver.findElement(By.xpath("(//a[@class='dropdown-item'])[14]"));
		categoryconfig.click();

//		      expander close
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//span[@class='material-symbols-outlined'])[1]")).click();

//		      product drop down  
		XSSFSheet sheet3 = wb.getSheetAt(3);

		XSSFRow productrow = sheet3.getRow(1);

		XSSFCell productcolumn = productrow.getCell(2);

		String productvalue = productcolumn.getStringCellValue();

		WebElement proddrop = driver
				.findElement(By.xpath("//label[@class='rz-dropdown-label rz-inputtext  rz-placeholder']"));
		Thread.sleep(2000);
		proddrop.click();

		Thread.sleep(2000);
		List<WebElement> prodname = driver.findElements(By.xpath("//*[contains(@role, 'option')]"));

		for (WebElement webElement : prodname) {

			if (webElement.getText().trim().equals(productvalue)) {

				System.out.println(productvalue);

				webElement.click();

				break;
			}
		}

//	        Action button
		Thread.sleep(2000);
		WebElement Action = driver.findElement(By.xpath("(//button[@type='button'])[2]"));
		Action.click();

//	        Edit button
		Thread.sleep(2000);
		WebElement Edit = driver.findElement(By.xpath("(//button[@type='button'])[3]"));
		Edit.click();

//	        Category management
		Thread.sleep(2000);
		WebElement categorymanagement = driver.findElement(By.xpath("(//div[@class='lib-row lib-header'])[4]"));
		categorymanagement.click();

//	        stage drop
		Thread.sleep(2000);
		WebElement stagedrop = driver
				.findElement(By.xpath("//label[@class='rz-dropdown-label rz-inputtext  rz-placeholder']"));
		stagedrop.click();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//	          Thread.sleep(2000);
		List<WebElement> stage = driver.findElements(By.xpath("//li[@aria-label='>customer onboarding']"));

		for (WebElement webElement : stage) {
			String value = "customer onboarding";

			if (webElement.getText().trim().equals(value)) {

				System.out.println(value);

				webElement.click();

				break;
			}
		}

//	        scroll down
		Thread.sleep(2000);
//	          JavascriptExecutor scroll = (JavascriptExecutor) driver;
//	          
//	          scroll.executeScript("window.scrollBy(0,200)");
//	          driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(1));

//	        source element
		WebElement sourceElement = driver.findElement(By.xpath("(//li[@class='componentlists-items-draggable'])[4]"));

//	        target element
		WebElement targetElement = driver.findElement(By.xpath("(//ul[@class='componentlists-wrapper '])[2]"));

		Actions dragdrop = new Actions(driver);
		Thread.sleep(2000);

		dragdrop.click().dragAndDrop(sourceElement, targetElement).build().perform();

	}

}
