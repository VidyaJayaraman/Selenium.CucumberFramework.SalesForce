package runners_salesforce;


import io.cucumber.testng.CucumberOptions;
import selenium_Java_Marathon.BaseClassSalesForce;
import steps_salesforce.BaseClassSalesforceCucumber;

@CucumberOptions(features= {"src/test/java/features2/OpportunitySalesForce.feature","src/test/java/features2/OpportunityWithoutMandatorySalesForce.feature"},glue="steps2",monochrome=true,publish=true)
public class RunnerSalesforceOpportWithoutMandData extends BaseClassSalesforceCucumber{
	
	

}     
                  