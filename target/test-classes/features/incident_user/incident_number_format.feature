Feature: All related test scenarios to Incident User

  Scenario: Ensure that "Number" field is autopopulated as with prefix INC with 7 digits starting at 10,000
    Given I Login to ServiceNow Application with valid credentials
    When I Create New Incident and get Incident Number Format
    Then I verify Number field is autopopulated as with prefix INC with 7 digits starting at 10,000

  Scenario: Ensure that ITIL user role can create a new Incident
    Given I Login to ServiceNow Application with valid credentials
    Then User Clicks on Incidents tab on dashboard
    #When User cliks on New Button to create an incident
    And User selects value from More Information dropdown
      | 3 - Low |
    Then User will enter the description and click submit button
      | Hardware Problem |

  Scenario: Ensure that Incidents can have Attachments added
    Given I Login to ServiceNow Application with valid credentials
    When I Navigate to Incidents and click on Attachment
    Then User should be able to add attachments
<<<<<<< HEAD

    #When  I Remove an attachment
    #Then User should be able to remove Attachment
    
    
   

  
=======
    When I Remove an attachment
    Then User should be able to remove Attachment

  Scenario: Ensure that ITIL user can search for the incident using search functionality
    Given I Login to ServiceNow Application with valid credentials
    Then User Clicks on Incidents tab on dashboard
    And User selects value from More Information dropdown
      | 3 - Low |
    Then User will enter the description and click submit button
      | Software Problem |
    Then User Search for the incident using search functionality
      | Incident Number |
      | INC0010087      |

>>>>>>> 0a63fbd7e6136e0cc906f9a9d0833a014e59d1c1
  Scenario: Incident Analyst can see the email window pop
    Given I Login to ServiceNow Application with valid credentials
    Then User enters text in Filter Navigator
      | Filter Navigator |
      | Incidents        |
    Then User will click the incident
      | Incident Number |
      | INC0010008      |
    Then user click on More Options presented as three dots

<<<<<<< HEAD
  
=======
>>>>>>> 0a63fbd7e6136e0cc906f9a9d0833a014e59d1c1
  Scenario: Ensure that Incident can be cancelled
    Given I Login to ServiceNow Application with valid credentials
    When I Click Incidents and open any incident
    Then I click on Delete
    
    Scenario: Ensure that ITIL user can search for the incident using search functionality
    Given I Login to ServiceNow Application with valid credentials
    Then User Clicks on Incidents tab on dashboard
    Then User Search for the incident using search functionality
  | Incident Number |
  |  INC0010002 |
  
  #Scenario: Ensure that ITIL user can search for the incident using search functionality
    #Given I Login to ServiceNow Application with valid credentials
    #Then User Clicks on Incidents tab on dashboard
    #And User selects value from More Information dropdown
    #| 3 - Low |
    #Then User will enter the description and click submit button
    #| Software Problem |
    #Then User Search for the incident using search functionality
  #| Incident Number |
  #|  INC0010008 |
  
  
  

  Scenario: Ensure that ITIL user can search for the incident using search functionality
    Given I Login to ServiceNow Application with valid credentials
    Then User Clicks on Incidents tab on dashboard On Left
    Then User Search for the incident using search functionality
      | Incident Number |
      | INC0010002      |
