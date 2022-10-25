Feature: Create Dashboard Salesforce

#Baseclass is implemented for launch browser,loadurl,close browser

Scenario Outline: Positive Flow Dashboard Creation
     
     When enter salesforce username <username>
	 And enter salesforce password <password>
	 And click salesforce login
	 And click toggle and viewall
	 And click sales 
	 When click dashboard and new   
	 And enter name and click create <name1>
	 Then verify the dashboard <name2>


Examples:
|username|password|name1|name2|
|viddhu.j@gmail.com|Testleaf123|Salesforce Automation by Vidya|Salesforce Automation by Vidya|
 	 