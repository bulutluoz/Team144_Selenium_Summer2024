package day01_driverMethodlari;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C02_DriverGetMethodlari {

    public static void main(String[] args) throws InterruptedException {

        // Her actigimiz class'da ilk isimiz WebDriver objesi olusturmak olmalidir


        System.setProperty("Webdriver.chrome.driver","KurulumDosyalari/chromedriver");
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.testotomasyonu.com");

        System.out.println(driver.getTitle()); // Test Otomasyonu - Test Otomasyonu

        System.out.println(driver.getCurrentUrl()); // https://www.testotomasyonu.com/

        System.out.println(driver.getPageSource()); // HTML sayfanin tum kaynak kodlarini getirir

        System.out.println(driver.getWindowHandle());
        // 3917D1EE9E3F9FCCDBF460DA7BADD951
        // E1893BAD35AB6C28F2DD6081523EF438
        // Selenium WebDriver actigi her browser icin benzersiz bir handle degeri uretir
        // EGER testimiz calisirken driver objesi ile birden fazla window acildi ise
        // bu window'lar arasinda gecisi windowHandle degerleri ile yapabiliriz
        //  76F3F2C4F4B1542F3D8E88B485F9AFC0

        System.out.println(driver.getWindowHandles());
        // Eger driver birden fazla window acti ise
        // acik olan tum window'larin windowHandleDegerlerini bize verir
        //  [76F3F2C4F4B1542F3D8E88B485F9AFC0]

        Thread.sleep(3000);
        driver.quit();
    }
}
