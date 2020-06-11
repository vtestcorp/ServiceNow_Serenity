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
    public void iLoginToServiceNowApplicationWithValidCredentials(String userId,String password) throws InterruptedException {
    	incident.opens_home_page();
    	incident.account_login(userId,password);
    }
    
    @When("I Create New Incident and get Incident Number Format")
	public void iCreateNewIncidentAndGetIncidentNumberFormat() throws InterruptedException{
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
    public void iRemoveAnAttachment() {
    	incident.remove_attachment();
    }
    @Then("User should be able to remove Attachment")
    public void userShouldBeAbleToRemoveAttachment() {
    	incident.verify_remove_attachment();
    }

}
