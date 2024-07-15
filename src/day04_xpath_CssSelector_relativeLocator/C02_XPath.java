package day04_xpath_CssSelector_relativeLocator;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;
import java.util.List;

public class C02_XPath {
    public static void main(String[] args) throws InterruptedException {

        //1-  bir class olusturun
        System.setProperty("Webdriver.chrome.driver","KurulumDosyalari/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //2-  https://www.testotomasyonu.com/ adresine gidin
        driver.get("https://www.testotomasyonu.com/");
        //3-  Browseri tam sayfa yapin
        driver.manage().window().maximize();
        //4-  Sayfayi “refresh” yapin
        driver.navigate().refresh();
        //5-  Sayfa basliginin “Test Otomasyonu” ifadesi icerdigini test edin

        String expectedTitleIcerik = "Test Otomasyonu";
        String actualTitle = driver.getTitle();

        if (actualTitle.contains(expectedTitleIcerik)){
            System.out.println("Title testi PASSED");
        }else System.out.println("Title testi FAILED");

        //6-  Furniture linkine tiklayin
        driver.findElement(By.xpath("(//a[text()='Furniture'])[3]"))
                .click();
        //7-  price range filtresinde min degere 40, max degere 200 yazip filtreleyin

        WebElement minKutusu = driver.findElement(By.xpath("//input[@name='min']"));
        WebElement maxKutusu = driver.findElement(By.xpath("//input[@name='max']"));
        WebElement filtreleButonu = driver.findElement(By.xpath("//*[@name='button']"));


        minKutusu.clear();
        maxKutusu.clear();
        minKutusu.sendKeys("40");
        maxKutusu.sendKeys("200");

        Thread.sleep(2000);

        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();

        Thread.sleep(2000);
        filtreleButonu.click();


        //8-  filtreleme sonucunda urun bulunabildigini test edin
        List<WebElement> bulunanUrunElementleriList =
                driver.findElements(By.xpath("//div[@class='product-box mb-2 pb-1']"));

        if (bulunanUrunElementleriList.size() > 0){
            System.out.println("Urun bulma testi PASSED");
        }else System.out.println("Urun bulma testi FAILED");

        //10-Ilk urunu tiklayin
        bulunanUrunElementleriList.get(0).click();

        //11- Urun fiyatinin 40 ile 200 arasinda oldugunu test edin
        WebElement fiyatElementi = driver.findElement(By.id("priceproduct"));

        String fiyatStr = fiyatElementi.getText(); // $50.00

        fiyatStr = fiyatStr.replaceAll("\\D",""); // "5000"

        double fiyatDouble = Double.parseDouble(fiyatStr); // double 5000

        fiyatDouble /= 100 ; // double 50.00

        if (fiyatDouble >=40 && fiyatDouble<=200){
            System.out.println("ilk urun fiyat testi PASSED");
        }else System.out.println("ilk urun fiyat testi FAILED");

        //12-Sayfayi kapatin
        Thread.sleep(2000);
        driver.quit();
    }
}
