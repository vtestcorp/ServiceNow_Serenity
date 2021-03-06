package net.thucydides.showcase.cucumber.steps;

import java.awt.AWTException;
import java.util.List;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import net.thucydides.showcase.cucumber.pages.HomePage;
import net.thucydides.showcase.cucumber.pages.Utils;
import net.thucydides.showcase.cucumber.steps.serenity.IncidentSteps;

public class VerifyIncidentNumberScenarioSteps {

	@Steps
	IncidentSteps incident;

	HomePage homePage;

	@Given("I Login to ServiceNow Application with valid credentials")
	public void iLoginToServiceNowApplicationWithValidCredentials() throws InterruptedException {
		incident.opens_home_page();
		incident.account_login(Utils.admin_Username(), Utils.admin_Password());
		System.out.println("login complete");
	}

	@Given("^Incident User Login to ServiceNow Application with valid credentials$")
	public void incident_User_Login_to_ServiceNow_Application_with_valid_credentials() {

		try {
			incident.opens_home_page();
			incident.account_login(Utils.incident_Username(), Utils.incident_Password());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Incident login complete");
	}

	@Then("^ESS User Login to ServiceNow Application with valid credentials$")
	public void ess_User_Login_to_ServiceNow_Application_with_valid_credentials() {
		try {
			incident.opens_home_page();
			incident.account_login(Utils.ESS_Username(), Utils.ess_Password());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("ESS login complete");
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
		homePage.click_IncidenTabOnLeft();
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

	@When("I create new Incident and change its status to (.*) .")
	public void iCreateNewIncidentAndChangeItsStatusToInProgress(String status) throws InterruptedException {
		incident.change_status(status);

	}

	@And("I change Status to On (.*) With reason (.*) .")
	public void iChangeStatusToOnHoldWithReasonITSMIdentifier(String status, String reason)
			throws InterruptedException {
		incident.change_status_hold(status, reason);

	}

	@And("I change status to (.*) add Resolution Code and Resolution Notes then press Save")
	public void iChangeStatusToResolved(String status) throws InterruptedException {
		incident.change_status_repeat(status);

	}

	@Then("I change status (.*) .")
	public void iChangeStatusToClosed(String status) throws InterruptedException {
		incident.change_status_closed(status);

	}

	@When("I create new Incident and Click on Submit without Mandetory Fields.")
	public void iCreateNewIncidentWithoutMandetoryFields() {
		incident.create_incident_withoutmandetoryfields();
	}

	@Then("I verify error message for Mandetory fields.")
	public void iVverifyErrorMessageForMandetoryfields() {
		incident.verify_error_message();

	}

	@Then("^User Clicks on Incidents tab on dashboard$")
	public void user_Clicks_on_Incidents_tab_on_dashboardPanel() {

		try {

			homePage.click_IncidenTabOnLeft();
		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	@Then("^USer Clicks on Resolve button in an incident$")
	public void user_Clicks_on_Resolve_button_in_an_incident() {
		try {

			homePage.clickResolvebutton();
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	@Then("^Switch to default frame$")
	public void switch_to_default_frame() {
		try {
			homePage.switchToDefaultFrame();
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	@Then("^User verifies the Incident status as Resolved$")
	public void user_verifies_the_Incident_status_as_Resolved() {
		try {
			homePage.verify();
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	@Then("^User verifies Incidents on Dashboard$")
	public void user_verifies_Incidents_on_Dashboard() {
		try {

			homePage.verify_IncidenTabOnLeft();
		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	@Then("^\"([^\"]*)\" Logout of the Application$")
	public void user_Logout_of_the_Application(String userName) {
		try {

			homePage.logoutFunctionality(userName);
		} catch (Exception e) {

			e.printStackTrace();
		}
	}
	
	 @When("I create new Incident and Inspect default values on the new Incident form")
	 public void  iCreateNewIncidentAndInspectDefaultValuesOnTheNewIncidentForm() {
		 incident.check_default_value();
	 }
	 
	 @Then("I verify list of Empty fields on the form")
	 public void iVerifyListEmptyFieldsOnTheForm() {
		 incident.verify_empty_field();
		 
	 }
	 
	 @When ("I create new incident and record its fields values")
	 public void iCreateNewIncidentAndRecordItsFieldsValues() throws InterruptedException {
		 incident.create_incident_record_fields();
		 
	 }
	 
	   @Then("I reopen it and click on copy Incident")
	   public void iReopenItAndClickOnCopyIncident() {
		   incident.copy_incident();
		  
		   
	   }
	   
	   @And("I verify copied Incident has all data from Parent Incident and its Number is present")
	   public void verifyDataCopiedFromParentIncident() {
		   incident.verify_copied_incident();
	   }


	@Then("^User Change the Incident State to$")
	public void user_Change_the_Incident_State_to(DataTable stateDropdown) {
		try {
			List<List<String>> value = stateDropdown.raw();

			System.out.println(value.get(1).get(0));
			homePage.changeStateDropdown(value.get(1).get(0));
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	@Then("^User Change the on hold reason to$")
	public void user_Change_the_on_hold_reason_to(DataTable onHoldReason) {
		try {
			List<List<String>> value = onHoldReason.raw();

			System.out.println(value.get(1).get(0));
			homePage.changeOnHoldReason(value.get(1).get(0));
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	@Then("^User click Update button$")
	public void user_click_Update_button() {
		try {
			homePage.clickUpdateButton();
		} catch (Exception e) {

			e.printStackTrace();
		}
	}
	@Then("^Verifies error for Additional Comments$")
	public void verifies_error_for_Additional_Comments(DataTable Error) {
		try {
			List<List<String>> message = Error.raw();

			System.out.println(message.get(1).get(0));
			homePage.verifyAdditionalCommentsError(message.get(1).get(0));
		} catch (Exception e) {

			e.printStackTrace();
		}
	}


}
