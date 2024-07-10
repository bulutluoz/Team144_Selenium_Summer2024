package day02_driverMethodlari_WebElement_Locator;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.LocalDateTime;
import java.time.LocalTime;

public class C02_DriverManageWindowMethodlari {

    public static void main(String[] args) throws InterruptedException {

        LocalTime localTime = LocalTime.now();
        long baslangicSaniye = localTime.toSecondOfDay();

        System.setProperty("Webdriver.chrome.driver","KurulumDosyalari/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        Thread.sleep(2000);

        driver.get("https://www.testotomasyonu.com");

        System.out.println("Maximize size : "+ driver.manage().window().getSize());
        System.out.println("Maximize konum : "+ driver.manage().window().getPosition());
        Thread.sleep(2000);

        // eger tum ekrani kaplamasini istersek

        driver.manage().window().fullscreen();
        System.out.println("Fullsecreen size : "+ driver.manage().window().getSize());
        System.out.println("Fullscreen konum : "+ driver.manage().window().getPosition());


        // konumu (200,200) ve boyutu da (800,500) yapin

        driver.manage().window().setPosition(new Point(200,200));
        driver.manage().window().setSize(new Dimension(800,500));
        System.out.println("Ozel boyut size : "+ driver.manage().window().getSize());
        System.out.println("Ozel boyut konum : "+ driver.manage().window().getPosition());


        Thread.sleep(5000);
        driver.quit();

        LocalTime localTime2 = LocalTime.now();
        long bitisSaniye = localTime2.toSecondOfDay();
        System.out.println("Sure : " + (bitisSaniye-baslangicSaniye));

    }
}
