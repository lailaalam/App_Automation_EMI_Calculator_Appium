package utilities;

import org.testng.annotations.DataProvider;

public class DataSet {
    @DataProvider(name="data-provider")
    public Object[][] setData(){
        return new Object[][]{
                {50000,10,1,2,4395.79,2749.53,1000,52749.53},
                {100000,10,2,4,4614.49,10747.82,4000,110747.82},
                {300000,15,1,6,27077.49,24929.92,18000,324929.92},
                {400000,15,3,5,13866.13,99180.73,20000,499180.73},
                {1000000,10,5,8,21247.04,274822.68,80000,1274822.68}
        };
    }

}
