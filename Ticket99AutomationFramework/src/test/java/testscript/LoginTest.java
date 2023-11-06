package testscript;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import excelutility.ExcelFileReader;

public class LoginTest {
	private static WebDriver driver;
	ExcelFileReader file =  new ExcelFileReader("C:\\Users\\CorevanceDesign\\eclipse-workspace\\Ticket99AutomationFramework\\src\\test\\java\\testdata\\Mastersheet.xlsx");
	
	  

	  public static Object[][] credentials() {

	        

	        return new Object[][] { { "Siva@EventTitans.com", "Test@12" }, { "Siva@EventTitans.com", "Welcome@123" }};

	  }

	  

	  @SuppressWarnings("deprecation")
	@Test(dataProvider = "Authentication")

	  public void test(String sUsername, String sPassword) {

	      driver = new ChromeDriver();

	      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	      driver.get("https://stage.tickets99.com");

	     

	     

	      driver.findElement(By.id("txtusername")).sendKeys(sUsername);

	      driver.findElement(By.id("txtpassword")).sendKeys(sPassword);

	      driver.findElement(By.id("aloginbutton")).click();}
	  
	  
	  @Test(testName = "Authentication")
	 
	    public Object[][] authenticationDataProvider(String ExcelFileReader) throws IOException {
	        // Initialize your ExcelFileReader with the correct file path
	        file = new ExcelFileReader("C:\\Users\\CorevanceDesign\\eclipse-workspace\\Ticket99AutomationFramework\\src\\test\\java\\testdata\\Mastersheet.xlsx");

	        // Define the sheet name from which you want to read data
	        String fileName = "Mastersheet";
	        String sheetName = "Master";
	        FileInputStream fis = new FileInputStream(ExcelFileReader);
	        XSSFWorkbook wb = new XSSFWorkbook(fis);
	        XSSFSheet sh = wb.getSheet(sheetName);
	        int rowCount = file.getRowCount(fileName);
	       System.out.println("total row:"+rowCount);
		return null;

	       
	      /*  Object[][] data = new Object[rowCount - 2][2]; // Assuming the first row is the header

	        for (int i = 2; i <= rowCount; i++) {
	            // Assuming the first column is username and the second column is password
	            String username = file.getCellData(fileName, "Username", i);
	            String password = file.getCellData(fileName, "Password", i);

	            data[i - 2][0] = username;
	            data[i - 2][1] = password;
	        }

	        return data;*/
	    }

	  
	  
	  @AfterMethod
	  public void aftermethod() {
		  
driver.quit();
}
	     

	      
/*@DataProvider

public Object[][] Authentication(Object sTestCaseName, Object iTestCaseRow) throws Exception{

	   

	ExcelFileReader.setExcelFile("D://ToolsQA//OnlineStore//src//testData//TestData.xlsx","Sheet1");
	System.out.println(driver.getTitle());

	 	sTestCaseName = this.toString();

	  	

	  	sTestCaseName = ExcelFileReader.getTestCaseName(this.toString());

	    

	 	iTestCaseRow = ExcelFileReader.getRowContains(sTestCaseName,0);

	    Object[][] testObjArray = ExcelFileReader.getTableArray("C:\\Users\\CorevanceDesign\\eclipse-workspace\\Ticket99AutomationFramework\\src\\test\\java\\testdata\\Mastersheet.xlsx","Master");

	    	return (testObjArray);

		}*/

}

	  





