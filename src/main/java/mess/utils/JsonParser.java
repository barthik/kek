package mess.utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import mess.model.Duplet;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JsonParser {

    public List<Duplet> map(String json) throws IOException {
        if (StringUtils.isEmpty(json)) {
            return new ArrayList<>();
        }

        return new ObjectMapper().readValue(json, new TypeReference<>() {
        });
    }

}
