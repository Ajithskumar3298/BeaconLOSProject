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

public class Scheme_Settings {

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

//	      expander
		driver.findElement(By.xpath("(//span[@class='material-symbols-outlined'])[1]")).click();

//	      product
		Thread.sleep(2000);
		WebElement product = driver.findElement(By.xpath("(//a[@id='dropdownMenuButton1'])[5]"));

		product.click();

//	      category configuration
		driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(1));
		Thread.sleep(2000);
		WebElement categoryconfig = driver.findElement(By.xpath("(//a[@class='dropdown-item'])[14]"));
		categoryconfig.click();

//	      expander close
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//span[@class='material-symbols-outlined'])[1]")).click();

//	      product dropdown 

		XSSFSheet sheet3 = wb.getSheetAt(3);

		XSSFRow productrow = sheet3.getRow(1);

		XSSFCell productcolumn = productrow.getCell(2);

		String productvalue = productcolumn.getStringCellValue();

		Thread.sleep(2000);
		WebElement proddrop = driver
				.findElement(By.xpath("//label[@class='rz-dropdown-label rz-inputtext  rz-placeholder']"));

		proddrop.click();

		Thread.sleep(2000);

		List<WebElement> prodname = driver.findElements(By.xpath("//*[contains(@role, 'option')]"));

		for (WebElement webElement : prodname) {

			if (webElement.getText().trim().equals(productvalue)) {

//                     System.out.println(productvalue);

				webElement.click();

				break;
			}
		}

//        Action button
		Thread.sleep(2000);
		WebElement Action = driver.findElement(By.xpath("(//button[@type='button'])[2]"));
		Action.click();

//        Edit button
		Thread.sleep(2000);
		WebElement Edit = driver.findElement(By.xpath("(//button[@type='button'])[3]"));
		Edit.click();

//        scroll down
		Thread.sleep(2000);
		JavascriptExecutor scroll = (JavascriptExecutor) driver;

		scroll.executeScript("window.scrollBy(0,300)");
//          driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(1));

//        Scheme Settings
		Thread.sleep(2000);
		WebElement schemesettings = driver.findElement(By.xpath("(//div[@class='lib-row lib-header'])[10]"));
		schemesettings.click();

//       add scheme button
		Thread.sleep(3000);
		WebElement schemebutton = driver.findElement(By.xpath("//a[@class='addbutton btn btn-primary ']"));
		schemebutton.click();

//       Add scheme value passing
//       scheme name
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@title='Name']")).click();
		XSSFSheet addscheme = wb.getSheetAt(4);

		XSSFRow addschemerow = addscheme.getRow(1);

		XSSFCell addschemecell = addschemerow.getCell(0);

		String schemename = addschemecell.getStringCellValue();

		System.out.println(schemename);

		driver.findElement(By.xpath("//input[@title='Name']")).sendKeys(schemename);

//	     short name
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@title='Short Name']")).click();
		XSSFCell addschemecell1 = addschemerow.getCell(1);

		String shortname = addschemecell1.getStringCellValue();

		System.out.println(shortname);

		driver.findElement(By.xpath("//input[@title='Short Name']")).sendKeys(shortname);

//	     Tenure mode
		Thread.sleep(1000);
		WebElement tenure = driver.findElement(By.xpath("(//label[@class='rz-dropdown-label rz-inputtext '])[3]"));
		tenure.click();

		Thread.sleep(1000);
		XSSFCell addschemecell2 = addschemerow.getCell(2);

		String Tenuremode = addschemecell2.getStringCellValue();

		Thread.sleep(1000);
		List<WebElement> tenuredrop = driver.findElements(By.xpath(".//*[@_bl_65='']/li"));
		for (WebElement webelement : tenuredrop) {

			if (webelement.getText().trim().equals(Tenuremode)) {

//                 System.out.println(Tenuremode);

				webelement.click();

				break;
			}

		}

//	      max tenure
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@placeholder='Max Tenure']")).click();

		XSSFCell addschemecell3 = addschemerow.getCell(3);

		String maxtenure = addschemecell3.getStringCellValue();

		System.out.println(maxtenure);

		driver.findElement(By.xpath("//input[@placeholder='Max Tenure']")).sendKeys(maxtenure);

//	      Max Apply Amount
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@placeholder='Max Apply Amt']")).click();

		XSSFCell addschemecell4 = addschemerow.getCell(4);

		String maxapplyamount = addschemecell4.getStringCellValue();

		System.out.println(maxapplyamount);

		driver.findElement(By.xpath("//input[@placeholder='Max Apply Amt']")).sendKeys(maxapplyamount);

//	      Minimum ROI
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@placeholder='Minimum ROI']")).click();

		XSSFCell addschemecell5 = addschemerow.getCell(5);

		String minimumroi = addschemecell5.getStringCellValue();

		System.out.println(minimumroi);

		driver.findElement(By.xpath("//input[@placeholder='Minimum ROI']")).sendKeys(minimumroi);

//	     Maximum ROI
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@placeholder='Maximum ROI']")).click();

		XSSFCell addschemecell6 = addschemerow.getCell(6);

		String maximumroi = addschemecell6.getStringCellValue();

		System.out.println(maximumroi);

		driver.findElement(By.xpath("//input[@placeholder='Maximum ROI']")).sendKeys(maximumroi);

//	     defualt roi
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@placeholder='Default ROI']")).click();

		XSSFCell addschemecell7 = addschemerow.getCell(7);

		String defualtroi = addschemecell7.getStringCellValue();

		System.out.println(defualtroi);

		driver.findElement(By.xpath("//input[@placeholder='Default ROI']")).sendKeys(defualtroi);

//	       Default Interest Type
		Thread.sleep(1000);
		WebElement defultinttype = driver.findElement(By.xpath("//div[@title='Default Interest Type']"));
		defultinttype.click();

		Thread.sleep(1000);
		XSSFCell addschemecell8 = addschemerow.getCell(8);

		String defuaintype = addschemecell8.getStringCellValue();
		System.out.println(defuaintype);

		Thread.sleep(1000);
		List<WebElement> intresttypedrop = driver.findElements(By.xpath(".//*[@_bl_77='']/li"));
		for (WebElement webelement : intresttypedrop) {

			if (webelement.getText().trim().equals(defuaintype)) {

//                 System.out.println(defuaintype);

				webelement.click();

				break;
			}

		}
//	       Default Installment Type
		Thread.sleep(1000);
		WebElement defultintalltype = driver
				.findElement(By.xpath("(//label[@class='rz-dropdown-label rz-inputtext '])[5]"));
		defultintalltype.click();

		Thread.sleep(1000);
		XSSFCell addschemecell9 = addschemerow.getCell(9);

		String defuaintallmentype = addschemecell9.getStringCellValue();
		System.out.println(defuaintallmentype);

		Thread.sleep(1000);
		List<WebElement> intallmentdrop = driver.findElements(By.xpath(".//*[@_bl_79='']/li"));
		for (WebElement webelement : intallmentdrop) {

			if (webelement.getText().trim().equals(defuaintallmentype)) {

//                 System.out.println(intallmentdrop);

				webelement.click();

				break;
			}

		}
//	       Default Installment Mode
		Thread.sleep(1000);
		WebElement defultintallmode = driver
				.findElement(By.xpath("(//label[@class='rz-dropdown-label rz-inputtext '])[6]"));
		defultintallmode.click();

		Thread.sleep(1000);
		XSSFCell addschemecell10 = addschemerow.getCell(10);

		String defuaintallmentmode = addschemecell10.getStringCellValue();
		System.out.println(defuaintallmentmode);

		Thread.sleep(1000);
		List<WebElement> intallmentmodedrop = driver.findElements(By.xpath(".//*[@_bl_81='']/li"));
		for (WebElement webelement : intallmentmodedrop) {

			if (webelement.getText().trim().equals(defuaintallmentmode)) {

//                 System.out.println(intallmentdrop);

				webelement.click();

				break;
			}

		}
//	       OD Interest
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@placeholder='OD Interest']")).click();

		XSSFCell addschemecell11 = addschemerow.getCell(11);

		String odintrest = addschemecell11.getStringCellValue();

		System.out.println(odintrest);

		driver.findElement(By.xpath("//input[@placeholder='OD Interest']")).sendKeys(odintrest);

//	       FOIR Percentage
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@placeholder='FOIR Percentage']")).click();

		XSSFCell addschemecell12 = addschemerow.getCell(12);

		String foirpercentage = addschemecell12.getStringCellValue();

		System.out.println(foirpercentage);

		driver.findElement(By.xpath("//input[@placeholder='FOIR Percentage']")).sendKeys(foirpercentage);

//	       check box
		Thread.sleep(1000);
		WebElement checkbox = driver.findElement(By.xpath("//span[@class='rz-chkbox-icon rzi rzi-check']"));
		if (checkbox.isEnabled()) {

			driver.findElement(By.xpath("//input[@type='submit']")).click();

		} else {

			System.out.println("checkbox disabled");
		}

		Thread.sleep(2000);
		driver.quit();

	}

}
