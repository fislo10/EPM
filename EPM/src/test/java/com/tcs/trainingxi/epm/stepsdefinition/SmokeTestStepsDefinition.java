package com.tcs.trainingxi.epm.stepsdefinition;

import com.tcs.trainingxi.epm.exceptions.LaunchingException;
import com.tcs.trainingxi.epm.questions.TheVisibility;
import com.tcs.trainingxi.epm.ui.MiFacturaWebPage;
import com.tcs.trainingxi.epm.ui.ProfilePage;
import com.tcs.trainingxi.epm.utils.constants.MessageException;
import cucumber.api.java.en.Then;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.actors.OnStage;

import static com.tcs.trainingxi.epm.models.enums.ManagementNavigationOptions.PERFIL;

public class SmokeTestStepsDefinition {

    @Then("^he should see the profile option$")
    public void heShouldSeeTheProfileOption() {
        OnStage.theActorInTheSpotlight().should(GivenWhenThen.seeThat(
                TheVisibility.of(MiFacturaWebPage.MY_ACCOUNT_OPTION.of(PERFIL.getOption())))
        .orComplainWith(LaunchingException.class, MessageException.MESSAGE_NOT_VISIBILITY));
    }

    @Then("^he should see save changes button$")
    public void heShouldSeeSaveChangesButton() {
        OnStage.theActorInTheSpotlight().should(GivenWhenThen.seeThat(
                TheVisibility.of(ProfilePage.SAVE_CHANGES_BTN))
                .orComplainWith(LaunchingException.class, MessageException.MESSAGE_NOT_VISIBILITY));
    }

}
