package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoUnit;

import static java.lang.String.format;

public class DatePickerPage {
    private WebDriver driver;

    private By openCalendar = By.id("datepicker");
    private By period = By.cssSelector("div.datepicker-days th.datepicker-switch");
    private By leftArrow = By.cssSelector("div.datepicker-days th.prev");
    private By rightArrow = By.cssSelector("div.datepicker-days th.next");
    private String day_FORMAT = "//td[contains(text(), '%d') and not(contains(@class, 'old')) and not(contains(@class, 'new'))]";//to select day from current month, w/o old and new days

    public DatePickerPage(WebDriver driver){
        this.driver = driver;
    }

    //OPEN DATE COMPONENT
    public void open(){
            driver.findElement(openCalendar).click();
    }

    //Get the current period (March 2021). Split it on 'March' and '2021'. And return LocalDate as (year:2021, month:MARCH, day:1)
    public LocalDate getCurrentPeriod(){
        var currentPeriod = driver.findElement(period).getText().split(" ");
        return LocalDate.of(
                Integer.parseInt(currentPeriod[1]), //'2021' convert from String to int
                Month.valueOf(currentPeriod[0].toUpperCase()),
                1);
    }

    //COMPARE CURRENT DATE WITH DESTINATION DATE.
    public void chooseMonth(LocalDate date) {
        var currentPeriod = getCurrentPeriod();
        long monthsAway = ChronoUnit.MONTHS.between(currentPeriod, date.withDayOfMonth(1));
        // if currentPeriod='2021/05/01', and date='2021/05/01' = 0 monthsAway
        // if currentPeriod='2021/05/01', and date='2021/04/01' = -1 monthsAway (past)
        // if currentPeriod='2021/05/01', and date='2021/07/01' = +2 monthsAway (future)

        // DETERMINE IF WE NEED TO GO TO A PAST, FUTURE, OR CURRENT MONTH
        By arrow = monthsAway < 0 ? leftArrow : rightArrow;
        for(int i = 0; i < Math.abs(monthsAway); i++){ // .abs gives the absolute value ( set value w/o - or +)
            driver.findElement(arrow).click(); //0 < 1, 1 times click  to arrow-left
        }
    }

    // CHOOSE DAY OF MONTH ON THE CALENDAR
    public void chooseDay(int dayOfMonth) {
        By locator = By.xpath(format(day_FORMAT, dayOfMonth));
        driver.findElement(locator).click();
    }

    //METHOD TO CHOOSE DATE
    public LocalDate chooseDate(LocalDate date){
        open();
        chooseMonth(date);
        chooseDay(date.getDayOfMonth());
        return getSelectedDate();
    }

    // RETURN SELECTED DATE BACK TO THE TEST (YEAR, MONTH, DAY)
    public LocalDate getSelectedDate(){
        var fields = driver.findElement(openCalendar).getAttribute("value").split("/");
        return LocalDate.of(
                Integer.parseInt(fields[2]),
                Integer.parseInt(fields[0]),
                Integer.parseInt(fields[1]));
    }

    }
