package pages;


import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class MainPage extends BasePage {

    @FindBy(xpath = "//span[.='Ипотека']")
    WebElement actionToButtonElement;

    @FindBy(xpath = "//li[@class='lg-menu__item lg-menu__item_hovered']//a[.='Ипотека на готовое жильё']")
    WebElement buttonCompleteHouseElement;


    @Step("навести курсор на значок ипотеки")
    public void actionToButton()
    {
//        WebDriverWait wait = new WebDriverWait(driver, 4, 2000);
        Actions action = new Actions(driver);
        action.moveToElement(actionToButtonElement);
        action.perform();
    }
    @Step("кликнуть по рассчитать стоимость ипотеки для готовой квартиры")
    public void clickButtonCompleteHouseElement(){
        buttonCompleteHouseElement.click();
    }



}
