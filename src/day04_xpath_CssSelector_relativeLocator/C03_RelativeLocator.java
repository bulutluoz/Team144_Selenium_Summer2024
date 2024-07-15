package day04_xpath_CssSelector_relativeLocator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

import java.time.Duration;

public class C03_RelativeLocator {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("Webdriver.chrome.driver","KurulumDosyalari/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //1 ) https://testotomasyonu.com/relativeLocators adresine gidin
        driver.get("https://testotomasyonu.com/relativeLocators");
        //2 ) DSLR Camera’yi  etrafindaki elementleri kullanarak
        //    3 farkli relative locator ile locate edip tiklayin

        WebElement dslrElementi = driver.findElement(By.xpath("//*[text()='DSLR Camera']"));

        //3 ) Acilan urunun DSLR Camera oldugunu test edin.

        dslrElementi.click();
        WebElement urunIsimElementi = driver.findElement(By.xpath(" //div[@class=' heading-sm mb-4']"));

        String expectedIsim = "DSLR Camera";

        if (urunIsimElementi.getText().equals(expectedIsim)){
            System.out.println("Direk locate testi PASSED");
        }else {
            System.out.println("Direk locate testi FAILED");
        }

        // EGER DSLR Camera elementini gorebildigimiz ve
        // HTML kodunu kullanabildigimiz halde
        // element'e ulasamiyorsak alternatif bir yontem olarak
        // Relative Locator kullanabiliriz
        // Relative locator kullanabilmek icin
        // A- hedef elemente ait bir ozellik
        // B- hedef elementin etrafinda kullanabildigimiz min. bir webelement gereklidir
        Thread.sleep(3000);


        // yukardaki testte ilk urune tikladigimiz icin once urunlerin oldugu sayfaya gelelim
        driver.get("https://testotomasyonu.com/relativeLocators");
        Thread.sleep(2000);
        // 1.relative locator'i apple kulakligin saginda diye yapalim
        //  hedef elementin ozelligi : id = pic7_thumb
        WebElement appleKulaklik = driver.findElement(By.id("pic6_thumb"));

        driver.findElement( RelativeLocator.with(By.id("pic7_thumb")).toRightOf(appleKulaklik) )
                .click();
        urunIsimElementi = driver.findElement(By.xpath(" //div[@class=' heading-sm mb-4']"));


        if (urunIsimElementi.getText().equals(expectedIsim)){
            System.out.println("1.relative locator testi PASSED");
        }else {
            System.out.println("1.relative locator testi FAILED");
        }
        Thread.sleep(2000);


        // 2.relative locator icin Bat kulakligin altinda diyelim
        driver.get("https://testotomasyonu.com/relativeLocators");
        Thread.sleep(2000);
        // hedef elementin bir ozelligi : id = pictext7
        WebElement batKulaklik = driver.findElement(By.id("pic2_thumb"));

        driver.findElement(  RelativeLocator.with(By.id("pictext7")).below(batKulaklik)  )
                .click();
        urunIsimElementi = driver.findElement(By.xpath(" //div[@class=' heading-sm mb-4']"));


        if (urunIsimElementi.getText().equals(expectedIsim)){
            System.out.println("2.relative locator testi PASSED");
        }else {
            System.out.println("2.relative locator testi FAILED");
        }
        Thread.sleep(2000);

        Thread.sleep(2000);
        // 3.relative locator icin motor telefonun solunda diyelim
        driver.get("https://testotomasyonu.com/relativeLocators");
        Thread.sleep(2000);
        // hedef elementin bir ozelligi : id = pictext7

        WebElement motorTelefon = driver.findElement(By.id("pic8_thumb"));

        driver.findElement(  RelativeLocator.with(By.id("pictext7")).toLeftOf(motorTelefon)  )
                .click();
        urunIsimElementi = driver.findElement(By.xpath(" //div[@class=' heading-sm mb-4']"));


        if (urunIsimElementi.getText().equals(expectedIsim)){
            System.out.println("3.relative locator testi PASSED");
        }else {
            System.out.println("3.relative locator testi FAILED");
        }
        Thread.sleep(2000);

        Thread.sleep(2000);
        // 4.relative locator icin motor telefonun solunda,apple kulakligin saginda
        //  ve bat kulakligin altinda diyelim
        driver.get("https://testotomasyonu.com/relativeLocators");
        Thread.sleep(2000);
        // hedef elementin bir ozelligi : id = pictext7

        // driver.findElement( RelativeLocator.with(By.id("pictext7")).toRightOf(appleKulaklik) ).click();
        /*
            Her ne kadar apple kulakligi locate etmis olsak da
            sonrasinda driver'i farkli sayfalara gonderdigimiz icin
            driver appleKulaklik icin "StaleElementReferenceException" veriyor

            Bu exception daha once locate edilmis ama artik kullanilamayan element oldugunda
            karsimiza cikar

            Cozum islemi yapmadan once locate'i yenilemektir
         */

        appleKulaklik = driver.findElement(By.id("pic6_thumb"));
        batKulaklik = driver.findElement(By.id("pic2_thumb"));
        motorTelefon = driver.findElement(By.id("pic8_thumb"));

        driver.findElement( RelativeLocator.with(By.id("pictext7"))
                                        .toRightOf(appleKulaklik)
                                        .toLeftOf(motorTelefon)
                                        .below(batKulaklik)  ).click();
        urunIsimElementi = driver.findElement(By.xpath(" //div[@class=' heading-sm mb-4']"));


        if (urunIsimElementi.getText().equals(expectedIsim)){
            System.out.println("4.relative locator testi PASSED");
        }else {
            System.out.println("4.relative locator testi FAILED");
        }
        Thread.sleep(2000);
        Thread.sleep(3000);
        driver.quit();

    }
}
