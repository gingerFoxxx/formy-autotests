package formcomplete;

import base.BaseTest;
import data.WebFormDP;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CompleteWebFormPage;
import pages.SubmitPage;
import static org.testng.Assert.assertTrue;

public class CompleteWebFormTests extends BaseTest {
    private CompleteWebFormPage completeWebFormPage;

    @Epic(value = "Проверка модуля")
    @Test (dataProviderClass = WebFormDP.class, dataProvider = "dataProvider")
    @Feature("Заполнение полей формы")
    @Description(value = "Описание тестов")

    public void correctData(String firstName, String lastName, String jobTitle, String date){
        completeWebFormPage = homePage.clickCompleteWebForm();

        completeWebFormPage.setTextFields(firstName, lastName, jobTitle, date);
        completeWebFormPage.setRadioBtn1();
        completeWebFormPage.setRadioBtn2();
        completeWebFormPage.setRadioBtn3();
        completeWebFormPage.setCheckbox1();
        completeWebFormPage.setCheckbox2();
        completeWebFormPage.setCheckbox3();
        completeWebFormPage.setDropdown("0-1");
        completeWebFormPage.clickSubmitBtn();

        assertTrue(completeWebFormPage.isRB1Checked());
        assertTrue(completeWebFormPage.isRB2Checked());
        assertTrue(completeWebFormPage.isRB3Checked());

        assertTrue(completeWebFormPage.isCB1Enabled());
        assertTrue(completeWebFormPage.isCB2Enabled());
        assertTrue(completeWebFormPage.isCB3Enabled());

        //SubmitPage submitPage = completeWebFormPage.clickSubmitBtn();
        //Assert.assertEquals(submitPage.getTextAlert(),"The form was successfully submitted!","Incorrect");
    }

}
