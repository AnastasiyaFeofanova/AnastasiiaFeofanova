package hw8;

import com.google.common.reflect.TypeToken;
import gherkin.deps.com.google.gson.Gson;
import gherkin.deps.com.google.gson.stream.JsonReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.Map;

public class Parser {
    private static Map<String, MetalsColors> mcData = null;

    private static void loadResource() throws FileNotFoundException {
        JsonReader jsonReader = new JsonReader(new FileReader(Parser.class.getClassLoader()
                .getResource("hw8/metalsColorsData.json").getFile()));

        Type token = new TypeToken<Map<String, MetalsColors>>() {{
        }}.getType();

        mcData = new Gson().fromJson(jsonReader, token);
    }
}
