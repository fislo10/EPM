package com.tcs.trainingxi.epm.stepsdefinition;


import com.tcs.trainingxi.epm.exceptions.LaunchingException;
import com.tcs.trainingxi.epm.models.UserData;
import com.tcs.trainingxi.epm.models.builders.UserDataBuilder;
import com.tcs.trainingxi.epm.questions.TheLenght;
import com.tcs.trainingxi.epm.questions.TheText;
import com.tcs.trainingxi.epm.tasks.Fill;
import com.tcs.trainingxi.epm.tasks.Login;
import com.tcs.trainingxi.epm.tasks.Navigate;
import com.tcs.trainingxi.epm.tasks.TypeMessage;
import com.tcs.trainingxi.epm.utils.readers.PropsCsv;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Clear;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.Cast;
import net.serenitybdd.screenplay.actors.OnStage;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import static com.tcs.trainingxi.epm.models.enums.ManagementNavigationOptions.*;
import static com.tcs.trainingxi.epm.models.enums.ManagementUrl.EPM_URL;
import static com.tcs.trainingxi.epm.ui.PopUpComponent.FINAL_MESSAGE_FAIL;
import static com.tcs.trainingxi.epm.ui.PopUpComponent.FINAL_MESSAGE_SUCCESSFULL;
import static com.tcs.trainingxi.epm.ui.ProfilePage.FIELD;
import static com.tcs.trainingxi.epm.ui.ProfilePage.SAVE_CHANGES_BTN;
import static com.tcs.trainingxi.epm.utils.constants.MessageException.MESSAGE_MAX_LENGTH;
import static com.tcs.trainingxi.epm.utils.constants.MessageException.MESSAGE_NOT_FOUND;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class ProfileUpdateStepsDefinition {


    private static UserData userData;

    @Managed
    public WebDriver hisBrowser;

    @Before
    public void setUp(){
        OnStage.setTheStage(Cast.ofStandardActors());
        OnStage.theActorCalled("Jonhatan");
        OnStage.theActorInTheSpotlight().can(BrowseTheWeb.with(hisBrowser));
    }


    @Given("^user has been on the main page$")
    public void userIsInMainPage() {
      OnStage.theActorInTheSpotlight().wasAbleTo(Open.url(EPM_URL.getUrl()));
    }


    @Given("^he has logged in$")
    public void heHasLoggedIn(List<Map<String, String>> users) throws IOException {
        userData = UserDataBuilder.
                UserDataInformation(PropsCsv.getDataCsv("userdata",users.get(0).get("filter"))).build();
        OnStage.theActorInTheSpotlight().wasAbleTo(
                Navigate.toLoginPage(CLIENTE.getOption(), PAGA_TU_FACTURA.getOption()),
                Login.with(
                        userData.getEmail(),
                        userData.getPassword()));
    }

    @Given("^he has navigate to profile update page$")
    public void heHasNavigateToProfileUpdatePage() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                Navigate.toProfilePage(PERFIL.getOption()));
    }


    @When("^he modifies his personal data in fields: (.*), (.*), (.*) and (.*)$")
    public void heModifiesHisPersonalDataInFieldsNombresDireccionTelefonoAndCelular(
            String n, String d, String t, String c)  {
        OnStage.theActorInTheSpotlight().attemptsTo(
                Fill.profileForm(n,d,t,c, userData),
                Click.on(SAVE_CHANGES_BTN)
        );
    }

    @Then("^he should see the message: (.*)$")
    public void heShouldSeeTheMessageLaInformacionIngresadaFueAlmacenadaConExito(String message) {
        OnStage.theActorInTheSpotlight().should(seeThat(
                TheText.of(FINAL_MESSAGE_SUCCESSFULL), is(equalTo(message)))
                .orComplainWith(LaunchingException.class, MESSAGE_NOT_FOUND));
    }

    @When("^he tries to save changes leaving the mandatory field (.*) empty$")
    public void heTriesToSaveChangesLeavingTheMandatoryFieldNombresEmpty(String option) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                Clear.field(FIELD.of(option)),
                Click.on(SAVE_CHANGES_BTN));
    }

    @Then("^he should see the next message: (.*)$")
    public void heShouldSeeTheNextMessageLosCamposMarcadosConSonRequeridos(String message) {
        OnStage.theActorInTheSpotlight().should(seeThat(
                TheText.of(FINAL_MESSAGE_FAIL), is(equalTo(message)))
                .orComplainWith(LaunchingException.class, MESSAGE_NOT_FOUND));
    }

    @When("^he updates the field (.*) with a value of (.*) characters$")
    public void heUpdatesTheFieldNombresWithAValueOfCharacters(String nameField, int quantity) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                TypeMessage.in(quantity, FIELD.of(nameField)));
    }


    @Then("^he should see the field (.*) with (.*) characters$")
    public void heShouldSeeTheFieldNombresWithCharacters(String nameField, int quantity) {
        OnStage.theActorInTheSpotlight().should(seeThat(
                TheLenght.of(FIELD.of(nameField), nameField), is(equalTo(quantity)))
                .orComplainWith(LaunchingException.class, MESSAGE_MAX_LENGTH));

    }


}
