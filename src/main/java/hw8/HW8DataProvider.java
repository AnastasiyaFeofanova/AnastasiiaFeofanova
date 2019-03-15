package hw8;

import org.testng.annotations.DataProvider;

import java.io.FileNotFoundException;
import java.util.Map;

public class HW8DataProvider {
    @DataProvider(name = "HW8DP")
    public Object[][] getData() throws FileNotFoundException {
        Map<String, MetalsColors> map = MetColLoader.getFile();
        Object[] keys = map.keySet().toArray();
        Object[] values = map.values().toArray();
        Object[][] result = new Object[map.size()][2];
        for (int i = 0; i < map.size(); i++) {
            result[i][0] = keys[i];
            result[i][1] = values[i];
        }
        System.out.println(result);
        return result;
}
}