package org.example.page;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
    public class PricingCalculator extends AbstractClass
    {
        private final WebDriver driver;
        private final WebDriverWait wait;
        @FindBy(className = "YSM5S")
        private WebElement searchButton;
        @FindBy(className = "qdOxv-fmcmS-wGMbrd")
        private WebElement searchInput;
        @FindBy(css = ".PETVs-OWXEXe-UbuQg")
        private WebElement searchSubmitButton;
        @FindBy(xpath = "//a[@href='https://cloud.google.com/products/calculator']")
        private WebElement pricingCalculatorLink;
        @FindBy(xpath = "//button[@data-idom-class='xhASFc']")
        private WebElement addToEstimateButton;
        @FindBy(className = "aHij0b-aGsRMb")
        private WebElement computeEngineButton;
        @Override
        protected AbstractClass openPage() {

            return null;
        }
        public PricingCalculator(WebDriver driver){
            this.driver = driver;
            this.wait= new WebDriverWait(driver, Duration.ofSeconds(15));
            PageFactory.initElements(driver, this);
        }
        public void searchText(String text){
            searchButton.click();
            searchInput.sendKeys(text);
            searchSubmitButton.click();

            //Perform click action
            Actions actions = new Actions(driver);
            int xCoordinate = 100; // Example x-coordinate
            int yCoordinate = 200; // Example y-coordinate
            actions.moveByOffset(xCoordinate, yCoordinate).click().perform();
        }
        public void clickOnPricingCalcLink(){
            wait.until(ExpectedConditions.elementToBeClickable(pricingCalculatorLink)).click();
        }
        public void clickOnAddToEstamateBtn() throws InterruptedException {
            wait.until(ExpectedConditions.elementToBeClickable(addToEstimateButton)).click();
            Thread.sleep(2000);
        }
        public void clickOnComputeEngine(){
            wait.until(ExpectedConditions.elementToBeClickable(computeEngineButton)).click();
        }
    }
