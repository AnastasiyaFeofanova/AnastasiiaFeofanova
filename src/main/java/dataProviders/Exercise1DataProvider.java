package dataProviders;

import org.testng.annotations.DataProvider;

public class Exercise1DataProvider {
    // TODO You should not leave the comments like this
    //@org.testng.annotations.DataProvider
    @DataProvider
    public Object[][] exersise1DataProvider(){
        return new Object[][]{
                {0, "To include good practices\n" +
                        "and ideas from successful\n" +
                        "EPAM project"},
                {1, "To be flexible and\n" +
                        "customizable"},
                {2, "To be multiplatform"},
                {3, "Already have good base\n(about 20 internal and\nsome external projects),\nwish to get more…"}
        };
    }
}
