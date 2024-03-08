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

public class Category_Configuration {

	public static void main(String[] args) throws IOException, InterruptedException {
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

//	      expander
		driver.findElement(By.xpath("(//span[@class='material-symbols-outlined'])[1]")).click();

//	      product
		Thread.sleep(2000);
		WebElement product = driver.findElement(By.xpath("(//a[@id='dropdownMenuButton1'])[5]"));

		product.click();

//	      category configuration
		Thread.sleep(2000);
		WebElement categoryconfig = driver.findElement(By.xpath("(//a[@class='dropdown-item'])[14]"));
		categoryconfig.click();

//	      expander close
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//span[@class='material-symbols-outlined'])[1]")).click();

//	      product dropdown  
		WebElement proddrop = driver
				.findElement(By.xpath("//label[@class='rz-dropdown-label rz-inputtext  rz-placeholder']"));
		Thread.sleep(2000);
		proddrop.click();

		Thread.sleep(2000);
		List<WebElement> prodname = driver.findElements(By.xpath("(//li[@class='rz-dropdown-item '])[2]"));

//          String value = "Automation";
		for (WebElement webElement : prodname) {
			String value = "Automation";

			if (webElement.getText().trim().equals(value)) {

				System.out.println(value);

				webElement.click();

				break;
			}
		}

//        Add category
//          Thread.sleep(3000);
//	      WebElement addcat= driver.findElement(By.xpath("(//a[@class='btn btn-primary'])[2]"));
//	      addcat.click();
//	      
////	       value pass
//	       XSSFSheet Categorymanagement=  wb.getSheetAt(3);
//	      	 
//	       XSSFRow row1 = Categorymanagement.getRow(1);
//	      
//	       XSSFCell cells = row1.getCell(0);
//	      
//	       String catname =  cells.getStringCellValue();
//	      
//	       System.out.println(catname);
//	      
//	       driver.findElement(By.xpath("//input[@title='Category Name']")).sendKeys(catname);

//	      clear button
//          Thread.sleep(2000);
//          WebElement clear = driver.findElement(By.xpath("//a[@class='btn btn-light ']"));
//          clear.click();

//	      Add button
//	      Thread.sleep(2000);
//          WebElement addbutton = driver.findElement(By.xpath("//button[@class='btn btn-primary']"));
//          addbutton.click();

//        Action button
		Thread.sleep(2000);
		WebElement Action = driver.findElement(By.xpath("(//button[@type='button'])[2]"));
		Action.click();

//        Edit button
		Thread.sleep(2000);
		WebElement Edit = driver.findElement(By.xpath("(//button[@type='button'])[3]"));
		Edit.click();

	}

}
