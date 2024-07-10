package day02_driverMethodlari_WebElement_Locator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C05_LocatorVeWebElementKullanimi {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("Webdriver.chrome.driver","KurulumDosyalari/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // testotomasyonu ana sayfaya gidin
        driver.get("https://www.testotomasyonu.com");

        // arama kutusunu locate edin

        // id'si global-search olan webelement dedigimizde unique degere ulasiyoruz
        // locator olarak By.id() kullanabiliriz

        // locate etme, belirlenen adresi ve locator'i kullanarak
        // istenen web elementi icinde bulundugumuz class'dan kullanilir hale getirmektir.

        WebElement aramaKutusu  = driver.findElement(By.id("global-search"));

        // arama kutusuna "phone" yazdirin
        aramaKutusu.sendKeys("phone");


        // ENTER'a basarak aramayi yaptirin
        aramaKutusu.submit();

        // sayfayi kapatin

        driver.quit();
    }
}
