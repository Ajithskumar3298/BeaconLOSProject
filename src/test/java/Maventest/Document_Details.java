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

public class Document_Details {

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

//	    	     expander
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//span[@class='material-symbols-outlined'])[1]")).click();

//	    	     inbox
		Thread.sleep(1000);
		WebElement inbox = driver.findElement(By.xpath("(//a[@id='dropdownMenuButton1'])[4]"));
		inbox.click();

//	    	     My queue button
		Thread.sleep(2000);
		WebElement myqueuebutton = driver.findElement(By.xpath("(//span[@class='material-symbols-outlined'])[12]"));
		myqueuebutton.click();

//	    	     expander close
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/div[1]/div[2]/body/div/div/nav/span/i/span")).click();

//	    	     applicant select
//	    	     By elementsLocator = By.cssSelector(".inboxleft-body"); // Replace with your locator
//	    	     List<WebElement> elementsList = driver.findElements(elementsLocator);
//
//	    	     for (WebElement element : elementsList) {
//	    	    	    String elementText = element.getText();
//	    	    	    System.out.println("Element Text: " + elementText);
//	    	    	    
////	   	    	     LOS Number
//	   			     XSSFSheet inboxandmyqueuesheet=  wb.getSheetAt(15);
//	   			     XSSFRow inboxandmyqueuerow = inboxandmyqueuesheet.getRow(1);
//	   			     XSSFCell losnumbercell = inboxandmyqueuerow.getCell(0);
//	   			     String losnumber =  losnumbercell.getStringCellValue();
//	   			     
//	   			     if(elementText.contains(losnumber)){
//	   			    	 
//	   			    	 driver.findElement(elementsLocator).click(); 			     
//	   			    	 
//	   			     }
//	    	    	}

//	    	     applicant select
		Thread.sleep(1000);
		WebElement applicant = driver.findElement(By.xpath("(//a[@class='inboxlist  '])[10]"));
		applicant.click();

//		          scroll up
		Thread.sleep(2000);
		JavascriptExecutor scrollup = (JavascriptExecutor) driver;

		scrollup.executeScript("window.scrollBy(0,-250)");

//	    	     Document
		Thread.sleep(1000);
		WebElement document = driver.findElement(By.xpath("//span[@class='loanstatus greenbg']"));
		document.click();

//	    	     Identity proof
		Thread.sleep(1000);
		String idprroftitle = driver.getTitle();
		System.out.println(idprroftitle);
		XSSFSheet documentdetails = wb.getSheetAt(15);
		XSSFRow documentdetailsrow = documentdetails.getRow(1);
		XSSFCell idproofcell = documentdetailsrow.getCell(2);
		String losnumber = idproofcell.getStringCellValue();

		idprroftitle.equalsIgnoreCase(losnumber);

//   			 Add Document
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[@class='btn btn-primary']")).click();

//   			 Document
		Thread.sleep(1000);
		WebElement Documentdrop = driver
				.findElement(By.xpath("//div[@class='rz-dropdown valid rz-clear form-control required']"));
		Documentdrop.click();
		XSSFCell Documentcell = documentdetailsrow.getCell(3);

		String Documentfield = Documentcell.getStringCellValue();

		Thread.sleep(1000);
		List<WebElement> Documentelement = driver.findElements(By.xpath("//li[contains(@role, 'option')]"));
		for (WebElement webelement : Documentelement) {

			if (webelement.getText().equals(Documentfield)) {

				System.out.println(Documentfield);

				webelement.click();

				break;
			}

		}

//	    	     Title
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@name='Title']")).click();
		XSSFCell Titlecell = documentdetailsrow.getCell(4);
		String Title = Titlecell.getStringCellValue();
		System.out.println(Title);
		driver.findElement(By.xpath("//input[@name='Title']")).sendKeys(Title);

//	    	     Checkbox
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@class='rz-chkbox-box']")).click();

//			     Browse Button1
		Thread.sleep(2000);
		String projectpath = System.getProperty("user.dir");
		WebElement browse1 = driver.findElement(By.xpath("//input[@name='DocFile']"));
		browse1.sendKeys(projectpath + "\\Files\\Image.jpg");

//			     Browse Button2
		Thread.sleep(2000);
		WebElement browse2 = driver.findElement(By.xpath("//input[@name='DocFile']"));
		browse2.sendKeys(projectpath + "\\Files\\Image.jpg");

//		         Notes
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@name='Name']")).click();
		XSSFCell Notescell = documentdetailsrow.getCell(5);
		String Notes = Notescell.getStringCellValue();
		System.out.println(Notes);
		driver.findElement(By.xpath("//input[@name='Name']")).sendKeys(Notes);

//			     Add Button
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@class='btn btn-primary']")).click();

//			     Save Button
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[@class='btn btn-primary ']")).click();

		int i;
		for (i = 1; i <= 13; i++) {

			Thread.sleep(2000);
			driver.findElement(By.xpath("//button[@class='btn btn-primary'][i]")).click();

		}
////			     Photo and Sign
//			     Thread.sleep(1000);
//			     driver.findElement(By.xpath("(//button[@class='btn btn-primary'])[2]")).click();
//			     
////			     Financial
//			     Thread.sleep(1000);
//			     driver.findElement(By.xpath("(//button[@class='btn btn-primary'])[3]")).click();
//			     
////			     IMD cheque
//			     Thread.sleep(1000);
//			     driver.findElement(By.xpath("(//button[@class='btn btn-primary'])[4]")).click();
//			     
////			     IMD bank statement
//			     Thread.sleep(1000);
//			     driver.findElement(By.xpath("(//button[@class='btn btn-primary'])[5]")).click();
//			     
////			     FI Document
//			     Thread.sleep(1000);
//			     driver.findElement(By.xpath("(//button[@class='btn btn-primary'])[6]")).click();
//			     
////			     FCU Document
//			     Thread.sleep(1000);
//			     driver.findElement(By.xpath("(//button[@class='btn btn-primary'])[7]")).click();
//			     
////			     Sanction Letter
//			     Thread.sleep(1000);
//			     driver.findElement(By.xpath("(//button[@class='btn btn-primary'])[8]")).click();
//			     
////			     Property
//			     Thread.sleep(1000);
//			     driver.findElement(By.xpath("(//button[@class='btn btn-primary'])[9]")).click();
//			     
////			     Insurance
//			     Thread.sleep(1000);
//			     driver.findElement(By.xpath("(//button[@class='btn btn-primary'])[10]")).click();
//			     
////			     CAM
//			     Thread.sleep(1000);
//			     driver.findElement(By.xpath("(//button[@class='btn btn-primary'])[11]")).click();
//			     
////			     Property valuation
//			     Thread.sleep(1000);
//			     driver.findElement(By.xpath("(//button[@class='btn btn-primary'])[12]")).click();
//			     
////			     Legal Verification
//			     Thread.sleep(1000);
//			     driver.findElement(By.xpath("(//button[@class='btn btn-primary'])[13]")).click();
//	    	     

	}

}
