package com.tcs.trainingxi.epm.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.WebDriver;

import java.util.Set;

public class SwitchToWindow implements Interaction {

    private String title;

    public SwitchToWindow(String title) {
        this.title = title;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        WebDriver driver = BrowseTheWeb.as(actor).getDriver();
        Set<String> windowsList = driver.getWindowHandles();
        for (String w: windowsList){
            driver.switchTo().window(w);
            if (driver.getTitle().contains(title)){
                break;
            }
        }

        if (!driver.getTitle().contains(title)){
            throw new NoSuchWindowException ("No window was found with title " + title);
        }
    }

    public static SwitchToWindow withTitle(String title){
        return Tasks.instrumented(SwitchToWindow.class, title);
    }

}
