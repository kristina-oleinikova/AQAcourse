package baseEntities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.configuration.ReadProperties;

public abstract class BasePage {
    private static final int WAIT_FOR_PAGE_LOADED_IN_SECONDS = 30;
    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;

        waitForOpen();
    }


    public void openPageByUrl(String pagePath) {
        driver.get(ReadProperties.getUrl() + pagePath);
    }

    protected abstract By getPageIdentifier();

    public boolean isPageOpened() {
        try{
        return driver.findElement(getPageIdentifier()).isDisplayed();
    } catch (Exception ex){
        return false;
        }
    }

    protected void waitForOpen() throws InterruptedException {
        int tryCount=0;
        boolean isPageOpenedIndicator = isPageOpened();

        while(!isPageOpenedIndicator && tryCount< WAIT_FOR_PAGE_LOADED_IN_SECONDS){
            Thread.sleep(1000);
            tryCount++;
            isPageOpenedIndicator = isPageOpened();
        }

        if (!isPageOpenedIndicator){
            throw new AssertionError("Page was not loaded");
        }
    }
}
