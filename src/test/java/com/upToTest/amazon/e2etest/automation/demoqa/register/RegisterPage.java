package com.upToTest.amazon.e2etest.automation.demoqa.register;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.upToTest.amazon.e2etest.automation.utils.Setup;
import com.upToTest.amazon.e2etest.automation.utils.WaitMethods;

public class RegisterPage {

	/* Locators */
	final static String NEWUSER_BUTTON = "newUser";
	final static String FIRSTNAME = "firstname";
	final static String LASTNAME = "lastname";
	final static String USERNAME = "userName";
	final static String PASSWORD = "password";
	final static String REGISTER_BUTTON = "register";

	/* @FindBy */
	@FindBy(how = How.ID, using = NEWUSER_BUTTON)
	public static WebElement btnNewUser;
	@FindBy(how = How.ID, using = FIRSTNAME)
	public static WebElement firstname;
	@FindBy(how = How.ID, using = LASTNAME)
	public static WebElement lastname;
	@FindBy(how = How.ID, using = USERNAME)
	public static WebElement username;
	@FindBy(how = How.ID, using = PASSWORD)
	public static WebElement password;
	@FindBy(how = How.ID, using = REGISTER_BUTTON)
	public static WebElement btnRegister;

	/* Instantiation */
	WaitMethods waitMethods = new WaitMethods();
	WebDriver driver = Setup.driver;

	/* Methods */
	public void clickBtnNewUser() {
		waitMethods.explicitWaitUntilVisibilityOfWEId(driver, NEWUSER_BUTTON, 1);
		btnNewUser.click();
	}

	public void fillFirstName(String fname) {
		firstname.sendKeys(fname);
	}

	public void fillLastName(String lname) {
		lastname.sendKeys(lname);
	}

	public void fillUserName(String uname) {
		username.sendKeys(uname);
	}

	public void fillPassword(String psd) {
		password.sendKeys(psd);
	}

	public void checkedRecaptcha() {

		new WebDriverWait(driver, 10).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath(
				"//iframe[starts-with(@name, 'a-') and starts-with(@src, 'https://www.google.com/recaptcha')]")));

		new WebDriverWait(driver, 20).until(
				ExpectedConditions.elementToBeClickable(By.xpath("//div [ @class =  'recaptcha-checkbox-border']")))
				.click();
		System.out.println("Clicked the checkbox");
		driver.switchTo().defaultContent();

		new WebDriverWait(driver, 20)
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='register']"))).click();
		System.out.println("Clicked the Register button");

	}

	public void clickBtnRegister() {

		btnRegister.click();
		System.out.println("Clicked the Register button");
	}

}
