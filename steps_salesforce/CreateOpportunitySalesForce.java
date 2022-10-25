package steps_salesforce;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.github.sukgu.support.FindElementBy;

public class CreateOpportunitySalesForce extends BaseClassSalesforceCucumber{

	
	
	@When("enter salesforce username (.*)$")
	public void enter_salesforce_usename(String username) {

		driver.findElement(By.id("username")).sendKeys(username);
	}

	@And("enter salesforce password (.*)$")
	public void enter_salesforce_password(String password) {

		driver.findElement(By.id("password")).sendKeys(password);

	}

	@And("click salesforce login")
	public void click_salesforce_login() throws InterruptedException {
		driver.findElement(By.id("Login")).click();
		Thread.sleep(5000);
	}

	@Then("verify error message")
	public void verify_error_message() {

		WebElement eleErrMsg = driver.findElement(By.xpath("//div[contains(text(),'check your')]"));
		wait.until(ExpectedConditions.visibilityOf(eleErrMsg));
		String loginErrMsg = eleErrMsg.getText();
		System.out.println(loginErrMsg);
		String errMsgOrg = "check";

		// Hard Assert- Static method
		
		Assert.assertTrue(loginErrMsg.contains(errMsgOrg));
		
		// softassert - instance creation
		// softAssert.assertTrue(loginErrMsg.contains(errMsgOrg));
		
		 System.out.println("Print this to check the Hard and Soft Assertion");
		
		 // softAssert.assertAll(); // To capture assert logs

	}

	@And("click toggle and viewall")
	public void click_toggle_and_viewall() throws InterruptedException {
		
		
		WebElement ele = driver.findElement(By.xpath("//div[@class='slds-icon-waffle']"));
		wait.until(ExpectedConditions.elementToBeClickable(ele)).click();
		WebElement ele1 = driver.findElement(By.xpath("//button[text() ='View All']"));
		wait.until(ExpectedConditions.elementToBeClickable(ele1)).click();
		
	}

	@And("click sales")
	public void click_sales() throws InterruptedException {

		
		WebElement eleSales = driver.findElement(By.xpath("//p[text()='Sales']"));
		wait.until(ExpectedConditions.elementToBeClickable(eleSales));
        eleSales.click();
	}

	@And("click opportunity and new")
	public void click_opportunity_and_new() {

		WebElement ele2 = driver.findElement(By.xpath("//a[@title='Opportunities']"));
		wait.until(ExpectedConditions.visibilityOf(ele2));
		driver.executeScript("arguments[0].click();", ele2);
		WebElement ele3 = driver.findElement(By.xpath("//a[@title='New']"));
		driver.executeScript("arguments[0].click();", ele3);
	}

	@Given("opportunity name as (.*)$")
	public void opportunity_name_as(String opportunityname) {
		driver.findElement(By.xpath("//input[@name='Name']")).sendKeys(opportunityname);

	}

	@And("choose close date as today")
	public void choose_close_date_as_today() {
		driver.findElement(By.xpath("//input[@name='CloseDate']")).sendKeys("10/24/2022");

	}

	@And("stage need analysis and save")
	public void stage_need_analysis_and_save() {
		WebElement ele4 = driver.findElement(By.xpath("//button[contains(@class,'slds-combobox__input')]"));
		driver.executeScript("arguments[0].click();", ele4);
		WebElement ele5 = driver.findElement(By.xpath("//span[@title = 'Value Proposition']"));
		driver.executeScript("arguments[0].click();", ele5);
		driver.findElement(By.xpath("//button[text()='Save']")).click();

	}

	@Then("verify oppurtunity name")
	public void verify_opportunity_name() {

		String successText = driver.findElement(By.xpath("(//a[@class='forceActionLink'])[2]")).getAttribute("title");

		if (successText.contains("Vidya")) {
			System.out.println("Opportunity for User Vidya Created");
		} else {
			System.out.println("Opportunity for User Vidya not Created");
		}

	}

	// *****************Verify error message without enter mandatory data in opportunities***************

	@And("save without enter mandatoryData")
	public void save_without_enter_mandatoryData() {

		driver.findElement(By.xpath("//button[text()='Save']")).click();

	}

	@Then("verify errorMessage")
	public void verify_errorMessage() {
		WebElement errMandDataEle = driver.findElement(By.xpath("//h2[@title='We hit a snag.']"));
		wait.until(ExpectedConditions.visibilityOf(errMandDataEle));
		String errMsgMandData = errMandDataEle.getText();
		Assert.assertTrue(errMsgMandData.contains("snag"));
		System.out.println(errMsgMandData);
	}


}
