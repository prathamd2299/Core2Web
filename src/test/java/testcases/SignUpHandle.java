package testcases;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SignUpHandle {
	String str1 = "p";
	String str2 = "Prathamesh2Dhasade";
	String str3 = "prat78";
	String str4 = "Pratham";
	String str5 = "l834530434";
	public WebDriver driver;

	@BeforeClass
	public void launchURL() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.navigate().to("https://core2web.in/");
	}

	@Test(priority = 1)
	public void signUpLinkClick() throws InterruptedException {
		WebElement signUpLink = driver
				.findElement(By.xpath("//div[@class='navigation--tab navigation--bar--signup--tab--btn']"));
		signUpLink.click();
		Thread.sleep(2000);
	}

	@Test(priority = 2)
	public void enterUsername() throws InterruptedException {
		WebElement username = driver.findElement(By.id("signup__username"));
		username.sendKeys(str1);
		String regex = "^[a-z]\\\\w{1,29}$";
		Pattern p = Pattern.compile(regex);

		Matcher m = p.matcher(str1);
		if (m.matches()) {
			System.out.println("Valid username\n");
		} else {
			WebElement errorUserName = driver.findElement(By.xpath("(//div[@class='signup__label'])[1]"));
			System.out.println(errorUserName.getText());
		}
		Thread.sleep(2000);
	}

	@Test(priority = 3)
	public void enterFullname() throws InterruptedException {
		WebElement fullname = driver.findElement(By.id("signup__name"));
		fullname.sendKeys(str2);

		String actualFullname = fullname.getAttribute("value");
		System.out.println(actualFullname);

		String regex = "\\p{Upper}(\\p{Lower}+\\s?)";

		String patternName = "(" + regex + "){2,60}";
		if (str2.matches(patternName)) {
			System.out.println("Valid Full Name\n");
		} else {
			WebElement errorFullName = driver.findElement(By.xpath("(//div[@class='signup__label'])[2]"));
			System.out.println(errorFullName.getText());
			System.out.println("Invalid Full Name\n");
		}
		Thread.sleep(2000);
	}

	@Test(priority = 4)
	public void enterEmail() throws InterruptedException {
		WebElement email = driver.findElement(By.id("signup_email"));
		email.sendKeys(str3);

		String actualEmail = email.getAttribute("value");
		System.out.println(actualEmail);
		String regex = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
		Pattern p = Pattern.compile(regex);

		Matcher m = p.matcher(str3);
		if (m.matches()) {
			System.out.println("Valid Email\n");
		} else {
			WebElement errorEmail = driver.findElement(By.xpath("(//div[@class='signup__label'])[3]"));
			System.out.println(errorEmail.getText());
			System.out.println("Invalid Email\n");
		}
		Thread.sleep(2000);
	}

	@Test(priority = 5)
	public void enterPassword() throws InterruptedException {
		WebElement password = driver.findElement(By.id("signup__password"));
		password.sendKeys(str4);

		String actualPassword = password.getAttribute("value");
		System.out.println(actualPassword);
		String regex = "^(?=.*[0-9])" + "(?=.*[a-z])(?=.*[A-Z])" + "(?=.*[@#$%^&+=])" + "(?=\\S+$).{8,50}$";
		Pattern p = Pattern.compile(regex);

		Matcher m = p.matcher(str4);
		if (m.matches()) {
			System.out.println("Valid Password\n");
		} else {
			WebElement errorpassword = driver.findElement(By.xpath("(//div[@class='signup__label'])[4]"));
			System.out.println(errorpassword.getText());
			System.out.println("Invalid Password\n");
		}
		Thread.sleep(2000);
	}

	@Test(priority = 6)
	public void enterPhoneNumber() throws InterruptedException {
		WebElement phoneNumber = driver.findElement(By.id("signup__phone-number"));
		phoneNumber.sendKeys(str5);
		String actualPhoneNumber = phoneNumber.getAttribute("value");
		System.out.println(actualPhoneNumber);
		String regex = "(0/91)?[7-9][0-9]{9}";
		Pattern p = Pattern.compile(regex);

		Matcher m = p.matcher(str5);
		if (m.matches()) {
			System.out.println("Valid Phone Number\n");
		} else {
			WebElement errorPhoneNumber = driver.findElement(By.xpath("(//div[@class='signup__label'])[5]"));
			System.out.println(errorPhoneNumber.getText());
			System.out.println("Invalid Phone Number\n");
		}
		Thread.sleep(2000);
	}

	@Test(priority = 7)
	public void clickOnTerms() throws InterruptedException {
		WebElement terms = driver.findElement(By.xpath("//input[@class='signup__tandc']"));
		terms.click();
		Thread.sleep(2000);
	}

	@Test(priority = 8)
	public void clickOnSignUpButton() throws InterruptedException {
		WebElement signUpButton = driver.findElement(By.xpath("//button[@class='signup__submit-button']"));
		signUpButton.click();
		Thread.sleep(2000);
	}

	@AfterClass
	public void tearDown() throws InterruptedException {
		Thread.sleep(2000);
		driver.quit();
	}

}
