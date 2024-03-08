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

public class Customer_onboarding_Address_Details {

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

//	    	  address details tab
		Thread.sleep(2000);
		WebElement addresstab = driver.findElement(By.xpath("(//span[@class='rz-tabview-title'])[2]"));
		addresstab.click();

//	          scroll down
		Thread.sleep(2000);
		JavascriptExecutor scrolldown1 = (JavascriptExecutor) driver;

		scrolldown1.executeScript("window.scrollBy(0,300)");

//	           Address proof
		Thread.sleep(1000);
		WebElement addressproofdrop = driver.findElement(By.xpath("(//div[@title='Address Proof'])[1]"));
		addressproofdrop.click();
		XSSFSheet Addressprrofsheet = wb.getSheetAt(10);
		XSSFRow addressrow = Addressprrofsheet.getRow(1);
		XSSFCell addressprrofcell = addressrow.getCell(0);

		String addressprooffield = addressprrofcell.getStringCellValue();

		Thread.sleep(1000);
		List<WebElement> industryelement = driver.findElements(By.xpath("//li[contains(@role, 'option')]"));
		for (WebElement webelement : industryelement) {

			if (webelement.getText().equals(addressprooffield)) {

				System.out.println(addressprooffield);

				webelement.click();

				break;
			}

		}

//		       line 1
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//input[@title='Line 1'])[1]")).click();
		XSSFCell address1cell = addressrow.getCell(1);
		String addressline1 = address1cell.getStringCellValue();
		System.out.println(addressline1);
		driver.findElement(By.xpath("(//input[@title='Line 1'])[1]")).sendKeys(addressline1);

//		       line 2
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//input[@title='Line 2'])[1]")).click();
		XSSFCell address2cell = addressrow.getCell(2);
		String addressline2 = address2cell.getStringCellValue();
		System.out.println(addressline2);
		driver.findElement(By.xpath("(//input[@title='Line 2'])[1]")).sendKeys(addressline2);

//		       line 3
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//input[@title='Line 3'])[1]")).click();
		XSSFCell address3cell = addressrow.getCell(3);
		String addressline3 = address3cell.getStringCellValue();
		System.out.println(addressline3);
		driver.findElement(By.xpath("(//input[@title='Line 3'])[1]")).sendKeys(addressline3);

//	           country
		Thread.sleep(1000);
		WebElement countrydrop = driver.findElement(By.xpath("(//div[@title='Country'])[1]"));
		countrydrop.click();

		XSSFCell countrycell = addressrow.getCell(4);

		String countryfield = countrycell.getStringCellValue();

		Thread.sleep(1000);
		List<WebElement> countryelement = driver.findElements(By.xpath("//li[contains(@role, 'option')]"));
		for (WebElement webelement : countryelement) {

			if (webelement.getText().equals(countryfield)) {

				System.out.println(countryfield);

				webelement.click();

				break;
			}

		}

//		       state
		Thread.sleep(1000);
		WebElement statedrop = driver.findElement(By.xpath("(//div[@title='State'])[1]"));
		statedrop.click();

		XSSFCell statecell = addressrow.getCell(5);

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

//		       district
		Thread.sleep(1000);
		WebElement districtdrop = driver.findElement(By.xpath("(//div[@title='District'])[1]"));
		districtdrop.click();

		XSSFCell districtcell = addressrow.getCell(6);

		String districtfield = districtcell.getStringCellValue();

		Thread.sleep(1000);
		List<WebElement> districtelement = driver.findElements(By.xpath("//li[contains(@role, 'option')]"));
		for (WebElement webelement : districtelement) {

			if (webelement.getText().equals(districtfield)) {

				System.out.println(districtfield);

				webelement.click();

				break;
			}

		}

//		       city
		Thread.sleep(1000);
		WebElement citydrop = driver.findElement(By.xpath("(//div[@title='City'])[1]"));
		citydrop.click();

		XSSFCell citycell = addressrow.getCell(7);

		String cityfield = citycell.getStringCellValue();

		Thread.sleep(1000);
		List<WebElement> cityelement = driver.findElements(By.xpath("//li[contains(@role, 'option')]"));
		for (WebElement webelement : cityelement) {

			if (webelement.getText().equals(cityfield)) {

				System.out.println(cityfield);

				webelement.click();

				break;
			}

		}

//		          scroll down
		Thread.sleep(2000);
		JavascriptExecutor scrolldown2 = (JavascriptExecutor) driver;

		scrolldown2.executeScript("window.scrollBy(0,300)");

//		       Pin Code
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//input[@title='Pin Code'])[1]")).click();
		XSSFCell pincodecell = addressrow.getCell(8);
		String pincode = pincodecell.getStringCellValue();
		System.out.println(pincode);
		driver.findElement(By.xpath("(//input[@title='Pin Code'])[1]")).sendKeys(pincode);

//		       To Be Verified
		Thread.sleep(1000);
		WebElement tobecheckbox = driver.findElement(By.xpath("(//div[@class='rz-chkbox-box'])[3]"));
		tobecheckbox.click();

//		       Is Communication Address
		Thread.sleep(1000);
		WebElement communicationcheckbox = driver.findElement(By.xpath("(//div[@class='rz-chkbox-box'])[3]"));
		communicationcheckbox.click();

//		       scroll down
		Thread.sleep(2000);
		JavascriptExecutor scrolldown3 = (JavascriptExecutor) driver;
		scrolldown3.executeScript("window.scrollBy(0,500)");

//		       Same as above
//		       Thread.sleep(1000);
		WebElement sameasabovecheckbox = driver.findElement(By.xpath("(//div[@class='rz-chkbox-box'])[3]"));
//		       sameasabovecheckbox.click();

////		       scroll down
//		    	  Thread.sleep(2000);
//		          JavascriptExecutor scrolldown4 = (JavascriptExecutor) driver;
//		          scrolldown4.executeScript("window.scrollBy(0,300)");

		if (sameasabovecheckbox.isEnabled()) {

			WebElement save = driver.findElement(By.xpath("(//input[@value='Save and Proceed'])[2]"));
			save.click();
		} else {

//		           Address proof
			Thread.sleep(1000);
			WebElement regaddressproofdrop = driver.findElement(By.xpath("(//div[@title='Address Proof'])[2]"));
			regaddressproofdrop.click();
			XSSFCell regaddressprrofcell = addressrow.getCell(9);

			String regaddressprooffield = regaddressprrofcell.getStringCellValue();

			Thread.sleep(1000);
			List<WebElement> regaddresselement = driver.findElements(By.xpath("//li[contains(@role, 'option')]"));
			for (WebElement webelement : regaddresselement) {

				if (webelement.getText().equals(regaddressprooffield)) {

					System.out.println(regaddressprooffield);

					webelement.click();

					break;
				}

			}

//			       line 1
			Thread.sleep(1000);
			driver.findElement(By.xpath("(//input[@title='Line 1'])[2]")).click();
			XSSFCell regaddress1cell = addressrow.getCell(10);
			String regaddressline1 = regaddress1cell.getStringCellValue();
			System.out.println(regaddressline1);
			driver.findElement(By.xpath("(//input[@title='Line 1'])[2]")).sendKeys(regaddressline1);

//			       line 2
			Thread.sleep(1000);
			driver.findElement(By.xpath("(//input[@title='Line 2'])[2]")).click();
			XSSFCell regaddress2cell = addressrow.getCell(11);
			String regaddressline2 = regaddress2cell.getStringCellValue();
			System.out.println(regaddressline2);
			driver.findElement(By.xpath("(//input[@title='Line 2'])[2]")).sendKeys(regaddressline2);

//			       line 3
			Thread.sleep(1000);
			driver.findElement(By.xpath("(//input[@title='Line 3'])[2]")).click();
			XSSFCell regaddress3cell = addressrow.getCell(12);
			String regaddressline3 = regaddress3cell.getStringCellValue();
			System.out.println(regaddressline3);
			driver.findElement(By.xpath("(//input[@title='Line 3'])[2]")).sendKeys(regaddressline3);

//		           country
			Thread.sleep(1000);
			WebElement regcountrydrop = driver.findElement(By.xpath("(//div[@title='Country'])[2]"));
			regcountrydrop.click();

			XSSFCell regcountrycell = addressrow.getCell(13);

			String regcountryfield = regcountrycell.getStringCellValue();

			Thread.sleep(1000);
			List<WebElement> regcountryelement = driver.findElements(By.xpath("//li[contains(@role, 'option')]"));
			for (WebElement webelement : regcountryelement) {

				if (webelement.getText().equals(regcountryfield)) {

					System.out.println(regcountryfield);

					webelement.click();

					break;
				}

			}

//			       state
			Thread.sleep(1000);
			WebElement regstatedrop = driver.findElement(By.xpath("(//div[@title='State'])[2]"));
			regstatedrop.click();

			XSSFCell regstatecell = addressrow.getCell(14);

			String regstatefield = regstatecell.getStringCellValue();

			Thread.sleep(1000);
			List<WebElement> regstateelement = driver.findElements(By.xpath("//li[contains(@role, 'option')]"));
			for (WebElement webelement : regstateelement) {

				if (webelement.getText().equals(regstatefield)) {

					System.out.println(regstatefield);

					webelement.click();

					break;
				}

			}

//			       district
			Thread.sleep(1000);
			WebElement regdistrictdrop = driver.findElement(By.xpath("(//div[@title='District'])[2]"));
			regdistrictdrop.click();

			XSSFCell regdistrictcell = addressrow.getCell(15);

			String regdistrictfield = regdistrictcell.getStringCellValue();

			Thread.sleep(1000);
			List<WebElement> regdistrictelement = driver.findElements(By.xpath("//li[contains(@role, 'option')]"));
			for (WebElement webelement : regdistrictelement) {

				if (webelement.getText().equals(regdistrictfield)) {

					System.out.println(regdistrictfield);

					webelement.click();

					break;
				}

			}

//			       city
			Thread.sleep(1000);
			WebElement regcitydrop = driver.findElement(By.xpath("(//div[@title='City'])[2]"));
			regcitydrop.click();

			XSSFCell regcitycell = addressrow.getCell(16);

			String regcityfield = regcitycell.getStringCellValue();

			Thread.sleep(1000);
			List<WebElement> regcityelement = driver.findElements(By.xpath("//li[contains(@role, 'option')]"));
			for (WebElement webelement : regcityelement) {

				if (webelement.getText().equals(regcityfield)) {

					System.out.println(regcityfield);

					webelement.click();

					break;
				}

			}

//			          scroll down
			Thread.sleep(2000);
			JavascriptExecutor regscrolldown2 = (JavascriptExecutor) driver;

			regscrolldown2.executeScript("window.scrollBy(0,300)");

//			       Pin Code
			Thread.sleep(1000);
			driver.findElement(By.xpath("(//input[@title='Pin Code'])[2]")).click();
			XSSFCell regpincodecell = addressrow.getCell(17);
			String regpincode = regpincodecell.getStringCellValue();
			System.out.println(regpincode);
			driver.findElement(By.xpath("(//input[@title='Pin Code'])[2]")).sendKeys(regpincode);
//		    	   
//		    	   
		}

//		       WebElement saveandproceed = driver.findElement(By.xpath("(//input[@value='Save and Proceed'])[2]"));
//		       saveandproceed.click();

	}

}
