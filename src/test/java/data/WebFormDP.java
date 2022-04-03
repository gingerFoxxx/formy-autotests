package data;

import org.testng.annotations.DataProvider;

public class WebFormDP {
    @DataProvider(name="dataProvider")
        public static Object[][]  dataSet(){
            Object[][] data = new Object[1][4];

            data[0][0] = "Joe";          data[0][1] = "Smith";	       data[0][2] = "QA engineer";         data[0][3] = "01/01/2000";
            /*data[1][0] = "Татьяна";      data[1][1] = "Васильевна";	   data[1][2] = "Тестировщик";        data[1][3] = "12/04/2022";
            data[2][0] = "JebrailHouse"; data[2][1] = "EvernoteMouse"; data[2][2] = "VeluVelueVelueRouye"; data[2][3] = "10/10/2005";*/
            return data;
    }
}
