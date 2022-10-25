Feature: Login salesforce and create new opportunity

#Baseclass is implemented for launch browser,loadurl,close browser

@Smoke 
Scenario Outline: Positive Flow
     
     When enter salesforce username <username>
	 And enter salesforce password <password>
	 And click salesforce login
	 And click toggle and viewall
	 And click sales 
	 And click opportunity and new  
	 Given opportunity name as <opportunityname>
     And choose close date as today 
	 And  stage need analysis and save
     Then verify oppurtunity name

Examples:
|username|password|opportunityname|
|viddhu.j@gmail.com|Testleaf123|Salesforce Automation by Vidya|
 
 
@Sanity
Scenario Outline: Incorrect Login
     
     When enter salesforce username <username>
	 And enter salesforce password <password>
	 And click salesforce login
	 Then verify error message
	 
 Examples:
|username|password| 
|Demo|Demo|
