package mess;

import mess.model.Duplet;
import mess.utils.FormatUtils;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Application {

    private static final String FILE = "dataset.json";

    public static void main(String[] args) throws IOException {
        final DataStore ds = new DataStore();
        final DataProcessor dp = new DataProcessor();
        final FormatUtils fu = new FormatUtils();

        ds.load(FILE);

        List<Duplet> result = dp.doIt(
                ds.getData()
                        .entrySet()
                        .stream()
                        .map(Map.Entry::getValue)
                        .collect(Collectors.toList())
        );

        fu.prettifyOutput(result);
    }

}
