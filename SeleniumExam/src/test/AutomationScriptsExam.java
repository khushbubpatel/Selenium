package test;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AutomationScriptsExam extends ReUseableMethodsExam {
	public static void TCID01A() throws IOException, InterruptedException 
	{	
		// TODO Auto-generated method stub
		String dt_Path = "D:/TekArc/TCID01A.xls";
		String [][] recData = ReUseableMethodsExam.readSheet(dt_Path, "Sheet1");
		
		ModuleExam.initialize(recData);
		
		
		ModuleExam.login(recData);
		
		
		bw.close();
		Thread.sleep(5000);
		//driver.quit();
	}
	
	public static void TCID01B() throws IOException, InterruptedException
	{
		String dt_Path = "D:/TekArc/TCID01B.xls";
		String [][] recData = ReUseableMethodsExam.readSheet(dt_Path, "Sheet1");
		
		ModuleExam.initialize(recData);
		
		ModuleExam.login(recData);
		
		String actualErrorMessage = "";
		String expectedErrorMessage = recData[1][4];
		
		
		
		
		if(driver.findElement(By.xpath("//*[@id='contentTop']/div[2]/div[1]/div[2]/p")).isDisplayed())
		{
			actualErrorMessage = (driver.findElement(By.xpath("//*[@id='contentTop']/div[2]/div[1]/div[2]/p"))).getText().trim();
		}
		
		if(expectedErrorMessage.equalsIgnoreCase(actualErrorMessage))
		{
			Update_Report("Pass", "Validate Error message ", "Expected error message is matching to actual error message.");
		}
		else
		{
			Update_Report("Fail", "Validate Error message", "Expected error message is NOT matching to actual error message.");
		}
		bw.close();
		Thread.sleep(5000);
	}
	
	public static void TCID01C() throws IOException, InterruptedException
	{
		String dt_Path = "D:/TekArc/TCID01C.xls";
		String [][] recData = ReUseableMethodsExam.readSheet(dt_Path, "Sheet1");
		
		ModuleExam.initialize(recData);
		
		ModuleExam.login(recData);
		
		String actualErrorMessage = "";
		String expectedErrorMessage = recData[1][4];
		
		
		
		if(driver.findElement(By.xpath("//*[@id='contentTop']/div[2]/div[1]/div[2]/p")).isDisplayed())
		{
			actualErrorMessage = (driver.findElement(By.xpath("//*[@id='contentTop']/div[2]/div[1]/div[2]/p"))).getText().trim();
		}
		
		if(expectedErrorMessage.equalsIgnoreCase(actualErrorMessage))
		{
			Update_Report("Pass", "Validate Error message ", "Expected error message is matching to actual error message.");
		}
		else
		{
			Update_Report("Fail", "Validate Error message", "Expected error message is NOT matching to actual error message.");
		}
		bw.close();
		Thread.sleep(5000);
	}
	
	public static void TCID01D() throws IOException, InterruptedException
	{
		String dt_Path = "D:/TekArc/TCID01D.xls";
		String [][] recData = ReUseableMethodsExam.readSheet(dt_Path, "Sheet1");
		
		ModuleExam.initialize(recData);
		
		
		String EId = recData[1][2];
		String ActualErrorMessage = "";
		String ActualUserName = "";
		String ExpectedErrorMessage = recData[1][3];
		System.out.println(ExpectedErrorMessage);
		
		WebElement ForgotPwdLink = new WebDriverWait(driver,10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='contentTop']/div[2]/div[1]/a")));
		clickButton(ForgotPwdLink, "ForgotPassword");
		
		WebElement UserNameForgotPwdField = new WebDriverWait(driver,10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='UserName']")));
		enterText(UserNameForgotPwdField,EId , "UserName");
		
		WebElement SendLinkButton = new WebDriverWait(driver,10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='submitButton']/a")));
		clickButton(SendLinkButton, "SendLink");
	
		Thread.sleep(5000);
		if(driver.findElement(By.xpath("//*[@id='contentTop']/div/p[1]")).isDisplayed())
		{
			ActualErrorMessage = new WebDriverWait(driver,10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='contentTop']/div/p[1]"))).getText().trim();
			System.out.println(ActualErrorMessage);
		}
		
		if(ExpectedErrorMessage.equals(ActualErrorMessage))
		{
			Update_Report("Pass", "Validate error message", "Expected error message is matching to actual error message.");
		}
		else
		{
			Update_Report("Fail", "Validate error message", "Expected error message is not matching to actual error message.");
		}
		
		if(driver.findElement(By.xpath("//*[@id='contentTop']/div/p[1]/strong")).isDisplayed())
		{
			ActualUserName = new WebDriverWait(driver,10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='contentTop']/div/p[1]/strong"))).getText().trim(); 
		}
		if(EId.equals(ActualUserName))
		{
			Update_Report("Pass", "Validate Email to send forgot password link", "Username linked to account is matching to actual username to which the link is sent.");
		}
		else
		{
			Update_Report("Fail", "Validate Email to send forgot password link", "Username linked to account is NOT matching to actual username to which the link is sent.");
		}
		bw.close();
		Thread.sleep(5000);
	}
	
	public static void TCID02A() throws IOException, InterruptedException
	{
		
		String dt_Path = "D:/TekArc/TCID02A.xls";
		String [][] recData = ReUseableMethodsExam.readSheet(dt_Path, "Sheet1");
		
		ModuleExam.initialize(recData);
		
		WebElement  FreeTrialButton = new WebDriverWait(driver,10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@class='glh-mainlink-cta-wrapper']")));
		clickButton(FreeTrialButton, "FreeTrial");
		
		String FName = recData[1][2];
		WebElement FirstName = new WebDriverWait(driver,10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@name='FirstName']")));
		enterText(FirstName, FName, "FirstName");
		
		String LName = recData[1][3];
		WebElement LastName = new WebDriverWait(driver,10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@name='LastName']")));
		enterText(LastName, LName, "LastName");
		
		String EmailAdd = recData[1][4];
		WebElement EmailAddress = new WebDriverWait(driver,10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@name='EmailAddress']")));
		enterText(EmailAddress, EmailAdd, "EmailAddress");
		
		String PhNo = recData[1][5];
		WebElement PhoneNo = new WebDriverWait(driver,10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@name='PhoneNumber']")));
		enterText(PhoneNo, PhNo, "PhoneNumber");
		
		WebElement CountryDropDown = new WebDriverWait(driver,10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//select[@name='LocationCode']")));
		Select clickCountry = new Select(CountryDropDown);
		clickCountry.selectByValue("IN");
		System.out.println("Here");
		// .//*[@id='recaptcha-anchor']/div[5]
		// //div[@class='recaptcha-checkbox-checkmark']
		/*Thread.sleep(2000);
		WebElement CaptchaCheckBox = new WebDriverWait(driver,10).until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@id='recaptcha-anchor']/div[5]")));
		selectCheckBox(CaptchaCheckBox, "CaptchaCheckBox");*/
		
		WebElement TermsCheckBox = new WebDriverWait(driver,10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@name='TermsAccepted']")));
		selectCheckBox(TermsCheckBox, "TermsAndConditionsCheckBox");
		System.out.println("Here");
		
		WebElement GetStartedButton = new WebDriverWait(driver,10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@class='btn btn-primary btn-disabled']")));
		clickButton(GetStartedButton, "GetStarted");
		bw.close();
		Thread.sleep(5000);
	}
	
	public static void TCID02C() throws IOException, InterruptedException
	{
		String dt_Path = "D:/TekArc/TCID02C.xls";
		String [][] recData = ReUseableMethodsExam.readSheet(dt_Path, "Sheet1");
		
		ModuleExam.initialize(recData);
		
		WebElement  FreeTrialButton = new WebDriverWait(driver,10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@class='glh-mainlink-cta-wrapper']")));
		clickButton(FreeTrialButton, "FreeTrial");
		
		WebElement TermsOfUseLink = new WebDriverWait(driver,10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[@class='form-label']/a[@href='https://www.xero.com/us/about/terms/']")));
		clickButton(TermsOfUseLink, "TermsOfUse");
		
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
                driver.close();
        	}
        }
     // Switching to Parent window i.e Main Window.
        driver.switchTo().window(MainWindow);
        
        WebElement PrivacyPolicyLink = new WebDriverWait(driver,10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[@class='form-label']/a[@href='https://www.xero.com/us/about/privacy/']")));
        clickButton(PrivacyPolicyLink, "PrivacyPolicy");
        
       MainWindow=driver.getWindowHandle();
		// To handle all new opened window.				
        s1=driver.getWindowHandles();		
        i1=s1.iterator();		
    		
        while(i1.hasNext())			
        {		
        	String ChildWindow=i1.next();		
        		
        	if(!MainWindow.equalsIgnoreCase(ChildWindow))			
        	{    		
        		// Switching to Child window
                driver.switchTo().window(ChildWindow);
                driver.close();
        	}
        }
     // Switching to Parent window i.e Main Window.
        driver.switchTo().window(MainWindow);
        
        bw.close();
        Thread.sleep(5000);
	}
	
	public static void TCID02D() throws IOException, InterruptedException
	{
		String dt_Path = "D:/TekArc/TCID02D.xls";
		String [][] recData = ReUseableMethodsExam.readSheet(dt_Path, "Sheet1");
		
		ModuleExam.initialize(recData);
		
		WebElement  FreeTrialButton = new WebDriverWait(driver,10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@class='glh-mainlink-cta-wrapper']")));
		clickButton(FreeTrialButton, "FreeTrial");
		
		WebElement OfferDetails = new WebDriverWait(driver,10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[@class='form-label']/a[@href='https://www.xero.com/us/signup/offer-details/']")));
		clickButton(OfferDetails, "OfferDetails");
		
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
                Update_Report("Pass", "Displaying Offer Details Page", "Successfully navigated to Offer Details Page");
                Thread.sleep(3000);
                driver.close();
        	}
        }
     // Switching to Parent window i.e Main Window.
        driver.switchTo().window(MainWindow);
        
        bw.close();
        Thread.sleep(5000);
	}
	
	public static void TCID02E() throws IOException, InterruptedException
	{
		String dt_Path = "D:/TekArc/TCID02E.xls";
		String [][] recData = ReUseableMethodsExam.readSheet(dt_Path, "Sheet1");
	
		ModuleExam.initialize(recData);
		
		WebElement  FreeTrialButton = new WebDriverWait(driver,10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@class='glh-mainlink-cta-wrapper']")));
		clickButton(FreeTrialButton, "FreeTrial");
		
		WebElement AccountantBookkeeper = new WebDriverWait(driver,10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@href='https://www.xero.com/us/partners/signup/']")));
		clickButton(AccountantBookkeeper, "AccountantOrBookkeeper");
		
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
                Update_Report("Pass", "Displaying Accountant or Bookkeeper Page", "Successfully navigated to Accountant or Bookkeeper Page");
                Thread.sleep(3000);
                driver.close();
        	}
        }
     // Switching to Parent window i.e Main Window.
        driver.switchTo().window(MainWindow);
        
        bw.close();
        Thread.sleep(5000);
	}
	
	public static void TCID03A() throws IOException, InterruptedException
	{
		String dt_Path = "D:/TekArc/TCID03A.xls";
		String [][] recData = ReUseableMethodsExam.readSheet(dt_Path, "Sheet1");
		
		ModuleExam.initialize(recData);
		
		ModuleExam.login(recData);
		
		String ExpectedTrialAccountMessage = recData[1][4];
		String ActualTrialAccountMessage = "";
		
		Thread.sleep(2000);
		
		ActualTrialAccountMessage = new WebDriverWait(driver,10).until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@id='xero-nav']/div[1]/p"))).getText().trim();
		System.out.println(ActualTrialAccountMessage);
		
		if(ExpectedTrialAccountMessage.equals(ActualTrialAccountMessage))
		{
			Update_Report("Pass", "Validate Trial Account Message", "Expected Trial Account Message is matching to Actual Trial Account Message.");
		}
		else
		{
			Update_Report("Fail", "Validate Trial Account Message", "Expected Trial Account Message is not matching to Actual Trial Account Message.");
		}
	
		WebElement DashboardLink = new WebDriverWait(driver,10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='Dashboard']")));
		clickButton(DashboardLink, "Dashboard");
		
		
		
		
		
		
		
		
		//Accounts
		WebElement AccountsLink = new WebDriverWait(driver,10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='Accounts']")));
		clickButton(AccountsLink, "Accounts");
		
		String expectedTemp1 = recData[1][5];
		String [] expected1 = expectedTemp1.split(",");
		System.out.println("Accounts drop down expected array "+expected1.length);
		List<WebElement> AccountsDropDown = new WebDriverWait(driver,10).until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//*[@id='xero-nav']/div[2]/div[2]/div[1]/ul/li[2]/ul/li")));
		if (expected1.length != AccountsDropDown.size()) 
		{
		    //System.out.println("fail, wrong number of elements found");
			Update_Report("Fail", "Drop Down Contents Size Check", "wrong number of elements found");
		}
		// make sure that the value of every <option> element equals the expected value
		for (int i = 0; i < expected1.length; i++) 
		{
		    String AccountsdropDownContentValue = AccountsDropDown.get(i).getText();
		    System.out.println(AccountsdropDownContentValue);
		    if (AccountsdropDownContentValue.equals(expected1[i])) 
		    {
		        //System.out.println("passed on: " + ContactsdropDownContentValue);
		    	Update_Report("Pass", "Comparing Drop Down Contents", "Expected Drop down content value is matching to "+AccountsdropDownContentValue);
		    }
		    else 
		    {
		    	Update_Report("Fail", "Comparing Drop Down Contents", "Expected Drop down content value is NOT matching to "+AccountsdropDownContentValue);
		    }
		}
		
		
		clickButton(AccountsLink, "Accounts");
		
		
		
		//Reports
		String expectedTemp2 = recData[1][6];
		String [] expected2 = expectedTemp2.split(",");
		System.out.println("Reports drop down expected array "+expected2.length);
		WebElement ReportsLink = new WebDriverWait(driver,10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='Reports']")));
		clickButton(ReportsLink, "Reports");
		System.out.println("Clicked Reports");
		List<WebElement> ReportsDropDown= new WebDriverWait(driver,10).until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//*[@id='xero-nav']/div[2]/div[2]/div[1]/ul/li[4]/ul/li")));
		System.out.println("Reports Drop Down Size "+ReportsDropDown.size());
		System.out.println(ReportsDropDown);
		/*for(int i=0;i<ReportsDropDown.size();i++)
		{
			String ReportsDropDownContent = ReportsDropDown.get(i).getText();
			System.out.println(ReportsDropDownContent);
		}*/
		if (expected2.length != ReportsDropDown.size()) 
		{
		    //System.out.println("fail, wrong number of elements found");
			Update_Report("Fail", "Drop Down Contents Size Check", "wrong number of elements found");
		}
		// make sure that the value of every <option> element equals the expected value
		for (int i = 0; i < expected2.length; i++) 
		{
		    String ReportsDropDownContent = ReportsDropDown.get(i).getText();
		    System.out.println(ReportsDropDownContent);
		    if (ReportsDropDownContent.equals(expected2[i])) 
		    {
		        //System.out.println("passed on: " + ContactsdropDownContentValue);
		    	Update_Report("Pass", "Comparing Drop Down Contents", "Expected Drop down content value is matching to "+ReportsDropDownContent);
		    }
		    else 
		    {
		    	Update_Report("Fail", "Comparing Drop Down Contents", "Expected Drop down content value is NOT matching to "+ReportsDropDownContent);
		    }
		}
		clickButton(ReportsLink, "Reports");
		
		
		
		//Contacts
		WebElement ContactsDropDown = new WebDriverWait(driver,10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='Contacts']")));
		clickButton(ContactsDropDown, "Contacts");
		
		
		String expectedTemp3 = recData[1][7];
		String [] expected3 = expectedTemp3.split(",");
		System.out.println("Contacts DropDown Expected Array"+expected3.length);
		List<WebElement> ContactsDropDownList = new WebDriverWait(driver,10).until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//*[@id='xero-nav']/div[2]/div[2]/div[1]/ul/li[5]/ul/li")));
		System.out.println("Contacts DropDown list size"+ContactsDropDownList.size());
		// make sure you found the right number of elements
		if (expected3.length != ContactsDropDownList.size()) 
		{
		    //System.out.println("fail, wrong number of elements found");
			Update_Report("Fail", "Drop Down Contents Size Check", "wrong number of elements found");
		}
		// make sure that the value of every <option> element equals the expected value
		for (int i = 0; i < expected3.length; i++) 
		{
		    String ContactsdropDownContentValue = ContactsDropDownList.get(i).getText();
		    //System.out.println(ContactsdropDownContentValue);
		    if (ContactsdropDownContentValue.equals(expected3[i])) 
		    {
		        //System.out.println("passed on: " + ContactsdropDownContentValue);
		    	Update_Report("Pass", "Comparing Drop Down Contents", "Expected Drop down content value is matching to "+ContactsdropDownContentValue);
		    }
		    else 
		    {
		    	Update_Report("Fail", "Comparing Drop Down Contents", "Expected Drop down content value is NOT matching to "+ContactsdropDownContentValue);
		    }
		}
		clickButton(ContactsDropDown, "Contacts");
		
		
		//Settings
		WebElement SettingsDropDown = new WebDriverWait(driver,10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='Settings']")));
		clickButton(SettingsDropDown, "Settings");
		
		
		String expectedTemp4 = recData[1][8];
		String [] expected4 = expectedTemp4.split(",");
		System.out.println("Contacts DropDown Expected Array"+expected4.length);
		List<WebElement> SettingsDropDownList = new WebDriverWait(driver,10).until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//*[@id='xero-nav']/div[2]/div[2]/div[1]/ul/li[6]/ul/li")));
		System.out.println("Contacts DropDown list size"+SettingsDropDownList.size());
		// make sure you found the right number of elements
		if (expected4.length != SettingsDropDownList.size()) 
		{
		    //System.out.println("fail, wrong number of elements found");
			Update_Report("Fail", "Drop Down Contents Size Check", "wrong number of elements found");
		}
		// make sure that the value of every <option> element equals the expected value
		for (int i = 0; i < expected4.length; i++) 
		{
		    String SettingsdropDownContentValue = SettingsDropDownList.get(i).getText();
		    //System.out.println(ContactsdropDownContentValue);
		    if (SettingsdropDownContentValue.equals(expected4[i])) 
		    {
		        //System.out.println("passed on: " + ContactsdropDownContentValue);
		    	Update_Report("Pass", "Comparing Drop Down Contents", "Expected Drop down content value is matching to "+SettingsdropDownContentValue);
		    }
		    else 
		    {
		    	Update_Report("Fail", "Comparing Drop Down Contents", "Expected Drop down content value is NOT matching to "+SettingsdropDownContentValue);
		    }
		}
		clickButton(SettingsDropDown, "Settings");
		
		
		//New
		WebElement NewDropDown = new WebDriverWait(driver,10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='quicklaunchTab']")));
		clickButton(NewDropDown, "New");
		
		
		String expectedTemp5 = recData[1][9];
		String [] expected5 = expectedTemp5.split(",");
		System.out.println("New DropDown Expected Array"+expected5.length);
		List<WebElement> NewDropDownList = new WebDriverWait(driver,10).until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//*[@id='quicklaunchPanel']/div/div/div[2]/div/ul/li")));
		System.out.println("New DropDown list size"+NewDropDownList.size());
		// make sure you found the right number of elements
		if (expected5.length != NewDropDownList.size()) 
		{
		    //System.out.println("fail, wrong number of elements found");
			Update_Report("Fail", "Drop Down Contents Size Check", "wrong number of elements found");
		}
		// make sure that the value of every <option> element equals the expected value
		for (int i = 0; i < expected5.length; i++) 
		{
		    String NewdropDownContentValue = NewDropDownList.get(i).getText();
		    //System.out.println(ContactsdropDownContentValue);
		    if (NewdropDownContentValue.equals(expected5[i])) 
		    {
		        //System.out.println("passed on: " + ContactsdropDownContentValue);
		    	Update_Report("Pass", "Comparing Drop Down Contents", "Expected Drop down content value is matching to "+NewdropDownContentValue);
		    }
		    else 
		    {
		    	Update_Report("Fail", "Comparing Drop Down Contents", "Expected Drop down content value is NOT matching to "+NewdropDownContentValue);
		    }
		}
		clickButton(NewDropDown, "New");
		
		
		
		
		
		//FilesTab
		WebElement FilesTab = new WebDriverWait(driver,10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='xero-nav']/div[2]/div[2]/div[2]/ul/li[2]/a")));
		clickButton(FilesTab, "Files");
		
		String ExpectedTabHeading = recData[1][10];
		String ActualTabHeading = "";
				
		Thread.sleep(2000);
		if(driver.findElement(By.xpath("//*[@id='page_title']/div/h1[1]")).isDisplayed())
		{
			ActualTabHeading = new WebDriverWait(driver,10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='page_title']/div/h1[1]"))).getText().trim();
		}
		if(ExpectedTabHeading.equals(ActualTabHeading))
		{
			Update_Report("Pass", "Verify Page Dispalyed", "Successfully navigated to Files Page");
		}
		else
		{
			Update_Report("Fail", "Verify Page Dispalyed", "Could not navigate to Files Page. Please check your application.");
		}
		
		Thread.sleep(2000);
		// Notifications
		
		WebElement NotificationTab = new WebDriverWait(driver,10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@class='notifications x-sandbox']")));
		clickButton(NotificationTab, "Notifications");
		
		WebElement NotificationsIFrame = new WebDriverWait(driver,10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//iframe[@id='post_office_frame']")));
		driver.switchTo().frame(NotificationsIFrame);
		String ExpectedNotificationsIFrameHeading = recData[1][11];
		String ActualNotificationsIFrameHeading = "";
		if(driver.findElement(By.xpath("//*[@id='app']/div/div[2]/div[1]")).isDisplayed())
		{
			ActualNotificationsIFrameHeading = new WebDriverWait(driver,10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='app']/div/div[2]/div[1]"))).getText().trim();
		}
		if(ExpectedNotificationsIFrameHeading.equals(ActualNotificationsIFrameHeading))
		{
			Update_Report("Pass", "Verify Notifications IFrame", "Successfully displayed Notofications IFrame");
		}
		else
		{
			Update_Report("Fail", "Verify Notifications IFrame", "Could not display Notofications IFrame");
		}
		Thread.sleep(2000);
		driver.switchTo().defaultContent();
		
		
		//Search
		WebElement SearchTab = new WebDriverWait(driver,10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@class='search']")));
		clickButton(SearchTab, "Search");
		
		Thread.sleep(2000);
		
		//Help
		WebElement HelpTab = new WebDriverWait(driver,10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@class='help']")));
		clickButton(HelpTab, "Help");
		
		String ExpectedHelpTabHeading = recData[1][12];
		String ActualHelpTabHeading = "";
		
		if(driver.findElement(By.xpath("//*[@id='rt']/div[1]/h3")).isDisplayed())
		{
			ActualHelpTabHeading = new WebDriverWait(driver,10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='rt']/div[1]/h3"))).getText().trim();
		}
		if(ExpectedHelpTabHeading.equals(ActualHelpTabHeading))
		{
			Update_Report("Pass", "Verify Help Tab", "Successfully displayed Help Tab");
		}
		else
		{
			Update_Report("Fail", "Verify Help Tab", "Could not display Help Tab");
		}
		
		bw.close();
		Thread.sleep(5000);
	}
}
