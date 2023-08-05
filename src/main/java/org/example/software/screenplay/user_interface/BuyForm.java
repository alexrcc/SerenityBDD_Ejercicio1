package org.example.software.screenplay.user_interface;
import org.openqa.selenium.By;

public class BuyForm {

    public static By NAME = By.id("name");
    public static By COUNTRY = By.id("country");
    public static By CITY = By.id("city");
    public static By CARD = By.id("card");
    public static By MONTH = By.id("month");
    public static By YEAR = By.id("year");
    public static By PURCHASE= By.xpath("//*[@id=\"orderModal\"]/div/div/div[3]/button[2]");
    public static By CONFIRM = By.xpath("/html/body/div[10]/div[7]/div/button");
}
