package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {
	
	
	@DataProvider(name="logindata")
	public String [][]getData() throws IOException
	
	{
		//taking xl file from testData
		String Path=".\\testData\\Opencart_LoginData.xlsx";
		ExcelUtility xcelut=new ExcelUtility(Path);
		
		int totalrows=xcelut.getRowCount("Sheet1");
		int totalcols=xcelut.getCellCount("Sheet1",1);
		
		String logindata[][]=new String[totalrows][totalcols];//created for two dimension array which can store the data user and password
		
		for (int i=1;i<=totalrows;i++) 
		{
			for(int j=0;j<totalcols;j++) 
			{
				logindata[i-1][j]= xcelut.getCellData("Sheet1", i, j);
			}
		}
		
		return logindata;
	}

}
