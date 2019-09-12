package com.aplana.SB;
/* небольшой тест, но учитывая что нужно прикрутить аллюр и кукумбер, также добавить скриншот при ошибке, думаю работы хватит)
Сбербанк
1) перейти на https://www.sberbank.ru
2) В верхнем меню "навестись" на Ипотека - дождаться открытия выпдающего меню и выбрать "Ипотека на готовое жилье"
3) Заполнить поля
Стоимость недвижмости 5 180 000 ₽
Первоначальнй взнос 3 058 000 ₽
Срок кредита 30 лет
Снять галочкку - есть зарплатная карта сбербанка
дождаться появляения "есть возможность подтвержить доход справкой"
поставить галочку "молодая семья"

Проверить значение полей
Сумма кредита
2 122 000 ₽
Ежемесячный платеж
18 937 ₽
Необходимый доход
31 561 ₽
Процентная ставка
11% - тут ошибка (специально)

https://www.sberbank.ru

подсказка - использовать  Actions из селениума и moveToElement


для "навестись" ну и вообще поэкспериментировать)*/


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.BuyingCompleteHousePage;
import pages.MainPage;

import java.util.concurrent.TimeUnit;

public class SbTest {
    WebDriver driver;

    @Before
    public void init(){
        System.setProperty("webdriver.chrome.driver", TestProperties.getInstance().getProperty("path.chrome"));
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(TestProperties.getInstance().getProperty("url"));
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
        Trash.driver = driver;

    }


    @Test
    public void checkMortgage() throws InterruptedException {
        MainPage mainPage = new MainPage();
        mainPage.actionToButton();
        mainPage.clickButtonCompleteHouseElement();


        BuyingCompleteHousePage buyingPage = new BuyingCompleteHousePage();
        buyingPage.setEstateCost("5180000");
        buyingPage.setInitialFee("3058000");
        buyingPage.setCreditItem("30");
        buyingPage.clickSalaryCard();
        buyingPage.clickIncomeStatement();
        buyingPage.clickFamily();
        buyingPage.assertAmountOfCredit("2 122 000 ₽");
        buyingPage.assertMonthlyPayment("18 937 ₽");
        buyingPage.assertRequiredIncome("31 561 ₽");
        buyingPage.assertRate("11%");
    }
    @After
    public void tearDown() throws Exception {
        driver.quit();
    }
}

