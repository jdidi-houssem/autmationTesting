package com.upToTest.amazon.e2etest.automation.authentication;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.upToTest.amazon.e2etest.automation.utils.Setup;
import com.upToTest.amazon.e2etest.automation.utils.WaitMethods;

public class AuthenticationPage {

	/* Locators */
	final static String ACCEPT_COOKIES = "sp-cc-accept";
	final static String COMPTES_ET_LISTES = "nav-link-accountList";
	final static String EMAIL = "ap_email";
	final static String CONTINUE_BUTTON = "continue";
	final static String PASSWORD = "ap_password";
	final static String SIGN_IN_SUBMIT_BUTTON = "signInSubmit";
	final static String MESSAGE = "nav-link-accountList-nav-line-1";
	final static String ERROR_INVALID_MAIL = "//*[@id=\"auth-error-message-box\"]/div/h4";
	/* @FindBy */
	@FindBy(how = How.ID, using = ACCEPT_COOKIES)
	public static WebElement acceptCookiesBtn;
	@FindBy(how = How.ID, using = COMPTES_ET_LISTES)
	public static WebElement comptesEtListes;
	@FindBy(how = How.ID, using = EMAIL)
	public static WebElement email;
	@FindBy(how = How.ID, using = CONTINUE_BUTTON)
	public static WebElement btnContinue;
	@FindBy(how = How.ID, using = PASSWORD)
	public static WebElement password;
	@FindBy(how = How.ID, using = SIGN_IN_SUBMIT_BUTTON)
	public static WebElement btnSignIn;
	@FindBy(how = How.ID, using = MESSAGE)
	public static WebElement message;
	@FindBy(how = How.XPATH, using = ERROR_INVALID_MAIL)
	public static WebElement erreurEmail;
	/* Instantiation */
	WaitMethods waitMethods = new WaitMethods();
	WebDriver driver = Setup.driver;

	/* Methods */
	public void clickAcceptCookies() {
		acceptCookiesBtn.click();
	}

	public void clickComptesEtListes() {
		waitMethods.explicitWaitUntilVisibilityOfWEId(driver, COMPTES_ET_LISTES, 3);
		comptesEtListes.click();
	}

	public void fillEmail(String adresseEmail) {
		email.sendKeys(adresseEmail);
	}

	public void clickBtnContinue() {
		btnContinue.click();
	}

	public void fillPassword(String psd) {
		waitMethods.explicitWaitUntilVisibilityOfWEId(driver, PASSWORD, 1);
		password.sendKeys(psd);
	}

	public void clickBtnSignIn() {
		btnSignIn.click();
	}

	public String getAccountText() {
		waitMethods.explicitWaitUntilVisibilityOfWEId(driver, MESSAGE, 1);
		return message.getText();
	}

	public String getErreurInvalidMailText() {
		waitMethods.explicitWaitUntilVisibilityOfWEXpath(driver, ERROR_INVALID_MAIL, 10);
		return erreurEmail.getText();
	}
}
