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

public class Basic_Configuration {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub

		WebDriver driver;

		driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(2));

		driver.get("http://192.168.32.23:44369/");

		driver.manage().window().maximize();

		String file = "./testdata/Demoexcell.xlsx";

		XSSFWorkbook wb = new XSSFWorkbook(file);

		XSSFSheet sheet = wb.getSheetAt(0);

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

		driver.findElement(By.xpath("//button[@type='submit']")).click();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		Thread.sleep(2000);

//	      expander
		driver.findElement(By.xpath("(//span[@class='material-symbols-outlined'])[1]")).click();

		Thread.sleep(2000);

//	      product

		WebElement product = driver.findElement(By.xpath("(//a[@id='dropdownMenuButton1'])[5]"));

		product.click();

//	      WebElement element = driver.findElement(By.id("//div[@class='navmenuscroll']"));
//	      
//	      JavascriptExecutor scroll = (JavascriptExecutor) driver;
//	      
//	      scroll.executeScript("arguments[0].scrollIntoView(true);", element);

		Thread.sleep(2000);
//	      product config
		WebElement productconfig = driver.findElement(By.xpath("(//a[@class='dropdown-item'])[13]"));

		productconfig.click();

		Thread.sleep(2000);
		// expander close
		driver.findElement(By.xpath("(//span[@class='material-symbols-outlined'])[1]")).click();

		// product select

		if (driver.findElement(By.xpath("//*[@id=\"dvBody\"]/div")).isDisplayed()) {

			Thread.sleep(3000);

			driver.findElement(By.xpath("(//a[@class='input-label'])[2]")).click();

		}
		Thread.sleep(4000);
		// basic config
		WebElement Basicconfiguration = driver.findElement(By.xpath("(//div[@class='lib-row lib-header'])[1]"));

		Basicconfiguration.click();

		// prodname
		Thread.sleep(1000);

		WebElement proname = driver.findElement(By.xpath("//input[@title='Name']"));
		proname.click();

		Actions clear = new Actions(driver);

		clear.moveToElement(proname).doubleClick().sendKeys(Keys.BACK_SPACE).perform();

		XSSFSheet Basicconfig = wb.getSheetAt(2);

		XSSFRow row1 = Basicconfig.getRow(1);

		XSSFCell cell2 = row1.getCell(0);

		String name2 = cell2.getStringCellValue();

		System.out.println(name2);

		proname.sendKeys(name2);

		Thread.sleep(1000);
		// minco

		WebElement mico = driver.findElement(By.xpath("(//input[@type='text'])[1]"));
		mico.click();

		Actions clear1 = new Actions(driver);

		clear1.moveToElement(mico).doubleClick().sendKeys(Keys.BACK_SPACE).perform();

		XSSFCell cell3 = row1.getCell(1);

		String name3 = cell3.getStringCellValue();

		System.out.println(name3);

		mico.sendKeys(name3);

		Thread.sleep(1000);
		// maxco
		WebElement mxco = driver.findElement(By.xpath("(//input[@type='text'])[2]"));
		mxco.click();

		Actions clear2 = new Actions(driver);

		clear2.moveToElement(mxco).doubleClick().sendKeys(Keys.BACK_SPACE).perform();

		XSSFCell cell4 = row1.getCell(2);

		String name4 = cell4.getStringCellValue();

		System.out.println(name4);

		mxco.sendKeys(name4);

		Thread.sleep(1000);
		// mingu
		WebElement migu = driver.findElement(By.xpath("(//input[@type='text'])[3]"));
		migu.click();

		Actions clear3 = new Actions(driver);

		clear3.moveToElement(migu).doubleClick().sendKeys(Keys.BACK_SPACE).perform();

		XSSFCell cell5 = row1.getCell(3);

		String name5 = cell5.getStringCellValue();

		System.out.println(name5);

		migu.sendKeys(name5);

		Thread.sleep(1000);
		// maxgu
		WebElement mxgu = driver.findElement(By.xpath("(//input[@type='text'])[4]"));
		mxgu.click();

		Actions clear4 = new Actions(driver);

		clear4.moveToElement(mxgu).doubleClick().sendKeys(Keys.BACK_SPACE).perform();

		XSSFCell cell6 = row1.getCell(4);

		String name6 = cell6.getStringCellValue();

		System.out.println(name6);

		mxgu.sendKeys(name6);

		// sanction
//     Thread.sleep(1000);
//     WebElement sanctionletterbrowse = driver.findElement(By.xpath("(//input[@type='file'])[1]"));
//    
//     String sanctionletter = "C:\\Users\\ajith.sunilkumar\\Desktop\\Ajith\\sanctionletter\\SanctionLetterTemplate.html";
//     
//     sanctionletterbrowse.sendKeys(sanctionletter);
//     
//     Thread.sleep(2000);
//     //prodimg
//     WebElement prodimagebrowse = driver.findElement(By.xpath("(//input[@type='file'])[2]"));
//     
//     String productimage = "C:\\Users\\ajith.sunilkumar\\Desktop\\loan.webp";
//     
//     prodimagebrowse.sendKeys(productimage);

		// imd
		Thread.sleep(1000);
		WebElement imd = driver.findElement(By.xpath("(//input[@type='text'])[5]"));
		imd.click();

		Actions clear5 = new Actions(driver);

		clear5.moveToElement(imd).doubleClick().sendKeys(Keys.BACK_SPACE).perform();

		XSSFCell cell7 = row1.getCell(5);

		String name7 = cell7.getStringCellValue();

		System.out.println(name7);
		imd.sendKeys(name7);

		driver.findElement(By.xpath("(//span[@class='rz-chkbox-icon rzi rzi-check'])[1]")).click();

//     driver.findElement(By.xpath("(//span[@class='rz-chkbox-icon rzi rzi-check'])[2]")).click();
//     
//     driver.findElement(By.xpath("(//span[@class='rz-chkbox-icon rzi rzi-check'])[3]")).click();
//     
//     driver.findElement(By.xpath("(//span[@class='rz-chkbox-icon rzi rzi-check'])[4]")).click();
//     
//     driver.findElement(By.xpath("(//span[@class='rz-chkbox-icon rzi rzi-check'])[5]")).click();

		// clear
		WebElement clr = driver.findElement(By.xpath("//a[@class='btn btn-light ']"));

		clr.click();

		// update
		WebElement update = driver.findElement(By.xpath("//button[@class='btn btn-primary ']"));

		update.click();
	}

}
