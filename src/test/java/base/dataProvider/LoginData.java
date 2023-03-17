package base.dataProvider;

import org.testng.annotations.DataProvider;

import java.io.FileReader;
import com.opencsv.CSVReader;
import java.io.IOException;
import java.util.List;

public class LoginData {
    @DataProvider(name = "login_provider")
    public Object[][] loginData(){
        Object [][] data = new Object [4][2];

        data [0][0] = "standard_user";		        data [0][1] = "secret_sauce";
        data [1][0] = "locked_out_user";			data [1][1] = "secret_sauce";
        data [2][0] = "problem_user";		        data [2][1] = "secret_sauce";
        data [3][0] = "performance_glitch_user";    data [3][1] = "secret_sauce";

        return data;
    }

    @DataProvider(name = "login_provider2")
    public Object[][] loginData2(){
        Object [][] data = new Object [8][3];

        data [0][0] = "standard_user";		        data [0][1] = "secret_sauce";       data[0][2] = "";
        data [1][0] = "standard_user";		    	data [1][1] = "";                   data[1][2] = "Epic sadface: Password is required";
        data [2][0] = "standard_user";		        data [2][1] = "SECRET_SAUCE";       data[2][2] = "Epic sadface: Username and password do not match any user in this service";
        data [3][0] = "standard_user";              data [3][1] = "secret";             data[3][2] = "Epic sadface: Username and password do not match any user in this service";
        data [4][0] = "user";                       data [4][1] = "secret_sauce";       data[4][2] = "Epic sadface: Username and password do not match any user in this service";
        data [5][0] = "";                           data [5][1] = "secret_sauce";       data[5][2] = "Epic sadface: Username and password do not match any user in this service";
        data [6][0] = "STANDARD_USER";              data [6][1] = "secret_sauce";       data[6][2] = "Epic sadface: Username and password do not match any user in this service";
        data [7][0] = "user";                       data [7][1] = "secret";             data[7][2] = "Epic sadface: Username and password do not match any user in this service";

        return data;
    }

    @DataProvider(name = "userDetails")
    public static Object[][] readCsv() throws IOException {
        CSVReader csvReader = new CSVReader(new FileReader(System.getProperty("user.dir")+"/src/test/resources/loginData.csv"),';');
        List<String[]> csvData=csvReader.readAll();
        Object[][] csvDataObject=new Object[csvData.size()][3];
        for (int i=0;i<csvData.size();i++) {
            csvDataObject[i]=csvData.get(i);
        }
        return  csvDataObject;
    }
}