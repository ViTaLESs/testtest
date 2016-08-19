Feature: Help desk


  @HelpDesk
  Scenario: Test1 - HelpDesk - Main-header - HelpDesk UI
    Given I am at ellos_se
    And I click on "Header_CustomerService_Link"
    And I check that I switch to HelpDesk page correctly
    Then I see that HelpDesk UI shown correctly

  @HelpDesk
  Scenario: Test2 - HelpDesk - Help desk Login/Registration button
    Given I am at ellos_se
    And I click on "Header_CustomerService_Link"
    And I check that I switch to HelpDesk page correctly
    And I click on "HelpDesk_LogReg_Button"
    And I check that I switch to Login page correctly

  @HelpDesk
  Scenario: Test3 - HelpDesk - Help desk more questions and answers button
    Given I am at ellos_se
    And I click on "Header_CustomerService_Link"
    And I check that I switch to HelpDesk page correctly
    And I click on "HelpDesk_MoreQuestionsAndAnswers_Button"
    And I check that HelpDesk MoreQuestionsAndAnswers info shown correctly
