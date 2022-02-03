package test.java.assertionHW;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class assertHW {

    WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void actionsBefore() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\petre\\Downloads\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.navigate().to("https://dou.ua/search/");
    }

    @AfterMethod(alwaysRun = true)
    public void actionAfter() {
        driver.close();
    }



    @Test(groups= {"searchResult"})
    public void searchResultHasSearchText() {
        WebElement searchField = driver.findElement(By.xpath("//input[@class=\"gsc-input\"]"));
        String searchText = "QA";
        String textSame = "тестировщик";
        searchField.sendKeys(searchText);
        searchField.sendKeys(Keys.ENTER);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        List<WebElement> searchResult = driver.findElements(By.xpath("//div[@class='gs-title']/a[@href]"));
        ArrayList<String> stResults = new ArrayList<>();

        for (WebElement element : searchResult) {
            stResults.add(element.getText());
        }

        for (String text: stResults) {
            Assert.assertTrue(text.contains(searchText) | text.contains(textSame));
        }
    }

    @DataProvider
    public Object [][] searchData() {
        return new Object[][]{
                {"qA"},
                {"йф"},
                {"Q A"},
        };
    }

    @Test(dataProvider = "searchData",groups= {"searchResult"})
    public void misprint(String searchText) {
        WebElement searchField = driver.findElement(By.xpath("//input[@class=\"gsc-input\"]"));
        searchField.sendKeys(searchText);
        searchField.sendKeys(Keys.ENTER);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        WebElement firstResult = driver.findElement(By.xpath("//a[@href=\"https://jobs.dou.ua/vacancies/?category=QA\"]"));
        String searchResult = firstResult.getText();
        String expectedTestResult = "QA";
        assertThat(searchResult, containsString(expectedTestResult));
    }

    @Test (groups= {"searchBy"})
    public void searchByEnter() {
        WebElement searchField = driver.findElement(By.xpath("//input[@class=\"gsc-input\"]"));
        String searchText = "QA";
        searchField.sendKeys(searchText);
        searchField.sendKeys(Keys.ENTER);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement resultBlock = driver.findElement(By.xpath("//*[@class=\"gsc-webResult gsc-result\"]"));

        Assert.assertTrue(resultBlock.isDisplayed());
    }

    @Test (groups= {"searchBy"})
    public void searchByButton() {
        WebElement searchField = driver.findElement(By.xpath("//input[@class=\"gsc-input\"]"));
        String searchText = "QA";
        searchField.sendKeys(searchText);
        WebElement searchButton = driver.findElement(By.xpath("//*[@class=\"gsc-search-button gsc-search-button-v2\"]"));
        searchButton.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement resultBlock = driver.findElement(By.xpath("//*[@class=\"gsc-webResult gsc-result\"]"));

        Assert.assertTrue(resultBlock.isDisplayed());
    }



    @Test (groups= {"searchWithoutResult"})
    public void negativeSearch() {
        WebElement searchField = driver.findElement(By.xpath("//input[@class=\"gsc-input\"]"));
        String searchText = "ацауыаыуапкв";
        searchField.sendKeys(searchText);
        WebElement searchButton = driver.findElement(By.xpath("//*[@class=\"gsc-search-button gsc-search-button-v2\"]"));
        searchButton.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        WebElement resultBlock = driver.findElement(By.xpath("//*[@class=\"gsc-webResult gsc-result\"]"));
        WebElement messageCorrect = driver.findElement(By.xpath("//*[@class=\"gs-snippet\"]"));

        Assert.assertTrue(!resultBlock.isDisplayed() | messageCorrect.isDisplayed());
    }
}
