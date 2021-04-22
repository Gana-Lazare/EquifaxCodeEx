package Runner;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"src/test/java/features"}, //the path of the feature files
        glue = "stepDefinitions", //the path of the step definition files
        plugin = {"pretty", "json:target/cucumber-reports/cucumber.json", "html:target/cucumber-reports/index.html","pretty:target/cucumber-reports/cucumber-pretty.txt","usage:target/cucumber-reports/cucumber-usage.json", "junit:target/cucumber-reports/cucumber-results.xml"}, //to generate different types of reporting
        strict = true, //it will check if any step is not defined in step definition file
        monochrome = true, //display the console output in a proper readable format
        dryRun = false, //to check the mapping is proper between feature file and step def file
        publish = true
        // tags = "(@SmokeTest or @Regression) and (not @pending)"
        //        tags = " (    @Regression or  @smokeTest    ) and not @pending    "
//        tags = {"@Regression or  @smokeTest or "}
//         tags={"@Test1,@Test2"}
)
public class AmazonRunner extends AbstractTestNGCucumberTests {
}
