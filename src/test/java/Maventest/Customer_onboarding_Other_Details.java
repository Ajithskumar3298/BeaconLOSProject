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

public class Customer_onboarding_Other_Details {

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

		Thread.sleep(3000);
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

//			  scroll down
		Thread.sleep(2000);
		JavascriptExecutor scroll = (JavascriptExecutor) driver;

		scroll.executeScript("window.scrollBy(0,350)");

//		      applicant
		Thread.sleep(2000);
		WebElement applicant = driver.findElement(By.xpath("(//a[@class='inboxlist  '])[10]"));
		applicant.click();

//		      scroll up
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

//	    	  Other Details Tab
		Thread.sleep(2000);
		WebElement Otherdetailstab = driver.findElement(By.xpath("(//span[@class='rz-tabview-title'])[6]"));
		Otherdetailstab.click();

//	          scroll down
		Thread.sleep(2000);
		JavascriptExecutor scrolldown1 = (JavascriptExecutor) driver;

		scrolldown1.executeScript("window.scrollBy(0,300)");

//	          Full Name
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@title='Full Name']")).click();
		XSSFSheet OTHERDETAILS = wb.getSheetAt(12);
		XSSFRow OTHERDETAILSrow = OTHERDETAILS.getRow(1);
		XSSFCell holdernamecell = OTHERDETAILSrow.getCell(0);
		String Fullname = holdernamecell.getStringCellValue();
		System.out.println(Fullname);
		driver.findElement(By.xpath("//input[@title='Full Name']")).sendKeys(Fullname);

//	          Father Name
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@title='Father / Spouse Name']")).click();
		XSSFCell fathernamecell = OTHERDETAILSrow.getCell(1);
		String Fathername = fathernamecell.getStringCellValue();
		System.out.println(Fathername);
		driver.findElement(By.xpath("//input[@title='Father / Spouse Name']")).sendKeys(Fathername);

//	          Pan number
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//input[@title='PAN'])[3]")).click();
		XSSFCell pancell = OTHERDETAILSrow.getCell(2);
		String pannumber = pancell.getStringCellValue();
		System.out.println(pannumber);
		driver.findElement(By.xpath("(//input[@title='PAN'])[3]")).sendKeys(pannumber);

//	          Aadhaar number
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@title='Aadhaar No']")).click();
		XSSFCell aadharcell = OTHERDETAILSrow.getCell(3);
		String aadhaar = aadharcell.getStringCellValue();
		System.out.println(aadhaar);
		driver.findElement(By.xpath("//input[@title='Aadhaar No']")).sendKeys(aadhaar);

//	          scroll down
		Thread.sleep(2000);

		scrolldown1.executeScript("window.scrollBy(0,300)");

//	          Date Of Birth
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@name='DateOfBirth']")).click();
		XSSFCell dobcell = OTHERDETAILSrow.getCell(4);
		String dob = dobcell.getStringCellValue();
		System.out.println(dob);
		driver.findElement(By.xpath("//input[@name='DateOfBirth']")).sendKeys(dob);

//	          DIN No.
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@name='DINNo']")).click();
		XSSFCell Dinnocell = OTHERDETAILSrow.getCell(5);
		String Dinnumber = Dinnocell.getStringCellValue();
		System.out.println(Dinnumber);
		driver.findElement(By.xpath("//input[@name='DINNo']")).sendKeys(Dinnumber);

//	          Address Line 1
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@title='Address Line 1']")).click();
		XSSFCell Address1cell = OTHERDETAILSrow.getCell(6);
		String Address1 = Address1cell.getStringCellValue();
		System.out.println(Address1);
		driver.findElement(By.xpath("//input[@title='Address Line 1']")).sendKeys(Address1);

//	          scroll down
		Thread.sleep(2000);

		scrolldown1.executeScript("window.scrollBy(0,300)");

//	          Address Line 2
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@title='Address Line 2']")).click();
		XSSFCell Address2cell = OTHERDETAILSrow.getCell(7);
		String Address2 = Address2cell.getStringCellValue();
		System.out.println(Address2);
		driver.findElement(By.xpath("//input[@title='Address Line 2']")).sendKeys(Address2);

//	          Landmark
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@title='Landmark']")).click();
		XSSFCell Landmarkcell = OTHERDETAILSrow.getCell(8);
		String Landmark = Landmarkcell.getStringCellValue();
		System.out.println(Landmark);
		driver.findElement(By.xpath("//input[@title='Landmark']")).sendKeys(Landmark);

//	           country
		Thread.sleep(1000);
		WebElement countrydrop = driver.findElement(By.xpath("//div[@title='Country']"));
		countrydrop.click();

		XSSFCell countrycell = OTHERDETAILSrow.getCell(9);

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
		WebElement statedrop = driver.findElement(By.xpath("//div[@title='State']"));
		statedrop.click();

		XSSFCell statecell = OTHERDETAILSrow.getCell(10);

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

//		          scroll down
		Thread.sleep(2000);

		scrolldown1.executeScript("window.scrollBy(0,300)");

//		       district
		Thread.sleep(1000);
		WebElement districtdrop = driver.findElement(By.xpath("//div[@title='District']"));
		districtdrop.click();

		XSSFCell districtcell = OTHERDETAILSrow.getCell(11);

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
		WebElement citydrop = driver.findElement(By.xpath("//div[@title='City']"));
		citydrop.click();

		XSSFCell citycell = OTHERDETAILSrow.getCell(12);

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

//		       Pin Code
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@name='Pincode']")).click();
		XSSFCell pincodecell = OTHERDETAILSrow.getCell(13);
		String pincode = pincodecell.getStringCellValue();
		System.out.println(pincode);
		driver.findElement(By.xpath("//input[@name='Pincode']")).sendKeys(pincode);

//		       Gender
		Thread.sleep(1000);
		WebElement Genderdrop = driver.findElement(By.xpath("(//div[@title='Gender'])[2]"));
		Genderdrop.click();

		XSSFCell Gendercell = OTHERDETAILSrow.getCell(14);

		String Genderfield = Gendercell.getStringCellValue();

		Thread.sleep(1000);
		List<WebElement> Genderelement = driver.findElements(By.xpath("//li[contains(@role, 'option')]"));
		for (WebElement webelement : Genderelement) {

			if (webelement.getText().equals(Genderfield)) {

				System.out.println(Genderfield);

				webelement.click();

				break;
			}

		}

//		          scroll down
		Thread.sleep(2000);

		scrolldown1.executeScript("window.scrollBy(0,300)");

//		       Designation
		Thread.sleep(1000);
		WebElement Designationdrop = driver.findElement(By.xpath("//div[@title='Designation / Relation with Entity']"));
		Designationdrop.click();

		XSSFCell Designationcell = OTHERDETAILSrow.getCell(15);

		String Designationfield = Designationcell.getStringCellValue();

		Thread.sleep(1000);
		List<WebElement> Designationelement = driver.findElements(By.xpath("//li[contains(@role, 'option')]"));
		for (WebElement webelement : Designationelement) {

			if (webelement.getText().equals(Designationfield)) {

				System.out.println(Designationfield);

				webelement.click();

				break;
			}

		}

//		       Category
		Thread.sleep(1000);
		WebElement Categorydrop = driver.findElement(By.xpath("//div[@title='Category']"));
		Categorydrop.click();

		XSSFCell Categorycell = OTHERDETAILSrow.getCell(16);

		String Categoryfield = Categorycell.getStringCellValue();

		Thread.sleep(1000);
		List<WebElement> Categoryelement = driver.findElements(By.xpath("//li[contains(@role, 'option')]"));
		for (WebElement webelement : Categoryelement) {

			if (webelement.getText().equals(Categoryfield)) {

				System.out.println(Categoryfield);

				webelement.click();

				break;
			}

		}

//		       Mobile No.
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//input[@title='Mobile No.'])[2]")).click();
		XSSFCell MobileNocell = OTHERDETAILSrow.getCell(17);
		String MobileNo = MobileNocell.getStringCellValue();
		System.out.println(MobileNo);
		driver.findElement(By.xpath("(//input[@title='Mobile No.'])[2]")).sendKeys(MobileNo);

//		       Profit Sharing
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@name='Shareholding']")).click();
		XSSFCell ProfitSharingcell = OTHERDETAILSrow.getCell(18);
		String ProfitSharing = ProfitSharingcell.getStringCellValue();
		System.out.println(ProfitSharing);
		driver.findElement(By.xpath("//input[@name='Shareholding']")).sendKeys(ProfitSharing);

//		          scroll down
		Thread.sleep(2000);

		scrolldown1.executeScript("window.scrollBy(0,300)");

//		       Academic Qualification
		Thread.sleep(1000);
		WebElement AcademicQualificationdrop = driver.findElement(By.xpath("//div[@title='Academic Qualification']"));
		AcademicQualificationdrop.click();

		XSSFCell AcademicQualificationcell = OTHERDETAILSrow.getCell(19);

		String AcademicQualificationfield = AcademicQualificationcell.getStringCellValue();

		Thread.sleep(1000);
		List<WebElement> AcademicQualificationelement = driver
				.findElements(By.xpath("//li[contains(@role, 'option')]"));
		for (WebElement webelement : AcademicQualificationelement) {

			if (webelement.getText().equals(AcademicQualificationfield)) {

				System.out.println(AcademicQualificationfield);

				webelement.click();

				break;
			}

		}

//		       Experience
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@name='Experience']")).click();
		XSSFCell Experiencecell = OTHERDETAILSrow.getCell(20);
		String Experience = Experiencecell.getStringCellValue();
		System.out.println(Experience);
		driver.findElement(By.xpath("//input[@placeholder='Experience In The Line Of Activity (Years)']"))
				.sendKeys(Experience);

//		       Politically Exposed
		Thread.sleep(1000);
		WebElement PoliticallyExposeddrop = driver.findElement(By.xpath("//div[@title='Politically Exposed']"));
		PoliticallyExposeddrop.click();

		XSSFCell PoliticallyExposedcell = OTHERDETAILSrow.getCell(21);

		String PoliticallyExposedfield = PoliticallyExposedcell.getStringCellValue();

		Thread.sleep(1000);
		List<WebElement> PoliticallyExposedelement = driver.findElements(By.xpath("//li[contains(@role, 'option')]"));
		for (WebElement webelement : PoliticallyExposedelement) {

			if (webelement.getText().equals(PoliticallyExposedfield)) {

				System.out.println(PoliticallyExposedfield);

				webelement.click();

				break;
			}

		}

//		       scroll down
		Thread.sleep(2000);

		scrolldown1.executeScript("window.scrollBy(0,250)");

//	          Add
		Thread.sleep(1000);
		WebElement add = driver.findElement(By.xpath("(//input[@class='btn btn-primary '])[1]"));
		add.click();

//		       scroll right
		Thread.sleep(2000);
		WebElement otherdetailsgridscroll = driver.findElement(By.xpath("(//div[@class='rz-data-grid-data'])[2]"));

		((JavascriptExecutor) driver).executeScript("arguments[0].scrollLeft += 750;", otherdetailsgridscroll);

//		       scroll down
		Thread.sleep(2000);

		scrolldown1.executeScript("window.scrollBy(0,250)");

//		       Save and Proceed
		Thread.sleep(1000);
		WebElement saveandproceed = driver.findElement(By.xpath("(//input[@class='btn btn-primary '])[2]"));
		saveandproceed.click();

	}

}
