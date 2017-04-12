/*
 * This file is for processing the input file & email. 
 */

package gmail.com;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GmailMailSender {
	
	public void send(String fileName) {
		WebDriver driver;
	
		/* Tried with absolute path but some how it is not working
 		File inputFile = new File(fileName);  
		String path = inputFile.getAbsolutePath();  
		System.out.println(path);   
		String cell[] = getCell(path); */
		
		String cell[] = getCell(fileName);

		System.out.println(Arrays.toString(cell));

		String browserNmae = cell[0];
		String emailId = cell[1];
		String password = cell[2];
		String toEmail = cell[3];
		String subjectEmail = cell[4];
		String bodyEmail = cell[5];
		String searchString = cell[6];
		String specificEmail = cell[7];
		
		
		BrowserSelect browserSelection = new BrowserSelect();
		driver = browserSelection.selectBrowser(browserNmae);
		
		driver.findElement(By.id("Email")).sendKeys(emailId);
		driver.findElement(By.id("Passwd")).sendKeys(password);
		driver.findElement(By.id("signIn")).click();

		// To skip the unnecessary pages
		driver.navigate().refresh();
		
		boolean shouldSkipBody = false;
		// This block is for skipping the email body for Chrome Browser 
		if (browserNmae.equals("CH")) shouldSkipBody = true;
		
		Email genEmail = new Email();
		genEmail.email(driver, toEmail, subjectEmail, bodyEmail, shouldSkipBody);
		
		WebElement sentMailClick = driver.findElement(By.xpath("//a[text()='Sent Mail']"));
		sentMailClick.click();
		
		//For skipping the email body for failEmail & passEmail.
		shouldSkipBody = true;

		driver.findElement(By.xpath("//input[@name='q']")).sendKeys("subject:"+searchString);
		driver.findElement(By.xpath("//button[@aria-label='Google Search']")).click();
	
		/*
		 * Logic: If the click on the 1st row is successful,
		 * then element exists so automation is successful,
		 * and vice versa.
		 */
		boolean searchResultFound;
		try {
			driver.findElement(By.xpath("//div[6]//tr[1]/td[6]//span[1]")).click(); //Sometimes this element is missing due to Dynamic design
			searchResultFound = true;
		} catch (Exception e) {
			searchResultFound = false;
		}

		if (searchResultFound) {
			System.out.println("Found");
			Email passEmail = new Email();
			passEmail.email(driver, specificEmail, "Automation Succeeded","The automation is successful.", shouldSkipBody);
		} else {
			System.out.println("Not Found");
			Email failEmail = new Email();
			failEmail.email(driver, specificEmail, "Automation Failed.","The automation is failed.", shouldSkipBody);
		}
		System.out.println("Done, Thanks.");
	}
	
	// Ref: StactOverFlow
	@SuppressWarnings("resource")
	private String[] getCell(String path) {

		BufferedReader br = null;
		String spliteBy = ",";
		String inputLine = null;

		try {
			br = new BufferedReader(new FileReader(path));
			while ((inputLine = br.readLine()) != null) break;
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		return inputLine.split(spliteBy);
	}
}
