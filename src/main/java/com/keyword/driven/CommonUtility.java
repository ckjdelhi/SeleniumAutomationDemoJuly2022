package com.keyword.driven;

import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CommonUtility {
	public static WebDriver driver = null;
	static {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\chand\\Desktop\\QA\\driver\\chromedriver.exe");
		//System.setProperty("webdriver.gecko.driver", "C:\\Users\\chand\\Desktop\\QA\\driver\\geckodriver.exe");
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		
	}

	public String[][] readExcelData(String path) throws Exception {
		FileInputStream file = new FileInputStream(new File(path));
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheetAt(0);
		int noOfRows = sheet.getLastRowNum();
		System.out.println("Rows: "+noOfRows);
		int noOfCols = sheet.getRow(0).getLastCellNum();
		System.out.println("Columns: "+ noOfCols);
		
		String[][] excelData = new String[noOfRows+1][noOfCols];
		for(int i=0; i<= noOfRows; i++) {
			XSSFRow row = sheet.getRow(i);
			for(int j=0;j<noOfCols;j++) {
				XSSFCell cell = row.getCell(j);
				excelData[i][j]= cell.toString();
			}
		}
		workbook.close();
		return excelData;
	}

	public void launchApp() {
		driver.get("https://demo.guru99.com/v4/manager/addcustomerpage.php");
		driver.manage().window().maximize();
	}

	public void fillText(String locator, String locatorValue, String parameter) {
		switch(locator) {
			case "name":
				driver.findElement(By.name(locatorValue)).sendKeys(parameter);
				break;
			case "xpath":
				driver.findElement(By.xpath(locatorValue)).sendKeys(parameter);
				break;
		}
	}

	public void clickButton(String locator, String locatorValue) {
		switch(locator) {
			case "name":
				driver.findElement(By.name(locatorValue)).click();
				break;
			case "xpath":
				driver.findElement(By.xpath(locatorValue)).click();
				break;
		}
		
	}
	
}
