package Maventest;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Demo_maven {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub

		WebDriver driver;

		driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(2));

//             WebDriverWait wait = new WebDriverWait(driver, 30);
//            
//             wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='User Name']")));

		driver.get("http://192.168.32.23:44369/");

		driver.manage().window().maximize();

		String file = "./testdata/Demoexcell.xlsx";

		XSSFWorkbook workbook = new XSSFWorkbook(file);

		XSSFSheet sheet = workbook.getSheetAt(0);

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
//         

		Thread.sleep(1000);

		driver.findElement(By.xpath("//button[@type='submit']")).click();

		if (driver.findElement(By.xpath("//div[@role='dialog']")).isDisplayed()) {

			WebElement popup = driver.findElement(By.xpath("//input[@class='btn btn-primary rounded-pill']"));

			Thread.sleep(1000);

			popup.click();

		}

		driver.findElement(By.xpath("//button[@type='submit']")).click();

//	          driver.findElement(By.xpath("//input[@placeholder='Current Password']")).sendKeys("ses@1234");
//	      
//	          driver.findElement(By.xpath("//input[@placeholder='New Password']")).sendKeys("ses@12345");
//	      
//	          driver.findElement(By.xpath("//input[@placeholder='Confirm Password']")).sendKeys("ses@12345");
//	      
//	          WebElement change = driver.findElement(By.xpath("//button[@class='btn btn-primary']"));
//	      
//	          change.click();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		Thread.sleep(2000);

		driver.findElement(By.xpath("(//span[@class='material-symbols-outlined'])[1]")).click();

		Thread.sleep(2000);

		WebElement user = driver.findElement(By.xpath("(//a[@id='dropdownMenuButton1'])[1]"));

		user.click();

		Thread.sleep(2000);
		WebElement usermanagement = driver.findElement(By.xpath("(//a[@class='dropdown-item'])[1]"));

		usermanagement.click();

		Thread.sleep(2000);

		WebElement newuser = driver.findElement(
				By.cssSelector("#dvBody > div:nth-child(2) > div.mycard-header.row > div > a:nth-child(1)"));

		newuser.click();
//         
//            Thread.sleep(1000);
//            
//           WebElement username =  driver.findElement(By.xpath("//input[@name='UserId']"));
//           username.click();
//           username.sendKeys("Speridian");
//           
//           Thread.sleep(1000);
//           
//           WebElement names =  driver.findElement(By.xpath("//input[@name='Name']"));
//           names.click();
//           names.sendKeys("AJITH");
//           
//           Thread.sleep(1000);
//           
//           WebElement email =  driver.findElement(By.xpath("//input[@name='Email']"));
//           email.click();
//           email.sendKeys("ajhgf@gmail.com");
//           
//           Thread.sleep(1000);
//           
//           WebElement MobileNumber =  driver.findElement(By.xpath("//input[@name='Mobile']"));
//           MobileNumber.click();
//           MobileNumber.sendKeys("7598767877");
//           
//           Thread.sleep(1000);
//           
//           WebElement EmployeeCode =  driver.findElement(By.xpath("//input[@name='Employee Code']"));
//           EmployeeCode.click();
//           EmployeeCode.sendKeys("SG9878");
//           
//           Thread.sleep(1000);
//           
//           WebElement UserGroup =  driver.findElement(By.xpath("//div[@title='User Group']"));
//           UserGroup.click();
//           
//           WebElement element = driver.findElement(By.xpath("//*[@id=\"popup-nrwy8xmknE\"]/div[2]/ul/li[1]"));
//           
//           
//           Select select  = new Select(element);
//           
//           select.selectByVisibleText("test");

	}

}
