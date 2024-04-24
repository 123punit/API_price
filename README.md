# API_price
I have used BDD approach to complete this assessment.
In Src/main/java folder: I have kept Price.Feaure file and PriceStepdefinition.java  file.
Price.Feature consists of all acceptance steps for automation testing. In Ghekin language. Gherkin is simple English language. Which help to understand the test steps for non technical background person.
Steps definition holds the test method and code which are mapped to the Gherkin test case steps on the feature file.
Src/test/java folder: I have kept PriceTestRunner.java file.
PriceTestRunner executes the Cucumber feature files and coordinates the steps defined in those feature files with the corresponding step definitions. In his file we passed the location of feature and step definition file and along with the some reporting and other methods supported by cucumber.
To run the project we need to select PriceTestRunner.java file and need to click on run as JUnit option.
