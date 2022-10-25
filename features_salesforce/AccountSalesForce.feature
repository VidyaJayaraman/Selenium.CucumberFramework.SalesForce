Feature: Create Account Salesforce

#Baseclass is implemented for launch browser,loadurl,close browser

Scenario Outline: Positive Flow Account Creation
     
     When enter salesforce username <username>
	 And enter salesforce password <password>
	 And click salesforce login
	 And click toggle and viewall
	 And click sales 
	 When click accounts and new  
	 And enter account <name> 
	 And select public <ownership> and save
	 Then verify the account <name>


Examples:
|username|password|name|ownership|
|viddhu.j@gmail.com|Testleaf123|Vidya|Public|
 	 