package mess;

import mess.utils.FormatUtils;

import java.io.IOException;
import java.util.ArrayList;

public class Application {

    private static final String FILE = "dataset.json"; // not sure about mkekOS ¯\_(ツ)_/¯

    private static final double MOMENTUM = 0.1;

    private static boolean run = true; // who needs to stop it anyway

    public static void main(String[] args) throws IOException, InterruptedException {
        var ds = new DataStore();
        var dp = new DataProcessorLightVersion();
        var fu = new FormatUtils();

        ds.load(FILE);

        // TODO: I think it works, but some tests would be nice
        do {
            var result = dp.doSomething(new ArrayList<>(ds.getData().values()), MOMENTUM);
            fu.prettifyOutput(result);
            ds.tap();
        } while (run);
    }

}
