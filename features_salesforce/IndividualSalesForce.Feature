Feature: Create Individual Salesforce

#Baseclass is implemented for launch browser,loadurl,close browser

Scenario Outline: Positive Flow Individual Creation
     
     When enter salesforce username <username>
	 And enter salesforce password <password>
	 And click salesforce login
	 And click toggle and viewall
	 And Search Individuals from App Launcher and Click individual
	 And click on New Individual
	 And enter <firstname> <lastname> and save
	 Then verify the individual <firstname>


Examples:
|username|password|firstname|lastname|
|viddhu.j@gmail.com|Testleaf123|Vidya|J|
 	 