package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Set;

interface WebDriverExtended extends WebDriver {
    void hello();
}

public class WebDriverDecorator implements WebDriverExtended {
    private WebDriver webDriverThatWillBeExtended;

    public WebDriverDecorator(WebDriver webDriver) {
        this.webDriverThatWillBeExtended = webDriver;
    }


    @Override
    public void hello() {
        System.out.println("HIIII!");
    }

    @Override
    public void get(String url) {
        this.webDriverThatWillBeExtended.get(url);
    }

    @Override
    public String getCurrentUrl() {
        return this.webDriverThatWillBeExtended.getCurrentUrl();
    }

    @Override
    public String getTitle() {
        return this.webDriverThatWillBeExtended.getTitle();
    }

    @Override
    public List<WebElement> findElements(By by) {
        return this.webDriverThatWillBeExtended.findElements(by);
    }

    @Override
    public WebElement findElement(By by) {
        return this.webDriverThatWillBeExtended.findElement(by);
    }

    @Override
    public String getPageSource() {
        return this.webDriverThatWillBeExtended.getPageSource();
    }

    @Override
    public void close() {
        this.webDriverThatWillBeExtended.close();
    }

    @Override
    public void quit() {
        this.webDriverThatWillBeExtended.quit();
    }

    @Override
    public Set<String> getWindowHandles() {
        return this.webDriverThatWillBeExtended.getWindowHandles();
    }

    @Override
    public String getWindowHandle() {
        return this.webDriverThatWillBeExtended.getWindowHandle();
    }

    @Override
    public TargetLocator switchTo() {
        return this.webDriverThatWillBeExtended.switchTo();
    }

    @Override
    public Navigation navigate() {
        return this.webDriverThatWillBeExtended.navigate();
    }

    @Override
    public Options manage() {
        return this.webDriverThatWillBeExtended.manage();
    }
}
