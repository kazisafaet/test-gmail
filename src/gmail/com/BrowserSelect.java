/*
 * This file is for selecting browser
 */

package gmail.com;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.By;

public class BrowserSelect {

	public WebDriver selectBrowser(String browserName) {
		
		WebDriver driver = null;
		if(browserName.equals("FF")){
			
			driver = new FirefoxDriver();
			driver.get("https://gmail.com");
		}
		/*Tried with IE but not successful, need more time to investigate*/
		else if (browserName.equals("IE")){
			System.setProperty("webdriver.internetExplorer.driver", "D:/SOFTWARE/eclipse-standard-kepler-SR2-win32/WS/workspace/testGmail/src/WebDrivers/IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			driver.get("https://gmail.com");
			driver.findElement(By.xpath("//a[@id='gmail-sign-in']")).click();
		}
		/*Chrome is doing well without email body section sometimes, need more time to investigate*/
		else if(browserName.equals("CH")){
			System.setProperty("webdriver.chrome.driver", "D:/SOFTWARE/eclipse-standard-kepler-SR2-win32/WS/workspace/testGmail/src/WebDrivers/chromedriver.exe");
			driver = new ChromeDriver();
			driver.get("https://gmail.com");
		}
		return driver;
	}
}
