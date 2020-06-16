package net.thucydides.showcase.cucumber.steps;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import net.thucydides.showcase.cucumber.pages.HomePage;
import net.thucydides.showcase.cucumber.pages.Utils;
import net.thucydides.showcase.cucumber.steps.serenity.IncidentSteps;
import java.awt.AWTException;
import java.util.List;

public class VerifyIncidentNumberScenarioSteps {

	@Steps
	IncidentSteps incident;

	HomePage homePage;

	@Given("I Login to ServiceNow Application with valid credentials")
	public void iLoginToServiceNowApplicationWithValidCredentials()
			throws InterruptedException {
		incident.opens_home_page();
		incident.account_login(Utils.admin_Username(), Utils.admin_Password());
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

	@Then("^User Clicks on Incidents tab on dashboard On Left$")
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

	@Then("^User Search for the incident in My Open Incidents List$")
	public void user_Search_for_the_incident_in_My_Open_Incidents_List(DataTable IncidentNumber) {
		try {
			List<List<String>> number = IncidentNumber.raw();
			homePage.searchIncident_MyOpenIncidents(number.get(1).get(0));
		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	/**
	 * @author Tanveer
	 * 
	 * @since 6/12/2020
	 */
	@Then("^User enters text in Filter Navigator$")
	public void user_enters_text_in_Filter_Navigator(DataTable searchText) {
		try {
			List<List<String>> text = searchText.raw();
			homePage.enter_FilterNavigator(text.get(1).get(0));
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	/**
	 * @author Tanveer
	 * 
	 * @since 6/12/2020
	 */

	@Then("^User will click the incident$")
	public void user_will_click_the_incident(DataTable number) {
		try {
			List<List<String>> inc_Number = number.raw();
			System.out.println(inc_Number.get(1).get(0));
			homePage.clickIncidentFromTable(inc_Number.get(1).get(0));
		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	@Then("^user click on More Options presented as three dots$")
	public void user_click_on_More_Options_presented_as_three_dots() {
		try {

			homePage.clickToggleButton();
		} catch (Exception e) {

			e.printStackTrace();
		}

	}

}
