package base.dataProvider;

import org.testng.annotations.DataProvider;

public class CheckOutData {
    @DataProvider(name = "PurchaseData")
    public Object[][] checkOutData(){
        Object[][] data = new Object[13][4];

        data[0][0] = "First name";        data[0][1] = "Last name";        data[0][2] = 1234;           data[0][3] = "";        //Happy path
        data[1][0] = "";                  data[1][1] = "Last name";        data[1][2] = 1234;           data[1][3] = "Error: First Name is required";        //First name is blank
        data[2][0] = "First name";        data[2][1] = "";                 data[2][2] = 1234;           data[2][3] = "";        //Last name is blank
        data[3][0] = "First name";        data[3][1] = "Last name";        data[3][2] = "";             data[3][3] = "";        //Zip code is blank
        data[4][0] = "First name";        data[4][1] = "Last name";        data[4][2] = "asdfg";        data[4][3] = "";        //String instead zip code
        data[5][0] = "";                  data[5][1] = "";                 data[5][2] = "asdfg";        data[5][3] = "";        //First and last name are blank
        data[6][0] = "First name";        data[6][1] = "";                 data[6][2] = "";             data[6][3] = "";        //Surname and zip code are blank
        data[7][0] = "";                  data[7][1] = "Last name";        data[7][2] = "";             data[7][3] = "";        //First name and zip code are blank
        data[8][0] = "";                  data[8][1] = "";                 data[8][2] = "";             data[8][3] = "";        //All are blank
        data[9][0] = 1234;                data[9][1] = "Last name";        data[9][2] = 1234;           data[9][3] = "";        //Number instead first name
        data[10][0] = "First name";       data[10][1] = 1234;              data[10][2] = 1234;          data[10][3] = "";        //Number instead last name
        data[11][0] = 1234;               data[11][1] = 1234;              data[11][2] = 1234;          data[11][3] = "";        //Number instead first and last name
        data[12][0] = 1234;               data[12][1] = 1234;              data[12][2] = "string";      data[12][3] = "";        //All data type incorrect

        return data;
    }
}
