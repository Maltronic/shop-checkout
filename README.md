# Sample Shop Checkout System
maltronic.io, Malcolm Davis - 2016-10-04

A sample shop checkout system for purchasing apples & oranges.
Written in Java using the DropWizard Framework and Maven.

# Installation and Running

- Package using Maven:

mvn package

- Run the server from the command-line using java:

java -jar target/shop-checkout-1.0.0-SNAPSHOT.jar server config_default.yml

- Test by sending a HTTP POST request to http://127.0.0.1:8080/basket/total

Include x-www-form-urlencoded data, for example:

items=Apple,Orange,Apple,Apple

# Workflow:

### Sprint 1

##### Critical Requirements

- Outputs total summed price

- Must handle 2 types of fruit products.

- Multiple items of each product type may be purchased

- Takes input of a comma-separated list of fruit name strings


##### Story: Shop Checkout

In order to sell 2 types 

fruit of with different prices

As a checkout staff member or shop customer

I want to retrieve the total price of the order

When providing a list of the fruit names

##### Notes:

Input consists of a comma-separated list, a fruit’s name appears for each of quantity within order

Example Input:

Apple,Apple,Orange,Apple

##### Spec 1:

Given that an order has 2 types of fruit

When above comma-separated string is input

And the fruit names appear for each of their quantity within the order

Then I should see a total representing the summation of every item’s price  

##### Spec 2:

Given that multiples of a type of fruit appear in an order

When above comma-separated string is input

And the fruit names duplicated multiple times within the order

Then I should see the total summation returned includes every duplicate of fruit types



### Sprint 2

##### Critical Requirements

- Must allow - buy one, get one free offer on Apples

- Must allow - 3 for the price of 2 offer on Oranges


##### Story: Shop Checkout

In order to allow offers on products

As a shop owner

I want to have offers modify the total after calculation based on the order content

##### Spec 1:

Given that an order has multiple apples

When above comma-separated string is input

Then return a total modified so the summation of apple item prices is halved for the number of apples divisible by 2

##### Spec 2:

Given that an order has multiple oranges

When above comma-separated string is input

Then return a total modified so the summation of orange item prices is reduced by 1/3 for the number of oranges divisible by 3
