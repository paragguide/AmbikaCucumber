Feature: Amazon Test cases
  I want to use this template for testing amazon login and shopping

  @amazon @uid
  Scenario: userid test
    Given i open "chrome" and get url "https://www.amazon.in" and create report "AmazonLogin" for testname "LoginTest"
    And i click on signin link
    When I enter valid userid "paragguide@yahoo.co.in"
    And click continue button
    Then I validate error message should not come 
  
  @amazon @pwd  
  Scenario: password test
     Given userid is valid 
     When entered a valid password that is "RMinfotech12#&&"
     Then i should login  
  
  @amazon @search   
  Scenario Outline: Product search
     Given user is logged in
     When i search for <products> in price <price> 
     Then search results must come
   
   @data1  
   Examples:
   |  products | price |
   | Shirt | 500 |
   | pant | 1500 |
   | tie | 200 |

   @data2
   Examples:
   |  products | price |
   | mobile | 5000 |
   | iphone | 150000 |
   | laptop | 41000 |
  
