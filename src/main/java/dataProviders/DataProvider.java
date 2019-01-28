package dataProviders;

public class DataProvider {
    @org.testng.annotations.DataProvider
    public Object[][] simpleDataProvider() {
        return new Object[][]{
                {"Object1", 1},
                {"Object2", 2},
                {"Object3", 3}
        };
    }
}
