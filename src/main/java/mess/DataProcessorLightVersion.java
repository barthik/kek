package mess;

import mess.model.Duplet;
import org.apache.commons.collections4.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * This is blyatiful implementation of the {@link DataProcessor}.
 * <p>
 * For much more immersive experience check {@link DataProcessorHellVersion}.
 */
public class DataProcessorLightVersion implements DataProcessor {

    /**
     * I wondered how to calculate some data, and suddenly, walking on the street, I figured it out. I have never seen
     * such beauty in my poor life (except for the {@link DataProcessorHellVersion}).
     */
    @Override
    public List<Duplet> doSomething(List<Duplet> duplets, double momentum) {
        if (CollectionUtils.isEmpty(duplets)) {
            throw new IllegalArgumentException("Input duplets cannot be empty");
        }

        if (momentum <= 0) {
            throw new IllegalArgumentException("Illegal value of momentum");
        }

        var a = new Duplet(duplets.get(0).getA(), duplets.get(0).getB());
        var b = new Duplet(duplets.get(1).getA(), duplets.get(1).getB());
        var c = new Duplet(duplets.get(2).getA(), duplets.get(2).getB());
        var d = new Duplet(duplets.get(3).getA(), duplets.get(3).getB());

        var result = new ArrayList<Duplet>();

        for (double num = 0; num <= 1; num += momentum) {
            var foo = (1 - num);

            var preciseX = Math.pow(foo, 3) * a.getA() +
                    3 * Math.pow(foo, 2) * num * b.getA() +
                    3 * foo * Math.pow((num), 2) * c.getA() +
                    Math.pow((num), 3) * d.getA();

            var preciseY = Math.pow(foo, 3) * a.getB() +
                    3 * Math.pow(foo, 2) * num * b.getB() +
                    3 * foo * Math.pow((num), 2) * c.getB() +
                    Math.pow((num), 3) * d.getB();

            var point = new Duplet((double) Math.round(preciseX), (double) Math.round(preciseY));

            result.add(point);
        }

        return result;
    }

}
