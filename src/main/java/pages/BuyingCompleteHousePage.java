package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.function.Function;

public class BuyingCompleteHousePage extends BasePage {
    @FindBy(xpath = "//input[@id='estateCost']")
    private
    WebElement estateCostElement;


    @FindBy(xpath = "//input[@id='initialFee']")
    private
    WebElement initialFee;

    @FindBy(xpath = "//input[@id='creditTerm']")
    private
    WebElement creditItem;



    @FindBy(xpath = "//span[@data-test-id='monthlyPayment']")
    private WebElement monthlyPayment;

    public String getMonthlyPayment() {
        return monthlyPayment.getText();
    }

    @FindBy (xpath = "//div[contains(@class, 'discounts')]//label[contains(@class, 'switch_checked')]")
    private
    WebElement salaryCardSwitch;

    @FindBy(xpath = "//div[@class='dcCalc_frame__discounts']/div[5]//span[@class='dcCalc_switch__control']")
    private
    WebElement family;

    @FindBy(xpath = "//div[@class='dcCalc_frame__discounts']/div[3]//span[@class='dcCalc_switch__control']")
    private
    WebElement incomeStatement;

    @FindBy(xpath = "//span[@data-test-id='rate']")
    private WebElement rate;

    public String getRate() {
        return rate.getText();
    }

    public String getAmountOfCredit() {
        return amountOfCredit.getText();
    }

    @FindBy(xpath = "//span[@data-test-id='amountOfCredit']")
    private WebElement amountOfCredit;

    @FindBy(xpath = "//span[@data-test-id='requiredIncome']")
    private WebElement requiredIncome;

    public String getRequiredIncome() {
        return requiredIncome.getText();
    }

    public void goToFrameAndSelectValues(String str, String str1, String str2){
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("window.scrollBy(0,500)");
        WebDriverWait wait = new WebDriverWait(driver, 4, 2000);
        driver.switchTo().frame("iFrameResizer0");
        estateCostElement.clear();
        estateCostElement.sendKeys(str);
        Function<? super WebDriver, Object> checkEstateCostElement = new ExpectedCondition<Object>() {
            @Override
            public Boolean apply(WebDriver webDriver) {
                String expectedPrice = "47 315 ₽";
                String actualPrice = monthlyPayment.getText();
                if((!expectedPrice.equals(actualPrice))){
                    estateCostElement.clear();
                    estateCostElement.sendKeys(str);
                }
                return (expectedPrice.equals(actualPrice));

            }
        };

        wait.until(checkEstateCostElement);
        initialFee.clear();
        initialFee.sendKeys(str1);

        Function<? super WebDriver, Object> checkEstateCostElement1 = new ExpectedCondition<Object>() {
            @Override
            public Boolean apply(WebDriver webDriver) {
                String expectedPrice = "22 545 ₽";
                String actualPrice = monthlyPayment.getText();
                if((!expectedPrice.equals(actualPrice))){
                    initialFee.clear();
                    initialFee.sendKeys(str1);
                }
                return (expectedPrice.equals(actualPrice));
            }
        };
        wait.until(checkEstateCostElement1);
        creditItem.clear();
        creditItem.sendKeys(str2);
        Function<? super WebDriver, Object> checkEstateCostElement2 = new ExpectedCondition<Object>() {
            @Override
            public Boolean apply(WebDriver webDriver) {
                String expectedPrice = "18 310 ₽";
                String actualPrice = monthlyPayment.getText();
                if((!expectedPrice.equals(actualPrice))){
                    creditItem.clear();
                    creditItem.sendKeys(str2);
                }
                return (expectedPrice.equals(actualPrice));
            }
        };

        wait.until(checkEstateCostElement2);

        driver.switchTo().defaultContent();

        jse.executeScript("window.scrollBy(0,350)");


        driver.switchTo().frame("iFrameResizer0");

        salaryCardSwitch.click();
        incomeStatement.click();
        driver.switchTo().defaultContent();


        jse.executeScript("window.scrollBy(0,150)");

        driver.switchTo().frame("iFrameResizer0");
        family.click();

        driver.switchTo().defaultContent();
        jse.executeScript("window.scrollBy(0,-500)");
        driver.switchTo().frame("iFrameResizer0");
    }

}
