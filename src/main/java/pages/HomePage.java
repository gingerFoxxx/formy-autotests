package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private WebDriver driver;


    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    public void clickLink(String linkText){
        driver.findElement(By.linkText(linkText)).click();
    }
    // Go to Autocomplete link
    public AutocompletePage clickAutocomplete(){
        clickLink("Autocomplete");
        return new AutocompletePage(driver);
    }
}
