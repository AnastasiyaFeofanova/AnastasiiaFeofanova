package hw8;

import com.google.common.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.Gson;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

public class MetColLoader {

    public static Map<String, MetalsColors> getFile() throws FileNotFoundException {
        Path folder = Paths.get("src/main/java/hw8");
        Path myFile = folder.resolve("metalsColorsData.json");

        JsonReader jsonReader = new JsonReader(new FileReader(myFile.toFile()));
        Type token = new TypeToken<Map<String, MetalsColors>>() {
        }.getType();

        return new Gson().fromJson(jsonReader, token);
    }
}
