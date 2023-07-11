Feature: Create an application
  In order to create an application on the Finansys demo platform
  User needs to access the App Editor page and fill the form

  Scenario Outline: User creates a new application using a valid Name value and the rest of the form fields are populated
    Given User navigates through the Create App form
    When User provides a value on the Name field from a given "<sheetName>" and <rowNumber>
    And User provides a value on the Description field from a given "<sheetName>" and <rowNumber>
    And User provides a value on the Group field from a given "<sheetName>" and <rowNumber>
    And User provides a value on the ML Service field from a given "<sheetName>" and <rowNumber>
    And User provides a value on the App Icon field from a given "<sheetName>" and <rowNumber>
    And User provides a value on the Quick Launch field from a given "<sheetName>" and <rowNumber>
    And User clicks the Create button
    Then An application is successfully created

    Examples:
      | sheetName    | rowNumber |
      |Claim_Journeys|0       |

  Scenario Outline: User cancels to create a new application
    Given User navigates through the Create App form
    When User provides a value on the Name field from a given "<sheetName>" and <rowNumber>
    And User provides a value on the Description field from a given "<sheetName>" and <rowNumber>
    And User provides a value on the Group field from a given "<sheetName>" and <rowNumber>
    And User provides a value on the ML Service field from a given "<sheetName>" and <rowNumber>
    And User provides a value on the App Icon field from a given "<sheetName>" and <rowNumber>
    And User provides a value on the Quick Launch field from a given "<sheetName>" and <rowNumber>
    And User clicks the Cancel button
    Then No application is created

    Examples:
      | sheetName    | rowNumber |
      |Claim_Journeys|1       |

  Scenario Outline: User create a new application using a valid Name value and the rest of the form fields are not populated
    Given User navigates through the Create App form
    When User provides a value on the Name field from a given "<sheetName>" and <rowNumber>
    And User clicks the Create button
    Then An application is successfully created

    Examples:
      | sheetName    | rowNumber |
      |Claim_Journeys|2       |

  Scenario Outline: User create a new application using an existing Name value and the rest of the form fields are populated according that same existing application
    Given User navigates through the Create App form
    When User provides a value on the Name field from a given "<sheetName>" and <rowNumber>
    And User provides a value on the Description field from a given "<sheetName>" and <rowNumber>
    And User provides a value on the Group field from a given "<sheetName>" and <rowNumber>
    And User provides a value on the ML Service field from a given "<sheetName>" and <rowNumber>
    And User provides a value on the App Icon field from a given "<sheetName>" and <rowNumber>
    And User provides a value on the Quick Launch field from a given "<sheetName>" and <rowNumber>
    And User clicks the Create button
    Then An appropriate error message is shown

    Examples:
      | sheetName    | rowNumber |
      |Claim_Journeys|3       |

  Scenario Outline: User create a new application using an existing Name value and the rest of the form fields are populated using new values
    Given User navigates through the Create App form
    When User provides a value on the Name field from a given "<sheetName>" and <rowNumber>
    And User provides a value on the Description field from a given "<sheetName>" and <rowNumber>
    And User provides a value on the Group field from a given "<sheetName>" and <rowNumber>
    And User provides a value on the ML Service field from a given "<sheetName>" and <rowNumber>
    And User provides a value on the App Icon field from a given "<sheetName>" and <rowNumber>
    And User provides a value on the Quick Launch field from a given "<sheetName>" and <rowNumber>
    And User clicks the Create button
    Then An appropriate error message is shown

    Examples:
      | sheetName    | rowNumber |
      |Claim_Journeys|4       |

  Scenario Outline: User create a new application with blank Name value and the rest of the form fields are populated
    Given User navigates through the Create App form
    When User provides a value on the Description field from a given "<sheetName>" and <rowNumber>
    And User provides a value on the Group field from a given "<sheetName>" and <rowNumber>
    And User provides a value on the ML Service field from a given "<sheetName>" and <rowNumber>
    And User provides a value on the App Icon field from a given "<sheetName>" and <rowNumber>
    And User provides a value on the Quick Launch field from a given "<sheetName>" and <rowNumber>
    And User clicks the Create button
    Then An appropriate error message is shown

    Examples:
      | sheetName    | rowNumber |
      |Claim_Journeys|5       |