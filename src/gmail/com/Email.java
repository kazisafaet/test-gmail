/*
 * This file is for processing every email 
 */

package gmail.com;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Email {
	
	void email(WebDriver driver, String toEmail,String subjectEmail,String bodyEmail, boolean shouldSkipBody){
		//Waiting for full page loading
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//Click on COMPOSE
		WebElement composeClick = driver.findElement(By.xpath("//div[text()='COMPOSE']"));
		composeClick.click();

		driver.findElement(By.xpath("//div/textarea[@name='to']")).sendKeys(toEmail);
		driver.findElement(By.xpath("//div/input[@name='subjectbox']")).sendKeys(subjectEmail);
		
		/* I tried to write in body by following the below link and sometimes I succeeded for the genEmail but not for failEmail & passEmail .
		 * So that I skipped this section for failEmail & passEmail.
		 * 
		 * Ref: http://selenium.10932.n7.nabble.com/Unable-to-switch-to-Body-of-the-Gmail-Email-Compose-box-Iframe-does-not-have-any-id-td29035.html
		 */
		if(!shouldSkipBody){
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@tabindex,'1') and contains(@frameborder,'0')]"))); //Switching to iframe
		driver.findElement(By.xpath("/html/body[@role='textbox']")).sendKeys(bodyEmail);    //Typing text into Email body //body[@role='textbox']
		driver.switchTo().defaultContent();   //switching back out from iframe
		}
		
		WebElement sendClick = driver.findElement(By.xpath("//div[text()='Send']"));
		sendClick.click(); 		
	}
}
