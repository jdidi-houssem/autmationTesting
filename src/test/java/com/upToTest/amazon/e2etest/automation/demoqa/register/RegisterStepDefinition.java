package com.upToTest.amazon.e2etest.automation.demoqa.register;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.upToTest.amazon.e2etest.automation.utils.CommonMethods;
import com.upToTest.amazon.e2etest.automation.utils.Setup;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RegisterStepDefinition extends CommonMethods {

	public WebDriver driver;
	public RegisterPage registerPage = new RegisterPage();

	public RegisterStepDefinition() {
		super();
		driver = Setup.driver;
		PageFactory.initElements(driver, registerPage);
	}

	@Given("Je navigue sur l'app demoqa")
	public void jeNavigueSurLAppDemoqa() throws IOException, InterruptedException {
		TimeUnit.SECONDS.sleep(1);
		super.openURLWithConfigFile("url2");
	}

	@Given("Je clique sur New User")
	public void jeCliqueSurNewUser() {
		registerPage.clickBtnNewUser();
	}

	@When("je remplis la formulaire avec ces valeurs")
	public void jeRemplisLaFormulaireAvecCesValeurs(DataTable users) {

		List<List<String>> data = users.asLists(String.class);
		registerPage.fillFirstName(data.get(1).get(1));
		registerPage.fillLastName(data.get(2).get(1));
		registerPage.fillUserName(data.get(3).get(1));
		registerPage.fillPassword(data.get(4).get(1));
	}

	@When("je clique sur captcha")
	public void jeCliqueSurCaptcha() throws InterruptedException {
		Thread.sleep(3000);
		registerPage.checkedRecaptcha();
	}

	@When("Je clique sur Register")
	public void jeCliqueSurRegister() {
		registerPage.clickBtnRegister();
	}

	@Then("Une popUp affiche\"User Register Successfully.\"")
	public void unePopUpAfficheUserRegisterSuccessfully() {

	}

}
