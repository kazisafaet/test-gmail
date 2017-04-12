# Welcome to my project #
*****************************************************************************************************************************************************************
************************************************* Test Assignment for SQA ***************************************************************************************

You have to automate the following scenarios using Selenium Webdriver with Java as scripting language. Please remember that whole scripting should be dynamic so 
that if we change any value then the automation should work properly. Your script should run in any browser, as we like.

Scenario: 
a.  Open browser and type gmail.com in URL Address Bar. 
b.  Enter username and password in the fields and click Sign in. 
c.  Now click Compose. 
d.  Enter only one To address, Subject: This is test mail for Widespace Test Assignment, and the mail body. Mail Body can contain anything that we will provide. 
e.  Now send email. 
f.  After mail is sent, go to Sent Mail. 
g.  Check the Sent Mail box for the mails with the Subject. 

If the scenario passed then sent an email to a specific email with subject and mail 
body as: Automation Succeeded, otherwise Automation Failed.

*****************************************************************************************************************************************************************
******************************************************* Project structure ***************************************************************************************

MainApp.java
 I
 I--> GmailMailSender.java
       I
       I--> BrowserSelect.java
       I
       I--> Email.java

*****************************************************************************************************************************************************************
******************************************************* How to run the project **********************************************************************************
1. Download "testGmail.rar".
2. Extract it.
3. Now open eclipse.
4. File -> Import -> General -> Existing Project into Workplace
5. Next.
6. Select root directory -> Browser.
7. Browser For Folder.
8. Finish.
9. Open "MainApp.java".
 9.1 Go to Line 8.
 9.2 Change the "input.csv" file path according to your OS.
10. Open "BrowserSelect.java".
 10.1 Go to Line 21 & 28.
 10.2 Change the "IEDriverServer.exe" and "chromedriver.exe" file path according to your OS.
11. Run -> Run.
12. Select "Java Application", click "OK".
13. "Select Java Application" window will be appeared.
14. Select "MainApp - gmail.com", click "OK".

*****************************************************************************************************************************************************************
************************************** Input data formation of "input.csv" file *********************************************************************************

1st value: Browser Type Like "FF" for Firefox, "CH" for Chrome, "IE" for Internet Explorer.
2nd value: User Email ID
3rd value: User Password
4th value: "To" Email address.
5th value: Subject of the email like "This is test mail for Widespace Test Assignment".
6th value: Body of the email.
7th value: Search String for checking the last send email.
8th value: A specific email where the automation status will be sent.
********************************************** Sample input string **********************************************************************************************

FF,test.username.email.id@gmail.com,testusername,test.username.email.id@gmail.com,This is test mail for Widespace Test Assignment,This is Body of test mail for Widespace Test Assignment,Widespace,ksmauvi@gmail.com

*****************************************************************************************************************************************************************
********************************************** Interesting Topic ************************************************************************************************

While googling I found this thread in selenium user google group
 
Stop trying to automate GMail
https://groups.google.com/forum/#!searchin/selenium-users/automate$20gmail/selenium-users/8jR6Fw5ndxU/7peVDuzkNN4J

***************************************************************************************************************************************************************** 
*****************************************************************************************************************************************************************
It is really not so easy to automate gmail, because of it's super intelligent design. Almost all of it's ids are dynamic. But I tried my best.

Thanks
Kazi Safaet Mahmud Auvi