package org.example.software.screenplay.tasks;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import org.example.software.screenplay.model.ProductoGenerico;
import org.example.software.screenplay.user_interface.HomeList;

public class BuyCar {
    public static Performable selectProduct(ProductoGenerico product) {
        return Task.where("{0} select #product",
                Click.on("//h4/a[contains(.,'"+product.getNombre()+"')]"));
    }
    public static Performable addToCar() {
       return Task.where("{0} adds product to car",
                Click.on(HomeList.ADD_CAR_BUTTOM)
        );
    }

    public static Performable goToCar() {
        return Task.where("{0} go to car",
                Click.on(HomeList.CAR_BUTTOM)
        );
    }
}
