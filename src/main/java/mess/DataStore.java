package mess;

import lombok.Data;
import mess.model.Duplet;
import mess.utils.DataLoader;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

@Data
public class DataStore {

    private HashMap<Integer, Duplet> data;

    final int MIN_VALUE = 0;
    final int MAX_VALUE = 100;

    public DataStore() {
        this.data = new HashMap<>();

        init();
    }

    public void load(String fileName) throws IOException {
        final DataLoader dl = new DataLoader();

        List<Duplet> duplets = dl.load(fileName);

        load(duplets);
    }

    public void load(List<Duplet> duplets) {
        this.data.clear();

        for (int i = 0; i < duplets.size(); i++) {
            this.data.put(i, duplets.get(i));
        }
    }

    private void init() {
        for (int i = 0; i < 4; i++) {
            this.data.put(
                    i,
                    new Duplet((double) getNumber(MIN_VALUE, MAX_VALUE), (double) getNumber(MIN_VALUE, MAX_VALUE))
            );
        }
    }

    public int getNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }

}
