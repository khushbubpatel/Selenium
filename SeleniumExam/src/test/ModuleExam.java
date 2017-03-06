package test;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ModuleExam extends ReUseableMethodsExam {
	public static void initialize(String [][]recData)
	{
		String url = recData[1][1];
		driver.get(url);
		driver.manage().window().maximize();
	}
	public static void login(String [][] recData) throws IOException
	{
		String EId = recData[1][2];
		String Pwd = recData[1][3];
		
		WebElement EmailId = new WebDriverWait(driver,10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='email']")));
		enterText(EmailId, EId, "EmailAddress"); 
		
		WebElement Password = new WebDriverWait(driver,10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='password']")));
		enterText(Password, Pwd, "Password");
	
		
		WebElement LoginButton = new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@id='submitButton']")));
		clickButton(LoginButton, "LoginButton");
	}
	public static void NavigateWindows() throws InterruptedException, IOException
	{
		String MainWindow=driver.getWindowHandle();
		// To handle all new opened window.				
        Set<String> s1=driver.getWindowHandles();		
        Iterator<String> i1=s1.iterator();		
    		
        while(i1.hasNext())			
        {		
        	String ChildWindow=i1.next();		
        		
        	if(!MainWindow.equalsIgnoreCase(ChildWindow))			
        	{    		
        		// Switching to Child window
                driver.switchTo().window(ChildWindow);
                //Update_Report("Pass", "Displaying Offer Details Page", "Successfully navigated to Offer Details Page");
                Thread.sleep(3000);
                driver.close();
        	}
        }
     // Switching to Parent window i.e Main Window.
        driver.switchTo().window(MainWindow);
	}

}
