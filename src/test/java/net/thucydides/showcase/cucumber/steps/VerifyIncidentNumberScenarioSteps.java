package net.thucydides.showcase.cucumber.steps;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Steps;
import net.thucydides.showcase.cucumber.pages.HomePage;
import net.thucydides.showcase.cucumber.steps.serenity.IncidentSteps;
import static org.assertj.core.api.Assertions.assertThat;
import java.util.Map;
import java.awt.AWTException;
import java.util.List;

public class VerifyIncidentNumberScenarioSteps {

	@Steps
	IncidentSteps incident;

	HomePage homePage;

	@Given("I Login to ServiceNow Application with valid credentials '(.*)' and '(.*)'")
	public void iLoginToServiceNowApplicationWithValidCredentials(String userId, String password)
			throws InterruptedException {
		incident.opens_home_page();
		incident.account_login(userId, password);
	}

	@When("I Create New Incident and get Incident Number Format")
	public void iCreateNewIncidentAndGetIncidentNumberFormat() throws InterruptedException {
		incident.get_new_incident_number();
	}

	@Then("I verify Number field is autopopulated as with prefix INC with 7 digits starting at 10,000")
	public void iVerifyIncidentNumberFormat() {
		incident.verify_new_incident_number();
	}

	@When("User cliks on New Button to create an incident")
	public void userCliksOnNewButtonToCreateAnIncident() {
		incident.click_new_button();
	}

	@And("^User selects value from More Information dropdown$")
	public void userSelectsValueFromMoreInformationDropdown(DataTable dropdownValues) {
		List<List<String>> value = dropdownValues.raw();
		incident.complete_createincident_form(value.get(0).get(0));
	}

	@Then("^User will enter the description and click submit button$")
	public void userWillEnterTheDescription(DataTable description) {
		List<List<String>> text = description.raw();
		incident.enter_description(text.get(0).get(0));
	}

	@When("I Navigate to Incidents and click on Attachment")
	public void iNavigateToIncidentsAndClickOnAttachment() throws InterruptedException {
		incident.click_attachment();
	}

	@Then("User should be able to add attachments")
	public void userShouldBeAbleToAddAttachments() throws AWTException, InterruptedException {
		incident.add_attchments();

	}

	@When("I Remove an attachment")
	public void iRemoveAnAttachment() throws InterruptedException {
		incident.remove_attachment();
	}

	@Then("User should be able to remove Attachment")
	public void userShouldBeAbleToRemoveAttachment() {
		incident.verify_remove_attachment();
	}

	@Then("^User Clicks on Incidents tab on dashboard$")
	public void user_Clicks_on_Incidents_tab_on_dashboard() {
		homePage.click_IncidenTab();
	}
	
	
	@Then("^User Search for the incident using search functionality$")
	public void user_Search_for_the_incident_using_search_functionality(DataTable incidentNumber) {

		try {
			List<List<String>> number = incidentNumber.raw();
			homePage.searchIncident(number.get(1).get(0));
		} catch (Exception e) {

			e.printStackTrace();
		}
	}
	@When("I Click Incidents and open any incident")
	public void iClickOnNewButtonToCreateAnIncident() {
		incident.click_new_incident();
	}
	@Then("I click on Delete")
	public void iClickOnDelete() {
		incident.delete_button();
	}
}
