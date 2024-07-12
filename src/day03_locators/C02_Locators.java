package day03_locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.ReusableMethods;

import java.time.Duration;
import java.util.List;

public class C02_Locators {
    public static void main(String[] args) {

        //1- Bir test class’i olusturun ilgili ayarlari yapin
        System.setProperty("Webdriver.chrome.driver","KurulumDosyalari/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //2- http://zero.webappsecurity.com/ adresine gidin
        driver.get("http://zero.webappsecurity.com/");
        //3- “ONLINE BANKING” linkine tiklayin
        driver.findElement(By.id("onlineBankingMenu"))
                .click();
        //4- Resim altinda 6 islem basligi oldugunu test edin
        List<WebElement> islemBasliklariList = driver.findElements(By.className("headers"));

        int expectedBaslikSayisi = 6;

        if (islemBasliklariList.size() == expectedBaslikSayisi){
            System.out.println("Baslik sayisi testi PASSED");
        }else System.out.println("Baslik sayisi testi FAILED");

        //5- Islem basliklari icinde “Pay Bills” oldugunu test edin

        // 1.yontem loop ile tum webelementlerin uzerlerindeki yazilari alip
        //   olusturacagimiz String bir listeye koyabilir
        //   ve contains() ile "Pay Bills" iceriyor mu test edebilirim

        List<String> islemIsimleriListesi = ReusableMethods.getStringList(islemBasliklariList);

        System.out.println(islemIsimleriListesi);

        if (islemIsimleriListesi.contains("Pay Bills")){
            System.out.println("Pay Bills testi PASSED");
        }else System.out.println("Pay Bills testi FAILED");


        // 2.yontem, bir flag olusturalim boolean payBillVarMi = false;
        //   for each loop ile her webelementin yazisini kontrol edelim
        //   Pay Bills olan varsa flag'i true yapalim
        //   loop bitince flag true mu diye test edelim

        boolean payBillsVarMi = false;

        for (WebElement eachElement : islemBasliklariList
             ) {

            if (eachElement.getText().equalsIgnoreCase("Pay Bills")){
                payBillsVarMi = true;
            }
        }

        // loop bittiginde eger listede pay bills varsa payBillsVarMi = true olur
        //                                        yoksa payBillsVarMi = false olur

        // bizden istenen payBill'in oldugunu test etmemiz

        if ( payBillsVarMi ){ // payBillsVarMi == true
            System.out.println("Pay Bills testi PASSED");
        }else {
            System.out.println("Pay Bills testi FAILED");
        }

        //6- Sayfayi kapatin

        driver.quit();
    }
}
