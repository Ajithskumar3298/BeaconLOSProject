package Maventest;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Product_Configuration {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub

		WebDriver driver;

		driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(2));

		driver.get("http://192.168.32.23:44369/");

		driver.manage().window().maximize();

		String file = "./testdata/Demoexcell.xlsx";

		XSSFWorkbook wb = new XSSFWorkbook(file);

		XSSFSheet login = wb.getSheetAt(0);

		XSSFRow row = login.getRow(1);

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

//      expander
		driver.findElement(By.xpath("(//span[@class='material-symbols-outlined'])[1]")).click();

		Thread.sleep(2000);

//      product

		WebElement product = driver.findElement(By.xpath("(//a[@id='dropdownMenuButton1'])[5]"));

		product.click();

//      WebElement element = driver.findElement(By.id("//div[@class='navmenuscroll']"));
//      
//      JavascriptExecutor scroll = (JavascriptExecutor) driver;
//      
//      scroll.executeScript("arguments[0].scrollIntoView(true);", element);

		Thread.sleep(2000);
//      product config
		WebElement productconfig = driver.findElement(By.xpath("(//a[@class='dropdown-item'])[13]"));

		productconfig.click();

		Thread.sleep(2000);
		// expander close
		driver.findElement(By.xpath("(//span[@class='material-symbols-outlined'])[1]")).click();

		Thread.sleep(4000);
		// add product button
		WebElement addproduct = driver.findElement(By.xpath("//a[@class='float link']"));

		addproduct.click();

		// Basic

		XSSFSheet productcreation = wb.getSheetAt(1);

		XSSFRow row1 = productcreation.getRow(1);

		XSSFCell cell2 = row1.getCell(0);

		String name2 = cell2.getStringCellValue();

		System.out.println(name2);

		Thread.sleep(1000);

		driver.findElement(By.xpath("//input[@title='Name']")).sendKeys(name2);

//      WebElement prodname= driver.findElement(By.xpath("//input[@title='Name']"));

//      prodname.sendKeys("Automation");

		Thread.sleep(1000);
		// minco
		XSSFCell cell3 = row1.getCell(1);

		String name3 = cell3.getStringCellValue();

		System.out.println(name3);

		WebElement minco = driver.findElement(By.xpath("(//input[@type='text'])[1]"));

		minco.click();
		minco.sendKeys(name3);

		Thread.sleep(1000);
		// maxco
		XSSFCell cell4 = row1.getCell(2);

		String name4 = cell4.getStringCellValue();

		System.out.println(name4);

		WebElement maxco = driver.findElement(By.xpath("(//input[@type='text'])[2]"));

		maxco.click();
		maxco.sendKeys(name4);

		Thread.sleep(1000);
		// mingur
		XSSFCell cell5 = row1.getCell(3);

		String name5 = cell5.getStringCellValue();

		System.out.println(name5);

		WebElement mingur = driver.findElement(By.xpath("(//input[@type='text'])[3]"));

		mingur.click();
		mingur.sendKeys(name5);

		Thread.sleep(1000);
		XSSFCell cell6 = row1.getCell(4);

		String name6 = cell6.getStringCellValue();

		System.out.println(name6);
		WebElement maxgur = driver.findElement(By.xpath("(//input[@type='text'])[4]"));

		maxgur.click();
		maxgur.sendKeys(name6);

		Thread.sleep(1000);
		String projectpath = System.getProperty("user.dir");

		WebElement sanctionletterbrowse = driver.findElement(By.xpath("(//input[@type='file'])[1]"));

		sanctionletterbrowse.sendKeys(projectpath + "\\Files\\sanction letter.pdf");

//    product image
		Thread.sleep(2000);

		WebElement prodimagebrowse = driver.findElement(By.xpath("(//input[@type='file'])[2]"));

		prodimagebrowse.sendKeys(projectpath + "\\Files\\loan.webp");

		// imd
		Thread.sleep(1000);
		WebElement imd = driver.findElement(By.xpath("(//input[@type='text'])[5]"));

		Actions clear = new Actions(driver);

		clear.moveToElement(imd).doubleClick().sendKeys(Keys.BACK_SPACE).perform();

		XSSFCell cell7 = row1.getCell(5);

		String name7 = cell7.getStringCellValue();

		System.out.println(name7);
		imd.sendKeys(name7);

		Thread.sleep(1000);
		WebElement check1 = driver.findElement(By.xpath("(//div[@class='rz-chkbox-box'])[2]"));

		if (!check1.isSelected()) {
			// If the checkbox is not selected, click on it to enable it
			check1.click();
		}

//      Thread.sleep(1000);
//      WebElement check2 = driver.findElement(By.xpath("(//div[@class='rz-chkbox-box'])[3]"));
//       
//    if(!check2.isSelected()) {
//    	   
//    	   check2.click();
//       }
//       
//     
////     boolean isChecked1 = check2.isSelected(); 
////     System.out.println("Is checkbox selected? " + isChecked1);
//    
//      Thread.sleep(1000);
//      WebElement check3 = driver.findElement(By.xpath("(//div[@class='rz-chkbox-box'])[4]"));
//      
//    if(!check3.isSelected()) {
//   	   
//   	   check3.click();
//      }
//      
//     
//      Thread.sleep(1000);
//      WebElement check4 = driver.findElement(By.xpath("(//div[@class='rz-chkbox-box'])[5]"));
//      
//    if(!check4.isSelected()) {
//   	   
//   	   check4.click();
//      }

//      Thread.sleep(1000);
//      WebElement check5 = driver.findElement(By.xpath("(//div[@class='rz-chkbox-box'])[6]"));
//      
//    if(!check5.isSelected()) {
//   	   
//   	   check5.click();
//      }

		// Bureau
		Thread.sleep(1000);
		WebElement check6 = driver.findElement(By.xpath("(//div[@class='rz-chkbox-box'])[7]"));

		if (!check6.isSelected()) {

			check6.click();
		}

//      Thread.sleep(1000);
//      WebElement check7 = driver.findElement(By.xpath("(//div[@class='rz-chkbox-box'])[8]"));
//      
//    if(!check7.isSelected()) {
//   	   
//   	   check7.click();
//      }

//      Thread.sleep(4000);
//      driver.findElement(By.xpath("//button[@class='btn btn-primary ']")).click();

//      Thread.sleep(7000);
//      driver.quit();
	}

}
