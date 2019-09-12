package com.aplana.SB;

import io.cucumber.java.Before;
import io.cucumber.java.en.When;
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
    public void getTheButton(){
        mainPage.actionToButton();
    }
    @When("кликнуть по рассчитать стоимость ипотеки для готовой квартиры")
    public void clButtonCompleteHouseElement(){
        mainPage.clickButtonCompleteHouseElement();
    }
    @When("ввести стоимоcть недвижимости(.*)")
    public void setCost(String str){
        buyingPage.setEstateCost(str);
    }
    @When("ввести первоначальный взнос(.*)")
    public void setFee(String str){
        buyingPage.setInitialFee(str);
    }
    @When("ввести срок кредита(.*)")
    public void setItem(String str){
        buyingPage.setCreditItem(str);
    }
    @When("кликнуть по переключателю является участником зарплатного проекта")
    public void clSalaryCard(){
        buyingPage.clickSalaryCard();
    }
    @When("кликнуть по переключателю могу подтвердить доход справкой")
    public void clIncomeStatement(){
        buyingPage.clickIncomeStatement();
    }
    @When("кликнуть по переключателю молодая семья")
    public void clFamily(){
        buyingPage.clickFamily();
    }
    @When("проверить сумму кредита(.*)")
    public void checkAmountOfCredit(String str){
        buyingPage.assertAmountOfCredit(str);
    }
    @When("проверить ежемесячный платеж(.*)")
    public void checkMonthlyPayment(String str){
        buyingPage.assertMonthlyPayment(str);
    }
    @When("проверить необходимый доход(.*)")
    public void checkRequiredIncome(String str){
        buyingPage.assertRequiredIncome(str);
    }
    @When("проверить срок кредита(.*)")
    public void checkRate(String str){
        buyingPage.assertRate(str);
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


}
