Feature: search for an Item Book from home page

  Scenario Outline: search for Search for Book qa testing for beginners in amazon search bare
    Given i type "<Item>" in amazon search Bar

    And i click on the first item in the list  result
    And i assert "<price>" after click on first item
    And i Click on Add to Cart
    And i assert "<price>" after click on add to cart
    When I click  on proceed to checkout
    Then i assert "<price>" after checkout
    Examples:
    |Item|price|
    |qa testing for beginners|$47.49|

