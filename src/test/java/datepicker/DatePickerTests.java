package datepicker;

import base.BaseTest;
import pages.DatePickerPage;
import org.testng.annotations.Test;

import java.time.LocalDate;
import java.time.Month;

import static org.testng.Assert.assertEquals;

public class DatePickerTests extends BaseTest {
    private DatePickerPage datePickerPage;


    @Test
    public void pastDate(){
        datePickerPage = homePage.clickDatepicker();
        var dateToSelect = LocalDate.of(1989, Month.DECEMBER, 30);
        var selectedDate = datePickerPage.chooseDate(dateToSelect);
        assertEquals(dateToSelect, selectedDate);
    }

    @Test
    public void trickyDate(){
        datePickerPage = homePage.clickDatepicker();
        var dateToSelect = LocalDate.of(2020, Month.MARCH, 31);
        var selectedDate = datePickerPage.chooseDate(dateToSelect);
        assertEquals(dateToSelect, selectedDate);
    }

    @Test
    public void futureDate(){
        datePickerPage = homePage.clickDatepicker();
        var dateToSelect = LocalDate.now().plusDays(5);
        var selectedDate = datePickerPage.chooseDate(dateToSelect);
        assertEquals(dateToSelect, selectedDate);
    }

    @Test
    public void currentMonth(){
        datePickerPage = homePage.clickDatepicker();
        var dateToSelect = LocalDate.now().withDayOfMonth(15);
        var selectedDate = datePickerPage.chooseDate(dateToSelect);
        assertEquals(dateToSelect, selectedDate);
    }
}
