package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Dropdown {
    private UIElement uiElement;
    private final UIElement select;
    private final UIElement dropdownWrapper;

    public Dropdown(WebDriver driver, String name){
        this.dropdownWrapper = new UIElement(driver, By.cssSelector("select[name=" + name + "] ~ div.chzn-container"));
        this.select = new UIElement(driver, By.cssSelector("select[name=" + name + "]"));
    }

    public void select(){
        dropdownWrapper.click();
    }

    public UIElement getFirstOption(){
        return dropdownWrapper.findUIElement(By.cssSelector("li"));
    }

    public boolean isOptionsVisible(){
        return dropdownWrapper.findUIElement(By.cssSelector("div.chzn-drop")).isDisplayed();
    }

    public void selectFirstOption(){
        getFirstOption().click();
    }

    public boolean firstOptionIsSelected(){
        UIElement selectOptionValue = select.findElement(By.cssSelector("[selected=\"selected\"]"));

        return selectOptionValue.getText().equals(getFirstOption().getText());
    }
}
