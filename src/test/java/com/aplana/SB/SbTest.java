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
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.*;

import java.util.concurrent.TimeUnit;

import static junit.framework.TestCase.assertEquals;

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

        buyingPage.goToFrameAndSelectValues("5180000","3058000","30");
        assertEquals("сумма кредита не совпадает", "2 122 000 ₽", buyingPage.getAmountOfCredit());
        assertEquals("ежемесячный платеж не совпадает", "18 937 ₽", buyingPage.getMonthlyPayment());
        assertEquals("необходимый доход не совпадает", "31 561 ₽", buyingPage.getRequiredIncome());
        assertEquals("процентная ставка не совпадает", "11%", buyingPage.getRate());











//        mainPage.sendMessage("playstation");
//        WebDriverWait wait = new WebDriverWait(driver, 4, 500);
//        ResultsPage resultsPage = new ResultsPage();
//        resultsPage.chooseProduct("PlayStation 4 Slim Black 1 TB");
//        ProductCard productCard = new ProductCard();
//        productCard.savePriceOfCurrentProduct("playstation");
//        productCard.selectWarranty1("2 года");
//        productCard.savePriceOfCurrentProduct("playstation");
//        productCard.buyButtonClick();
//        mainPage.sendMessage("Detroit\n");
//        productCard.savePriceOfCurrentProduct("game");
//        productCard.buyButtonClick();
//        wait.until(mainPage.valueChanged);
//        assertEquals("цена корзины не  равна сумме покупок", Trash.summa(), mainPage.getTotalPrice());
//        mainPage.goToBasket();
//        BasketPage basketPage = new BasketPage();
//        assertEquals("для приставки не выбрана гарантия на 2 года", true, basketPage.checkWarranty());
//        assertEquals("цена приставки не совпадает ", 21999, basketPage.getPriceOfProductFromSite());
//        assertEquals("цена игры не совпадает", Integer.parseInt(Trash.get("game")), basketPage.getPriceOfGame());
//        assertEquals("цена корзины не  равна сумме покупок", Trash.summa(), basketPage.getFullPrice());
//        basketPage.doRemoveGame();
//        wait.until(ExpectedConditions.numberOfElementsToBe(By.xpath("//a[.='Игра  Detroit: Стать человеком (PS4)']"), 0));
//        assertEquals("Detroit всё ещё в корзине", true, basketPage.isGameFalse());
//        assertEquals("сумма уменьшилась на цену Detroit", Integer.parseInt(Trash.get("game")), Trash.summa()-Integer.parseInt(Trash.get("playstation")));
//        basketPage.clickPlusButton();
//        wait.until(mainPage.valueChanged2PS);
//        basketPage.clickPlusButton();
//        wait.until(mainPage.valueChanged3PS);
//        assertEquals("сумма не равная трем PS", Integer.parseInt(Trash.get("playstation"))*3, mainPage.getTotalPrice());
//        basketPage.clickBackButton();
//        wait.until(ExpectedConditions.numberOfElementsToBe(By.xpath("//a[.='Игра  Detroit: Стать человеком (PS4)']"), 1));
//        wait.until(mainPage.valueChanged3PSAndGame);
//        assertEquals("Detroit нет в корзине", false, basketPage.isGameFalse());
//        assertEquals("сумма не увеличиласть на стоимость Detroit", Integer.parseInt(Trash.get("playstation"))*3+Integer.parseInt(Trash.get("game")), mainPage.getTotalPrice());
    }
//    @After
//    public void tearDown() throws Exception {
//        driver.quit();
//    }
}

