package org.example.software.screenplay.navigate;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;

public class Start {
    public static Performable OpenBuyPage() {
        return Task.where("{0} Open home page",
                Open.browserOn().the(OpenPage.class));
    }
}
