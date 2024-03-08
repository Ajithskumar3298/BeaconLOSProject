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

public class Customer_onboarding_Institution {

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

//			      applicant selection
//			      XSSFSheet institutiondetails=  wb.getSheetAt(9);
//			      XSSFRow institutionrow = institutiondetails.getRow(1);
//			      XSSFCell institutioncolumn=institutionrow.getCell(0);
//
//			      String gototimeline=institutioncolumn.getStringCellValue();
//			      
//			      Thread.sleep(2000);
//			      List<WebElement>losnumber=driver.findElements(By.xpath("//a[@class='inboxlist']"));
//
//		          for (WebElement webElement : losnumber) {
//		        	  
//		               
//		                 if(webElement.getText().trim().contains(gototimeline)) {
//
//		                     System.out.println(gototimeline);
//
//		                     webElement.click();
//
//		                     break;
//		                 }
//		            }

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
//	    	  )
//	    	  scroll down
		Thread.sleep(2000);
		JavascriptExecutor scrolldown = (JavascriptExecutor) driver;

		scrolldown.executeScript("window.scrollBy(0,300)");

//	          Trading Name
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@title='Trading Name']")).click();
		XSSFSheet institutiondetails = wb.getSheetAt(9);
		XSSFRow institutionrow = institutiondetails.getRow(1);
		XSSFCell tradenamecell = institutionrow.getCell(1);

		String TradingName = tradenamecell.getStringCellValue();

		System.out.println(TradingName);

		driver.findElement(By.xpath("//input[@title='Trading Name']")).sendKeys(TradingName);

//		       BusinessType
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@title='BusinessType']")).click();
		XSSFCell Businesstypecell = institutionrow.getCell(2);

		String BusinessType = Businesstypecell.getStringCellValue();

		System.out.println(BusinessType);

		driver.findElement(By.xpath("//input[@title='BusinessType']")).sendKeys(BusinessType);

//		       scroll down
		Thread.sleep(2000);
		JavascriptExecutor scrolldown1 = (JavascriptExecutor) driver;

		scrolldown1.executeScript("window.scrollBy(0,300)");

////		       Entity Type
//	           Thread.sleep(1000);
//	           WebElement entitydrop =driver.findElement(By.xpath("(//label[@class='rz-dropdown-label rz-inputtext  rz-placeholder'])[2]"));
//	           entitydrop.click();
//	           
//	           Thread.sleep(1000);
//		       XSSFCell Entitytypecell = institutionrow.getCell(3);
//			      
//		       String EntityType =  Entitytypecell.getStringCellValue();
//		      
//		       Thread.sleep(1000);
//		       List<WebElement> entityelement = driver.findElements(By.xpath(".//*[@_bl_447='']/li"));
//		       for(WebElement webelement : entityelement  ) {
//		    	   
//		    	   if(webelement.getText().trim().equals(EntityType)) {
//
////	                 System.out.println(Tenuremode);
//
//		    		   webelement.click();
//
//	                 break;
//	             }
//		    	   
//		       }

//		       Industry
		Thread.sleep(1000);
		WebElement industrydrop = driver
				.findElement(By.xpath("(//label[@class='rz-dropdown-label rz-inputtext  rz-placeholder'])[1]"));
		industrydrop.click();

		XSSFCell industrycell = institutionrow.getCell(4);

		String industryfield = industrycell.getStringCellValue();

		Thread.sleep(1000);
		List<WebElement> industryelement = driver.findElements(By.xpath("//li[contains(@role, 'option')]"));
		for (WebElement webelement : industryelement) {

			if (webelement.getText().trim().equals(industryfield)) {

				System.out.println(industryfield);

				webelement.click();

				break;
			}

		}

//		       Sub Industry
		Thread.sleep(1000);
		WebElement subindustrydrop = driver
				.findElement(By.xpath("(//label[@class='rz-dropdown-label rz-inputtext  rz-placeholder'])[1]"));
		subindustrydrop.click();

		Thread.sleep(1000);
		XSSFCell subindustrycell = institutionrow.getCell(5);

		String subindustry = subindustrycell.getStringCellValue();

		Thread.sleep(1000);
		List<WebElement> subindustryelement = driver.findElements(By.xpath("//li[contains(@role, 'option')]"));
		for (WebElement webelement : subindustryelement) {

			if (webelement.getText().trim().equals(subindustry)) {

//	                 System.out.println(Tenuremode);

				webelement.click();

				break;
			}

		}

//		       Business Premises
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@title='Business Premises']")).click();
		XSSFCell Businesspremiscell = institutionrow.getCell(6);

		String Businesspremis = Businesspremiscell.getStringCellValue();

		System.out.println(Businesspremis);

		driver.findElement(By.xpath("//input[@title='Business Premises']")).sendKeys(Businesspremis);

//		       scroll down
		Thread.sleep(2000);
		JavascriptExecutor scrolldow = (JavascriptExecutor) driver;

		scrolldow.executeScript("window.scrollBy(0,300)");

//		          String doimonth = "March";
//		          String doiyear = "2019";
//		          String doiday = "25";
//		          
////		          DOI
//		          Thread.sleep(2000);
//		          driver.findElement(By.xpath("(//span[@class='rz-button-icon-left  rzi rzi-calendar'])[1]")).click();
//		          
////		          Month
//		          Thread.sleep(2000);
//		          driver.findElement(By.xpath("(//div[@class='rz-dropdown'])[10]")).click();
//		          
//		          List<WebElement> doimonths = driver.findElements(By.xpath("//li[contains(@role, 'option')]"));
//			       for(WebElement webelement : doimonths  ) {
//			    	   
//			    	   if(webelement.getText().trim().equals(doimonth)) {
//
//		                 System.out.println(doimonth);
//
//			    		   webelement.click();
//
//		                 break;
//		             }
//			    	   
//			       }
//			       
////			       Year
//			       Thread.sleep(2000);
//			       driver.findElement(By.xpath("(//div[@class='rz-dropdown'])[11]")).click();
//			          
//			          List<WebElement> doiyears = driver.findElements(By.xpath("//li[contains(@role, 'option')]"));
//				       for(WebElement webelement : doiyears  ) {
//				    	   
//				    	   if(webelement.getText().trim().equals(doiyear)) {
//
//			                 System.out.println(doiyear);
//
//				    		   webelement.click();
//
//			                 break;
//			             }
//				    	   
//				       }
//				       
////				       Day
//				       Thread.sleep(2000);
//				       driver.findElement(By.xpath("/html/body/div[9]/div/div[2]/table/tbody/tr/td/span[contains(text(),"+doiday+")]")).click();

//		       date of incorp

//		       Thread.sleep(1000);
//		       driver.findElement(By.xpath("//input[@placeholder='Date Of Incorporation']")).click();
//		       XSSFCell dateofinccell = institutionrow.getCell(7);
//		       String dateoficorp =  dateofinccell.getStringCellValue();
//		       System.out.println(dateofinccell);
//		       driver.findElement(By.xpath("//input[@placeholder='Date Of Incorporation']")).sendKeys(dateoficorp);

//		       business vintage
//		       Thread.sleep(1000);
//		       driver.findElement(By.xpath("//input[@title='Business Vintage(In Months)']")).click();
//		       XSSFCell businessvincell = institutionrow.getCell(8);
//		       String businessvintage =  businessvincell.getStringCellValue();
//		       System.out.println(businessvintage);
//		       driver.findElement(By.xpath("//input[@title='Business Vintage(In Months)']")).sendKeys(businessvintage);

//		       scroll down
//		    	  Thread.sleep(2000);
//		          JavascriptExecutor scrolldown2 = (JavascriptExecutor) driver;
//
//		          scrolldown2.executeScript("window.scrollBy(0,300)");
////		       place of incorp
//		       Thread.sleep(1000);
//		       driver.findElement(By.xpath("//input[@title='Place Of Incorporation']")).click();
//		       XSSFCell placeofincocell = institutionrow.getCell(8);
//		       String placeofincorp =  placeofincocell.getStringCellValue();
//		       System.out.println(placeofincorp);
//		       driver.findElement(By.xpath("//input[@title='Place Of Incorporation']")).sendKeys(placeofincorp);
//		       
////		       Date Of Commencement 
//		       Thread.sleep(1000);
//		       driver.findElement(By.xpath("//input[@placeholder='Date Of Commencement Of Business']")).click();
//		       XSSFCell dateofcommencecell = institutionrow.getCell(9);
//		       String dateofcommence =  dateofcommencecell.getStringCellValue();
//		       System.out.println(dateofcommence);
//		       driver.findElement(By.xpath("//input[@placeholder='Date Of Commencement Of Business']")).sendKeys(dateofcommence);
//		       
////		       Date Of business 
//		       Thread.sleep(1000);
//		       driver.findElement(By.xpath("//input[@placeholder='Doing Business Since']")).click();
//		       XSSFCell dateofbuscell = institutionrow.getCell(10);
//		       String dateofbusiness =  dateofbuscell.getStringCellValue();
//		       System.out.println(dateofbusiness);
//		       driver.findElement(By.xpath("//input[@placeholder='Doing Business Since']")).sendKeys(dateofbusiness);
//		       
////		       scroll down
//		    	  Thread.sleep(2000);
//		          JavascriptExecutor scrolldown3 = (JavascriptExecutor) driver;
//
//		          scrolldown3.executeScript("window.scrollBy(0,300)");
//		       
////		       Tax residency
//		       Thread.sleep(1000);
//	           WebElement taxresidencydrop =driver.findElement(By.xpath("(//label[@class='rz-dropdown-label rz-inputtext  rz-placeholder'])[1]"));
//	           taxresidencydrop.click();
//	           
//	           Thread.sleep(1000);
//		       XSSFCell taxrecedencycell = institutionrow.getCell(11);
//			      
//		       String taxresidency =  taxrecedencycell.getStringCellValue();
//		      
//		       Thread.sleep(1000);
//		       List<WebElement> taxresidencydata = driver.findElements(By.xpath("//li[contains(@role, 'option')]"));
//		       for(WebElement webelement : taxresidencydata  ) {
//		    	   
//		    	   if(webelement.getText().trim().equals(taxresidency)) {
//
////	                 System.out.println(Tenuremode);
//
//		    		   webelement.click();
//
//	                 break;
//	             }  
//		       }
//		       
////		       pan number
//		       Thread.sleep(1000);
//		       driver.findElement(By.xpath("//input[@title='PAN']")).click();
//		       XSSFCell pannumcell = institutionrow.getCell(12);
//		       String pannumber =  pannumcell.getStringCellValue();
//		       System.out.println(pannumber);
//		       driver.findElement(By.xpath("//input[@title='PAN']")).sendKeys(pannumber);
//		       
////		       scroll down
//		    	  Thread.sleep(2000);
//		          JavascriptExecutor scrolldown4 = (JavascriptExecutor) driver;
//
//		          scrolldown4.executeScript("window.scrollBy(0,300)");
//		       
////		       mobile number
//		       Thread.sleep(1000);
//		       driver.findElement(By.xpath("//input[@title='Mobile No.']")).click();
//		       XSSFCell mobilenumcell = institutionrow.getCell(13);
//		       String mobilenumber =  mobilenumcell.getStringCellValue();
//		       System.out.println(mobilenumber);
//		       driver.findElement(By.xpath("//input[@title='Mobile No.']")).sendKeys(mobilenumber);
//		       
////		       scroll down
//		    	  Thread.sleep(2000);
//		          JavascriptExecutor scrolldown5 = (JavascriptExecutor) driver;
//
//		          scrolldown5.executeScript("window.scrollBy(0,450)");
//
//		       
////		       email id
//		       Thread.sleep(1000);
//		       driver.findElement(By.xpath("//input[@title='Email ID']")).click();
//		       XSSFCell emailidcell = institutionrow.getCell(14);
//		       String emailid =  emailidcell.getStringCellValue();
//		       System.out.println(emailid);
//		       driver.findElement(By.xpath("//input[@title='Email ID']")).sendKeys(emailid);
//		       
////		       udayam
//		       Thread.sleep(1000);
//		       driver.findElement(By.xpath("//input[@title='UDYAM Reg No.']")).click();
//		       XSSFCell udayamcell = institutionrow.getCell(15);
//		       String udayamnumber =  udayamcell.getStringCellValue();
//		       System.out.println(udayamnumber);
//		       driver.findElement(By.xpath("//input[@title='UDYAM Reg No.']")).sendKeys(udayamnumber);
//		       
////		       status
//		       Thread.sleep(1000);
//	           WebElement statusdrop =driver.findElement(By.xpath("(//label[@class='rz-dropdown-label rz-inputtext  rz-placeholder'])[1]"));
//	           statusdrop.click();
//	           
//	           Thread.sleep(1000);
//		       XSSFCell statuscell = institutionrow.getCell(16);
//			      
//		       String status =  statuscell.getStringCellValue();
//		      
//		       Thread.sleep(1000);
//		       List<WebElement> statusdata = driver.findElements(By.xpath("//li[contains(@role, 'option')]"));
//		       for(WebElement webelement : statusdata  ) {
//		    	   
//		    	   if(webelement.getText().trim().equals(status)) {
//
////	                 System.out.println(Tenuremode);
//
//		    		   webelement.click();
//
//	                 break;
//	             }  
//		       }
//		       
////		       Registration No
//		       Thread.sleep(1000);
//		       driver.findElement(By.xpath("//input[@title='Registration No.']")).click();
//		       XSSFCell regnocell = institutionrow.getCell(17);
//		       String regnumber =  regnocell.getStringCellValue();
//		       System.out.println(regnumber);
//		       driver.findElement(By.xpath("//input[@title='Registration No.']")).sendKeys(regnumber);
//		       
////		       scroll down
//		    	  Thread.sleep(2000);
//		          JavascriptExecutor scrolldown6 = (JavascriptExecutor) driver;
//
//		          scrolldown6.executeScript("window.scrollBy(0,500)");
//		       
////		       Tan N0
//		       Thread.sleep(1000);
//		       driver.findElement(By.xpath("//input[@title='TAN']")).click();
//		       XSSFCell tannocell = institutionrow.getCell(18);
//		       String tannumber =  tannocell.getStringCellValue();
//		       System.out.println(tannumber);
//		       driver.findElement(By.xpath("//input[@title='TAN']")).sendKeys(tannumber);
//		       
////		       Tin N0
//		       Thread.sleep(1000);
//		       driver.findElement(By.xpath("//input[@title='TIN']")).click();
//		       XSSFCell tinnocell = institutionrow.getCell(19);
//		       String tinnumber =  tinnocell.getStringCellValue();
//		       System.out.println(tinnumber);
//		       driver.findElement(By.xpath("//input[@title='TIN']")).sendKeys(tinnumber);
//		       
////		       scroll down
//		    	  Thread.sleep(2000);
//		          JavascriptExecutor scrolldown7 = (JavascriptExecutor) driver;
//
//		          scrolldown7.executeScript("window.scrollBy(0,500)");
//		       
////		       gst applicable
//		       Thread.sleep(1000);
//	           WebElement gstapplicabledrop =driver.findElement(By.xpath("(//label[@class='rz-dropdown-label rz-inputtext  rz-placeholder'])[1]"));
//	           gstapplicabledrop.click();
//	           
//	           Thread.sleep(1000);
//		       XSSFCell gstapplicablecell = institutionrow.getCell(20);
//			      
//		       String gstapplicable =  gstapplicablecell.getStringCellValue();
//		      
//		       Thread.sleep(1000);
//		       List<WebElement> gstapplidata = driver.findElements(By.xpath("//li[contains(@role, 'option')]"));
//		       for(WebElement webelement : gstapplidata  ) {
//		    	   
//		    	   if(webelement.getText().trim().equals(gstapplicable)) {
//
////	                 System.out.println(Tenuremode);
//
//		    		   webelement.click();
//
//	                 break;
//	             }  
//		       }
//		       
////		       GSTR No.
//		       Thread.sleep(1000);
//		       driver.findElement(By.xpath("//input[@title='GSTR No.']")).click();
//		       XSSFCell gstrnocell = institutionrow.getCell(21);
//		       String gstrnumber =  gstrnocell.getStringCellValue();
//		       System.out.println(gstrnumber);
//		       driver.findElement(By.xpath("//input[@title='GSTR No.']")).sendKeys(gstrnumber);
//		       
////		       scroll down
//		    	  Thread.sleep(2000);
//		          JavascriptExecutor scrolldown8 = (JavascriptExecutor) driver;
//
//		          scrolldown8.executeScript("window.scrollBy(0,500)");
//		       
////		       Shop And Establishment Licence
//		       Thread.sleep(1000);
//		       driver.findElement(By.xpath("//input[@title='Shop And Establishment Licence']")).click();
//		       XSSFCell shopandestcell = institutionrow.getCell(22);
//		       String shopandestnumber =  shopandestcell.getStringCellValue();
//		       System.out.println(shopandestnumber);
//		       driver.findElement(By.xpath("//input[@title='Shop And Establishment Licence']")).sendKeys(shopandestnumber);
//		       
////		       Office Stability
//		       Thread.sleep(1000);
//		       driver.findElement(By.xpath("//input[@title='Office Stability']")).click();
//		       XSSFCell officestablecell = institutionrow.getCell(23);
//		       String officestability =  officestablecell.getStringCellValue();
//		       System.out.println(officestability);
//		       driver.findElement(By.xpath("//input[@title='Office Stability']")).sendKeys(officestability);
//		       
////		       Commercial Credit Score
//		       Thread.sleep(1000);
//		       driver.findElement(By.xpath("//input[@title='Commercial Credit Score']")).click();
//		       XSSFCell comercreditcell = institutionrow.getCell(24);
//		       String comcredit =  comercreditcell.getStringCellValue();
//		       System.out.println(comcredit);
//		       driver.findElement(By.xpath("//input[@title='Commercial Credit Score']")).sendKeys(comcredit);
//		       
////		       scroll down
//		    	  Thread.sleep(2000);
//		          JavascriptExecutor scrolldown9 = (JavascriptExecutor) driver;
//
//		          scrolldown9.executeScript("window.scrollBy(0,500)");
//		       
////		       Risk ID
//		       Thread.sleep(1000);
//	           WebElement riskiddrop =driver.findElement(By.xpath("(//label[@class='rz-dropdown-label rz-inputtext  rz-placeholder'])[1]"));
//	           riskiddrop.click();
//	           
//	           Thread.sleep(1000);
//		       XSSFCell riskidcell = institutionrow.getCell(25);
//			      
//		       String riskid =  riskidcell.getStringCellValue();
//		      
//		       Thread.sleep(1000);
//		       List<WebElement> riskiddata = driver.findElements(By.xpath("//li[contains(@role, 'option')]"));
//		       for(WebElement webelement : riskiddata  ) {
//		    	   
//		    	   if(webelement.getText().trim().equals(riskid)) {
//
////	                 System.out.println(Tenuremode);
//
//		    		   webelement.click();
//
//	                 break;
//	             }  
//		       }
//		       
////		       Remarks
//		       Thread.sleep(1000);
//		       driver.findElement(By.xpath("//input[@title='Remarks']")).click();
//		       XSSFCell remarkscell = institutionrow.getCell(26);
//		       String remarks =  remarkscell.getStringCellValue();
//		       System.out.println(remarks);
//		       driver.findElement(By.xpath("//input[@title='Remarks']")).sendKeys(remarks);
//		       
////		       Active Special Instruction
//		       Thread.sleep(1000);
//		       driver.findElement(By.xpath("//input[@title='Active Special Instruction']")).click();
//		       XSSFCell activespcell = institutionrow.getCell(27);
//		       String activespecial =  activespcell.getStringCellValue();
//		       System.out.println(activespecial);
//		       driver.findElement(By.xpath("//input[@title='Active Special Instruction']")).sendKeys(activespecial);
//
////		       Suspecious
//		       Thread.sleep(1000);
//	           WebElement Suspeciousdrop =driver.findElement(By.xpath("(//label[@class='rz-dropdown-label rz-inputtext  rz-placeholder'])[1]"));
//	           Suspeciousdrop.click();
//	           
//	           Thread.sleep(1000);
//		       XSSFCell Suspeciouscell = institutionrow.getCell(28);
//			      
//		       String Suspecious =  Suspeciouscell.getStringCellValue();
//		      
//		       Thread.sleep(1000);
//		       List<WebElement> Suspeciousdata = driver.findElements(By.xpath("//li[contains(@role, 'option')]"));
//		       for(WebElement webelement : Suspeciousdata  ) {
//		    	   
//		    	   if(webelement.getText().trim().equals(Suspecious)) {
//
////	                 System.out.println(Tenuremode);
//
//		    		   webelement.click();
//
//	                 break;
//	             }  
//		       }
//		       
////		       scroll down
//		    	  Thread.sleep(2000);
//		          JavascriptExecutor scrolldown10 = (JavascriptExecutor) driver;
//
//		          scrolldown10.executeScript("window.scrollBy(0,500)");
//		       
////		       save and proceed
//		       Thread.sleep(2000);
//		       WebElement saveandproceed = driver.findElement(By.xpath("(//input[@value='Save and Proceed'])[1]"));
//		       saveandproceed.click();
//		       

//	    	     Thread.sleep(6000);
//	    	     driver.quit();
	}

}
