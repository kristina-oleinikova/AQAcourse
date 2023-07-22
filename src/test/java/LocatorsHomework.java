import factory.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.configuration.ReadProperties;

import java.util.concurrent.TimeUnit;

public class LocatorsHomework {
    protected WebDriver driver;

    @BeforeMethod
    public void setUp(){
        BrowserFactory browserFactory = new BrowserFactory();
        driver = browserFactory.getDriver();
    }

    @AfterMethod
    public void tearDown (){
        driver.quit();
    }

    @Test
    public void BasicLocatorsHomework(){
        driver.get(ReadProperties.getUrl());

        //Login to Web-site

        driver.findElement(By.id("user-name")).sendKeys(ReadProperties.username());
        driver.findElement(By.name("password")).sendKeys(ReadProperties.password());
        driver.findElement(By.id("login-button")).click();

        //Verify that Twitter icon(hyperlink) is displayed at the left top corner of the Main page

        driver.findElement(By.tagName("li")).isDisplayed();
        driver.findElement(By.className("social_twitter")).isDisplayed();
        driver.findElement(By.linkText("Twitter")).isDisplayed();
        driver.findElement(By.partialLinkText("tter")).isDisplayed();
    }

    public void CssSelectorsHomework(){
        driver.get("https://www.saucedemo.com/inventory.html");

        // Поиск по id
        Assert.assertTrue(driver.findElement(By.cssSelector("#add-to-cart-sauce-labs-backpack")).isDisplayed());
        //   аналог
        Assert.assertTrue(driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).isDisplayed());

        // Поиск по class name
        Assert.assertTrue(driver.findElement(By.cssSelector(".footer")).isDisplayed());
        //   аналог
        Assert.assertTrue(driver.findElement(By.className("footer")).isDisplayed());

        // Поиск по нескольким значения в аттрибуте class
        Assert.assertTrue(driver.findElement(By.cssSelector(".shopping_cart_container.shopping_cart_container")).isDisplayed());

        // Поиск по tag name
        Assert.assertTrue(driver.findElement(By.cssSelector("ul")).isDisplayed());
        //   аналог
        Assert.assertTrue(driver.findElement(By.tagName("ul")).isDisplayed());

        // Поиск по tag и значению из аттрибута class
        Assert.assertTrue(driver.findElement(By.cssSelector("div.shopping_cart_container")).isDisplayed());

        // Поиск по id и значению из аттрибута class
        Assert.assertEquals(1, driver.findElements(By.cssSelector("#root .shopping_cart_container")).size());

        // Поиск всех элементов с тэгом meta или link
        Assert.assertEquals(10, driver.findElements(By.cssSelector("meta, link")).size());

        // Поиск всех элементов с тэгом footer у которых непосредственный родитель с тэгом div
        Assert.assertEquals(1, driver.findElements(By.cssSelector("div > footer")).size());

        // Поиск всех элементов с тэгом link которые идут сразу за элементом с тэго meta
        Assert.assertEquals(1, driver.findElements(By.cssSelector("meta + link")).size());

        // Поиск всех элементов с тэгом link которые являются братьями элементу с тэгом meta
        Assert.assertEquals(4, driver.findElements(By.cssSelector("link ~ meta")).size());

        // Поиск всех элементов у которых присутствует аттрибут title
        Assert.assertEquals(0, driver.findElements(By.cssSelector("[title]")).size());

        // Поиск всех элементов у которых присутствует аттрибут style с конкретным значением
        Assert.assertEquals(1, driver.findElements(By.cssSelector("[style = \"z-index: 1000;\"]")).size());

        // Поиск всех элементов у которых присутствует аттрибут id со значением заканчивающимся на какое-то value
        Assert.assertEquals(7, driver.findElements(By.cssSelector("[id$='er']")).size());

        // Поиск всех элементов у которых присутствует аттрибут id со значением начинающимся на какое-то value
        Assert.assertEquals(1, driver.findElements(By.cssSelector("[id^='con']")).size());

        // Поиск всех элементов у которых присутствует аттрибут id со значением начинающимся на какое-то слово
        Assert.assertEquals(0, driver.findElements(By.cssSelector("[id |=page]")).size());

        // Поиск всех элементов у которых присутствует аттрибут title со значением содержащим слово целиком
        Assert.assertEquals(0, driver.findElements(By.cssSelector("[title~=Swag]")).size());

        // Поиск всех элементов у которых присутствует аттрибут title со значением содержащим какой текст
        Assert.assertEquals(0, driver.findElements(By.cssSelector("[title*='Swag Labs']")).size());

        // Поиск всех disabled элементов
        Assert.assertEquals(0, driver.findElements(By.cssSelector(":disabled")).size());

        // Поиск всех enabled элементов
        Assert.assertEquals(13, driver.findElements(By.cssSelector(":enabled")).size());
        // Additional example
        Assert.assertEquals(1, driver.findElements(By.cssSelector("select.product_sort_container:enabled")).size());

        // Поиск всех выборанных элементов
        Assert.assertEquals(1, driver.findElements(By.cssSelector(":checked")).size());

        // Поиск всех элементов c пустым телом
        Assert.assertEquals(21, driver.findElements(By.cssSelector(":empty")).size());

        // Поиск элемента с тэгом p и которым является первым дочерним элементом
        Assert.assertEquals(1, driver.findElements(By.cssSelector("meta:first-child")).size());

        // Поиск элемента с тэгом p и которым является последним дочерним элементом
        Assert.assertEquals(1, driver.findElements(By.cssSelector("link:last-child")).size());

        // Поиск элемента с тэгом p и которым является n-ым дочерним элементом
        Assert.assertEquals(1, driver.findElements(By.cssSelector("option:nth-child(2)")).size());
    }

    @Test
    public void basicXpathLocatorsHomework(){
        driver.get("https://www.saucedemo.com/inventory.html");

        // Аналог поиска по tagName
        Assert.assertTrue(driver.findElement(By.xpath("//ul")).isDisplayed());

        // Аналог родительского footer и на один уровень ниже ul
        Assert.assertTrue(driver.findElement(By.xpath("//footer//ul")).isDisplayed());

        // Аналог родительского footer и на любом уровене ниже div
        Assert.assertTrue(driver.findElement(By.xpath("//footer//div")).isDisplayed());

        // Поиск элемента с тэгом div у которого есть аьттрибут id
        Assert.assertTrue(driver.findElement(By.xpath("//div[@id]''")).isDisplayed());

        // Поиск элемента у которого есть аттрибут id cо значением shopping_cart_container
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id='shopping_cart_container']")).isDisplayed());

        // Поиск элемента у которого есть аттрибут target cо значением и aттрибут rel со значением
        Assert.assertTrue(driver.findElement(By.xpath("//*[@target='_blank' and @rel='noreferrer']")).isDisplayed());

        // Поиск элемента у которого значение аттрибута начинается  c 'shop'
        Assert.assertTrue(driver.findElement(By.xpath("//*[starts-with(@id, 'shop')]")).isDisplayed());

        // Поиск элемента у которого значение аттрибута содержит подстроку 'secondary_container'
        Assert.assertTrue(driver.findElement(By.xpath("//*[contains(@class, 'secondary_container')]()")).isDisplayed());

        // Поиск элемента у которого текстовое значение содержит равно
        Assert.assertTrue(driver.findElement(By.xpath("//div[text() = 'Swag Labs']")).isDisplayed());
//        Assert.assertTrue(driver.findElement(By.xpath("//*[. = 'Todos']")).isDisplayed());
//
        // Поиск элемента у которого текстовое значение содержит подстроку 'Swag Labs'
        Assert.assertTrue(driver.findElement(By.xpath("//*[contains(text(), 'Swag Labs')]")).isDisplayed());

        // Поиск элемента по индексу
        Assert.assertTrue(driver.findElement(By.xpath("//div[@class='inventory_item']/div[1]")).isDisplayed());
    }

    @Test
    public void axesXPathHomework() {
        driver.get("https://www.saucedemo.com/inventory.html");

        // Поиск родителя у элемента с тэгом h1
        Assert.assertTrue(driver.findElement(By.xpath("//div/..")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//parent::div")).isDisplayed());

        // Поиск всех предков с тэгом div у элемента с тэгом span
        Assert.assertTrue(driver.findElement(By.xpath("//span/ancestor::div")).isDisplayed());

        // Использование child - все дочерние элементы с тэго button от div
        Assert.assertTrue(driver.findElement(By.xpath("//div/child::button")).isDisplayed());

        // Использование child - все дочерние элементы с тэгом button[] от div
        Assert.assertTrue(driver.findElement(By.xpath("//div/descendant::button")).isDisplayed());

        //Использование following - Выбирает всё в документе после закрытия тэга текущего узла
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id='shopping_cart_container']/following::span")).isDisplayed());

        //Использование following-sibling - Выбирает все узлы одного уровня после текущего узла
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id='menu_button_container']/following-sibling::div")).isDisplayed());

        //Использование preceding- Выбирает все узлы, которые появляются перед текущим узлом в документе
        //Assert.assertTrue(driver.findElement(By.xpath("//*[@class=\"dialog-title\"]/preceding::form")).isDisplayed());

        //Использование preceding-sibling - Выбирает все узлы одного уровня до текущего узла
        //Assert.assertTrue(driver.findElement(By.xpath("//*[@class='dialog-title']/preceding-sibling::form")).isDisplayed());
    }
}
