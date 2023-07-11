package stepDefinitions;

import dataReader.excelReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import pageObjects.createAppPageObjects;
import utilities.helper;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import static utilities.hooks.driver;


public class createAppStepDefinitions {

    String excelPath = "excel/edit_profile_test_data.xlsx";
    excelReader reader = new excelReader();

    createAppPageObjects createApp;

    @Given("User navigates through the Create App form")
    public void user_navigates_through_the_create_app_form() {
        createApp = new createAppPageObjects(driver);
        createApp.navigateToWebsite();
        createApp.fillUsername();
        createApp.fillPassword();
        createApp.clickSignIn();
        createApp.isHomeMenuDisplayed();
        createApp.clickAppEditor();
        createApp.isAppEditorPageDisplayed();
        createApp.clickCreateNewApp();
        createApp.isCreateAppFormDisplayed();
    }

    @When("User provides a value on the Name field from a given {string} and {int}")
    public void user_provides_a_value_on_the_name_field_from_a_given_and(String sheetName, Integer rowNumber) throws IOException, InvalidFormatException {
        List<Map<String,String>> testData = reader.getData(excelPath, sheetName);
        String name = testData.get(rowNumber).get("name");

        String namePlaceholder = createApp.emptyNameField();

        helper.assertWithLog("the placeholder of Name", namePlaceholder, "Enter name");
        createApp.fillNameField(name);
    }

    @When("User provides a value on the Description field from a given {string} and {int}")
    public void user_provides_a_value_on_the_description_field_from_a_given_and(String sheetName, Integer rowNumber) throws IOException, InvalidFormatException {
        List<Map<String,String>> testData = reader.getData(excelPath, sheetName);
        String description = testData.get(rowNumber).get("description");

        String descriptionPlaceholder = createApp.emptyDescriptionField();

        helper.assertWithLog("the placeholder of Description", descriptionPlaceholder, "Enter description (optional)");
        createApp.fillDescriptionField(description);
    }

    @When("User provides a value on the Group field from a given {string} and {int}")
    public void user_provides_a_value_on_the_group_field_from_a_given_and(String sheetName, Integer rowNumber) throws IOException, InvalidFormatException {
        List<Map<String,String>> testData = reader.getData(excelPath, sheetName);
        String group = testData.get(rowNumber).get("group");

        String groupPlaceholder = createApp.emptyGroupField();

        helper.assertWithLog("the placeholder of Group", groupPlaceholder, "Select...");
        createApp.fillGroupField(group);
    }

    @When("User provides a value on the ML Service field from a given {string} and {int}")
    public void user_provides_a_value_on_the_ml_service_field_from_a_given_and(String sheetName, Integer rowNumber) throws IOException, InvalidFormatException {
        List<Map<String,String>> testData = reader.getData(excelPath, sheetName);
        String machineLearningService = testData.get(rowNumber).get("group");

        String machineLearningServicePlaceholder = createApp.emptyMachineLearningService();

        helper.assertWithLog("the placeholder of Machine Learning Service", machineLearningServicePlaceholder, "Select...");
        createApp.fillMachineLearningService(machineLearningService);
    }

    @When("User provides a value on the App Icon field from a given {string} and {int}")
    public void user_provides_a_value_on_the_app_icon_field_from_a_given_and(String sheetName, Integer rowName) {
        createApp.chooseAppIcon();
    }

    @When("User provides a value on the Quick Launch field from a given {string} and {int}")
    public void user_provides_a_value_on_the_quick_launch_field_from_a_given_and(String sheetName, Integer rowName) {

        String quickLaunch = createApp.emptyQuickLaunch();

        helper.assertWithLog("Quick Launch", quickLaunch, "false");
        createApp.tickQuickLaunch();
    }

    @When("User clicks the Create button")
    public void user_clicks_the_create_button() {
        createApp.clickCreateButton();
    }

    @Then("An application is successfully created")
    public void an_application_is_successfully_created() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("User clicks the Cancel button")
    public void user_clicks_the_cancel_button() {
        createApp.clickCancelButton();
    }

    @Then("No application is created")
    public void no_application_is_created() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("An appropriate error message is shown")
    public void an_appropriate_error_message_is_shown() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

}
