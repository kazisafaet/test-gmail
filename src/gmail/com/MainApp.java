package gmail.com;

public class MainApp {

	public static void main(String[] args) {
		GmailMailSender mailSender = new GmailMailSender();
		mailSender.send("D:/SOFTWARE/eclipse-standard-kepler-SR2-win32/WS//workspace/testGmail/src/data/input.csv");
		/* Tried with absolute path but some how it is not working
		mailSender.send("input.csv");*/
		
	}
}