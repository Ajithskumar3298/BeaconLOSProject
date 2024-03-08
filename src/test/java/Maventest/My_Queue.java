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

public class My_Queue {

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

//		expander
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//span[@class='material-symbols-outlined'])[1]")).click();

//		inbox
		Thread.sleep(1000);
		WebElement inbox = driver.findElement(By.xpath("(//a[@id='dropdownMenuButton1'])[4]"));
		inbox.click();

//		    	     My queue button
		Thread.sleep(2000);
		WebElement myqueuebutton = driver.findElement(By.xpath("(//span[@class='material-symbols-outlined'])[12]"));
		myqueuebutton.click();

//		    	     expander close
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/div[1]/div[2]/body/div/div/nav/span/i/span")).click();

		XSSFSheet inboxandmyqueuesheet = wb.getSheetAt(14);
		XSSFRow inboxandmyqueuerow = inboxandmyqueuesheet.getRow(1);
		XSSFCell inboxcell = inboxandmyqueuerow.getCell(0);

		String losnumbers = inboxcell.getStringCellValue();

		Thread.sleep(1000);
		List<WebElement> loselement = driver
				.findElements(By.xpath("/html/body/div[1]/div[2]/div/div[2]/div/div[1]/div[2]/div/a[i]/h6"));
		for (WebElement webelement : loselement) {

			if (webelement.getText().equalsIgnoreCase(losnumbers)) {

				System.out.println(losnumbers);

				webelement.click();

				break;
			}

			else {

				return;
			}

		}

////		    	     Filter Button
//		    	     Thread.sleep(1000);
//		    	     driver.findElement(By.xpath("//a[@class='']")).click();
//		    	     
////		    	     LOS Number
//		    	     Thread.sleep(1000);
//				     driver.findElement(By.xpath("//input[@title='LOS Number']")).click();
//				     XSSFSheet inboxandmyqueuesheet=  wb.getSheetAt(14);
//				     XSSFRow inboxandmyqueuerow = inboxandmyqueuesheet.getRow(1);
//				     XSSFCell losnumbercell = inboxandmyqueuerow.getCell(0);
//				     String losnumber =  losnumbercell.getStringCellValue();
//				     System.out.println(losnumber);
//				     driver.findElement(By.xpath("//input[@title='LOS Number']")).sendKeys(losnumber);
//				       
////		    	     Applicant Name
//		    	     Thread.sleep(1000);
//				     driver.findElement(By.xpath("//input[@title='Applicant Name']")).click();
//				     XSSFCell ApplicantNamecell = inboxandmyqueuerow.getCell(1);
//				     String ApplicantName =  ApplicantNamecell.getStringCellValue();
//				     System.out.println(ApplicantName);
//				     driver.findElement(By.xpath("//input[@title='Applicant Name']")).sendKeys(ApplicantName);
//				    
////		    	     Mobile No
//		    	     Thread.sleep(1000);
//				     driver.findElement(By.xpath("//input[@title='Mobile No']")).click();
//				     XSSFCell MobileNocell = inboxandmyqueuerow.getCell(2);
//				     String MobileNo =  MobileNocell.getStringCellValue();
//				     System.out.println(MobileNo);
//				     driver.findElement(By.xpath("//input[@title='Mobile No']")).sendKeys(MobileNo);			     
//				     
////		    	     PAN No
//		    	     Thread.sleep(1000);
//				     driver.findElement(By.xpath("//input[@title='PAN']")).click();
//				     XSSFCell PANNocell = inboxandmyqueuerow.getCell(3);
//				     String PANNo =  PANNocell.getStringCellValue();
//				     System.out.println(PANNo);
//				     driver.findElement(By.xpath("//input[@title='PAN']")).sendKeys(PANNo);
//				
////		    	     Aadhaar No
//		    	     Thread.sleep(1000);
//				     driver.findElement(By.xpath("//input[@title='Aadhaar']")).click();
//				     XSSFCell AadhaarNocell = inboxandmyqueuerow.getCell(4);
//				     String AadhaarNo =  AadhaarNocell.getStringCellValue();
//				     System.out.println(AadhaarNo);
//				     driver.findElement(By.xpath("//input[@title='Aadhaar']")).sendKeys(AadhaarNo);
//		    	     
////			         Branch
//				     Thread.sleep(1000);
//			         WebElement Branchdrop =driver.findElement(By.xpath("//div[@title='BRANCH']"));
//			         Branchdrop.click();
//				     XSSFCell Branchcell = inboxandmyqueuerow.getCell(5);
//					      
//				     String Branch =  Branchcell.getStringCellValue();
//				      
//				       Thread.sleep(1000);
//				       List<WebElement> Branchelement = driver.findElements(By.xpath("//ul[contains(@role, 'listbox')]"));
//				       for(WebElement webelement : Branchelement  ) {
//				    	   
//				    	   if(webelement.getText().equals(Branch)) {
//
//			                 System.out.println(Branch);
//
//				    		   webelement.click();
//
//			                 break;
//			             }
//				    	   
//				       }	
//				       
//////				        scroll right
////				          Thread.sleep(2000);
////				          WebElement inboxscroll = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[2]/div/div[1]/div[2]/div"));
////				          
////				          ((JavascriptExecutor) driver).executeScript("arguments[0].scrollLeft += 350;", inboxscroll);	
//				       
//				   
//
//				       // Locate the element inside the mail window that you want to scroll to
//				       WebElement productname = driver.findElement(By.xpath("//div[@title='PRODUCT']"));
//
//				       // Create a JavascriptExecutor instance
//				       JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
//
//				       // Scroll to the element using JavaScript
//				       jsExecutor.executeScript("arguments[0].scrollIntoView(true);", productname);
//
//		    	     
////				     Product
//					 Thread.sleep(3000);
//				     WebElement Productdrop =driver.findElement(By.xpath("//div[@title='PRODUCT']"));
//				     Productdrop.click();
//					 XSSFCell Productcell = inboxandmyqueuerow.getCell(6);
//						      
//					 String Product =  Productcell.getStringCellValue();
//					      
//					       Thread.sleep(1000);
//					       List<WebElement> Productelement = driver.findElements(By.xpath("//li[contains(@class, 'rz-multiselect-item ')]"));
//					       for(WebElement webelement : Productelement  ) {
//					    	   
//					    	   if(webelement.getText().equals(Product)) {
//
//				                 System.out.println(Product);
//
//					    		   webelement.click();
//
//				                 break;
//				             }
//					    	   
//					       }		    
//					       
////					 Search
//					 Thread.sleep(2000);
//					 WebElement search = driver.findElement(By.xpath("(//button[@class='btn btn-primary '])[2]"));
//					 search.click();
//					 
////					 Refresh
////					 Thread.sleep(1000);
////					 WebElement Refresh = driver.findElement(By.xpath("(//button[@class='btn btn-primary '])[1]"));
////					 Refresh.click();
//		    	     
//		    	     WebElement inboxdata = driver.findElement(By.xpath("//a[@class='inboxlist  clicked']"));
//		    	     String datavalue = inboxdata.getText();
//		    	     if(datavalue.contains(ApplicantName)) {
//		    	    	 
//		    	    	 driver.findElement(By.xpath("//a[@class='inboxlist  clicked']']")).click();
//		    	    	 
//		    	     }
//		    	     
////		    	     View
//		    	     Thread.sleep(1000);
//		    	     WebElement view = driver.findElement(By.xpath("//span[@class='loanstatus yellowbg']"));
//		    	     view.click();
//		    	     
////		    	     Back to Timeline
//		    	     Thread.sleep(1000);
//		    	     WebElement backtotimeline = driver.findElement(By.xpath("//span[@class='loanstatus greenbg']"));
//		    	     backtotimeline.click();
//		    	     
////		    	     Return
//		    	     Thread.sleep(1000);
//		    	     WebElement retun = driver.findElement(By.xpath("(//span[@class='loanstatus greenbg'])[2]"));
//		    	     retun.click();
//		    	     
////		    	     my inbox
//		    	     driver.findElement(By.xpath("(//a[@role='button'])[1]")).click();
//		    		 
////		    		 myqueue
//		    		 driver.findElement(By.xpath("(//a[@class='dropdown-item pointer'])[2]")).click();
//		    	     
//		    		 List<WebElement> applicantdata = driver.findElements(By.xpath("//a[@class='inboxlist  ']"));
//		    		 
//		    		 if(applicantdata.contains(ApplicantName)) {
//		    			 
//		    			 
//		    		 }

//		    	   Thread.sleep(10000);  
//		    	   driver.quit();

	}

}
