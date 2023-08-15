package elements;

import org.openqa.selenium.By;

public class OptionRadioButton {
    private UIElement uiElement;

    public OptionRadioButton(UIElement uiElement) {
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
