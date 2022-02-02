package test.java;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;


import java.time.Duration;

public class gmailHW{
    @Test
    public void loginHP() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\petre\\Downloads\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://mail.google.com/");
        WebElement loginField = driver.findElement(By.name("identifier"));
        WebElement buttonFollow = driver.findElement(By.xpath("//*[@class = 'VfPpkd-LgbsSe VfPpkd-LgbsSe-OWXEXe-k8QpJ VfPpkd-LgbsSe-OWXEXe-dgl2Hf nCP5yc AjY5Oe DuMIQc qIypjc TrZEUc lw1w4b']"));
        loginField.sendKeys("testKatePetro@gmail.com");
        buttonFollow.click();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        WebElement passwordField = driver.findElement(By.name("password"));
        passwordField.sendKeys("Katetest38");
        passwordField.sendKeys(Keys.ENTER);

        driver.findElement(By.xpath("//div[@class = 'T-I T-I-KE L3']")).isDisplayed();
    }

    @Test
    public void loginNP() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\petre\\Downloads\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://mail.google.com/");
        WebElement loginField = driver.findElement(By.name("identifier"));
        WebElement buttonFollow = driver.findElement(By.xpath("//*[@class = 'VfPpkd-LgbsSe VfPpkd-LgbsSe-OWXEXe-k8QpJ VfPpkd-LgbsSe-OWXEXe-dgl2Hf nCP5yc AjY5Oe DuMIQc qIypjc TrZEUc lw1w4b']"));
        loginField.sendKeys("testKatePetro@gmail.com");
        buttonFollow.click();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        WebElement passwordField = driver.findElement(By.name("password"));
        passwordField.sendKeys("Katetest3");
        passwordField.sendKeys(Keys.ENTER);

        driver.findElement(By.xpath("//*[@class=\"OyEIQ uSvLId\"]")).isDisplayed();
    }

    @Test
    public void sendEmailHP() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\petre\\Downloads\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://mail.google.com/");
        WebElement loginField = driver.findElement(By.name("identifier"));
        WebElement buttonFollow = driver.findElement(By.xpath("//*[@class = 'VfPpkd-LgbsSe VfPpkd-LgbsSe-OWXEXe-k8QpJ VfPpkd-LgbsSe-OWXEXe-dgl2Hf nCP5yc AjY5Oe DuMIQc qIypjc TrZEUc lw1w4b']"));
        loginField.sendKeys("testKatePetro@gmail.com");
        buttonFollow.click();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        WebElement passwordField = driver.findElement(By.name("password"));
        passwordField.sendKeys("Katetest38");
        passwordField.sendKeys(Keys.ENTER);

        WebElement buttonWrite = driver.findElement(By.xpath("//div[@class = 'T-I T-I-KE L3']"));
        buttonWrite.click();

        WebElement emailTitle = (new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//input[@class= 'aoT']")))));
        emailTitle.sendKeys("test");


        WebElement emailReceiver = (new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@class = 'agP aFw']"))));
        emailReceiver.sendKeys("ande.sladkoeshko@gmail.com");

        WebElement sendButton = driver.findElement(By.xpath("//*[@class=\"T-I J-J5-Ji aoO v7 T-I-atl L3\"]"));
        sendButton.click();
    }


    @Test
    public void sendEmailNP() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\petre\\Downloads\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://mail.google.com/");
        WebElement loginField = driver.findElement(By.name("identifier"));
        WebElement buttonFollow = driver.findElement(By.xpath("//*[@class = 'VfPpkd-LgbsSe VfPpkd-LgbsSe-OWXEXe-k8QpJ VfPpkd-LgbsSe-OWXEXe-dgl2Hf nCP5yc AjY5Oe DuMIQc qIypjc TrZEUc lw1w4b']"));
        loginField.sendKeys("testKatePetro@gmail.com");
        buttonFollow.click();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        WebElement passwordField = driver.findElement(By.name("password"));
        passwordField.sendKeys("Katetest38");
        passwordField.sendKeys(Keys.ENTER);

        WebElement buttonWrite = driver.findElement(By.xpath("//div[@class = 'T-I T-I-KE L3']"));
        buttonWrite.click();

        WebElement emailTitle = (new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//input[@class= 'aoT']")))));
        emailTitle.sendKeys("test");
        WebElement sendButton = driver.findElement(By.xpath("//*[@class=\"T-I J-J5-Ji aoO v7 T-I-atl L3\"]"));
        sendButton.click();
        driver.findElement(By.xpath("//*[@class=\"Kj-JD\"]")).isDisplayed();
    }
}
