package com.tcs.trainingxi.epm.tasks;

import com.tcs.trainingxi.epm.utils.BuildString;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.targets.Target;


public class TypeMessage implements Task {

    private int quantity;
    private Target target;

    public TypeMessage(int quantity, Target target) {
        this.quantity = quantity;
        this.target = target;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        String message = BuildString.WriteText(quantity);
        actor.attemptsTo(Enter.theValue(message).into(target));
    }

    public static TypeMessage in(int quantity, Target target){
        return Tasks.instrumented(TypeMessage.class, quantity, target);
    }

}
