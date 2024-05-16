package org.example.page;

import org.openqa.selenium.WebDriver;

public abstract class AbstractClass {
    protected WebDriver driver;
    protected abstract AbstractClass openPage();
    protected final int WAIT_TIMEOUT_SECONDS=15;
    protected AbstractClass(WebDriver driver){
        this.driver = driver;
    }
    protected AbstractClass(){};
}
