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

public class Customer_onboarding_Bank_Account_Details {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub

		WebDriver driver;

		driver = new FirefoxDriver();

		driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(2));

		driver.get("http://192.168.32.23:44369/");

		driver.manage().window().maximize();

		String file = "./testdata/Demoexcell.xlsx";

		XSSFWorkbook wb = new XSSFWorkbook(file);

		XSSFSheet sheet = wb.getSheetAt(6);

		XSSFRow row = sheet.getRow(2);

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

//	    	     inbox
		Thread.sleep(1000);
		WebElement inbox = driver.findElement(By.xpath("(//a[@id='dropdownMenuButton1'])[4]"));
		inbox.click();

//	    	     inbox button
		Thread.sleep(1000);
		WebElement inboxbutton = driver.findElement(By.xpath("(//a[@class='dropdown-item'])[6]"));
		inboxbutton.click();

		Thread.sleep(2000);
//	    	     expander close
		driver.findElement(By.xpath("(//span[@class='material-symbols-outlined'])[1]")).click();

//	    	     inbox data
		Thread.sleep(1000);
		List<WebElement> inboxdata = driver.findElements(By.xpath("//div[@class='inboxleft-body']"));

		for (WebElement element : inboxdata) {

			String value = element.getText();
			System.out.println(value);

			if (value.contains("LOS138400600000005")) {

				driver.findElement(By.xpath("//span[@type='button']")).click();
				break;
			} else {

				System.out.println("Element Not Found");
				driver.findElement(By.xpath("(//a[@role='button'])[1]")).click();

//			    		 myqueue
				driver.findElement(By.xpath("(//a[@class='dropdown-item pointer'])[2]")).click();
			}
		}

//			      scroll down
		Thread.sleep(2000);
		JavascriptExecutor scroll = (JavascriptExecutor) driver;

		scroll.executeScript("window.scrollBy(0,350)");

//		          applicant
		Thread.sleep(2000);
		WebElement applicant = driver.findElement(By.xpath("(//a[@class='inboxlist  '])[10]"));
		applicant.click();

//		          scroll up
		Thread.sleep(2000);
		JavascriptExecutor scrollup = (JavascriptExecutor) driver;

		scrollup.executeScript("window.scrollBy(0,-250)");

//	    	  click view
		Thread.sleep(2000);
		WebElement view = driver.findElement(By.xpath("//span[@class='loanstatus yellowbg']"));
		view.click();

//	    	  close
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[@class='closebtn']")).click();

//	    	  Bank Account Details Tab
		Thread.sleep(2000);
		WebElement Bankaccountdetailstab = driver.findElement(By.xpath("(//span[@class='rz-tabview-title'])[4]"));
		Bankaccountdetailstab.click();

//	          scroll down
		Thread.sleep(2000);
		JavascriptExecutor scrolldown1 = (JavascriptExecutor) driver;

		scrolldown1.executeScript("window.scrollBy(0,300)");

//	          Account Type
		Thread.sleep(1000);
		WebElement BANKACCOUNTdrop = driver.findElement(By.xpath("(//div[@title='Account Type'])[2]"));
		BANKACCOUNTdrop.click();
		XSSFSheet BANKACCOUNTDETAILS = wb.getSheetAt(11);
		XSSFRow bankaccountrow = BANKACCOUNTDETAILS.getRow(1);
		XSSFCell accounttypecell = bankaccountrow.getCell(0);

		String accounttypefield = accounttypecell.getStringCellValue();

		Thread.sleep(1000);
		List<WebElement> accounttypeelement = driver.findElements(By.xpath("//li[contains(@role, 'option')]"));
		for (WebElement webelement : accounttypeelement) {

			if (webelement.getText().equals(accounttypefield)) {

				System.out.println(accounttypefield);

				webelement.click();

				break;
			}

		}

//		          STATE
		Thread.sleep(1000);
		WebElement statedrop = driver.findElement(By.xpath("//div[@title='State']"));
		statedrop.click();

		XSSFCell statecell = bankaccountrow.getCell(1);

		String statefield = statecell.getStringCellValue();

		Thread.sleep(1000);
		List<WebElement> stateelement = driver.findElements(By.xpath("//li[contains(@role, 'option')]"));
		for (WebElement webelement : stateelement) {

			if (webelement.getText().equals(statefield)) {

				System.out.println(statefield);

				webelement.click();

				break;
			}

		}

//			          BANK ID
		Thread.sleep(1000);
		WebElement bankiddrop = driver.findElement(By.xpath("//div[@title='Bank ID']"));
		bankiddrop.click();

		XSSFCell bankidcell = bankaccountrow.getCell(2);

		String bankidfield = bankidcell.getStringCellValue();

		Thread.sleep(1000);
		List<WebElement> bankidelement = driver.findElements(By.xpath("//li[contains(@role, 'option')]"));
		for (WebElement webelement : bankidelement) {

			if (webelement.getText().equals(bankidfield)) {

				System.out.println(bankidfield);

				webelement.click();

				break;
			}

		}

//				          BRANCH ID
		Thread.sleep(1000);
		WebElement branchiddrop = driver.findElement(By.xpath("//div[@title='Branch ID']"));
		branchiddrop.click();

		XSSFCell branchidcell = bankaccountrow.getCell(3);

		String branchidfield = branchidcell.getStringCellValue();

		Thread.sleep(1000);
		List<WebElement> branchidelement = driver.findElements(By.xpath("//li[contains(@role, 'option')]"));
		for (WebElement webelement : branchidelement) {

			if (webelement.getText().equals(branchidfield)) {

				System.out.println(branchidfield);

				webelement.click();

				break;
			}

		}

//		                 Holder Name
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@title='Account Holder Name']")).click();
		XSSFCell holdernamecell = bankaccountrow.getCell(4);
		String holdername = holdernamecell.getStringCellValue();
		System.out.println(holdername);
		driver.findElement(By.xpath("//input[@title='Account Holder Name']")).sendKeys(holdername);

//		                 Address
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@title='Address']")).click();
		XSSFCell Addresscell = bankaccountrow.getCell(5);
		String Address = Addresscell.getStringCellValue();
		System.out.println(Address);
		driver.findElement(By.xpath("//input[@title='Address']")).sendKeys(Address);

//		                 Account No.
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@title='Account No.']")).click();
		XSSFCell AccountNocell = bankaccountrow.getCell(6);
		String AccountNo = AccountNocell.getStringCellValue();
		System.out.println(AccountNo);
		driver.findElement(By.xpath("//input[@title='Account No.']")).sendKeys(AccountNo);

//		                 scroll down
		Thread.sleep(2000);
		JavascriptExecutor scrolldown = (JavascriptExecutor) driver;

		scrolldown.executeScript("window.scrollBy(0,300)");

//		                 ReAccount No.
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@title='Retype Account No.']")).click();
		XSSFCell ReAccountNocell = bankaccountrow.getCell(7);
		String ReAccountNo = ReAccountNocell.getStringCellValue();
		System.out.println(ReAccountNo);
		driver.findElement(By.xpath("//input[@title='Retype Account No.']")).sendKeys(ReAccountNo);

//	                     Date
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@placeholder='Start Date']")).click();
		XSSFCell Datecell = bankaccountrow.getCell(8);
		String Date = Datecell.getStringCellValue();
		System.out.println(Date);
		driver.findElement(By.xpath("//input[@placeholder='Start Date']")).sendKeys(Date);

//		                 Mode Of Operation
		Thread.sleep(1000);
		WebElement modeofoperationdrop = driver.findElement(By.xpath("//div[@title='Mode Of Operation']"));
		modeofoperationdrop.click();

		XSSFCell modeofoperationcell = bankaccountrow.getCell(9);

		String modeofoperationfield = modeofoperationcell.getStringCellValue();

		Thread.sleep(1000);
		List<WebElement> modeofoperationelement = driver.findElements(By.xpath("//li[contains(@role, 'option')]"));
		for (WebElement webelement : modeofoperationelement) {

			if (webelement.getText().equals(modeofoperationfield)) {

				System.out.println(modeofoperationfield);

				webelement.click();

				break;
			}

		}

//					       Is Default Account check box
		Thread.sleep(1000);
		WebElement checkbox = driver.findElement(By.xpath("(//div[@class='rz-chkbox-box'])[3]"));
		checkbox.click();

//			               scroll down
		Thread.sleep(2000);
		scrolldown.executeScript("window.scrollBy(0,300)");

//			   	           Add Button
		Thread.sleep(1000);
		WebElement ADD = driver.findElement(By.xpath("(//input[@class='btn btn-primary'])[3]"));
		ADD.click();

//			                 scroll down
		Thread.sleep(2000);
		scrolldown.executeScript("window.scrollBy(0,300)");

//			   	           Save Button
		Thread.sleep(1000);
		WebElement save = driver.findElement(By.xpath("(//input[@class='btn btn-primary'])[4]"));
		save.click();

	}

}
