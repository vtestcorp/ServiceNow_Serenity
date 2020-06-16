package com.SN.util;

import net.thucydides.core.pages.PageObject;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import net.serenitybdd.core.pages.WebElementFacade;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utility extends PageObject {

	public static void click(WebElement element) {
		element.click();
	}

	public static void fill(WebElement element, String text) {
		element.clear();
		element.sendKeys(text);
	}

	public void wait(WebElement element) {
		WebDriverWait wt = new WebDriverWait(getDriver(), 10);
		wt.until(ExpectedConditions.visibilityOf(element));

	}

	public void wait_N_click(WebElement element) {
		WebDriverWait wt = new WebDriverWait(getDriver(), 10);
		wt.until(ExpectedConditions.visibilityOf(element));
		element.click();
	}

	public void scrollToElement(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		js.executeScript("arguments[0].scrollIntoView();", element);
	}

	public void scrollToElement_N_click(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		js.executeScript("arguments[0].scrollIntoView();", element);
		element.click();
	}

	public void rightclickElement_N_click(WebElement element) {
		Actions actions = new Actions(getDriver());
		actions.contextClick(element).perform();
	}

	public void mouseHover(WebElement ele) {
		Actions act = new Actions(getDriver());
		act.moveToElement(ele).build().perform();
	}

	public static void selectByText(WebElement ele, String text) {
		Select dpdwn = new Select(ele);
		dpdwn.selectByVisibleText(text);
	}

	public static void selectByValue(WebElement ele, String value) {
		Select dpdwn = new Select(ele);
		dpdwn.selectByValue(value);
	}

	public static void selectByIndex(WebElement ele, String index) {
		Select dpdwn = new Select(ele);
		dpdwn.selectByValue(index);
	}

	public void div_Dpdwn(WebElement menu) throws Exception {
		Actions act = new Actions(getDriver());
		act.click(menu).build().perform();
	}

	public static void load() throws InterruptedException {
		Thread.sleep(10000);
	}
}