package data;

import org.testng.annotations.DataProvider;

public class WebFormDP {
    @DataProvider(name="dataProvider")
        public static Object[][]  dataSet(){
            Object[][] data = new Object[14][4];
            //VALID DATA
            data[0][0] = "Joe";          data[0][1] = "Smith";       data[0][2] = "QA engineer";        data[0][3] = "01/01/2000";
            data[1][0] = " ";            data[1][1] = " ";	         data[1][2] = " ";                  data[1][3] = "31/12/2001";
            data[2][0] = "Samuel Leroy"; data[2][1] = "Jackson";     data[2][2] = "Actor";              data[2][3] = "02/02/2003";
            data[3][0] = "Lee";          data[3][1] = "Van";         data[3][2] = "Software Developer"; data[3][3] = "30/11/2005";
            data[4][0] = "Ann";          data[4][1] = "Jane";        data[4][2] = "-";                  data[4][3] = "01/01/1000";
            data[5][0] = "-";            data[5][1] = "-";           data[5][2] = "-";                  data[5][3] = "01/01/2657";
            data[6][0] = "<div>";        data[6][1] = "</div>";      data[6][2] = "-";                  data[6][3] = "10/05/2023";
            data[7][0] = "123";          data[7][1] = "0";           data[7][2] = "-";                  data[7][3] = "15/07/2022";

            //INVALID DATA
            data[8][0] = "Billy";        data[8][1] = "King";        data[8][2] = "none";               data[8][3] = "00/01/2007";
            data[9][0] = "Name";         data[9][1] = "Surname";     data[9][2] = "none";               data[9][3] = "32/12/2009";
            data[10][0] = "Stan";        data[10][1] = "Smith";      data[10][2] = "none";              data[10][3] = "01/00/2011";
            data[11][0] = "Chris";       data[11][1] = "Lee";        data[11][2] = "none";              data[11][3] = "31/13/2013";
            data[12][0] = "Maria";       data[12][1] = "Kurmachova"; data[12][2] = "none";              data[12][3] = "01/01/0000";
            data[13][0] = "Mike";        data[13][1] = "Town";       data[13][2] = "none";              data[13][3] = "01/01/201";

            return data;
    }
}
