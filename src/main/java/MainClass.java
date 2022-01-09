import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class MainClass {

    static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.edge.driver", "C:\\Users\\pasha\\IdeaProjects\\Test\\Drivers\\msedgedriver.exe");
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\pasha\\IdeaProjects\\Test\\Drivers\\chromedriver.exe");
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\pasha\\IdeaProjects\\Test\\Drivers\\geckodriver.exe");
        driver = new EdgeDriver();
//        ChromeDriver driver2 = new ChromeDriver();
//        WebDriver driver1 = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        driver.get("https://www.google.com");
//        System.out.println(driver.getTitle());
//        System.out.println(driver.getCurrentUrl());
//        driver.navigate().to("https://ru.wikipedia.org/");
//        System.out.println(driver.getCurrentUrl());
//        driver.findElement(By.xpath("//*[@id=\"Добро_пожаловать_в_Википедию,\"]/a")).click();
//        System.out.println(driver.getCurrentUrl());
//        WebElement button = driver.findElement(By.xpath("//*[@id=\"ca-talk\"]/a"));
//        if (button.getText().equals("Обсуждение")) {
//            System.out.println("OK");
//        }
//        else System.out.println("Not OK");
//        button.click();
//        System.out.println(driver.getTitle());
//        driver.findElement(By.xpath("//*[@id=\"searchInput\"]")).sendKeys("Россия");
//        System.out.println(driver.findElement(By.xpath("//*[@id=\"searchInput\"]")).getAttribute("value"));
//        driver.findElement(By.xpath("//*[@id=\"searchButton\"]")).click();
//        System.out.println(driver.getTitle());
//        WebElement text = driver.findElement(By.xpath("//*[@id=\"mw-content-text\"]/div[1]/p[13]/a[7]"));
//        System.out.println(text.getText());
//        text.click();
//        System.out.println(driver.getTitle());

//
//        driver.get("https://mail.ru/");
//        WebElement Search = driver.findElement(By.xpath("//*[@id=\"q\"]"));
//        Search.sendKeys("bulkin");
//        driver.findElement(By.xpath("//*[@id=\"search:submit\"]")).click();
//        System.out.println(driver.getTitle() + " " + driver.getCurrentUrl());


//        driver.get("https://market.yandex.ru/catalog--smartfony-v-cheliabinske/26893750/list?hid=91491&cpa=0&onstock=1&local-offers-first=0");
//        driver.findElement(By.xpath("//input[@name='Производитель Apple']/parent::*")).click();
//        selectCheckBox("Производитель HONOR");
//        noselectCheckBox("Производитель Apple");
//        driver.findElement(By.xpath("//span[text()='До 5 дней']/parent::div/parent::*"))

        driver.get("https://www.adidas.ru/krossovki-outlet");
        selectOption("ТИП ТОВАРА", "Кроссовки");
        driver.findElement(By.xpath("//button[@aria-label='Закрыть']")).click();
        selectOption("КАТЕГОРИЯ", "Аксессуары");
        selectOption("СКИДКА","10%");
////        driver.quit();

    }

    public static void selectCheckBox(String name,String name1){

        String cbXpath = "//input[@name='%s']/parent::*";
        if(!driver.findElement(By.xpath(String.format(cbXpath, name) + "/input")).isSelected())
            driver.findElement(By.xpath(String.format(cbXpath, name))).click();
    }

    public static void noselectCheckBox(String name){
        String cbXpath = "//input[@name='%s']/parent::*";
        if(driver.findElement(By.xpath(String.format(cbXpath, name) + "/input")).isSelected())
            driver.findElement(By.xpath(String.format(cbXpath, name))).click();
    }

    public static void selectOption(String ListName, String Options){
        String listXpath = String.format("//span[@title='%s']/parent::*", ListName);
        String optionXpath = String.format("//input[@title='%s']/parent::*", Options);
        driver.findElement(By.xpath(listXpath)).click();
        driver.findElement(By.xpath(optionXpath)).click();
    }
}
