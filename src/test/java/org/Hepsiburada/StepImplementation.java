package org.Hepsiburada;

import com.thoughtworks.gauge.Step;
import org.Hepsiburada.base.HookImp;
import org.Hepsiburada.base.Locator;
import org.Hepsiburada.methods.Methods;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StepImplementation extends HookImp {
    Methods methods = new Methods();

    public Logger logger = LoggerFactory.getLogger(getClass());



    @Step("Android bildirimi varsa kapatılır")
    public void handleCloseNotifications() {
        try {
            logger.info("Andorid bildirimi kontrol ediliyor.");
            methods.waitForElementVisible(Locator.NOTIFICATIONS, "xpath", 5); // Kısa bir süre bekleyin
            methods.click(Locator.NOTIFICATIONS, "xpath");
            logger.info("Bildirim kapatildi.");
        } catch (org.openqa.selenium.TimeoutException e) {
            logger.info("Bildirim bulunamadi, test devam ediyor.");

        }
    }

    @Step("Pop-up varsa kapatılır")
    public void handleClosePopup() {
        try {
            logger.info("Pop-up varligi kontrol ediliyor.");
            methods.waitForElementVisible(Locator.POP_UP, "xpath", 20);
            logger.info("Pop-up kapatildi.");
        }catch (org.openqa.selenium.TimeoutException e) {

            logger.info("Pop-up bulunamadi test devam ediyor");
        }
        int x = 900; 
        int y = 1846;
        methods.tapByCoordinates(x, y);
        methods.click(Locator.POP_UP,"xpath");
    }
    @Step("Hesabim sayfasına tiklanir")
    public void clickMyAccountPage() {
        methods.waitForElementVisible(Locator.MY_ACCOUNT_TAB,"xpath",20);
        methods.click(Locator.MY_ACCOUNT_TAB,"xpath");
        logger.info("Hesabim sayfasına tiklandi.");

    }
    @Step("Giris yap butonuna tiklanir.E-mail yada telefon girilir.Giris yap butonuna tiklanir")
    public void firstLoginSteps(){
        methods.waitForElementVisible(Locator.LOGIN_BUTTON,"xpath",20);
        methods.click(Locator.LOGIN_BUTTON,"xpath");
        logger.info("Giriş yap butonuna tiklandi.");

        methods.waitForElementVisible(Locator.LOGIN_BUTTON_2,"xpath",20);
        methods.sendKeys(Locator.EMAIL_PHONE_TAB,"eyupcanbilginbae@gmail.com","xpath");
        logger.info("E-posta veya telefon girildi.");

        methods.click(Locator.LOGIN_BUTTON_2,"xpath");
        logger.info("Giriş yap butonuna tiklandi.");
    }
    @Step("Sifre girilir. Giriş yap butonuna tıklanir")
    public void secoundLoginSteps(){
        methods.waitForElementVisible(Locator.PASSWORD_TAB,"xpath",20);
        methods.sendKeys(Locator.PASSWORD_TAB,"Eyupcan0901.","xpath");
        logger.info("Şifre girildi.");

        methods.click(Locator.LOGIN_BUTTON_3,"xpath");
        logger.info("Giriş yap butonuna tiklandi");
    }
    @Step("Hosgeldin mesaji kapatilir.Anasayfa'ya gidilir")
    public void homePageAndSearch(){
        methods.waitForElementVisible(Locator.WELCOME_MSG_OK,"xpath",20);
        methods.click(Locator.WELCOME_MSG_OK,"xpath");
        logger.info("Hosgeldin mesaji kapatildi.");

        methods.click(Locator.HOME_PAGE_BUTTON,"xpath");
        logger.info("Anasayfa butonuna tiklandi.");
    }
    @Step("Arama çubuğuna tiklanir ve gaming laptop yazilir.Çikan ilk seçime tiklanir")
    public void searchAndClick(){
        methods.waitForElementVisible(Locator.SEARCH_TAB,"xpath",20);
        methods.click(Locator.SEARCH_TAB,"xpath");
        logger.info("Arama çubuğuna tiklandi.");

        methods.sendKeys(Locator.SEARCH_TAB,"gaming laptop","xpath");
        logger.info("Arama cubuguna 'gaming laptop' yazildi.");

        methods.waitForElementVisible(Locator.SEARCH_RESULT,"xpath",20);
        methods.click(Locator.SEARCH_RESULT,"xpath");
        logger.info("Cikan ilk sonuca tiklandi.");
    }
    @Step("Filtrelere tiklanir")
    public void filterClick(){
        methods.waitForElementVisible(Locator.FILTER_BUTTON,"id",20);
        methods.click(Locator.FILTER_BUTTON,"id");
        methods.click(Locator.GRAPHIC_CARD_BUTTON,"xpath");
        methods.selectRandomGraphicsCard(12);
        logger.info("Rastgele ekran kartı secildi");
        methods.click(Locator.FILTER_APPLY,"id");
        logger.info("Filtre uygulandi");

    }
    @Step("Fiyat filtresine girilir")
    public void priceFilter(){
        methods.waitForElementVisible(Locator.PRICE_FILTER,"xpath",20);
        methods.click(Locator.PRICE_FILTER,"xpath");
        methods.selectRandomPrice(5);
        logger.info("Rastgele fiyat araligi secildi");
        methods.click(Locator.FILTER_APPLY,"id");
        logger.info("Filtre uygulandi");
        methods.click(Locator.SEE_FILTERED_PRODUCTS,"id");
    }
    @Step("Rastgele urun secilir")
    public void showProducts(){
        methods.waitForElementVisible(Locator.FILTER_BUTTON,"id",20);
        methods.selectRandomProduct(2);
        logger.info("Rasgele urun secildi");
    }
    @Step("Secili urun sepete eklenir")
    public void addToCart(){
        methods.waitForElementVisible(Locator.ADD_CART,"id",20);
        logger.info("Sayfanin gorunurlugu kontrol ediliyor");
        methods.click(Locator.ADD_CART,"id");
        logger.info("Urun sepete eklenir");
        methods.waitForElementVisible(Locator.GO_CART,"id",20);
        methods.click(Locator.GO_CART,"id");
        logger.info("Sepetim sayfasina gidilir");

    }
    @Step("Sepetim sayfasina gidilir ve urun sepetten cikarilir")
    public void goToCart(){

        methods.waitForElementVisible(Locator.CART_DONE,"xpath",20);
        logger.info("Sayfanin gorunurlugu kontrol edilir");
        methods.click(Locator.REMOVE_CART,"xpath");
        logger.info("Sepet bosaltilir");
        methods.waitForElementVisible(Locator.DELETE_CART,"xpath",20);
        methods.click(Locator.DELETE_CART,"xpath");
        logger.info("Sil tusuna basilir");

    }
    @Step("Hesaptan cikis yapilir")
    public void signOutAcc(){
        methods.waitForElementVisible(Locator.MY_ACCOUNT_TAB,"xpath",20);
        logger.info("Sayfanin gorunurlugu kontrol edilir");
        methods.click(Locator.MY_ACCOUNT_TAB,"xpath");
        logger.info("Hesabim sekmesine tiklanir");
        methods.waitForElementVisible(Locator.MY_ORDERS,"xpath",20);
        logger.info("Sayfanin gorunurlugu kontrol edilir");
        methods.scrollDown();
        logger.info("Sayfa asagi kaydirilir");
        methods.click(Locator.SIGNOUT_ACC,"xpath");
        logger.info("Cikis yap tusuna tiklanir");
    }







}