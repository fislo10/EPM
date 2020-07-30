package com.tcs.trainingxi.epm.questions;


import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.targets.Target;



public class TheLenght implements Question<Integer> {

    private Target target;
    private String option;


    public TheLenght(Target target, String option) {
        this.target = target;
        this.option = option;
    }

    @Override
    public Integer answeredBy(Actor actor) {
        WebElementFacade element = target.resolveFor(actor).findBy("//input[contains(@id,'"+option+"')]");
        return element.getValue().length();
    }

    public static TheLenght of(Target target, String option){
        return new TheLenght(target, option);
    }

}
