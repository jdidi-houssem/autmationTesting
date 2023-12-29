package com.upToTest.amazon.e2etest.automation.demoqa.login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import com.upToTest.amazon.e2etest.automation.utils.Setup;
import com.upToTest.amazon.e2etest.automation.utils.WaitMethods;

public class LoginPage {

	/* Locators */
	final static String USERNAME = "userName";
	final static String PASSWORD = "password";
	final static String LOGIN_BUTTON = "login";
	final static String INVALID_USERNAME = "name";

	/* @FindBy */
	@FindBy(how = How.ID, using = USERNAME)
	public static WebElement username;
	@FindBy(how = How.ID, using = PASSWORD)
	public static WebElement password;
	@FindBy(how = How.ID, using = LOGIN_BUTTON)
	public static WebElement btnLogin;
	@FindBy(how = How.ID, using = INVALID_USERNAME)
	public static WebElement invalidUsername;
	/* Instantiation */
	WaitMethods waitMethods = new WaitMethods();
	WebDriver driver = Setup.driver;

	/* Methods */
	public void fillUserName(String uname) {
		username.sendKeys(uname);
	}

	public void fillPassword(String psd) {
		password.sendKeys(psd);
	}

	public void clickBtnLogin() {
		waitMethods.explicitWaitUntilVisibilityOfWEId(driver, LOGIN_BUTTON, 2);
		btnLogin.click();
	}

	public String getErreurInvalidUsername() {
		waitMethods.explicitWaitUntilVisibilityOfWEId(driver, INVALID_USERNAME, 10);
		return invalidUsername.getText();
	}

}
