package Datadriven;

import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;
import java.util.*;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Datadriventest {
WebDriver driver;

	@BeforeClass
	
	public void setup() throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver","C:\\Users\\anilk\\eclipse-workspace\\Datadriventest1\\Driver\\chromedriver.exe");
		driver=new ChromeDriver();//launch browser
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		Thread.sleep(1000);
		driver.manage().window().maximize();
			
	}
	
	@Test(dataProvider="Logindata")
	public void loginTest(String user,String pwd,String repwd,String exp) throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver","C:\\Users\\anilk\\eclipse-workspace\\Datadriventest1\\Driver\\chromedriver.exe");
		driver=new ChromeDriver();//launch browser
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		Thread.sleep(1000);
		driver.manage().window().maximize();
		
		
   driver.get("https://dsportalapp.herokuapp.com/register");
   Thread.sleep(2000);
	
	WebElement txtuser=driver.findElement(By.name("username"));
	txtuser.clear();
	txtuser.sendKeys(user);
	Thread.sleep(1000);
	WebElement txtpass=driver.findElement(By.name("password1"));
	txtpass.clear();
	txtpass.sendKeys(pwd);
	
	Thread.sleep(1000);
	WebElement txtrepass=driver.findElement(By.name("password2"));
	txtrepass.clear();
	txtrepass.sendKeys(repwd);
	Thread.sleep(1000);
	driver.findElement(By.xpath("//div[@class='col-sm']/form/input[5]")).click();
	Thread.sleep(1000);
	String exp_title="New Account Created. You are logged in as Besusnwpy";
	String act_title=driver.getTitle();
	
	if(exp.equals("Valid"))
	{
	if(exp_title.equals(act_title))
	{
	driver.findElement(By.linkText("logout")).click();
	Assert.assertTrue(true);
	}
	else
	{Assert.assertTrue(false);
	}
	}
	else if(exp.equals("Invalid"))
	{
	if(exp_title.equals(act_title))
	{
	driver.findElement(By.linkText("logout")).click();
	Assert.assertTrue(false);
	}
	else
	{Assert.assertTrue(true);
	}
	
	
	}
	
	
	}
	@DataProvider(name="Logindata")
	
	public String [][] getdata() throws IOException
	{
	/*String logindata[][]= {
			{"ssss","asdsd","hhh","valid"},
			{"ssss","asdsd","hhh","invalid"},
			{"ssss","asd66","hhh","valid"},
			{"ssss","asd77","hhh","invalid"}
	};*/
		
		String path=".\\Datafiles\\Book1.xlsx";
		 Utilityfile xl=new Utilityfile(path);
		 int totalrows=xl.getRowCount("sheet1");
		 int totalcols=xl.getCellCount("sheet1",1);
		 String  logindata[][]=new String[totalrows][totalcols];
		 
		 for(int i=1;i<=totalrows;i++)
		 {
			 for(int j=0;j<totalcols;j++)
			 {
				logindata[i-1][j]=xl.getCellData("sheet1",i,j); 
			 }
		 }
	return logindata;
	}
	
	
	@AfterClass
	
	void tearDown()
	{
		driver.close();
	}
	
	
}	
