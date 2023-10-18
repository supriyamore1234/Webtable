package restassured;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class weTable {
    static WebDriver driver;
    private static String url = "https://www.techlistic.com/p/demo-selenium-practice.html";

    public weTable() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        // this.driver = driver;
    }

    public static void getMethod() {
        if (!driver.getCurrentUrl().equals(url)) {
            driver.get(url);
        }
    }

    public void WebTable() {
        List<WebElement> table_ = driver.findElements(By.xpath("//table[@id='customers']/tbody/tr/th"));
        // table_.getSize();
        System.out.println(table_.size());
        System.out.println("header names are");
        for (WebElement tt : table_) {
            System.out.println(tt.getText());

        }
    }

    public static void main(String[] args) {
        weTable ww = new weTable();

        getMethod();

        ww.WebTable();
        driver.quit();
    }

}