package org.example.config;
import org.example.page.CloudCalculator.ComputeEngine;
import org.example.page.CloudCalculator.Summary;
import org.example.utils.TestListener;
import org.testng.Assert;
import org.testng.annotations.*;

@Listeners(TestListener.class)
public class TestCalculatorPage extends BrowserSetUP {
    private ComputeEngine cEngine;
    private Summary summary;

    @Test
    public void navigateToCreateComputeEngine()  {
        driver.get(TestDataReader.getProperty("url"));

        cEngine = new ComputeEngine(driver);
        summary = new Summary(driver);

        cEngine.searchText("Google Cloud Platform Pricing Calculator")
                .clickOnPricingCalcLink()
                .clickOnAddToEstimateBtn()
                .clickOnComputeEngine();

        cEngine.numberOfInstances("4")
                .selectDropdownSystem("Free: Debian, CentOS, CoreOS, Ubuntu or BYOL (Bring Your Own License)")
                .provisioningModel()
                .machineType("N1", "n1-standard-8")
                .addGpus("NVIDIA Tesla V100", "1")
                .shareEstimateBtn();

        String totalPrice = summary.verifyTotalPrice();
        Assert.assertFalse(totalPrice.isEmpty(), "Total price is not displayed or is empty.");

        summary.openEstSummary();

        Assert.assertTrue(summary.verifyEstSummary(3).contains("n1-standard-8, vCPUs: 8, RAM: 30 GB"));
        Assert.assertTrue(summary.verifyEstSummary(5).contains("NVIDIA V100"));
        Assert.assertTrue(summary.verifyEstSummary(6).contains("1"));
        Assert.assertTrue(summary.verifyEstSummary(7).contains("2x375 GB"));
        Assert.assertTrue(summary.verifyEstSummary(11).contains("Free: Debian, CentOS, CoreOS, Ubuntu or BYOL (Bring Your Own License)"));
        Assert.assertTrue(summary.verifyEstSummary(12).contains("Regular"));
        Assert.assertTrue(summary.verifyEstSummary(19).contains("1 year"));
    }
}

