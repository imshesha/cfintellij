package com.vtiger.TestRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/main/resources/Feature/",
		glue = "com.vtiger.Stepdefination",
		//dryRun = true,
		tags ="@leadactivity",
		monochrome = false,
		plugin = { "pretty", "html:target/cucumber-html-report.html","json:target/cucumber.json" }
		)
public class TestRunner {

}