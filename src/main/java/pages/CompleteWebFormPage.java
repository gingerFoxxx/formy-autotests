package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class CompleteWebFormPage {
    private WebDriver driver;
    //---TEXT FIELDS:
    private By firstNameField = By.id("first-name");
    private By lastNameField = By.id("last-name");
    private By jobTitleField = By.id("job-title");
    //---

    //---RADIO BUTTONS (Highest level of education):
    private By highSchoolRadioBtn = By.id("radio-button-1");
    private By collegeRadioBth = By.id("radio-button-2");
    private By gradSchoolRadioBth = By.id("radio-button-1");
    //---

    //---CHECKBOXES (Sex):
    private By maleCheckbox = By.id("checkbox-1");
    private By femaleCheckbox = By.id("checkbox-2");
    private By notToSayCheckbox = By.id("checkbox-3");
    //---

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
        driver.findElement(dateField).sendKeys(date + Keys.ENTER);
    }
    //---RADIO BUTTON METHODS:
    public boolean isRadioBtn1Selected(){
        return driver.findElement(highSchoolRadioBtn).isSelected();
    }
    public void setRadioBtn1(){
        if(!isRadioBtn1Selected()){
            driver.findElement(highSchoolRadioBtn).click();
        }
    }
    public boolean isRadioBtn2Selected(){
        return driver.findElement(collegeRadioBth).isSelected();
    }
    public void setRadioBtn2(){
        if(!isRadioBtn2Selected()){
            driver.findElement(collegeRadioBth).click();
        }
    }
    public boolean isRadioBtn3Selected(){
        return driver.findElement(gradSchoolRadioBth).isSelected();
    }
    public void setRadioBtn3(){
        if(!isRadioBtn3Selected()){
            driver.findElement(gradSchoolRadioBth).click();
        }
    }
    //---

    //---CHECKBOX METHODS:
    public boolean isCheckbox1Selected(){
        return driver.findElement(maleCheckbox).isSelected();
    }
    public void setCheckbox1(){
        if(!isCheckbox1Selected()){
            driver.findElement(maleCheckbox).click();
        }
    }

    public boolean isCheckbox2Selected(){
        return driver.findElement(femaleCheckbox).isSelected();
    }
    public void setCheckbox2(){
        if(!isCheckbox2Selected()){
            driver.findElement(femaleCheckbox).click();
        }
    }

    public boolean isCheckbox3Selected(){
        return driver.findElement(notToSayCheckbox).isSelected();
    }
    public void setCheckbox3(){
        if(!isCheckbox3Selected()){
            driver.findElement(notToSayCheckbox).click();
        }
    }
    //---

    public void setDropdown(String option){
        Select dropdownElement = new Select(driver.findElement(yearsDropdown));
        dropdownElement.selectByVisibleText(option);
    }

    public SubmitPage clickSubmitBtn(){
        driver.findElement(submitBtn).click();
        return new SubmitPage(driver);
    }

    //ASSERTIONS:
    public boolean isRB1Checked(){
        return driver.findElement(highSchoolRadioBtn).isSelected();
    }
    public boolean isRB2Checked(){
        return driver.findElement(collegeRadioBth).isSelected();
    }
    public boolean isRB3Checked(){
        return driver.findElement(gradSchoolRadioBth).isSelected();
    }
    public boolean isCB1Enabled(){
        return driver.findElement(maleCheckbox).isEnabled();
    }
    public boolean isCB2Enabled(){
        return driver.findElement(femaleCheckbox).isEnabled();
    }
    public boolean isCB3Enabled(){
        return driver.findElement(notToSayCheckbox).isEnabled();
    }

}
