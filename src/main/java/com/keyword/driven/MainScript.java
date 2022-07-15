package com.keyword.driven;

public class MainScript {

	public static void main(String[] args) throws Exception {
		CommonUtility utility = new CommonUtility();
		String path = "C:\\Users\\chand\\Desktop\\QA\\kdd_excelsheet_testcase.xlsx";
		String[][] excelData = utility.readExcelData(path);
		for(int i=1; i<excelData.length;i++) {
			String functionName = excelData[i][3];
			String locator	= excelData[i][4];
			String locatorValue	= excelData[i][5];
			String parameter= excelData[i][6];
			
			//System.out.println(functionName+" "+ locator+" "+locatorValue+" "+ parameter);
			
			switch(functionName) {
				case "launchApp":
					System.out.println("Launching application");
					utility.launchApp();
					break;
				case "fillText":
					System.out.println("Filling Textbox");
					utility.fillText(locator, locatorValue, parameter);
					break;
				case "clickButton":
					System.out.println("Clicking Button");
					utility.clickButton(locator, locatorValue);
					break;
				
			}
		}
	}

}
