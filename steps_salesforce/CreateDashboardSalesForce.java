package steps_salesforce;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CreateDashboardSalesForce extends BaseClassSalesforceCucumber{
	  
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	
	@When("click dashboard and new")
    public void click_dashboard_and_new() throws InterruptedException
    {
		WebElement ele1 = driver.findElement(By.xpath("//span[text()='Dashboards']"));
		driver.executeScript("arguments[0].click();",ele1);
		WebElement ele2 = driver.findElement(By.xpath("//div[text()='New Dashboard']"));
		driver.executeScript("arguments[0].click();",ele2);
		
		 }
	
	@And("enter name and click create (.*)$")
	public void enter_name_and_click_create(String name1) throws InterruptedException{
		
		WebElement frameEle = driver.findElement(By.xpath("//iframe[@title='dashboard']"));
		driver.switchTo().frame(frameEle);
		WebElement eleDashName = driver.findElement(By.xpath("//h2[text()='New Dashboard']/following::input[@id='dashboardNameInput']"));
		wait.until(ExpectedConditions.elementToBeClickable(eleDashName));
		eleDashName.sendKeys(name1);
		driver.findElement(By.xpath("//button[text()='Create']")).click();
		
	}
	
	
	@Then("verify the dashboard (.*)$")
	public void verify_dashboard(String name2)
	{
	  String verifyText = driver.findElement(By.xpath("//div[@class='slds-form-element__control slds-has-divider_bottom']/span")).getText();	
	  Assert.assertTrue(verifyText.contains(name2));
	}
	

}
