package mess.utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import mess.model.Duplet;

import java.io.IOException;
import java.util.List;

public class JsonParser {

    public List<Duplet> map(String json) throws IOException {
        return new ObjectMapper().readValue(json, new TypeReference<List<Duplet>>() {});
    }

}
