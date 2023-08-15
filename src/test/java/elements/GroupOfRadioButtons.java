package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class GroupOfRadioButtons {
    private final List<OptionRadioButton> radioButtons = new ArrayList<>();

    public GroupOfRadioButtons(WebDriver driver, String name) {
        for (WebElement val : driver.findElements(By.cssSelector("div.radio"))) {
            OptionRadioButton radioButton = new OptionRadioButton(new UIElement(driver, val));

            if (radioButton.getName().equals(name)) {
                this.radioButtons.add(radioButton);
            }
        }
    }

    public void selectByIndex(int index) {
        this.radioButtons.get(index).select();
    }

    public void selectByValue(String value) {
        for (OptionRadioButton radioButton : this.radioButtons) {
            if (radioButton.getValue().equals(value)) {
                radioButton.select();
            }
        }
    }

    public void selectByText(String text) {
        for (OptionRadioButton radioButton : this.radioButtons) {
            if (radioButton.getText().equals(text)) {
                radioButton.select();
            }
        }
    }
}
