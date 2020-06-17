package net.thucydides.showcase.cucumber.steps.serenity;

import java.awt.AWTException;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import net.thucydides.showcase.cucumber.pages.HomePage;

@SuppressWarnings("serial")
public class IncidentSteps extends ScenarioSteps {

	HomePage homePage;

	@Step
	public void opens_home_page() {
		homePage.open();

	}

	@Step
	public void account_login(String userId, String password) throws InterruptedException {
		homePage.login(userId, password);
	}

	@Step
	public void get_new_incident_number() throws InterruptedException {
		homePage.createincidentgetnumber();
	}

	@Step
	public void verify_new_incident_number() {
		homePage.verifyincidentnumber();
	}

	@Step
	public void click_new_button() {
		homePage.clicknewbutton();
	}

	@Step
	public void complete_createincident_form(String dropdownValue) {
		homePage.completecreateincidentform(dropdownValue);
	}

	@Step
	public void enter_description(String description) {
		homePage.enterdescription(description);
	}

	@Step
	public void click_attachment() {
		homePage.clickattachment();
	}

	@Step
	public void add_attchments() throws AWTException, InterruptedException {
		homePage.addattchments();
	}

	@Step
	public void remove_attachment() throws InterruptedException {
		homePage.removeattchments();
	}

	@Step
	public void verify_remove_attachment() {
		homePage.verifyremovedattachment();
	}

	@Step
	public void click_new_incident() {
		homePage.clicknewincident();
	}

	@Step
	public void delete_button() {
		homePage.deletebutton();
	}
	
	@Step
	public void change_status(String status) throws InterruptedException {
		homePage.createincidentgetnumber();
		homePage.changestatus(status);
	}
	
	@Step
	public void change_status_repeat(String status) throws InterruptedException {
		homePage.changestatusrepeat(status);
		
	}
	@Step
	public void change_status_closed(String status) throws InterruptedException {
		homePage.changestatusclosed(status);
		
	}
	
	@Step
	public void change_status_hold(String status,String reason) throws InterruptedException {
		homePage.changestatushold(status,reason);
	}
	
	@Step
	public void create_incident_withoutmandetoryfields() {
		homePage.createincidentwithoutmandetoryfields();
	}
	
	@Step
	public void verify_error_message() {
		homePage.verifyerrormessage();
	}
}
