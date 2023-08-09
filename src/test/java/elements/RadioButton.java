package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class RadioButton {
    private UIElement uiElement;

    public RadioButton(UIElement uiElement) {
        this.uiElement = uiElement;
    }

    public String getName() {
        return this.uiElement.findElement(By.cssSelector("input")).getAttribute("name");
    }

    public String getValue() {
        return this.uiElement.findElement(By.cssSelector("input")).getAttribute("value");
    }

    public String getText() {
        return this.uiElement.findElement(By.cssSelector("strong")).getText();
    }

    public void select() {
        this.uiElement.click();
    }
}
