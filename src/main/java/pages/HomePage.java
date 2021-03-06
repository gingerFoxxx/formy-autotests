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
    // Go to DatePicker link
    public DatePickerPage clickDatepicker(){
        clickLink("Datepicker");
        return new DatePickerPage(driver);
    }
    // Go to Complete Web Form link
    public CompleteWebFormPage clickCompleteWebForm(){
        clickLink("Complete Web Form");
        return new CompleteWebFormPage(driver);
    }
}
