package runners_salesforce;

import io.cucumber.testng.CucumberOptions;
import steps_salesforce.BaseClassSalesforceCucumber;


@CucumberOptions(features= "src/test/java/features2/AccountSalesForce.feature",glue="steps2",monochrome=true,publish=true)

public class RunnerSalesforceAccount extends BaseClassSalesforceCucumber {

}
