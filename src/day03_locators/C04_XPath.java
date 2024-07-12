package day03_locators;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.ReusableMethods;

import java.time.Duration;
import java.util.List;

public class C04_XPath {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("Webdriver.chrome.driver","KurulumDosyalari/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // testotomasyonu anasayfaya gidin
        driver.get("https://www.testotomasyonu.com");

        // dress icin arama yapin
        WebElement aramaKutusu = driver.findElement(By.id("global-search"));
        aramaKutusu.sendKeys("dress" + Keys.ENTER);

        // urun bulunabildigini test edin

        List<WebElement> urunIsimElementleriList = driver.findElements(By.xpath("//a[@class = 'prod-title mb-3 ']"));

        if (urunIsimElementleriList.size() > 0){
            System.out.println("urun bulma testi PASSED");
        }else System.out.println("urun bulma testi FAILED");

        // bulunan urun isimlerini yazdirin

        System.out.println(ReusableMethods.getStringList(urunIsimElementleriList));


        // sayfayi kapatin
        Thread.sleep(3000);
        driver.quit();

    }
}
