package Maventest;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Eligibility_Calculation {

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

//		      scheme configuration
		Thread.sleep(2000);
		WebElement schemeconfig = driver.findElement(By.xpath("(//a[@class='dropdown-item'])[15]"));
		schemeconfig.click();

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

//	    category drop down 
		XSSFSheet categoryname = wb.getSheetAt(3);

		XSSFRow categoryrow = categoryname.getRow(2);

		XSSFCell catcolumn = categoryrow.getCell(0);

		String catvalue = catcolumn.getStringCellValue();

		WebElement catdrop = driver
				.findElement(By.xpath("//label[@class='rz-dropdown-label rz-inputtext  rz-placeholder']"));
		Thread.sleep(2000);
		catdrop.click();

		Thread.sleep(2000);
		List<WebElement> catname = driver.findElements(By.xpath("//*[contains(@role, 'option')]"));

		for (WebElement webElement : catname) {

			if (webElement.getText().trim().equals(catvalue)) {

				System.out.println(catvalue);

				webElement.click();

				break;
			}
		}

//	        scroll right
		Thread.sleep(2000);
		WebElement schemescroll = driver
				.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[2]/div/div/div[3]/div/div/div/div"));

		((JavascriptExecutor) driver).executeScript("arguments[0].scrollLeft += 750;", schemescroll);

//	        action button
		Thread.sleep(2000);
		WebElement actionbutton = driver.findElement(By.xpath("//button[@id='dropdownMenu2']"));
		actionbutton.click();

//	        edit button
		Thread.sleep(2000);
		WebElement editbutton = driver.findElement(By.xpath("//button[@class='dropdown-item']"));
		editbutton.click();

//		    Eligibility calculation
		Thread.sleep(2000);
		WebElement eligibiltycalc = driver.findElement(By.xpath("(//div[@class='lib-row lib-header'])[2]"));
		eligibiltycalc.click();

//		    add field
		Thread.sleep(2000);
		WebElement addfield = driver.findElement(By.xpath("//a[@class='btn btn-primary']"));
		addfield.click();

//		    Input Data Type
		Thread.sleep(2000);
		WebElement inputdata = driver.findElement(By.xpath("(//label[@class='rz-dropdown-label rz-inputtext '])[1]"));
		inputdata.click();

		XSSFSheet eligibilitycalc = wb.getSheetAt(5);

		XSSFRow eligibilitycalcrow = eligibilitycalc.getRow(1);

		XSSFCell eligibilitycalccolumn = eligibilitycalcrow.getCell(0);

		String eligibilitycalcvalue = eligibilitycalccolumn.getStringCellValue();

		Thread.sleep(2000);
		List<WebElement> eligibilitycalcname = driver.findElements(By.xpath(".//*[@_bl_21='']/li"));

		for (WebElement webElement : eligibilitycalcname) {

			if (webElement.getText().trim().equals(eligibilitycalcvalue)) {

				System.out.println(eligibilitycalcvalue);

				webElement.click();

				break;
			}
		}

//	       Calculation Type
		Thread.sleep(2000);
		WebElement calctype = driver.findElement(By.xpath("(//label[@class='rz-dropdown-label rz-inputtext '])[2]"));
		calctype.click();

		XSSFCell eligibilitycalccolumn1 = eligibilitycalcrow.getCell(1);

		String calctypevalue = eligibilitycalccolumn1.getStringCellValue();

		Thread.sleep(2000);
		List<WebElement> calctypename = driver.findElements(By.xpath(".//*[@_bl_23='']/li"));

		for (WebElement webElement : calctypename) {

			if (webElement.getText().trim().equals(calctypevalue)) {

				System.out.println(calctypevalue);

				webElement.click();

				break;
			}
		}

//	       Field name
		Thread.sleep(2000);
		WebElement fieldname = driver.findElement(By.xpath("//input[@title='Field Name']"));
		fieldname.click();

		XSSFCell fieldnamecolumn = eligibilitycalcrow.getCell(2);

		String fieldnamevalue = fieldnamecolumn.getStringCellValue();

		driver.findElement(By.xpath("//input[@title='Field Name']")).sendKeys(fieldnamevalue);

//		   Field for
		Thread.sleep(2000);
		WebElement fieldfor = driver.findElement(By.xpath("(//label[@class='rz-dropdown-label rz-inputtext '])[3]"));
		fieldfor.click();

		XSSFCell fieldforcolumn = eligibilitycalcrow.getCell(3);

		String fieldforvalue = fieldforcolumn.getStringCellValue();

		Thread.sleep(2000);
		List<WebElement> fieldforname = driver.findElements(By.xpath(".//*[@_bl_26='']/li"));

		for (WebElement webElement : fieldforname) {

			if (webElement.getText().trim().equals(fieldforvalue)) {

				System.out.println(fieldforvalue);

				webElement.click();

				break;
			}
		}

//	       Label Name
		Thread.sleep(2000);
		WebElement labelname = driver.findElement(By.xpath("//input[@title='Label Name']"));
		labelname.click();

		XSSFCell labelnamecolumn = eligibilitycalcrow.getCell(4);

		String labelnamevalue = labelnamecolumn.getStringCellValue();

		driver.findElement(By.xpath("//input[@title='Label Name']")).sendKeys(labelnamevalue);

//		   Font Style
		Thread.sleep(2000);
		WebElement fondstyle = driver.findElement(By.xpath("(//label[@class='rz-dropdown-label rz-inputtext '])[4]"));
		fondstyle.click();

		XSSFCell fondstylecolumn = eligibilitycalcrow.getCell(5);

		String fondstylevalue = fondstylecolumn.getStringCellValue();

		Thread.sleep(2000);
		List<WebElement> fondstylename = driver.findElements(By.xpath(".//*[@_bl_29='']/li"));

		for (WebElement webElement : fondstylename) {

			if (webElement.getText().trim().equals(fondstylevalue)) {

				System.out.println(fondstylevalue);

				webElement.click();

				break;
			}
		}

//	       Add to list
		Thread.sleep(2000);
		WebElement addlist = driver.findElement(By.xpath("(//button[@class='btn btn-primary '])[1]"));
		addlist.click();

	}

}
