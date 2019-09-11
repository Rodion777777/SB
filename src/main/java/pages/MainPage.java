package pages;


import com.aplana.SB.Trash;
import com.google.common.base.Function;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage extends BasePage {

    @FindBy(xpath = "//span[.='Ипотека']")
    WebElement actionToButtonElement;

    @FindBy(xpath = "//li[@class='lg-menu__item lg-menu__item_hovered']//a[.='Ипотека на готовое жильё']")
    WebElement buttonCompleteHouseElement;



    public void actionToButton()
    {
        WebDriverWait wait = new WebDriverWait(driver, 4, 2000);
        Actions action = new Actions(driver);
        action.moveToElement(actionToButtonElement);
        action.perform();
    }

    public void clickButtonCompleteHouseElement(){
        buttonCompleteHouseElement.click();
    }



}
