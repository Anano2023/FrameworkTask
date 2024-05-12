package org.example.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Summary extends AbstractClass{
    private final WebDriver driver;

    @Override
    protected AbstractClass openPage() {
        return null;
    }

    public Summary(WebDriver driver){
        this.driver=driver;

    }
    public void openEstSummary(){
        driver.findElement(By.xpath("(//a[@href='./products/calculator/estimate-preview/2f0eeb88-8672-4b75-a989-3c17bbfbd408'])[position()=2]")).click();
    }
    public String verifyEstSummary(int position){
        String xpath= String.format("(//span[@class='Kfvdz'])[position()=%d]", position);
        return driver.findElement(By.xpath(xpath)).getText();

    }
}
