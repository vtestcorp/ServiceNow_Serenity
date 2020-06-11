package net.thucydides.showcase.cucumber.pages;

import com.SN.util.Utility;
import com.google.common.base.Function;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertEquals;

import java.awt.AWTException;
import java.util.List;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.concurrent.TimeUnit;

@DefaultUrl("https://dev83486.service-now.com/")

public class HomePage extends PageObject {
	public String new_Incidentnum;
	
	@FindBy(xpath="//input[@id=\"user_name\"]")
	WebElementFacade username;
	@FindBy(xpath="//input[@id=\"user_password\"]")
	WebElementFacade password;
	@FindBy(xpath="//iframe[@id='gsft_main']")
	WebElementFacade frame;
	@FindBy(xpath="//input[@id='filter']")
	WebElementFacade filter;
	
	@FindBy(xpath="//button[text()=\"Login\"]")
	WebElementFacade login_button;
	@FindBy(xpath="//div[@data-sn-macro-sys-id=\"345c23800a0a0aa7007d46e66544d541\"]//a[contains(text(),'Create Incident')]")
	WebElementFacade create_incident;
	@FindBy(xpath="//button[@id='submit_button']")
	WebElementFacade submit_button;
	@FindBy(xpath="//span[@class='form_display_value']")
	WebElementFacade get_IncidentNum;
	@FindBy(xpath="//select[@id=\"IO:5a33d0ef0a0a0b9b007b906f6c589c57\"]")
	WebElementFacade select_urgency;
	@FindBy(xpath="//textarea[@id='IO:3f272c500a0a0b990059c24380a2bc02']")
	WebElementFacade more_information;
	@FindBy(xpath="//a[@class='navbar-brand']")
	WebElementFacade servicenow_icon;
	@FindBy(xpath="//a[@id='087800c1c0a80164004e32c8a64a97c9']")
	WebElementFacade Incidents;
	@FindBy(xpath = "//button[@id='sysverb_new']")
	WebElementFacade new_Button;
	@FindBy(xpath="(//a[@class=\"linked formlink\"])[1]")
	WebElementFacade Click_firstIncident;
	@FindBy(xpath="//button[@title=\"Manage Attachments\"]")
	WebElementFacade manage_attachments;
	@FindBy(xpath="//h1[@id='attachment_title']")
	WebElementFacade attchment_popup;
	@FindBy(xpath="//input[@value=\"Choose file\"]")
	WebElementFacade choose_file_button;
	@FindBy(xpath="(//tbody[@id=\"attachment_table_body\"]//tr//td//input[contains(@aria-label,\"Select attachment \")])[1]")
	WebElementFacade select_first_attachment;
	@FindBy(xpath="//input[@id='removeButton']")
	WebElementFacade remove_button;
	
	
	
	Select select;
	public File file ;
	List<WebElement> listOfElements;
	int size;
	
	

	public void load_page()
    {
		getDriver().manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
    }
	
	public void uploadfile() throws AWTException, InterruptedException {
		StringSelection strSelection = new StringSelection(file.getAbsolutePath());
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		clipboard.setContents(strSelection, null);
			Robot robot = new Robot();
			Thread.sleep(3000);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			robot.keyRelease(KeyEvent.VK_V);
			Thread.sleep(3000);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
		
	}
    public void login(String Username,String Password) throws InterruptedException {
		System.out.println(Username);
		System.out.println(Password);
		getDriver().switchTo().frame(frame);
		waitforelement(username);
        username.sendKeys(Username);
		password.sendKeys(Password);
		login_button.click();
		Thread.sleep(11000);
	}
	public void switchtoframe(WebElementFacade ele) {
		getDriver().switchTo().frame(ele);
	}
	public void waitforelement(WebElementFacade ele) {
	WebDriverWait wt=new WebDriverWait(getDriver(),10);
    wt.until(ExpectedConditions.visibilityOf(ele));
    
	}
	
	public void scrollToElement_N_click(WebElementFacade element) 
    {
    	JavascriptExecutor js=(JavascriptExecutor)getDriver();
    	js.executeScript("arguments[0].scrollIntoView();", element);
    	element.click();
    }
	
	public void createincidentgetnumber() throws InterruptedException {
		load_page();
		getDriver().switchTo().defaultContent();
		new WebDriverWait(getDriver(), 40).until(ExpectedConditions.visibilityOf(Incidents));
		 getDriver().switchTo().frame(0);
     	create_incident.click();
		load_page();
		new WebDriverWait(getDriver(), 40).until(ExpectedConditions.visibilityOf(select_urgency));
		Utility.selectByText(select_urgency,"2 - Medium");
		more_information.sendKeys("Test Parent Incident");
		waitforelement(submit_button);
		scrollToElement_N_click(submit_button);
		load_page();
		waitforelement(get_IncidentNum);
		new_Incidentnum=get_IncidentNum.getText();
	}
	public void verifyincidentnumber() {
    	System.out.println(new_Incidentnum);
    	String digits=new_Incidentnum.substring(3, 9);
    	if(digits.length()==7) {
		Boolean flag=new_Incidentnum.contains("INC0010");
		assertEquals(flag, true);}
		System.out.println(new_Incidentnum);
	}
	public void clicknewbutton() {
     	load_page();
		getDriver().switchTo().defaultContent();
		new WebDriverWait(getDriver(), 40).until(ExpectedConditions.visibilityOf(Incidents));
		 getDriver().switchTo().frame(0);
     	create_incident.click();
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
		if(attchment_popup.isDisplayed()) {
			choose_file_button.click();
		}
	}
	public void addattchments() throws AWTException, InterruptedException {
		file = new File("Input\\imagefile.jpg");
		uploadfile();
		getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		listOfElements = getDriver().findElements(By.xpath("//div[@id=\"current_attachments\"]//td//a[@class=\"content_editable\"]"));
        int oldsize=listOfElements.size();
        //choose_file_button.click();
//		file = new File("Input\\docfile.doc");
//		uploadfile();
//		getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//
//		choose_file_button.click();
//		file = new File("Input\\docxfile.docx");
//		uploadfile();
//		getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//
//		choose_file_button.click();
//		file = new File("Input\\xlsfile.xls");
//		uploadfile();
		getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		listOfElements = getDriver().findElements(By.xpath("//div[@id=\"current_attachments\"]//td//a[@class=\"content_editable\"]"));
        size=listOfElements.size();
		assertEquals(oldsize,size);
	}
	public void removeattchments() {
		//getDriver().switchTo().frame(0);
		new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOf(select_first_attachment));
		select_first_attachment.click();
		remove_button.click();
	}
	
	public void verifyremovedattachment() {
		listOfElements = getDriver().findElements(By.xpath("//div[@id=\"current_attachments\"]//td//a[@class=\"content_editable\"]"));
        int newsize=listOfElements.size();
		assertEquals(newsize,size-1);
	}
}
