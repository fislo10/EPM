package com.tcs.trainingxi.epm.runners;


import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src/test/resources/features/profile_update.feature",
        snippets = SnippetType.CAMELCASE,
        glue = "com.tcs.trainingxi.epm.stepsdefinition",
        tags = "@tag1",
        dryRun = false)
public class ProfileUpdate {


}
