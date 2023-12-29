package com.upToTest.amazon.e2etest.automation.demoqa.login;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.upToTest.amazon.e2etest.automation.utils.CommonMethods;
import com.upToTest.amazon.e2etest.automation.utils.Setup;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStepDefinition extends CommonMethods {

	public WebDriver driver;
	public LoginPage loginPage = new LoginPage();

	public LoginStepDefinition() {
		super();
		driver = Setup.driver;
		PageFactory.initElements(driver, loginPage);
	}

	@When("je remplis la formulaire avec les champs")
	public void jeRemplisLaFormulaireAvecLesChamps(DataTable users) {
		List<List<String>> data = users.asLists(String.class);

		loginPage.fillUserName(data.get(1).get(1));
		loginPage.fillPassword(data.get(2).get(1));
	}

	@When("Je clique sur Login")
	public void jeCliqueSurLogin() throws InterruptedException {
		//Thread.sleep(3000);
		loginPage.clickBtnLogin();
	}

	@Then("Je me dirige vers la page profile")
	public void jeMeDirigeVersLaPageProfile() {
		System.out.println("Connected!");
	}

	@Then("Un message d'erreur s'affiche en rouge {string}")
	public void unMessageDErreurSAfficheEnRouge(String erreurUsername) {
		String message = loginPage.getErreurInvalidUsername();
		System.out.println("message is: " + message);
		Assert.assertTrue(message.contains(erreurUsername));
	}

}
