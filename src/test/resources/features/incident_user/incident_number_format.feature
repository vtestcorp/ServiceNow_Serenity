Feature: All related test scenarios to Incident User

  Scenario Outline: Ensure that "Number" field is autopopulated as with prefix INC with 7 digits starting at 10,000
    Given I Login to ServiceNow Application with valid credentials '<UserID>' and '<Password>'
    When I Create New Incident and get Incident Number Format
    Then I verify Number field is autopopulated as with prefix INC with 7 digits starting at 10,000

    Examples: 
      | UserID | Password |
      |        |          |

  #@Smoke
  Scenario Outline: Ensure that ITIL user role can create a new Incident
    Given I Login to ServiceNow Application with valid credentials '<UserID>' and '<Password>'
    When User cliks on New Button to create an incident
    And User selects value from More Information dropdown
      | 3 - Low |
    Then User will enter the description and click submit button
      | Hardware Problem |

    Examples: 
      | UserID | Password |
      |        |          |

  Scenario Outline: Ensure that Incidents can have Attachments added
    Given I Login to ServiceNow Application with valid credentials '<UserID>' and '<Password>'
    When I Navigate to Incidents and click on Attachment
    Then User should be able to add attachments

    #When  I Remove an attachment
    #Then User should be able to remove Attachment
    Examples: 
      | UserID | Password |
      |        |          |

  @Smoke
  Scenario Outline: Ensure that ITIL user can search for the incident using search functionality
    Given I Login to ServiceNow Application with valid credentials '<UserID>' and '<Password>'
    Then User Clicks on Incidents tab on dashboard
    #Scenario Outline: Ensure that "Number" field is autopopulated as with prefix INC with 7 digits starting at 10,000
    #Given I Login to ServiceNow Application with valid credentials '<UserID>' and '<Password>'
    #When I Create New Incident and get Incident Number Format
    #Then I verify Number field is autopopulated as with prefix INC with 7 digits starting at 10,000
    #
    #Examples:
    #
    #| UserID        | Password     |
    #| currentid     | currentpasword |
    #Scenario Outline: Ensure that ITIL user role can create a new Incident
    #Given I Login to ServiceNow Application with valid credentials '<UserID>' and '<Password>'
    #When I click on New Button to create an incident
    #And  User selects value from More Information dropdown
    #| 3 - Low |
    #Then User will enter the description and click submit button
    #| Hardware Problem |
    #Examples:
    #| UserID        | Password     |
    #| currentid     | currentpasword |
    #Scenario Outline: Ensure that Incidents can have Attachments added
    #Given I Login to ServiceNow Application with valid credentials '<UserID>' and '<Password>'
    #When  I Navigate to Incidents and click on Attachment
    #Then  User should be able to add attachments
    #When  I Remove an attachment
    #Then User should be able to remove Attachment
    #Examples:
    #| UserID        | Password     |
    #| currentid     | currentpasword |
    #@Smoke
    #Scenario Outline: Ensure that ITIL user can search for the incident using search functionality
    #Given I Login to ServiceNow Application with valid credentials '<UserID>' and '<Password>'
    #Then User Clicks on Incidents tab on dashboard
    #And User selects value from More Information dropdown
    #| 3 - Low |
    #Then User will enter the description and click submit button
    #| Software Problem |
    Then User Search for the incident using search functionality
      | Incident Number |
      | INC0010087      |

    Examples: 
      | UserID | Password |
      |        |          |

  @Test
  Scenario Outline: Incident Analyst can see the email window pop
    Given I Login to ServiceNow Application with valid credentials '<UserID>' and '<Password>'
    Then User enters text in Filter Navigator
      | Filter Navigator |
      | Incidents        |
    Then User will click the incident
      | Incident Number |
      | INC0010111      |
    Then user click on More Options presented as three dots

    Examples: 
      | UserID | Password |
      |        |          |

  #Then User Search for the incident using search functionality
  #| Incident Number |
  #|  1234 |
  #
  #Examples:
  #| UserID        | Password     |
  #  | currentid     | currentpasword |
  #
  #
  Scenario Outline: Ensure that Incident can be cancelled
    Given I Login to ServiceNow Application with valid credentials '<UserID>' and '<Password>'
    When I Click Incidents and open any incident
    Then I click on Delete

    Examples: 
      | UserID    | Password       |
      | currentid | currentpasword |
