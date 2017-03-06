package test;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverExam {
	public static WebDriver driver;
	public static int reportFlag = 0;
	public static void main(String[] args) throws IOException, NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, InterruptedException {
		// TODO Auto-generated method stub
		
		String dataPath = "D:/TekArc/TestSuiteExam.xls";
		
		String[][] recData = ReUseableMethodsExam.readSheet(dataPath, "Sheet1");
		for(int i = 1; i <recData.length; i++){
			
			if(recData[i][1].equalsIgnoreCase("Y")){
				
				/*Firefox*/
				if(recData[i][3].equalsIgnoreCase("Y")){
					driver = new FirefoxDriver();
					reportFlag = 0;  // Reset
					String testScript = recData[i][2];
					ReUseableMethodsExam.startReport(testScript, "D:/eclipse/Advanced Programming/SeleniumExam/Report/", "Firefox");
					
					/*Java Reflection or Reflexive API*/
					Method ts = AutomationScriptsExam.class.getMethod(testScript);
					ts.invoke(ts);
					
					driver.close();
					if(reportFlag == 0){
						ReUseableMethodsExam.writeExcel(dataPath, "Sheet1", i, 5, "Pass");
					}else{
						ReUseableMethodsExam.writeExcel(dataPath, "Sheet1", i, 5, "Fail");
					}
				}
				Thread.sleep(10000);
				// Chrome..
				if(recData[i][4].equalsIgnoreCase("Y")){
				
					System.setProperty("webdriver.chrome.driver", "D:/TekArc/chromedriver.exe");
					driver = new ChromeDriver();
					
					reportFlag = 0;  // Reset
					String testScript = recData[i][2];
					ReUseableMethodsExam.startReport(testScript, "D:/eclipse/Advanced Programming/SeleniumExam/Report/", "Chrome");
					
					/*Java Reflection or Reflexive API*/
					Method ts = AutomationScriptsExam.class.getMethod(testScript);
					ts.invoke(ts);
					
					driver.close();
					if(reportFlag == 0){
						ReUseableMethodsExam.writeExcel(dataPath, "Sheet1", i, 6, "Pass");
					}else{
						ReUseableMethodsExam.writeExcel(dataPath, "Sheet1", i, 6, "Fail");
					}
				}
				
				
				
			}else{
				System.out.println("Row number :" +i+ " script is not executed..");
				System.out.println();
				ReUseableMethodsExam.writeExcel(dataPath, "Sheet1", i, 3, "NA");
			}
			
			//ReUsableMethods_Exam.bw.close();
		}
	}

}
