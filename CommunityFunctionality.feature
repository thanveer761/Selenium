Feature: Comunity Functionality in salesforce

Scenario Outline: Community Functionality

Given open Chrome Browser                                                                               
Given load the application url                                                                               
Given maximze the browser                                
Given apply implicit wait                  
And Enter the user name as <username>                    
And Enter the password as <password>          
When click on login button 
When click community on most recently used         
Then Print the Application Name and Developer Name for the App Type Lighting       
When Click on View Profile icon 
When Click on Switch to Salesforce Classic
When Click on Create New and Select Event
And Enter subject as Call/Email/Meeting <data>  
And Enter Start date as tomorrow 
And Enter End date as aftertomorrow    
When click on Add invitees as Contact: Click on the LookUp icon
When Search for Sarath and select first result 
 

Examples:
|username|password|data|
|nupela@testleaf.com|Bootcamp$123|call|