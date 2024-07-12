package day02_driverMethodlari_WebElement_Locator;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C06_LocatorsVeFindElementsMethodu {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("Webdriver.chrome.driver","KurulumDosyalari/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // testotomasyonu anasayfaya gidin
        driver.get("https://www.testotomasyonu.com");

        // arama kutusuna phone yazip aratin

        driver.findElement(By.id("global-search"))
                .sendKeys("phone" + Keys.ENTER);

        // arama sonucunda 3'den fazla urun bulunabildigini test edin

        // 1.yontem arama sonuc yazisi olan "4 Products Found" yazisindaki 4'u
        //          sayi olarak kaydedip, 3'den buyuk oldugunu test edelim

        WebElement aramaSonucElementi = driver.findElement(By.className("product-count-text"));

        // System.out.println(aramaSonucElementi.getText()); // 4 Products Found

        String aramaSonucYazisi = aramaSonucElementi.getText(); // "4 Products Found"

        aramaSonucYazisi = aramaSonucYazisi.replaceAll("\\D",""); // "4"

        int actualAramaSonucSayisi = Integer.parseInt(aramaSonucYazisi); // 4
        int expectedMinSonucSayisi = 3;

        if (actualAramaSonucSayisi > expectedMinSonucSayisi) {
            System.out.println("Arama sonuc sayisi testi PASSED");
        }else System.out.println("Arama sonuc sayisi testi FAILED");


        // 2.yontem bulunan urunleri bir liste olarak kaydedip
        //          listenin size'inin 3'den buyuk oldugunu test edebiliriz

        List<WebElement> bulunanUrunElementleriList = driver.findElements(By.className("prod-img"));

        if ( bulunanUrunElementleriList.size() > expectedMinSonucSayisi  ){
            System.out.println("Arama sonuc sayisi testi PASSED");
        }else System.out.println("Arama sonuc sayisi testi FAILED");


        // sayfayi kapatin

        Thread.sleep(3000);
        driver.quit();
    }
}
