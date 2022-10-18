package mess.utils;

import mess.model.Duplet;
import org.apache.commons.lang3.StringUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Objects.isNull;

public class DataLoader {

    public List<Duplet> extractDuplets(String resourceName) throws IOException {
        if (StringUtils.isEmpty(resourceName)) {
            return new ArrayList<>();
        }

        final JsonParser jp = new JsonParser();

        return jp.map(readResource(resourceName));
    }

    public String readResource(String resourceName) throws IOException {
        if (StringUtils.isEmpty(resourceName)) {
            return null;
        }

        ClassLoader classLoader = ClassLoader.getSystemClassLoader();

        try (InputStream is = classLoader.getResourceAsStream(resourceName)) {

            if (isNull(is)) {
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
