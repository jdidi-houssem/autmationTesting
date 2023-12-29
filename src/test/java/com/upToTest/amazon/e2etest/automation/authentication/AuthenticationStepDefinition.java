package com.upToTest.amazon.e2etest.automation.authentication;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import com.upToTest.amazon.e2etest.automation.utils.CommonMethods;
import com.upToTest.amazon.e2etest.automation.utils.Setup;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AuthenticationStepDefinition extends CommonMethods {

	public WebDriver driver;
	public AuthenticationPage authenticationPage = new AuthenticationPage();

	public AuthenticationStepDefinition() {
		super();
		driver = Setup.driver;
		PageFactory.initElements(driver, authenticationPage);
	}

	@Given("Je navigue sur l'app AMAZON")
	public void jeNavigueSurLAppAMAZON() throws IOException, InterruptedException {
		super.openURLWithConfigFile("url");
		TimeUnit.SECONDS.sleep(1);
		driver.navigate().refresh();
	}

	/*
	 * @Given("J'accepte les cookies") public void jAccepteLesCookies() {
	 * authenticationPage.clickAcceptCookies(); }
	 */
	@When("Je clique sur compte et listes")
	public void jeCliqueSurCompteEtListes() {
		authenticationPage.clickComptesEtListes();
	}

	@When("Je saisis l'email {string}")
	public void jeSaisisLEmail(String email) {
		authenticationPage.fillEmail(email);
	}

	@When("Je clique sur continuer")
	public void jeCliqueSurContinuer() {
		authenticationPage.clickBtnContinue();
	}

	@When("Je saisis le mdp {string}")
	public void jeSaisisLeMdp(String password) {
		authenticationPage.fillPassword(password);
	}

	@When("Je clique sur s'identifier")
	public void jeCliqueSurSIdentifier() {
		authenticationPage.clickBtnSignIn();
	}

	@Then("Je me dirige vers la page d'accueil et {string}")
	public void jeMeDirigeVersLaPageDAccueilEt(String msg) {
		String message = authenticationPage.getAccountText();
		System.out.println("message is: " + message);
		Assert.assertTrue(message.contains(msg));
	}

	@Then("Un message d'erreur s'affiche {string}")
	public void unMessageDErreurSAffiche(String erreurEmail) {
		String message = authenticationPage.getErreurInvalidMailText();
		System.out.println("message is: " + message);
		Assert.assertTrue(message.contains(erreurEmail));
	}



}
