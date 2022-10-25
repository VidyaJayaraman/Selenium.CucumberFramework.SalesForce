Feature: Login salesforce and create new opportunity

#Baseclass is implemented for launch browser,loadurl,close browser

@Regression @Smoke @Sanity
Scenario Outline: Without enter mandatory data
     
     When enter salesforce username <username>
	 And enter salesforce password <password>
	 And click salesforce login
	 And click toggle and viewall
	 And click sales 
	 And click opportunity and new  
#	 Given opportunity name as <opportunityname>
#    And choose close date as today 
#	 And  stage need analysis and save
     And save without enter mandatoryData
     Then verify errorMessage
     
     
Examples:
|username|password|opportunityname|
|viddhu.j@gmail.com|Testleaf123|Salesforce Automation by Vidya|
 