package org.example.page;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
public class ComputeEngine extends AbstractClass {
    private final WebDriverWait wait;
    public ComputeEngine(WebDriver driver) {
        super(driver);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(openPage().WAIT_TIMEOUT_SECONDS));
    }
    @Override
    protected AbstractClass openPage() {
        driver.get("https://cloud.google.com/products/calculator");
        return this; // Create a new instance of ComputeEngine
    }
    public void numberOfInstances(){
        WebElement el = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".QiFlid > .BfUoNb > div:nth-child(3) .wX4xVc-Bz112c-RLmnJb")));
        for(int i=0; i<3; i++){
            el.click();
        }
    }
    public void selectDropdownSystem()
    {
        driver.findElement(By.xpath("//div[@id='ucj-1']/div/div/div/div/div/div/div/div/div/div[2]/div[3]/div[7]/div/div/div/div/div/div/div")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='ucj-1']/div/div/div/div/div/div/div/div/div/div[2]/div[3]/div[7]/div/div/div/div/div/div[2]/ul/li[1]"))).click();
    }
    public void provisioningModel(){
        driver.findElement(By.xpath("//div[@id='ucj-1']/div/div/div/div/div/div/div/div/div/div[2]/div[3]/div[9]/div/div/div[2]/div/div/div/label")).click();
    }
    public void machineType(){
        WebElement mFamily = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='ucj-1']/div/div/div/div/div/div/div/div/div/div[2]/div[3]/div[11]/div/div/div[2]/div/div/div/div/div/div/div/div")));
        mFamily.click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='ucj-1']/div/div/div/div/div/div/div/div/div/div[2]/div[3]/div[11]/div/div/div[2]/div/div/div/div/div/div/div[2]/ul/li[1]"))).click();

        WebElement mSeries = driver.findElement(By.xpath("//div[@id='ucj-1']/div/div/div/div/div/div/div/div/div/div[2]/div[3]/div[11]/div/div/div[2]/div/div/div[2]/div/div/div/div/div"));
        mSeries.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='ucj-1']/div/div/div/div/div/div/div/div/div/div[2]/div[3]/div[11]/div/div/div[2]/div/div/div[2]/div/div/div/div[2]/ul/li[1]"))).click();

        WebElement mType = driver.findElement(By.xpath("//div[@id='ucj-1']/div/div/div/div/div/div/div/div/div/div[2]/div[3]/div[11]/div/div/div[2]/div/div/div[3]/div/div/div/div/div"));
        mType.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='ucj-1']/div/div/div/div/div/div/div/div/div/div[2]/div[3]/div[11]/div/div/div[2]/div/div/div[3]/div/div/div/div[2]/ul/li[7]"))).click();
    }
    public void addGpus(){
        WebElement gpuBtn = driver.findElement(By.xpath("(//button[@class='eBlXUe-scr2fc eBlXUe-scr2fc-OWXEXe-uqeOfd']//span[@class='eBlXUe-hywKDc'])[position() = 5]\n"));
        gpuBtn.click();

        WebElement gpuType = driver.findElement(By.xpath("(//div[@jsname='oYxtQd']//div[@class='VfPpkd-aPP78e'])[position()=8]"));
        gpuType.click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@jsname='xl07Ob']/ul[@jsname='rymPhb']/li[3])[position()=8]"))).click();

        WebElement gpuNumber = driver.findElement(By.xpath("//div[@id='ucj-1']/div/div/div/div/div/div/div/div/div/div[2]/div[3]/div[24]/div/div/div/div/div/div/div"));
        gpuNumber.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='ucj-1']/div/div/div/div/div/div/div/div/div/div[2]/div[3]/div[24]/div/div/div/div/div/div[2]/ul/li"))).click();

        WebElement ssd = driver.findElement(By.xpath("(//div[@jsname='oYxtQd']/div[@class='VfPpkd-aPP78e'])[position()=10]"));
        ssd.click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@jsname='xl07Ob']/ul[@jsname='rymPhb']/li[3]//span[@class='VfPpkd-rymPhb-Gtdoyb'])[position()=10]"))).click();

        WebElement region = driver.findElement(By.xpath("//div[@id='ucj-1']/div/div/div/div/div/div/div/div/div/div[2]/div[3]/div[29]/div/div/div/div/div/div/div"));
        region.click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@jsname='xl07Ob']/ul[@jsname='rymPhb']/li[12])[position()=2]"))).click();

        WebElement usage = driver.findElement(By.xpath("//div[@id='ucj-1']/div/div/div/div/div/div/div/div/div/div[2]/div[3]/div[31]/div/div/div[2]/div/div/div[2]/label"));
        usage.click();
    }
    public void shareEstimateBtn(){
        JavascriptExecutor js = (JavascriptExecutor) driver;

        // Scroll down the page by a specific pixel value (e.g., 500 pixels)
        js.executeScript("window.scrollBy(0, 900)");
        driver.findElement(By.xpath("(//div[@class='VfPpkd-dgl2Hf-ppHlrf-sM5MNb']/button)[position()=3]")).click();
    }
}
