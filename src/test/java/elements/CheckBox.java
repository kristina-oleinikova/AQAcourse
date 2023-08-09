package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckBox {
    private UIElement uiElement;

    public CheckBox(WebDriver driver, By by){
        this.uiElement = new UIElement(driver, by);
    }

    public CheckBox(WebDriver driver, WebElement webElement){
        this.uiElement = new UIElement(driver, webElement);
    }

    public void setFlag(){
        if(!uiElement.isSelected()){
            uiElement.click();
        }
    }

    public void removeFlag(){
        if(uiElement.isSelected()){
            uiElement.click();
        }
    }
}
