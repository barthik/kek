package mess.utils;

import mess.model.Duplet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;

public class DataLoader {

    public List<Duplet> load(String fileName) throws IOException {
        final JsonParser jp = new JsonParser();

        return jp.map(loadData(fileName));
    }

    public String loadData(String fileName) throws IOException {
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();

        try (InputStream is = classLoader.getResourceAsStream(fileName)) {

            if (is == null) {
                return null;
            }

            try (
                    InputStreamReader isr = new InputStreamReader(is);
                    BufferedReader reader = new BufferedReader(isr)
            ) {
                return reader.lines().collect(Collectors.joining(System.lineSeparator()));
            }
        }
    }

}
