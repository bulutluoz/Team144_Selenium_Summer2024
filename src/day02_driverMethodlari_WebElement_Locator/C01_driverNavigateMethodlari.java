package day02_driverMethodlari_WebElement_Locator;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class C01_driverNavigateMethodlari {
    public static void main(String[] args) throws InterruptedException {
        //System.setProperty("Webdriver.chrome.driver","KurulumDosyalari/chromedriver");
        /*
            9.satirin gorevi
            bilgisayarimizda fiziki olarak kullandigimiz chrome versiyonuna uygun
            selenium.dev sitesinden indirdigimiz ve kopya browser olusturmamizi saglayan
            chromedriver.exe dosyasini clasimiza tanitmak.

            Selenium 4.0.0 versiyonu ile kutuphanelerine
            tum guncel browser'lara ait driver'lari yukledi
            boylece bir class olusturdugumuzda

            BIZ ISTERSEK, kendi driver'imizi 9.satiri kullanarak tanitabilir
            veya ISTERSEK 9.satiri atlayip Selenium'un kendi driver'larini kullanabiliriz
         */
        WebDriver driver = new FirefoxDriver();

        driver.get("https://www.testotomasyonu.com");

        driver.navigate().to("https://www.wisequarter.com");

        // 28.satir ile 26.satir islev acisindan aynidir
        Thread.sleep(2000);

        // tekrar testotomasyonuna donun
        driver.navigate().back();

        Thread.sleep(2000);
        // bir daha wisequarter'a gidelim
        driver.navigate().forward();


        Thread.sleep(2000);
        // sayfayi yenileyelim
        driver.navigate().refresh();


        Thread.sleep(2000);
        driver.quit();

    }
}
