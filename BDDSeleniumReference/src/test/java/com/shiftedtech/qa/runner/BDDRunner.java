package com.shiftedtech.qa.runner;

/**
 * Created by MOHSEN on 09/21/18.
 */

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
//       tags = { "@debug" },
        monochrome = true,
        features = "src/test/resources/features/",
        glue = {"com.shiftedtech.qa.steps"},
//        dryRun = true,
        plugin={
            "pretty:target/cucumber-test-report/cucumber-pretty.txt",
            "html:target/cucumber-test-report",
            "json:target/cucumber-test-report/cucumber-report.json",
            "junit:target/cucumber-test-report/test-report.xml",
            "json:target/test-report.json"
        }
        )
public class BDDRunner {

}
