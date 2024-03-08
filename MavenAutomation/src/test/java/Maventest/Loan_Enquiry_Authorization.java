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

public class Loan_Enquiry_Authorization {

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
//		    	     expander
		driver.findElement(By.xpath("(//span[@class='material-symbols-outlined'])[1]")).click();

		Thread.sleep(2000);
//		    	     Authorization
		WebElement authorization = driver.findElement(By.xpath("(//a[@id='dropdownMenuButton1'])[3]"));
		authorization.click();

//		    	     loan inquiry approval
		Thread.sleep(2000);
		WebElement loanenquiryapproval = driver.findElement(By.xpath("(//a[@class='dropdown-item'])[4]"));
		loanenquiryapproval.click();

		Thread.sleep(1000);
//		    	     expander close
		driver.findElement(By.xpath("(//span[@class='material-symbols-outlined'])[1]")).click();

//		    	     loan inquiry approve
//		    	     XSSFSheet enquiryapprove=  wb.getSheetAt(8);
//			      	 
//				     XSSFRow aproverow = enquiryapprove.getRow(1);
//				      
//				     XSSFCell approvecell = aproverow.getCell(0);
//				      
//				     String enquiryapproval =  approvecell.getStringCellValue();
//				      
//				     System.out.println(enquiryapproval);

		Thread.sleep(2000);

		List<WebElement> enqnumber = driver
				.findElements(By.xpath("//table[@class='rz-grid-table rz-grid-table-fixed']//tr//td[2]"));

		boolean enqstatus = false;

		for (WebElement element : enqnumber) {

			String value = element.getText();
			System.out.println(value);

			if (value.contains("ENQ10140530000000125")) {

				enqstatus = true;
				break;

			}
		}

		driver.findElement(By.xpath(""));

	}

}
