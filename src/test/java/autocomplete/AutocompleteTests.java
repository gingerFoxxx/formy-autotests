package autocomplete;

import base.BaseTest;
import com.google.common.base.Verify;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.awt.*;

import static org.testng.Assert.assertEquals;

public class AutocompleteTests extends BaseTest {
    @Test
    public void testAddressOptions() throws InterruptedException {
        var autocompletePage = homePage.clickAutocomplete();
        autocompletePage.fillAddressField("10 Cornerstone Squ");

        assertEquals(autocompletePage.getAddressFieldText(),"10 Cornerstone Square, Westford, Массачусетс, США","Incorrect text");
        assertEquals(autocompletePage.getStreetAddress2FieldText(),"Cornerstone Square","Incorrect text");
        assertEquals(autocompletePage.getCityFieldText(),"Westford","Incorrect text");
        assertEquals(autocompletePage.getStateFieldText(),"MA","Incorrect text");
        assertEquals(autocompletePage.getZipCodeFieldText(),"01886","Incorrect text");
        assertEquals(autocompletePage.getCountryFieldText(),"Соединенные Штаты Америки","Incorrect text");

        autocompletePage.goBackHomePage();

    }

}
