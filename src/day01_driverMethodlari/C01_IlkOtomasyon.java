package day01_driverMethodlari;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C01_IlkOtomasyon {

    public static void main(String[] args) throws InterruptedException {

        /*
            kurulum dosyalarini proje altina kopyalamak
            selenium ve chromedriver'i projeye eklemek icin yeterli degildir

            Selenium'u kurmak icin
            jar dosyalarini olusturdugumuz her projede bir kez
            projeye eklemeliyiz

            chromedriver.exe ise
            her class'da WebDriver objeji olusturulurken kullanilir
         */

        /*
            Selenium bizim istedigimiz tum otomasyonlari
            olusturacagimiz WebDriver objesi ile yapar

            Selenium ile bir otomasyon yapilacaksa
            once WebDriver objesi olusturulmalidir
         */

       System.setProperty("Webdriver.chrome.driver","KurulumDosyalari/chromedriver");
       WebDriver driver = new ChromeDriver();
       // 31.satir calistiginda,
       // Selenium bilgisayarimizda var olan browser'lardan
       // sectigimizin bir kopyasini olusturup otomasyon icin bizim kodlarimizi bekler


       driver.get("https://testotomasyonu.com");
       /*
            otomasyonla bir url'e gitmak icin tum url'i yazmamiz gerekir
            url'de https:// kullanilmazsa selenium verilen url'e gitmez
            ama www kullanilmasa da olabilir
        */

        Thread.sleep(5000);


       // driver.close();
       // driver olusturulurken acilan window'u kapatir
       driver.quit();
       // driver calistigi muddetce acilan tum window'lari kapatir

    }
}
