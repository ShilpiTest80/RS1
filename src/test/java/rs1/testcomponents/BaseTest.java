package rs1.testcomponents;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import rs1.pageobjects.LandingPage;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class BaseTest {

    public WebDriver driver;
    public WebDriver initializeDriver() throws IOException {


        //properties class
        Properties properties = new Properties();
        FileInputStream fileInputStream = new FileInputStream("src/main/java/rs1/resources/GlobalData.properties");
        properties.load(fileInputStream);
        String browserName = properties.getProperty("BROWSER");

        if(browserName.equalsIgnoreCase("firefox")){
            WebDriverManager.firefoxdriver().create();
            driver = new FirefoxDriver();

        } else if (browserName.equalsIgnoreCase("edge")) {
            WebDriverManager.edgedriver().create();
            driver = new EdgeDriver();

        }else if (browserName.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().create();
            driver = new ChromeDriver();
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        return driver;
    }

    public LandingPage launchApplication() throws IOException {
        driver = initializeDriver();
        LandingPage landingPage = new LandingPage(driver);
        landingPage.goTo();
        return landingPage;
    }
}
