package com.upToTest.amazon.e2etest.automation;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;

@RunWith(Cucumber.class)
@CucumberOptions(
features = { "src/specs/features" }, 
plugin = { "pretty", "html: target/cucumber-report.html","json: target/cucumber-report.json" }, 
tags = ("@register"), 
snippets = SnippetType.CAMELCASE, 
monochrome = true)
public class TestRunner {
	
}
