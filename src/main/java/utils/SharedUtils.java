package utils;

import org.apache.commons.io.IOUtils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class SharedUtils {
    private static final String BASE_PATH = "/Users/jlemsky/adventofcode/src/main/resources/";

    public static String loadDataFromInput(String input) {
        String data = "";
        try {
            InputStream inputStream = new FileInputStream(BASE_PATH  + input);
            data = IOUtils.toString(inputStream, "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }
}
