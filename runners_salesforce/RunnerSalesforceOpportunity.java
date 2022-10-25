package runners_salesforce;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import steps_salesforce.BaseClassSalesforceCucumber;

@CucumberOptions(features= "src/test/java/features2/OpportunitySalesForce.feature",glue= {"steps2"},monochrome=true,publish=true)
public class RunnerSalesforceOpportunity extends BaseClassSalesforceCucumber {

}
