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

public class Bureau_Score {

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

		Thread.sleep(1000);
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

		Thread.sleep(1000);
//	    	     expander close
		driver.findElement(By.xpath("/html/body/div[1]/div[2]/body/div/div/nav/span/i/span")).click();

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
		driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[2]/div[4]/div[1]/div/a")).click();

//	    	  Credit info
		WebElement CreditInfobutton = driver.findElement(By.xpath("//button[@class='btn btn-primary']"));

		while (true)
			if (CreditInfobutton.isDisplayed()) {

				CreditInfobutton.click();
//		    	  Check crif Score
//		    	  Thread.sleep(2000);
//		    	  driver.findElement(By.xpath("(//button[@class='btn btn-primary'])[1]")).click();

//			      scroll down
				Thread.sleep(1000);
				JavascriptExecutor subscroll = (JavascriptExecutor) driver;

				subscroll.executeScript("window.scrollBy(0,550)");

//		          re-check
				Thread.sleep(1000);
				driver.findElement(By.xpath("(//button[@class='btn btn-primary'])[1]"));

//		          CIBIL TAB
//		          Thread.sleep(2000);
//		          driver.findElement(By.xpath("(//a[@role='tab'])[2]")).click();
//		          
////		          Check cibil Score
//		          Thread.sleep(2000);
//		          driver.findElement(By.xpath("(//button[@class='btn btn-primary'])[2]")).click();

//		          Done button
				Thread.sleep(2000);
				driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[1]/div[2]/div/div[2]/button")).click();

				break;
			}

//	    	  AML 
//	    	  WebElement AMLbutton = driver.findElement(By.xpath("(//button[@class='btn btn-primary'])[1]"));
//	    	  
//	    	  while(true)
//		    	  if(AMLbutton.isDisplayed()) {
//		    		  
//		    		  AMLbutton.click();
////			    	 
////		    		  info
//		    		  
////			          Done button
//			          Thread.sleep(2000);
//			          driver.findElement(By.xpath("(//button[@class='btn btn-primary'])[1]")).click();
//			    	  
//			          break;
//		    	  }

//	    	  Back to Timeline
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[@class='loanstatus greenbg']")).click();

////	    	  Policy Check
//	    	  Thread.sleep(2000);
//	    	  driver.findElement(By.xpath("//div[@class='rz-chkbox-box']")).click();

////	    	  Submit
//	    	  Thread.sleep(2000);
//	    	  driver.findElement(By.xpath("(//button[@class='loanstatus yellowbg'])[2]")).click();

//	    	  Action
		Thread.sleep(1000);
		WebElement Actiondrop = driver.findElement(By.xpath("//label[@class='rz-dropdown-label rz-inputtext ']"));
		Actiondrop.click();

		XSSFSheet bureauscoresheet = wb.getSheetAt(13);
		XSSFRow bureaurow = bureauscoresheet.getRow(1);
		XSSFCell Actioncell = bureaurow.getCell(0);

		String Actionfield = Actioncell.getStringCellValue();

		Thread.sleep(1000);
		List<WebElement> Actionelement = driver.findElements(By.xpath("//li[contains(@role, 'option')]"));
		for (WebElement webelement : Actionelement) {

			if (webelement.getText().equals(Actionfield)) {

				System.out.println(Actionfield);

				webelement.click();

				break;
			}

		}

//		       Bureau Score
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@name='ActionRequired']")).click();
		XSSFCell remarkcell = bureaurow.getCell(1);
		String Remarks = remarkcell.getStringCellValue();
		System.out.println(Remarks);
		driver.findElement(By.xpath("//input[@name='ActionRequired']")).sendKeys(Remarks);

//	    	  Submit
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@class='btn btn-primary rounded-pill']")).click();

	}

}
