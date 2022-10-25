package steps_salesforce;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class CreateIndividualSalesForce extends BaseClassSalesforceCucumber {

	@And("Search Individuals from App Launcher and Click individual")
	public void SearchClickIndividual() throws InterruptedException {
		driver.findElement(By.xpath("//input[contains(@placeholder,'Search apps')]")).sendKeys("Individual",
				Keys.ENTER);
		Thread.sleep(6000);
		driver.findElement(By.xpath("//mark[text()='Individual']")).click();
	}

	@And("click on New Individual")
	public void clickjIndividual() {
		driver.findElement(By.xpath("//div[text()='New']")).click();
	}

	@And("enter (.*) (.*) and save$")
	public void enterFirstnameLastname(String firstname, String lastname) {

		driver.findElement(By.xpath("//input[@placeholder='First Name']")).sendKeys(firstname);
		driver.findElement(By.xpath("//input[@placeholder='Last Name']")).sendKeys(lastname);
		driver.findElement(By.xpath("//button[@title='Save']")).click();

	}

	@Then("verify the individual (.*)$")
	public void verifyIndividual(String firstName) {

		String verifyName = driver.findElement(By.xpath("//div[text()='Individual']/following::span")).getText();
		String Expected = firstName;
		Assert.assertTrue(verifyName.contains(firstName));
		
	}

}
