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

public class Loan_Search {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub

		WebDriver driver;

		driver = new FirefoxDriver();

		driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(2));

		driver.get("http://192.168.32.23:44369/");

		driver.manage().window().maximize();

		String file = "./testdata/Demoexcell.xlsx";

		XSSFWorkbook wb = new XSSFWorkbook(file);

		XSSFSheet sheet = wb.getSheetAt(6);

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
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[@type='submit']")).click();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		Thread.sleep(2000);
//	    	     expander
		driver.findElement(By.xpath("(//span[@class='material-symbols-outlined'])[1]")).click();

		Thread.sleep(2000);
//	    	     loan management
		WebElement loanmangement = driver.findElement(By.xpath("(//a[@id='dropdownMenuButton1'])[1]"));
		loanmangement.click();

		Thread.sleep(2000);
//	    	     loan search
		WebElement loansearch = driver.findElement(By.xpath("(//a[@class='dropdown-item'])[2]"));
		loansearch.click();

		Thread.sleep(1000);
//	    	     expander close
		driver.findElement(By.xpath("(//span[@class='material-symbols-outlined'])[1]")).click();

//	    	     los number
		XSSFSheet loansrch = wb.getSheetAt(7);

		XSSFRow losrow = loansrch.getRow(1);

		XSSFCell loscell = losrow.getCell(0);

		String losno = loscell.getStringCellValue();

		System.out.println(losno);

		Thread.sleep(2000);
		WebElement losnumber = driver.findElement(By.xpath("//input[@placeholder='LOS Number']"));
		losnumber.click();
		losnumber.sendKeys(losno);

//	  	       enq number
		XSSFRow enqrow = loansrch.getRow(1);

		XSSFCell enqcell = enqrow.getCell(1);

		String enqno = enqcell.getStringCellValue();

		System.out.println(enqno);

		Thread.sleep(2000);
		WebElement enqnumber = driver.findElement(By.xpath("//input[@placeholder='Enquiry Ref No']"));
		enqnumber.click();
		enqnumber.sendKeys(enqno);

//	  	       cust id
//	  	       XSSFRow custidrow = loansrch.getRow(1);
//	  	      
//	  	       XSSFCell custidcell = custidrow.getCell(2);
//	  	      
//	  	       int custid=(int) custidcell.getNumericCellValue();
//	  	      
//	  	       System.out.println(custid);
//	  	       
//	  	       Thread.sleep(2000);
//	  	       WebElement customerid = driver.findElement(By.xpath("//input[@placeholder='Customer ID']"));
//	  	       customerid.click();
//	  	       customerid.sendKeys(String.valueOf(custid));

//	  	       customer search
		Thread.sleep(1000);
		WebElement custidsearch = driver.findElement(By.xpath("//text[@class='material-symbols-outlined textsearch']"));
		custidsearch.click();

//		       Pan no
		XSSFRow pannorow = loansrch.getRow(1);
		XSSFCell pannocell = pannorow.getCell(4);
		String panno = pannocell.getStringCellValue();

		System.out.println(panno);

		Thread.sleep(2000);
		WebElement pannumber = driver.findElement(By.xpath("//input[@placeholder='PAN']"));
		pannumber.click();
		pannumber.sendKeys(panno);

//		       aadhaar no

		XSSFRow aadharrow = loansrch.getRow(1);
		XSSFCell aadharnocell = aadharrow.getCell(5);
		String aadhaarno = aadharnocell.getStringCellValue();

		System.out.println(aadhaarno);

		Thread.sleep(2000);
		WebElement aadharnumber = driver.findElement(By.xpath("//input[@placeholder='Aadhaar Number']"));
		aadharnumber.click();
		aadharnumber.sendKeys(aadhaarno);

//             CKYC Number

		XSSFRow ckycrow = loansrch.getRow(1);
		XSSFCell ckyccell = ckycrow.getCell(6);
//		       int ckycno=(int) ckyccell.getNumericCellValue();
		String ckycno = ckyccell.getStringCellValue();

		System.out.println(ckycno);

		Thread.sleep(2000);
		WebElement ckycnumber = driver.findElement(By.xpath("//input[@placeholder='CKYC Number']"));
		ckycnumber.click();
		ckycnumber.sendKeys(ckycno);

//		  	   Mobile Number

		XSSFRow mobrow = loansrch.getRow(1);
		XSSFCell mobcell = mobrow.getCell(7);
		int mobno = (int) mobcell.getNumericCellValue();

		System.out.println(mobno);

		Thread.sleep(2000);
		WebElement mobnumber = driver.findElement(By.xpath("//input[@placeholder='Mobile Number']"));
		mobnumber.click();
		mobnumber.sendKeys(String.valueOf(mobno));

//		   	   Udyam Reg. No.

		XSSFRow udayamrow = loansrch.getRow(1);
		XSSFCell udayamcell = udayamrow.getCell(8);
		String udayamno = udayamcell.getStringCellValue();

		System.out.println(udayamno);

		Thread.sleep(2000);
		WebElement udayamnumber = driver.findElement(By.xpath("//input[@placeholder='Mobile Number']"));
		udayamnumber.click();
		udayamnumber.sendKeys(udayamno);

//		   	   search button
		driver.findElement(By.xpath("(//button[@type='submit'])[1]")).click();

//	  	       branch
		XSSFRow bracnchrow = loansrch.getRow(1);

		XSSFCell branchcell = bracnchrow.getCell(3);

		String branch = branchcell.getStringCellValue();

		System.out.println(branch);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//label[@class='rz-dropdown-label rz-inputtext  rz-placeholder']")).click();

		Thread.sleep(1000);
		List<WebElement> branchdrop = driver.findElements(By.xpath("//li[contains(@role,'option')]"));
		for (WebElement webelement : branchdrop) {

			if (webelement.getText().trim().equals(branch)) {

//	                 System.out.println(branch);

				webelement.click();

				break;
			}

		}

//		       clear button
//		       Thread.sleep(1000);
//		       WebElement clear = driver.findElement(By.xpath("//a[@class='addbutton btn btn-primary']"));
//		       clear.click();

//		       search button
		Thread.sleep(2000);
		WebElement search = driver.findElement(By.xpath("//button[@type='submit']"));
		search.click();

//		       scroll right
		Thread.sleep(2000);
		WebElement loansearchscroll = driver.findElement(By.xpath("//div[@class='rz-data-grid-data']"));

		((JavascriptExecutor) driver).executeScript("arguments[0].scrollLeft += 750;", loansearchscroll);

//		       view button
		Thread.sleep(1000);
		WebElement view = driver.findElement(By.xpath("(//button[@type='button'])[2]"));
		view.click();

	}

}
