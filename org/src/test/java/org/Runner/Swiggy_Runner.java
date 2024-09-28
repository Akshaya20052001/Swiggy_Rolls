package org.Runner;

import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(


	features = "src\\test\\java\\org\\Feature\\swiggy.feature",
	glue = "org.Step_Definition",
	dryRun = false,
	monochrome = true,
	publish=true
	
	)

public class Swiggy_Runner {
	
}



