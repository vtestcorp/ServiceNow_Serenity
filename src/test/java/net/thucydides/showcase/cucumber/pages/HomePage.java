package net.thucydides.showcase.cucumber.pages;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.SN.util.Utility;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.PageObject;

public class HomePage extends PageObject {
	private String new_Incidentnum;

	@FindBy(xpath = "//input[@id=\"user_name\"]")
	WebElementFacade username;
	@FindBy(xpath = "//input[@id=\"user_password\"]")
	WebElementFacade password;
	@FindBy(xpath = "//iframe[@id='gsft_main']")
	WebElementFacade frame;
	@FindBy(xpath = "//input[@id='filter']")
	WebElementFacade filter;

	@FindBy(xpath = "//button[text()=\"Login\"]")
	WebElementFacade login_button;

	@FindBy(xpath = "//div[@data-sn-macro-sys-id=\"345c23800a0a0aa7007d46e66544d541\"]//a[contains(text(),'Create Incident')]")
	WebElementFacade create_incident;

	@FindBy(xpath = "//button[@id='submit_button']")
	WebElementFacade submit_button;
	@FindBy(xpath = "//div[@class='navbar-header']")
	WebElementFacade get_IncidentNum;
	@FindBy(xpath = "//div[@class=\"navbar-title-display-value\"]")
	WebElementFacade get_Incident;
	@FindBy(xpath = "//select[@id=\"IO:5a33d0ef0a0a0b9b007b906f6c589c57\"]")

	WebElementFacade select_urgency;
	@FindBy(xpath = "//textarea[@id='IO:3f272c500a0a0b990059c24380a2bc02']")
	WebElementFacade more_information;
	@FindBy(xpath = "//a[@class='navbar-brand']")
	WebElementFacade servicenow_icon;
	@FindBy(xpath = "//a[@id='087800c1c0a80164004e32c8a64a97c9']//div[@class='sn-widget-list-title'][contains(text(),'Incidents')]")
	WebElementFacade Incidents;
	@FindBy(xpath = "//button[@id='sysverb_new']")
	WebElementFacade new_Button;
	@FindBy(xpath = "(//a[@class=\"linked formlink\"])[1]")
	WebElementFacade Click_firstIncident;
	@FindBy(xpath = "//button[@title=\"Manage Attachments\"]")
	WebElementFacade manage_attachments;
	@FindBy(xpath = "//h1[@id='attachment_title']")
	WebElementFacade attchment_popup;
	@FindBy(xpath = "//input[@value=\"Choose file\"]")
	WebElementFacade choose_file_button;
	@FindBy(xpath = "(//form[@action=\"sys_attachment.do?DELETE\"]//input[@aria-label=\"Select attachment imagefile.jpg for deletion\"])[1]")
	WebElementFacade select_first_attachment;
	@FindBy(xpath = "//input[@id='removeButton']")
	WebElementFacade remove_button;
	@FindBy(xpath = "//button[@id='attachment_closemodal']")
	WebElementFacade close_attchment;
	@FindBy(xpath = "//button[@id='sysverb_delete']")
	WebElementFacade Delete_button;
	@FindBy(xpath = "//h1[@id='delete_confirm_form_title']")
	WebElementFacade Delete_confirmation;
	@FindBy(xpath = "//button[@id='sysverb_new']//following::input[1]")
	WebElementFacade search_Button;
	@FindBy(xpath = "//a[@id='087800c1c0a80164004e32c8a64a97c9']//div[@class='sn-widget-list-title'][contains(text(),'Incidents')]")
	WebElementFacade incidentTab;

	@FindBy(xpath = "//table[@id='incident_table']")
	WebElementFacade mytable;

	@FindBy(xpath = "//div[@id='window.com.glide.ui.portal.RenderDashboard_fd7c1cb8-683c-4839-aa4c-6871229672bb']//table[contains(@class,'drag_section_header')]")
	WebElementFacade myOpenIncidents_Table;

	@FindBy(xpath = "//table[@id='incident_table']")
	WebElementFacade systemAdmin_Incidents_Table;
	@FindBy(xpath = "//select[@id='incident.state']")
	WebElementFacade insident_state;

	@FindBy(xpath = "//div[contains(text(),'Save')]")
	WebElementFacade save_button;
	@FindBy(xpath = "//select[@id='incident.hold_reason']")
	WebElementFacade hold_status;
	@FindBy(xpath = "//span[@class='outputmsg_text']")
	WebElementFacade error_message;

	// select[@id='incident.hold_reason']
	@FindBy(xpath = "//button[@id='sysverb_update']")
	WebElementFacade Update_button;

	@FindBy(xpath = "//button[@data-original-title=\"Next page\"]//span")
	WebElementFacade nextpage_button;

	// @FindBy(xpath = "//a[text() ='" + value + "']")
	// WebElementFacade incidentNum;

	// WebElement incidentNum = getDriver().findElement(By.xpath("//a[text() ='"
	// + new_Incidentnum + "']"));

	@FindBy(xpath = "//button[@id='header_add_attachment']//following::button[3]")
	WebElementFacade toggleMoreOptions;
	@FindBy(xpath = "//span[@class='list_view']")
	WebElementFacade listView;
	@FindBy(xpath = "//option[contains(text(),'In Progress')]")
	WebElementFacade inprogress;

	@FindBy(xpath = "//strong[contains(text(),'Create Incident')]")
	WebElementFacade createIncident_expand;
	@FindBy(xpath = "//a[@class='sc_bottom_link']")
	WebElementFacade view_all;

	@FindBy(xpath = "//div[text()='Incidents']")
	WebElementFacade leftIncident;

	@FindBy(xpath = "//button[@id='resolve_incident']")
	WebElementFacade resolve_Button;

	@FindBy(xpath = "//select[@id='incident.state']")
	WebElementFacade resolve_Status;

	@FindBy(xpath = "//button[@id='user_info_dropdown']")
	WebElementFacade systemAdministrator;

	@FindBy(linkText = "Logout")
	WebElementFacade logoutButton;
	@FindBy(xpath = "//input[@id='incident.opened_at']")
	WebElementFacade get_openedatvalue;
	@FindBy(xpath = "//input[@id='incident.closed_at']")
	WebElementFacade get_closedatvalue;
	@FindBy(xpath = "//input[@id='cxs_related_search']")
	WebElementFacade related_search;
	@FindBy(xpath = "//input[@id='incident.short_description']")
	WebElementFacade short_description;
	@FindBy(xpath = "//input[@id='sys_display.incident.caller_id']")
	WebElementFacade get_caller;
	@FindBy(xpath = "//span[@class='navbar_ui_actions']")
	WebElementFacade header;
	@FindBy(xpath = "//div[contains(text(),'Copy Incident')]")
	WebElementFacade copy_incident;
	@FindBy(xpath = "id=\"incident.work_notes\"")
	WebElementFacade parent_incidentnumber;

	// input[@id='cxs_related_search']

	@FindBy(xpath = "incident.short_description")
	WebElementFacade shortDescription;

	Select select;
	public File file;
	List<WebElement> listOfElements;
	int size;
	String getUrgency;
	String getStatus;
	String get_shortdescription;
	String get_callervalue;

	public void load_page() {
		getDriver().manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
	}

	public void uploadfile() throws AWTException, InterruptedException {
		StringSelection strSelection = new StringSelection(file.getAbsolutePath());
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		clipboard.setContents(strSelection, null);
		Robot robot = new Robot();

		getDriver().manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);

		getDriver().manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);

	}

	public void login(String Username, String Password) throws InterruptedException {
		System.out.println(Username);
		System.out.println(Password);
		getDriver().switchTo().frame(frame);
		waitforelement(username);
		username.sendKeys(Username);
		password.sendKeys(Password);
		login_button.click();
		getDriver().manage().timeouts().implicitlyWait(11000, TimeUnit.MILLISECONDS);
	}

	public void switchtoframe(WebElementFacade ele) {
		getDriver().switchTo().frame(ele);
	}

	public void waitforelement(WebElementFacade ele) {
		WebDriverWait wt = new WebDriverWait(getDriver(), 10);
		wt.until(ExpectedConditions.visibilityOf(ele));

	}

	public void scrollToElement_N_click(WebElementFacade element) {
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		js.executeScript("arguments[0].scrollIntoView();", element);
		element.click();
	}

	// public void createincidentgetnumber() throws InterruptedException {
	//
	// load_page();
	// getDriver().switchTo().defaultContent();
	// new
	// WebDriverWait(getDriver(),40).until(ExpectedConditions.visibilityOf(Incidents));
	// getDriver().switchTo().frame(0);
	// new
	// WebDriverWait(getDriver(),40).until(ExpectedConditions.visibilityOf(view_all));
	// view_all.click();
	// new
	// WebDriverWait(getDriver(),40).until(ExpectedConditions.visibilityOf(createIncident_expand));
	//
	// createIncident_expand.click();
	// load_page();
	// new
	// WebDriverWait(getDriver(),40).until(ExpectedConditions.visibilityOf(select_urgency));
	// Utility.selectByText(select_urgency, "2 - Medium");
	// more_information.sendKeys("Test Parent Incident");
	// waitforelement(submit_button);
	// scrollToElement_N_click(submit_button);
	// load_page();
	// waitforelement(get_IncidentNum);
	// new_Incidentnum = get_IncidentNum.getText();
	// }

	// public void createincidentgetnumber() throws InterruptedException {
	// load_page();
	// getDriver().switchTo().defaultContent();
	// Incidents.click();
	// getDriver().switchTo().frame(0);
	// new WebDriverWait(getDriver(),
	// 20).until(ExpectedConditions.visibilityOf(listView));
	// listView.click();
	// new_Button.click();
	// // load_page();
	// // getDriver().switchTo().defaultContent();
	// // new WebDriverWait(getDriver(),
	// // 40).until(ExpectedConditions.visibilityOf(Incidents));
	// // getDriver().switchTo().frame(0);
	// // create_incident.click();
	// // load_page();
	// // new WebDriverWait(getDriver(),
	// // 40).until(ExpectedConditions.visibilityOf(select_urgency));
	// // Utility.selectByText(select_urgency, "2 - Medium");
	// more_information.sendKeys("Test Parent Incident");
	// waitforelement(submit_button);
	// scrollToElement_N_click(submit_button);
	// load_page();
	// waitforelement(get_IncidentNum);
	// new_Incidentnum = get_IncidentNum.getText();
	// }

	public void verifyincidentnumber() {
		System.out.println(new_Incidentnum);
		String digits = new_Incidentnum.substring(3, 9);
		if (digits.length() == 7) {
			Boolean flag = new_Incidentnum.contains("INC0010");
			assertEquals(flag, true);
		}
		System.out.println(new_Incidentnum);
	}

	public void clicknewbutton() {
		load_page();
		getDriver().switchTo().defaultContent();
		new WebDriverWait(getDriver(), 40).until(ExpectedConditions.visibilityOf(Incidents));
		getDriver().switchTo().frame(0);
		new WebDriverWait(getDriver(), 40).until(ExpectedConditions.visibilityOf(view_all));
		view_all.click();
		new WebDriverWait(getDriver(), 40).until(ExpectedConditions.visibilityOf(createIncident_expand));

		createIncident_expand.click();
		load_page();

		getDriver().switchTo().defaultContent();
		new WebDriverWait(getDriver(), 40).until(ExpectedConditions.visibilityOf(new_Button));
		getDriver().switchTo().frame(0);
		new_Button.click();
		// create_incident.click();
		load_page();
	}

	public void completecreateincidentform(String dropdownValue) {
		new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOf(select_urgency));
		select = new Select(select_urgency);
		select.selectByVisibleText(dropdownValue);
	}

	public void enterdescription(String description) {
		new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOf(more_information));
		more_information.sendKeys(description);
		new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOf(submit_button));
		submit_button.click();
	}

	public void clickattachment() {

		load_page();
		getDriver().switchTo().defaultContent();
		Incidents.click();
		getDriver().switchTo().frame(0);
		new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOf(Click_firstIncident));
		Click_firstIncident.click();
		new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOf(manage_attachments));
		manage_attachments.click();
		new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOf(attchment_popup));
		if (attchment_popup.isDisplayed()) {
			choose_file_button.click();
		}
	}

	public void addattchments() throws AWTException, InterruptedException {
		file = new File("Input\\imagefile.jpg");
		uploadfile();
		getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		listOfElements = getDriver()
				.findElements(By.xpath("//div[@id=\"current_attachments\"]//td//a[@class=\"content_editable\"]"));
		int oldsize = listOfElements.size();
		// choose_file_button.click();
		// file = new File("Input\\docfile.doc");
		// uploadfile();
		// getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//
		// choose_file_button.click();
		// file = new File("Input\\docxfile.docx");
		// uploadfile();
		// getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//
		// choose_file_button.click();
		// file = new File("Input\\xlsfile.xls");
		// uploadfile();
		getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		listOfElements = getDriver()
				.findElements(By.xpath("//div[@id=\"current_attachments\"]//td//a[@class=\"content_editable\"]"));
		size = listOfElements.size();
		assertEquals(oldsize, size);
	}

	public void removeattchments() throws InterruptedException {
		getDriver().switchTo().frame(0);

		getDriver().manage().timeouts().implicitlyWait(6000, TimeUnit.SECONDS);
		new WebDriverWait(getDriver(), 40).until(ExpectedConditions.visibilityOf(select_first_attachment));
		select_first_attachment.click();
		remove_button.click();
	}

	public void verifyremovedattachment() {
		listOfElements = getDriver()
				.findElements(By.xpath("//div[@id=\"current_attachments\"]//td//a[@class=\"content_editable\"]"));
		int newsize = listOfElements.size();
		assertEquals(newsize, size - 1);
	}

	@Step
	public void click_IncidenTab() {

		try {
			// getDriver().switchTo().defaultContent();
			// new WebDriverWait(getDriver(),
			// 40).until(ExpectedConditions.visibilityOf(incidentTab));
			// incidentTab.click();

			load_page();
			getDriver().switchTo().defaultContent();
			new WebDriverWait(getDriver(), 40).until(ExpectedConditions.visibilityOf(Incidents));
			getDriver().switchTo().frame(0);
			new WebDriverWait(getDriver(), 40).until(ExpectedConditions.visibilityOf(view_all));
			view_all.click();
			new WebDriverWait(getDriver(), 40).until(ExpectedConditions.visibilityOf(createIncident_expand));
			createIncident_expand.click();
			load_page();
			new WebDriverWait(getDriver(), 40).until(ExpectedConditions.visibilityOf(select_urgency));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Step
	public void click_IncidenTabOnLeft() {

		try {
			// getDriver().switchTo().defaultContent();
			// new WebDriverWait(getDriver(),
			// 40).until(ExpectedConditions.visibilityOf(incidentTab));
			// incidentTab.click();

			load_page();
			getDriver().switchTo().defaultContent();
			new WebDriverWait(getDriver(), 40).until(ExpectedConditions.visibilityOf(leftIncident));
			System.out.println("incident on left");
			leftIncident.click();
			getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			// getDriver().switchTo().frame(0);
			// new WebDriverWait(getDriver(),
			// 40).until(ExpectedConditions.visibilityOf(view_all));
			// view_all.click();
			// new WebDriverWait(getDriver(),
			// 40).until(ExpectedConditions.visibilityOf(createIncident_expand));
			// createIncident_expand.click();
			// load_page();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Step
	public void searchIncident(String incidentNumber) {

		try {
			getDriver().switchTo().frame(0);
			new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOf(search_Button));

			search_Button.sendKeys(incidentNumber);

			getDriver().manage().timeouts().implicitlyWait(3000L, TimeUnit.SECONDS);
			search_Button.sendKeys(Keys.ENTER);
			// search_Button.sendKeys(Keys.ENTER);

			getDriver().manage().timeouts().implicitlyWait(3000L, TimeUnit.SECONDS);
			//

			printTableResults(incidentNumber);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Step
	public void searchIncident_MyOpenIncidents(String value) {

		try {
			getDriver().switchTo().frame(0);
			new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOf(myOpenIncidents_Table));

			List<WebElement> rows_table = myOpenIncidents_Table.findElements(By.tagName("tr"));

			int rows_count = rows_table.size();

			for (int row = 0; row < rows_count; row++) {

				List<WebElement> Columns_row = rows_table.get(row).findElements(By.tagName("td"));

				int columns_count = Columns_row.size();

				for (int column = 0; column < columns_count; column++) {

					String celtext = Columns_row.get(column).getText();

					if (celtext.equals(value)) {

						System.out.println("text is " + celtext);

						assertEquals(celtext, value);
					} else {
						assertEquals(celtext, value);
					}
				}

			}

		} catch (

		Exception e) {
			e.printStackTrace();
		}

	}

	@Step
	public void printTableResults(String value) {

		List<WebElement> rows_table = mytable.findElements(By.tagName("tr"));

		int rows_count = rows_table.size();

		for (int row = 0; row < rows_count; row++) {

			List<WebElement> Columns_row = rows_table.get(row).findElements(By.tagName("td"));

			int columns_count = Columns_row.size();

			for (int column = 0; column < columns_count; column++) {

				String celtext = Columns_row.get(column).getText();

				if (celtext.equals(value)) {

					System.out.println("text is " + celtext);

					assertEquals(celtext, value);
				} else {
					assertEquals(celtext, value);
				}
			}

		}

	}

	/**
	 * @author Tanveer
	 * 
	 * @since 6/12/2020
	 */
	@Step
	public void clickIncidentFromTable(String value) throws InterruptedException {
		getDriver().switchTo().frame(0);
		System.out.println("val is " + value);

		// new_Incidentnum = value;
		WebElement incidentNum = getDriver().findElement(By.xpath("//a[text() ='" + value + "']"));

		incidentNum.click();

		getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	}

	/**
	 * @author Tanveer
	 * 
	 * @since 6/12/2020
	 */
	@Step
	public void enter_FilterNavigator(String text) {

		try {
			// getDriver().switchTo().frame(0);
			getDriver().manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
			new WebDriverWait(getDriver(), 50).until(ExpectedConditions.elementToBeClickable(filter));
			filter.click();
			filter.sendKeys(text);
			filter.click();
			filter.sendKeys(Keys.ENTER);
			// filter.sendKeys(Keys.ENTER);
			// Robot robot = new Robot();
			//// Thread.sleep(3000);
			// robot.keyPress(KeyEvent.VK_ENTER);
			// robot.keyRelease(KeyEvent.VK_ENTER);

			getDriver().manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * @author Tanveer
	 * 
	 * @since 6/12/2020
	 */
	@Step
	public void clickToggleButton() {
		try {
			// getDriver().switchTo().frame("gsft_main");
			toggleMoreOptions.click();

			getDriver().manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void clicknewincident() {
		load_page();
		getDriver().switchTo().defaultContent();
		Incidents.click();
		getDriver().switchTo().frame(0);
		new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOf(Click_firstIncident));
		Click_firstIncident.click();
		// getDriver().switchTo().frame(0);
		// new WebDriverWait(getDriver(),
		// 20).until(ExpectedConditions.visibilityOf(Delete_button));
		// Delete_button.click();
		// assert(Delete_confirmation.isDisplayed());
	}

	public void deletebutton() {
		new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOf(Delete_button));
		Delete_button.click();
		assert (Delete_confirmation.isDisplayed());
	}

	public void createincidentgetnumber() throws InterruptedException {

		load_page();
		getDriver().switchTo().defaultContent();
		new WebDriverWait(getDriver(), 40).until(ExpectedConditions.visibilityOf(Incidents));
		getDriver().switchTo().frame(0);
		new WebDriverWait(getDriver(), 40).until(ExpectedConditions.visibilityOf(view_all));
		view_all.click();
		new WebDriverWait(getDriver(), 40).until(ExpectedConditions.visibilityOf(createIncident_expand));

		createIncident_expand.click();
		load_page();
		new WebDriverWait(getDriver(), 40).until(ExpectedConditions.visibilityOf(select_urgency));
		Utility.selectByText(select_urgency, "2 - Medium");
		more_information.sendKeys("Test Parent Incident");
		waitforelement(submit_button);
		scrollToElement_N_click(submit_button);
		load_page();
		waitforelement(get_Incident);
		new_Incidentnum = get_Incident.getText();
		new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOf(Update_button));
		Update_button.click();

	}

	@Step
	public void clickResolvebutton() {
		try {
			new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOf(resolve_Button));
			resolve_Button.click();
			getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Step
	public void verify() {
		try {
			new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOf(resolve_Status));
			// System.out.println("Status is " + resolve_Button.getText());
			// assertEquals("Resolve", resolve_Button.getText());

			Select select = new Select(resolve_Status);
			System.out.println("Status is " + select.getFirstSelectedOption().getText());

			assertEquals("Resolved", select.getFirstSelectedOption().getText());

			getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Step
	public void changeStateDropdown(String value) {
		try {
			new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOf(resolve_Status));

			Select select = new Select(resolve_Status);

			select.selectByVisibleText(value);

			getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Step
	public void changeOnHoldReason(String value) {
		try {
			new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOf(hold_status));

			Select select = new Select(hold_status);

			select.selectByVisibleText(value);

			getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Step
	public void verifyAdditionalCommentsError(String value) {
		try {
			String error = "The following mandatory fields are not filled in: Additional comments (Customer visible)";
			WebElement errorMessage = getDriver().findElement(By.xpath("//span[text()='" + value + "']"));
			new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOf(errorMessage));
			if (errorMessage.getText().equalsIgnoreCase(error))

				assertEquals(error, errorMessage.getText());
			System.out.println("Error verified as " + error);
			getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Step
	public void enterShortDescription(String value) {
		try {
			new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOf(shortDescription));

			shortDescription.sendKeys(value);

			getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Step
	public void clickUpdateButton() {
		try {
			new WebDriverWait(getDriver(), 20).until(ExpectedConditions.elementToBeClickable(Update_button));

			Update_button.click();

			getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void switchToDefaultFrame() {
		getDriver().switchTo().defaultContent();
	}

	@Step
	public void verify_IncidenTabOnLeft() {

		try {

			load_page();
			getDriver().switchTo().defaultContent();
			new WebDriverWait(getDriver(), 40).until(ExpectedConditions.visibilityOf(leftIncident));
			System.out.println("incident on left");
			if (leftIncident.isEnabled() || leftIncident.isDisplayed()) {

				System.out.println("Incident tab verified");

			}
			getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Step
	public void logoutFunctionality(String name) {

		try {

			load_page();
			getDriver().switchTo().defaultContent();

			WebElement user = getDriver().findElement(By.xpath("//span[text()='" + name + "']"));
			new WebDriverWait(getDriver(), 40).until(ExpectedConditions.elementToBeClickable(user));
			System.out.println("sys admin " + user.getText());
			user.click();
			getDriver().manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			// new WebDriverWait(getDriver(),
			// 40).until(ExpectedConditions.elementToBeClickable(logoutButton));
			// System.out.println("log button " + logoutButton.getText());
			// logoutButton.click();
			// getDriver().manage().timeouts().implicitlyWait(40,
			// TimeUnit.SECONDS);

			Robot r = new Robot();
			r.keyPress(KeyEvent.VK_DOWN);
			r.keyPress(KeyEvent.VK_DOWN);
			r.keyPress(KeyEvent.VK_ENTER);
			r.keyRelease(KeyEvent.VK_ENTER);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void changestatus(String status) throws InterruptedException {

		getDriver().switchTo().defaultContent();
		new WebDriverWait(getDriver(), 40).until(ExpectedConditions.visibilityOf(Incidents));
		Incidents.click();
		getDriver().manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
		String link = new_Incidentnum.substring(0, 10);
		clickIncidentFromTable(link);
		new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOf(insident_state));
		insident_state.click();
		WebElement update_status = getDriver().findElement(By.xpath("//option[contains(text()," + status + ")]"));
		update_status.click();
		new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOf(Update_button));
		Update_button.click();

	}

	public void changestatusrepeat(String status) throws InterruptedException {
		String link = new_Incidentnum.substring(0, 10);
		WebElement incidentNum = getDriver().findElement(By.xpath("//a[text() ='" + link + "']"));
		incidentNum.click();
		new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOf(insident_state));
		insident_state.click();
		WebElement update_status = getDriver().findElement(By.xpath("//option[contains(text()," + status + ")]"));
		update_status.click();
		new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOf(Update_button));
		Update_button.click();

	}

	public void changestatushold(String status, String reason) throws InterruptedException {
		String link = new_Incidentnum.substring(0, 10);
		WebElement incidentNum = getDriver().findElement(By.xpath("//a[text() ='" + link + "']"));
		incidentNum.click();
		new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOf(insident_state));
		insident_state.click();
		WebElement update_status = getDriver().findElement(By.xpath("//option[contains(text()," + status + ")]"));
		update_status.click();
		new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOf(hold_status));
		hold_status.click();
		WebElement update_reason = getDriver().findElement(By.xpath("//option[contains(text()," + reason + ")]"));
		update_reason.click();
		new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOf(Update_button));
		Update_button.click();

	}

	public void createincidentwithoutmandetoryfields() {
		load_page();
		getDriver().switchTo().defaultContent();
		new WebDriverWait(getDriver(), 40).until(ExpectedConditions.visibilityOf(Incidents));
		getDriver().switchTo().frame(0);
		new WebDriverWait(getDriver(), 40).until(ExpectedConditions.visibilityOf(view_all));
		view_all.click();
		new WebDriverWait(getDriver(), 40).until(ExpectedConditions.visibilityOf(createIncident_expand));
		createIncident_expand.click();
		load_page();
		waitforelement(submit_button);
		scrollToElement_N_click(submit_button);
		load_page();
	}

	public void verifyerrormessage() {
		load_page();
		assertTrue(error_message.isDisplayed());

	}

	public void changestatusclosed(String status) throws InterruptedException {
		String link = new_Incidentnum.substring(0, 10);
		WebElement incidentNum = getDriver().findElement(By.xpath("//a[text() ='" + link + "']"));
		incidentNum.click();
		new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOf(insident_state));
		insident_state.click();
		WebElement update_status = getDriver().findElement(By.xpath("//option[contains(text()," + status + ")]"));
		update_status.click();
		new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOf(Update_button));
		Update_button.click();

	}

	public void checkdefaultvalue() {
		getDriver().switchTo().defaultContent();
		new WebDriverWait(getDriver(), 40).until(ExpectedConditions.visibilityOf(Incidents));
		Incidents.click();
		getDriver().manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
		getDriver().switchTo().frame(0);
		nextpage_button.click();
		new WebDriverWait(getDriver(), 40).until(ExpectedConditions.visibilityOf(new_Button));
		new_Button.click();
		String date_onform = get_openedatvalue.getAttribute("value");
		String current_datetime = Utility.getcurrentdateandtime();
		// assertEquals("Opend At field is present with value",
		// current_datetime, date_onform);
		getUrgency = get_dropdowndefaultvalue("incident.urgency");
		assertEquals("Urgency field is present with value as 3-Low", "3 - Low", getUrgency);
		getStatus = get_dropdowndefaultvalue("incident.state");
		assertEquals("Urgency field is present with value as New", "New", getStatus);

	}

	public void verifyemptyfield() {
		get_shortdescription = short_description.getAttribute("value");
		String get_closedat = get_closedatvalue.getAttribute("value");
		assertEquals("short description is null", "", get_shortdescription);
		assertEquals("closed at is null", "", get_closedat);

	}

	public String get_dropdowndefaultvalue(String field) {
		select = new Select(getDriver().findElement(By.xpath("//select[@id ='" + field + "']")));

		WebElement option = select.getFirstSelectedOption();

		String defaultItem = option.getText();

		return defaultItem;
	}

	public void createincidentrecordfields() {
		load_page();
		getDriver().switchTo().defaultContent();
		new WebDriverWait(getDriver(), 40).until(ExpectedConditions.visibilityOf(Incidents));
		getDriver().switchTo().frame(0);
		new WebDriverWait(getDriver(), 40).until(ExpectedConditions.visibilityOf(view_all));
		view_all.click();
		new WebDriverWait(getDriver(), 40).until(ExpectedConditions.visibilityOf(createIncident_expand));

		createIncident_expand.click();
		load_page();
		new WebDriverWait(getDriver(), 40).until(ExpectedConditions.visibilityOf(select_urgency));
		Utility.selectByText(select_urgency, "2 - Medium");
		more_information.sendKeys("Test Parent Incident");
		waitforelement(submit_button);
		scrollToElement_N_click(submit_button);
		load_page();
		waitforelement(get_Incident);
		new_Incidentnum = get_Incident.getText();
		getUrgency = get_dropdowndefaultvalue("incident.urgency");
		getStatus = get_dropdowndefaultvalue("incident.state");
		get_shortdescription = short_description.getAttribute("value");
		get_callervalue = get_caller.getAttribute("value");
		new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOf(Update_button));
		Update_button.click();

	}

	public void copyincident() {
		String link = new_Incidentnum.substring(0, 10);
		WebElement incidentNum = getDriver().findElement(By.xpath("//a[text() ='" + link + "']"));
		incidentNum.click();
		Actions actions = new Actions(getDriver());
		actions.contextClick(header).perform();
		new WebDriverWait(getDriver(), 40).until(ExpectedConditions.visibilityOf(copy_incident));
		copy_incident.click();

	}

	public void verifycopiedincident() {
		String getCopiedUrgency = get_dropdowndefaultvalue("incident.urgency");
		String getCopiedStatus = get_dropdowndefaultvalue("incident.state");
		String get_Copiedshortdescription = short_description.getAttribute("value");
		String get_Copiedcallervalue = get_caller.getAttribute("value");
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		js.executeScript("arguments[0].scrollIntoView();", parent_incidentnumber);
		String get_parentIncidentnumber = parent_incidentnumber.getText();
		String link = new_Incidentnum.substring(0, 10);
		assertEquals("Urgency status is", getUrgency, getCopiedUrgency);
		assertEquals("Incident Status is", getStatus, getCopiedStatus);

		assertEquals("Short Description is", get_shortdescription, get_Copiedshortdescription);
		if (getCopiedUrgency.contains(link)) {
			assert (true);
		}

	}

}
