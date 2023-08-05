package org.example.software.screenplay.tasks;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import org.example.software.screenplay.model.ProductoGenerico;
import org.example.software.screenplay.user_interface.BuyPageList;

public class ProcessBuy {
    public static Performable placeOrder() {
        return Task.where("{0} place order",
                Click.on(BuyPageList.PLACE_ORDER_BUTTOM));
    }
}
