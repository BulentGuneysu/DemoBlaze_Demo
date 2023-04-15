package com.demoblaze.step_Defs;

import com.demoblaze.pages.HomePage;
import com.demoblaze.pages.LoginPage;
import com.demoblaze.utilities.ConfigurationReader;
import com.demoblaze.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.Map;

public class Login_stepDefs {
    LoginPage loginPage=new LoginPage();
    HomePage homePage=new HomePage();

    @Given("The user is on the login page")
    public void the_user_is_on_the_login_page() {
        Driver.get().get(ConfigurationReader.get("url"));
    }

    @When("The user enters valid credentials")
    public void the_user_enters_valid_credentials() {
        loginPage.login();
    }

    @Then("The user verify that Welcome username is displayed")
    public void the_user_verify_that_Welcome_username_is_displayed() {
        homePage.verifyWelcomeMessage();
    }

    @When("The user enters with {string} and {string} credentials")
    public void the_user_enters_with_and_credentials(String username, String password) {
        loginPage.login(username, password);
    }

    @Then("The user verify that {string} is displayed")
    public void the_user_verify_that_is_displayed(String expectedMessage) {
        homePage.verifyWelcomeMessage(expectedMessage);
    }

    @When("The user enters valid username and password credentials")
    public void the_user_enters_valid_username_and_password_credentials(Map<String,String> userInfo) {
        loginPage.login(userInfo.get("username"),userInfo.get("password"));
    }
    @Then("The user verify that invalid credential {string}")
    public void the_user_verify_that_invalid_credential(String expectedWarningMessage) {
        loginPage.verifyWithPopUpMessage(expectedWarningMessage);
    }



}
