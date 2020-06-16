Feature: Login with Incident and ESS user , verify element on dashboard in one scenario

  
  Scenario: Ensure that ITIL user can resolve the incident
    Given Incident User Login to ServiceNow Application with valid credentials
    Then User verifies Incidents on Dashboard
    Then "Incident User" Logout of the Application
    Then ESS User Login to ServiceNow Application with valid credentials
    Then User verifies Incidents on Dashboard
    Then "ESS User" Logout of the Application
