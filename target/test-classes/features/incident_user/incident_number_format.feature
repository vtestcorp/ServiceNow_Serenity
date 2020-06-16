Feature: All related test scenarios to Incident User

  Scenario: Ensure that "Number" field is autopopulated as with prefix INC with 7 digits starting at 10,000
    Given I Login to ServiceNow Application with valid credentials
    When I Create New Incident and get Incident Number Format
    Then I verify Number field is autopopulated as with prefix INC with 7 digits starting at 10,000
    
@Test
  Scenario: Ensure that ITIL user role can create a new Incident
    Given I Login to ServiceNow Application with valid credentials
    Then User Clicks on Incidents tab on dashboard On Left
    And User selects value from More Information dropdown
      | 3 - Low |
    Then User will enter the description and click submit button
      | Hardware Problem |

  Scenario: Ensure that Incidents can have Attachments added
    Given I Login to ServiceNow Application with valid credentials
    When I Navigate to Incidents and click on Attachment
    Then User should be able to add attachments
    When I Remove an attachment
    Then User should be able to remove Attachment

  @Test
  Scenario: Incident Analyst can see the email window pop
    Given I Login to ServiceNow Application with valid credentials
    Then User Clicks on Incidents tab on dashboard
    Then User will click the incident
      | Incident Number |
      | INC0010111      |
    Then user click on More Options presented as three dots

  Scenario: Ensure that Incident can be cancelled
    Given I Login to ServiceNow Application with valid credentials
    When I Click Incidents and open any incident
    Then I click on Delete
    
@Test
  Scenario: Ensure that ITIL user can search for the incident using search functionality
    Given I Login to ServiceNow Application with valid credentials
    Then User Clicks on Incidents tab on dashboard
    Then User Search for the incident using search functionality
      | Incident Number |
      | INC0010002      |

  #@Test
  Scenario: Ensure that ITIL user can resolve the incident
    Given I Login to ServiceNow Application with valid credentials
    Then User Clicks on Incidents tab on dashboard
    Then User will click the incident
      | Incident Number |
      | INC0010093      |
    Then USer Clicks on Resolve button in an incident
    Then User Clicks on Incidents tab on dashboard
    Then Switch to default frame
    Then User will click the incident
      | Incident Number |
      | INC0010093      |
    Then User verifies the Incident status as Resolved
