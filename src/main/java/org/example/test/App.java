package org.example.test;
import com.beust.jcommander.Parameter;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.example.driver.TestDataReader;
import org.example.page.AbstractClass;
import org.example.page.ComputeEngine;
import org.example.page.PricingCalculator;
import org.example.page.Summary;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

@Listeners(TestListener.class)
public class App extends AbstractClass
{   private SoftAssert softAssert;
    private WebDriver driver;
    private final String LINK = "https://cloud.google.com/";
    private PricingCalculator pCalc;
    private ComputeEngine cEngine;
    private Summary summary;
    private String browserName;
    public App(){
        super(null);
    }
    @BeforeClass
    @Parameters({"browser"})
    public void setup(String browser){
        softAssert = new SoftAssert();
        browserName = TestDataReader.getProperty("browser.name");
        if(browserName.equalsIgnoreCase("edge")){
        WebDriverManager.edgedriver().setup();
        EdgeOptions options = new EdgeOptions();
            if (TestDataReader.shouldMaximizeBrowser()) {
                options.addArguments("--start-maximized");
            }
        driver = new EdgeDriver(options);}
        else if (browserName.equalsIgnoreCase("chrome")) {
            // Initialize ChromeDriver
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            if(TestDataReader.shouldMaximizeBrowser()) {
                options.addArguments("--start-maximized");
            }
            driver = new ChromeDriver(options);
        }

        pCalc = new PricingCalculator(driver);
        cEngine = new ComputeEngine(driver);
        summary = new Summary(driver);

        // Set WebDriver for TestListener
        TestListener listener = new TestListener();
        listener.setDriver(driver);

    }
    @Override
    protected AbstractClass openPage() {
        driver.get(LINK);
        return this;
    }
    @Test
    public void navigateToCreateComputeEngine() throws InterruptedException {
        openPage();

// Form data has different fields and there is no possibility to fulfill the exercise
        pCalc.searchText("Google Cloud Platform Pricing Calculator");
        pCalc.clickOnPricingCalcLink();
        pCalc.clickOnAddToEstamateBtn();
        pCalc.clickOnComputeEngine();
        cEngine.numberOfInstances();
        cEngine.selectDropdownSystem();
        cEngine.provisioningModel();
        cEngine.machineType();
        cEngine.addGpus();
        cEngine.shareEstimateBtn();
        summary.openEstSummary();

        softAssert.assertTrue(summary.verifyEstSummary(3).contains("n1-standard-8, vCPUs: 8, RAM: 30 GB"));
        softAssert.assertTrue(summary.verifyEstSummary(5).contains("NVIDIA Tesla V100"));
        softAssert.assertTrue(summary.verifyEstSummary(6).contains("1"));
        softAssert.assertTrue(summary.verifyEstSummary(7).contains("2x375 GB"));
        softAssert.assertTrue(summary.verifyEstSummary(11).contains("Free: Debian, CentOS, CoreOS, Ubuntu or BYOL (Bring Your Own License)"));
        softAssert.assertTrue(summary.verifyEstSummary(12).contains("Regular"));
        softAssert.assertTrue(summary.verifyEstSummary(18).contains("Frankfurt (europe-west3)"));
    }
    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
        softAssert.assertAll();
    }
}
