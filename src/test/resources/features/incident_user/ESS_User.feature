Feature: All related test scenarios to ESS User


 @TC03
 #//pending because ess user does not exist in build
  Scenario Outline: Ensure that ESS user can search for the incident using search functionality
    Given I Login to ServiceNow Application with valid credentials '<UserID>' and '<Password>'
    #When User cliks on New Button to create an incident
    #And User selects value from More Information dropdown
      #| 3 - Low |
    #Then User will enter the description and click submit button
      #| ESS User Hardware Problem |
    Then User Search for the incident in My Open Incidents List
      | Incident Number |
      | INC0010087      |

   

      
    