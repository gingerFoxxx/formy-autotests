package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SubmitPage {
    private WebDriver driver;

    private By alert = By.xpath("//div[@class='alert alert-success']");


    public SubmitPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getTextAlert(){
        return driver.findElement(alert).getText();
    }

}
