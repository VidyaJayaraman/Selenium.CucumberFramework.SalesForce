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

public class CreateAccountSalesForce extends BaseClassSalesforceCucumber{

	
	
	 @When("click accounts and new")
	 public void clickAccounts()
	 {
		WebElement eleAcc = driver.findElement(By.xpath("//span[text()='Accounts']"));
		driver.executeScript("arguments[0].click();", eleAcc);
		driver.findElement(By.xpath("//div[@title='New']")).click();
		 
	 }
	 
	 
	 @And("enter account (.*)$")
	 public void enterAccountName(String name) throws InterruptedException
	 {
		
		 driver.findElement(By.xpath("//input[@name='Name']")).sendKeys("Vidya");
		 
		 
	 }
	 
	 @And("select public (.*) and save$")
	 public void selectOwnership(String ownership)
	 {
		 WebElement eleOwn = driver.findElement(By.xpath("//label[text()='Ownership']/following::span[contains(text(),'None')]"));
		 driver.executeScript("arguments[0].click();", eleOwn);
		 WebElement elePublic = driver.findElement(By.xpath("//span[@title='"+ownership+"']"));
		 wait.until(ExpectedConditions.elementToBeClickable(elePublic));
		 driver.executeScript("arguments[0].click();", elePublic);
		 // Save the account
		 driver.findElement(By.xpath("//button[text()='Save']")).click();
		 
	 }
	 
	 
	 @Then("verify the account (.*)$")
	 public void verifyAccount(String name)
	 {
		String verifyText = driver.findElement(By.xpath("//lightning-formatted-text[@class='custom-truncate']")).getText();
	    System.out.println(verifyText);
	    Assert.assertTrue(verifyText.contains(name));
	 }
	
	
}
