#Feature: Load "New customer" page
#
#Scenario Outline: valid email for new customer
#Given the main page is loaded
#When user enter valid email as "<email>" for new customer in filed Email address
#And click Continue button
#Then page with registration form is loaded and message appears
#
#  Examples:
#    | email                 |
#    | bunasyuliya2.20@gmail.com |
#    | yul15@gmail.com |
#    | ybunos@gmail.com |