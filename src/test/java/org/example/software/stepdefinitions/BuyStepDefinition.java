package org.example.software.stepdefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import org.example.software.screenplay.model.ProductoGenerico;
import org.example.software.screenplay.navigate.Start;
import org.example.software.screenplay.tasks.BuyCar;
import org.example.software.screenplay.tasks.FormBuy;
import org.example.software.screenplay.tasks.ProcessBuy;

import static net.serenitybdd.core.Serenity.getDriver;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.withCurrentActor;

public class BuyStepDefinition {
    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Given("que el usuario {string} ingresa a la pagina principal")
    public void queElUsuarioIngresaALaPaginaPrincipal(String actor) {
       theActorCalled(actor).attemptsTo(Start.OpenBuyPage());
    }

    @When("selecciona el producto {string}")
    public void seleccionaElProducto(String nombre) {
       withCurrentActor(
                BuyCar.selectProduct(new ProductoGenerico(nombre))
        );
    }

    @And("visualiza el detalle y lo agrega al carro de compras")
    public void visualizaElDetalleYLoAgregaAlCarroDeCompras() throws InterruptedException{
        withCurrentActor(
                BuyCar.addToCar()
        );
        Thread.sleep(1000);
        getDriver().switchTo().alert().accept();
    }

    @And("{string} regresa a la pagina principal")
    public void regresaALaPaginaPrincipal(String actor) {
        theActorCalled(actor).attemptsTo(Start.OpenBuyPage());
    }

    @When("navega al carrito de compras")
    public void navegaAlCarritoDeCompras() {
        withCurrentActor(
                BuyCar.goToCar()
        );
    }

    @And("procesa la orden")
    public void procesaLaOrden() {
        withCurrentActor(
                ProcessBuy.placeOrder()
        );
    }

    @When("completa el formulario de compra {string} {string} {string} {string} {string} {string}")
    public void completaElFormularioDeCompra(String name, String country, String city, String card, String month, String year) {
        withCurrentActor(
                FormBuy.fillForm(name,country,city,card,month,year)
        );

    }

    @And("confirma la compra")
    public void confirmaLaCompra() {
        withCurrentActor(
                FormBuy.Purchase()
        );
    }

    @Then("finalizar compra")
    public void finalizarCompra() {
        withCurrentActor(
                FormBuy.Finish()
        );
    }
}
