package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class CompleteWebFormPage {
    private WebDriver driver;

    private By firstNameField = By.id("first-name");
    private By lastNameField = By.id("last-name");
    private By jobTitleField = By.id("job-title");
    private By highSchoolRadioBtn = By.id("radio-button-1");
    private By femaleCheckbox = By.id("checkbox-2");
    private By yearsDropdown = By.id("select-menu");
    private By dateField = By.id("datepicker");
    private By submitBtn = By.cssSelector("a.btn.btn-lg.btn-primary");

    public CompleteWebFormPage(WebDriver driver) {
        this.driver = driver;
    }

    public void setTextFields(String firstName, String lastName, String jobTitle, String date){
        driver.findElement(firstNameField).sendKeys(firstName);
        driver.findElement(lastNameField).sendKeys(lastName);
        driver.findElement(jobTitleField).sendKeys(jobTitle);
        driver.findElement(dateField).sendKeys(date);
    }

    public boolean isRadioBtnSelected(){
        return driver.findElement(highSchoolRadioBtn).isSelected();
    }
    public void setRadioBtn(){
        if(!isRadioBtnSelected()){
        driver.findElement(highSchoolRadioBtn).click();
        }
    }
    public boolean isCheckboxSelected(){
        return driver.findElement(femaleCheckbox).isSelected();
    }
    public void setCheckbox(){
        if(!isCheckboxSelected()){
            driver.findElement(femaleCheckbox).click();
        }
    }

    public void setDropdown(String option){
        Select dropdownElement = new Select(driver.findElement(yearsDropdown));
        dropdownElement.selectByVisibleText(option);
    }

    public SubmitPage clickSubmitBtn(){
        driver.findElement(submitBtn).click();
        return new SubmitPage(driver);
    }
}
