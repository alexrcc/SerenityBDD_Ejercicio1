package org.example.software.screenplay.tasks;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import org.example.software.screenplay.user_interface.BuyForm;


public class FormBuy {
    public static Performable fillForm(String name, String country,String city, String card, String month, String year){
        return Task.where("{0} checkout form",
                        Enter.theValue(name).into(BuyForm.NAME),
                        Enter.theValue(country).into(BuyForm.COUNTRY),
                        Enter.theValue(city).into(BuyForm.CITY),
                        Enter.theValue(card).into(BuyForm.CARD),
                        Enter.theValue(month).into(BuyForm.MONTH),
                        Enter.theValue(year).into(BuyForm.YEAR)
                )
                .with("name").of(name)
                .with("country").of(country)
                .with("city").of(city)
                .with("card").of(card)
                .with("month").of(month)
                .with("year").of(year);
    }
    public static Performable Purchase(){
        return Task.where("{0} go to car",
                Click.on(BuyForm.PURCHASE)
        );
    }
    public static Performable Finish(){
        return Task.where("{0} go to car",
                Click.on(BuyForm.CONFIRM)
        );
    }
}
