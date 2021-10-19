package mess;

import lombok.Data;
import mess.model.Duplet;
import mess.utils.DataLoader;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

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

    public void load(String resourceName) throws IOException {
        if (StringUtils.isEmpty(resourceName)) {
            throw new IllegalArgumentException("Resource name cannot be empty");
        }
        final DataLoader dl = new DataLoader();

        List<Duplet> duplets = dl.extractDuplets(resourceName);

        load(duplets);
    }

    public void load(List<Duplet> duplets) {
        if (CollectionUtils.isEmpty(duplets)) {
            throw new IllegalArgumentException("Duplet source cannot be empty");
        }

        this.data.clear();

        for (int i = 0; i < duplets.size(); i++) {
            this.data.put(i, duplets.get(i));
        }
    }

    public void tap() throws InterruptedException {
        HashMap<Integer, Duplet> next = new HashMap<>();

        next.put(
                0,
                new Duplet(
                        this.data.get(this.data.size() - 1).getA(),
                        this.data.get(this.data.size() - 1).getB()
                )
        );

        for (int i = 1; i < data.size(); i++) {
            next.put(
                    i,
                    new Duplet(
                            (double) getNumber(MIN_VALUE, MAX_VALUE),
                            (double) getNumber(MIN_VALUE, MAX_VALUE)
                    )
            );
        }

        this.data.clear();

        this.data = next;

        camouflage();
    }

    private void init() {
        for (int i = 0; i < 4; i++) {
            this.data.put(
                    i,
                    new Duplet(
                            (double) getNumber(MIN_VALUE, MAX_VALUE),
                            (double) getNumber(MIN_VALUE, MAX_VALUE)
                    )
            );
        }
    }

    public int getNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }

    private void camouflage() throws InterruptedException {
        Thread.sleep(1000); // ψ(｀∇´)ψ
    }

}
