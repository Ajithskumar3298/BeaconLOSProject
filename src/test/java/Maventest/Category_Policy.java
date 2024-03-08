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

public class Category_Policy {

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
		Thread.sleep(2000);
		WebElement categoryconfig = driver.findElement(By.xpath("(//a[@class='dropdown-item'])[14]"));
		categoryconfig.click();

//		      expander close
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//span[@class='material-symbols-outlined'])[1]")).click();

//		      product dropdown  
		WebElement proddrop = driver
				.findElement(By.xpath("//label[@class='rz-dropdown-label rz-inputtext  rz-placeholder']"));
		Thread.sleep(2000);
		proddrop.click();

		Thread.sleep(2000);
		List<WebElement> prodname = driver.findElements(By.xpath("(//li[@class='rz-dropdown-item '])[2]"));

//	          String value = "Automation";
		for (WebElement webElement : prodname) {
			String value = "Automation";

			if (webElement.getText().trim().equals(value)) {

				System.out.println(value);

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

//	        Category policy
		Thread.sleep(2000);
		WebElement categorypolicy = driver.findElement(By.xpath("(//div[@class='lib-row lib-header'])[2]"));
		categorypolicy.click();

//	        Add row
		Thread.sleep(2000);
		int addrow;
		for (addrow = 1; addrow <= 1; addrow++) {

			WebElement addrowbutton = driver.findElement(By.xpath("//input[@value='Add Row']"));
			addrowbutton.click();

		}
//	        value pass
		XSSFSheet catpolicy = wb.getSheetAt(3);

		XSSFRow policyrow = catpolicy.getRow(1);

		XSSFCell policycell = policyrow.getCell(1);

		String policyname = policycell.getStringCellValue();

		System.out.println(policyname);

		driver.findElement(By.xpath("//input[@title='Policy']")).sendKeys(policyname);

//	        deviation approval
		Thread.sleep(2000);
		WebElement deviationaprovallevel = driver
				.findElement(By.xpath("//label[@class='rz-dropdown-label rz-inputtext ']"));
		deviationaprovallevel.click();

//		    drop down
		Thread.sleep(2000);
		List<WebElement> deviationlevel = driver.findElements(By.xpath("(//li[@role='option'])[3]"));

		String value = "Credit";
		for (WebElement webElement : deviationlevel) {

			if (webElement.getText().trim().equals(value)) {

				System.out.println(value);

				webElement.click();

				break;
			}
		}

//	         check box
		Thread.sleep(2000);
		WebElement checkbox = driver.findElement(By.xpath("//div[@class='rz-chkbox-box']"));
		checkbox.click();

//	         delete button
		Thread.sleep(2000);
		WebElement delete = driver.findElement(By.xpath("(//button[@type='button'])[12]"));
		delete.click();

//		     alert window
		Thread.sleep(2000);
		WebElement alert = driver.findElement(By.xpath("(//input[@type='button'])[1]"));
		alert.click();

//	         cancel button
//		         Thread.sleep(2000);
//		         WebElement cancel = driver.findElement(By.xpath("(//button[@type='button'])[13]"));
//		         cancel.click();

////		     save button
//		         Thread.sleep(2000);
//		         WebElement save = driver.findElement(By.xpath("//button[@class='btn btn-primary ']"));
//		         save.click();

	}

}
