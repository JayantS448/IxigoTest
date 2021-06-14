package Cucumber.Options;



import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;


@CucumberOptions(features="src/test/java/Features",
					plugin ="json:target/jsonReports/cucumber-report.json", 
					glue={"stepDef"}, 
					tags={"@ixigo"})	
public class TestRunner extends AbstractTestNGCucumberTests {
    
}


// to run from maven any specific tag we need to give 
// mvn test -Dcucumber.options="--tags @tagname"