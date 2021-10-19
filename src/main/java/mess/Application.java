package mess;

import mess.model.Duplet;
import mess.utils.FormatUtils;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Application {

    private static final String FILE = "dataset.json";

    private static final double MOMENTUM = 0.1;

    private static boolean run = true;

    public static void main(String[] args) throws IOException, InterruptedException {
        final DataStore ds = new DataStore();
        final DataProcessor dp = new DataProcessor();
        final FormatUtils fu = new FormatUtils();

        ds.load(FILE);

        do {
            List<Duplet> result = dp.doIt(
                    ds.getData()
                            .entrySet()
                            .stream()
                            .map(Map.Entry::getValue)
                            .collect(Collectors.toList()),
                    MOMENTUM
            );

            fu.prettifyOutput(result);

            ds.next();
        } while(run);
    }

}
