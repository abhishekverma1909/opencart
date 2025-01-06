package testBase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass {
	
	static public WebDriver driver;
	public Logger logger;
	public Properties p;
	 
	@BeforeClass(groups= {"sanity","reg","master"})
	@Parameters({"os","browser"})
	public void setUp(String os, String br) throws IOException, InterruptedException
	
	{

		//loading properties file
		 FileReader file=new FileReader(".//src//test//resources//config.properties");
		 p=new Properties();
		 p.load(file);
		 System.out.println("Value of 'execution_env': " + p.getProperty("execution_env"));
		
		
		logger=LogManager.getLogger(this.getClass());//log4j
		
		if(p.getProperty("execution_env").equalsIgnoreCase("remote")) 
		{
			DesiredCapabilities capabilities=new DesiredCapabilities();
			
			//os
			if(os.equalsIgnoreCase("Windows")) 
			{
				capabilities.setPlatform(Platform.WIN11);
			}
			else if (os.equalsIgnoreCase("mac")) 
			{
				capabilities.setPlatform(Platform.MAC);
			}
			else 
			{
				System.out.println("No matching os");
				return;
			}
			//browser
			switch(br.toLowerCase()) 
			{
			case "chrome": capabilities.setBrowserName("chrome"); break;
			case "edge": capabilities.setBrowserName("MicrosoftEdge"); break;
			default: System.out.println("No matching browser"); return;
			}
			driver=new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),capabilities);
		}
		
		
		
		else if(p.getProperty("execution_env").equalsIgnoreCase("local")) {
		
			switch(br.toLowerCase()) 
			{
			case "chrome": driver=new ChromeDriver(); break; 
			case "edge" : driver=new EdgeDriver(); break;
			case "firefox": driver=new FirefoxDriver(); break;
			default: System.out.println("Invaild browser");
			return;
			}
		}
		
		
		
	
		
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get(p.getProperty("appURL"));
		driver.manage().window().maximize();
	}
	
	@AfterClass (groups= {"sanity","reg","master"})
	public void tearDown() throws InterruptedException 
	{
		driver.quit();
		 
	}
	
	public String randomeString() 
	{
		String generateString=RandomStringUtils.randomAlphabetic(5);
		return generateString;
	}

	public String randomeint() 
	{
		String genrateinteger=RandomStringUtils.randomNumeric(8);
		return genrateinteger;
	}
	
	public String randomAlphaNumaric() 
	{
		String generateString=RandomStringUtils.randomAlphabetic(5);
		String genrateinteger=RandomStringUtils.randomNumeric(5);
		return (generateString+genrateinteger);
	}
	
	public String captureScreen(String tname) throws IOException {

		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
				
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
		
		String targetFilePath=System.getProperty("user.dir")+"\\screenshots\\" + tname + "_" + timeStamp + ".png";
		File targetFile=new File(targetFilePath);
		
		sourceFile.renameTo(targetFile);
			
		return targetFilePath;
	
	}

}
