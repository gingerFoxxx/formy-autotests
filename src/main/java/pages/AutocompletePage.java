package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AutocompletePage {
    private WebDriver driver;
    private By addressField = By.id("autocomplete");
    private By streetAddressField = By.id("street_number");
    private By streetAddress2Field = By.id("route");
    private By cityField = By.id("locality");
    private By stateField = By.id("administrative_area_level_1");
    private By zipCodeField = By.id("postal_code");
    private By countryField = By.id("country");
    private By logo = By.id("logo");

    public AutocompletePage(WebDriver driver){
        this.driver = driver;
    }

    public void fillAddressField(String addressText) throws InterruptedException {
        WebElement address = driver.findElement(addressField);
        address.sendKeys(addressText);
        Thread.sleep(2000);
        address.sendKeys(Keys.ARROW_DOWN);
        Thread.sleep(2000);
        address.sendKeys(Keys.ENTER);
        Thread.sleep(2000);
        }
    public String getAddressFieldText(){
        return driver.findElement(addressField).getAttribute("value");
    }
    public String getStreetAddress2FieldText(){
        return driver.findElement(streetAddress2Field).getAttribute("value");
    }
    public String getCityFieldText(){
        return driver.findElement(cityField).getAttribute("value");
    }
    public String getStateFieldText(){
        return driver.findElement(stateField).getAttribute("value");
    }
    public String getZipCodeFieldText(){
        return driver.findElement(zipCodeField).getAttribute("value");
    }
    public String getCountryFieldText(){
        return driver.findElement(countryField).getAttribute("value");
    }

    public HomePage goBackHomePage(){
        driver.findElement(logo).click();
        return new HomePage(driver);
    }
}
