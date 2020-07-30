package com.tcs.trainingxi.epm.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Visibility;
import net.serenitybdd.screenplay.targets.Target;

public class TheVisibility implements Question<Boolean> {

    private Target target;

    public TheVisibility(Target target) {
        this.target = target;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        return Visibility.of(target).viewedBy(actor).asBoolean();
    }

    public static TheVisibility of(Target target){
        return new TheVisibility(target);
    }

}
