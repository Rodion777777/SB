package com.aplana.SBCucumber;

import io.cucumber.core.api.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.When;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.BuyingCompleteHousePage;
import pages.MainPage;

import java.util.concurrent.TimeUnit;

public class Steps {

    MainPage mainPage = new MainPage();
    BuyingCompleteHousePage buyingPage = new BuyingCompleteHousePage();

    @When("открывается главная страница")
    public void openMain(){
    }
    @When("навести курсор на значок ипотеки")
    public void actionToButton(){
        new MainPage().actionToButton();
    }
    @When("кликнуть по рассчитать стоимость ипотеки для готовой квартиры")
    public void clickButtonCompleteHouseElement(){
        new MainPage().clickButtonCompleteHouseElement();
    }
    @When("ввести стоимоcть недвижимости(.*)")
    public void setEstateCost(String str){
        new BuyingCompleteHousePage().setEstateCost(str);
    }
    @When("ввести первоначальный взнос(.*)")
    public void setInitialFee(String str){
        new BuyingCompleteHousePage().setInitialFee(str);
    }
    @When("ввести срок кредита(.*)")
    public void setCreditItem(String str){
        new BuyingCompleteHousePage().setCreditItem(str);
    }
    @When("кликнуть по переключателю является участником зарплатного проекта")
    public void clickSalaryCard(){
        new BuyingCompleteHousePage().clickSalaryCard();
    }
    @When("кликнуть по переключателю могу подтвердить доход справкой")
    public void clickIncomeStatement(){
        new BuyingCompleteHousePage().clickIncomeStatement();
    }
    @When("кликнуть по переключателю молодая семья")
    public void clickFamily(){
        new BuyingCompleteHousePage().clickFamily();
    }
    @When("проверить сумму кредита (.*)")
    public void assertAmountOfCredit(String str){
        new BuyingCompleteHousePage().assertAmountOfCredit(str);
    }
    @When("проверить ежемесячный платеж (.*)")
    public void checkMonthlyPayment(String str){
        new BuyingCompleteHousePage().assertMonthlyPayment(str);
    }
    @When("проверить необходимый доход (.*)")
    public void assertRequiredIncome(String str){
        new BuyingCompleteHousePage().assertRequiredIncome(str);
    }
    @When("проверить срок кредита (.*)")
    public void assertRate(String str){
        new BuyingCompleteHousePage().assertRate(str);
    }

    @Before
    public void before(){
        WebDriver driver;
        System.setProperty("webdriver.chrome.driver", TestProperties.getInstance().getProperty("path.chrome"));
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(TestProperties.getInstance().getProperty("url"));
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
        Trash.driver = driver;
    }

    @After
    public void tearDown() throws Exception {

        Trash.getDriver().quit();
    }
//    @Attachment(type = "image/png", value = "Screenshot")
//    public static byte[] takeScreenshot() {
//        return ((TakesScreenshot) Trash.getDriver()).getScreenshotAs(OutputType.BYTES);
//    }
    public void embedScreenshot(Scenario scenario) {
    if (scenario.isFailed()) {
        try {
            byte[] screenshot = ((TakesScreenshot) Trash.getDriver())
                    .getScreenshotAs(OutputType.BYTES);
            scenario.embed(screenshot, "image/png");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}



}
