package mess;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;
import mess.model.Duplet;

public class DataProcessor {

    /**
     * I wondered how to calculate some data, and suddenly, walking on the street, I figured it out. I have never seen
     * such beauty in my poor life. It's just so amazing. I cried out of pure happiness when I wrote this method.
     * <p>
     * (ﾉ◕ヮ◕)ﾉ*:･ﾟ✧ Such amaze, much wow.
     */
    public List<Duplet> doIt(List<Duplet> duplets, double momentum) {
        final Duplet a = new Duplet(duplets.get(0).getA(), duplets.get(0).getB());
        final Duplet b = new Duplet(duplets.get(1).getA(), duplets.get(1).getB());
        final Duplet c = new Duplet(duplets.get(2).getA(), duplets.get(2).getB());
        final Duplet d = new Duplet(duplets.get(3).getA(), duplets.get(3).getB());

        return DoubleStream.iterate(0, operand -> operand + momentum)
                .parallel()
                .limit((long) (1 / momentum) + 1)
                .boxed()
                .map(i -> Arrays.asList(i, (1 - i)))
                .map(
                        lst -> Arrays.asList(
                                Stream.of(
                                                DoubleStream.of(
                                                        Math.pow(lst.get(1), 3),
                                                        new Duplet(a.getA(), a.getB()).getA()
                                                ),
                                                DoubleStream.of(
                                                        3,
                                                        Math.pow(lst.get(1), 2),
                                                        lst.get(0),
                                                        new Duplet(b.getA(), b.getB()).getA()
                                                ),
                                                DoubleStream.of(
                                                        3,
                                                        lst.get(1),
                                                        Math.pow((lst.get(0)), 2),
                                                        new Duplet(c.getA(), c.getB()).getA()
                                                ),
                                                DoubleStream.of(
                                                        Math.pow((lst.get(0)), 3),
                                                        new Duplet(d.getA(), d.getB()).getA()
                                                )
                                        )
                                        .map(streams -> streams.reduce((left, right) -> (left * right)))
                                        .mapToDouble(item -> item.orElse(0D))
                                        .sum(),
                                Stream.of(
                                                DoubleStream.of(
                                                        Math.pow(lst.get(1), 3),
                                                        new Duplet(a.getA(), a.getB()).getB()
                                                ),
                                                DoubleStream.of(
                                                        3,
                                                        Math.pow(lst.get(1), 2), lst.get(0),
                                                        new Duplet(b.getA(), b.getB()).getB()
                                                ),
                                                DoubleStream.of(
                                                        3,
                                                        lst.get(1),
                                                        Math.pow((lst.get(0)), 2),
                                                        new Duplet(c.getA(), a.getB()).getB()
                                                ),
                                                DoubleStream.of(
                                                        Math.pow((lst.get(0)), 3),
                                                        new Duplet(d.getA(), d.getB()).getB()
                                                )
                                        )
                                        .map(streams -> streams.reduce((left, right) -> (left * right)))
                                        .mapToDouble(item -> item.orElse(0D))
                                        .sum()
                        )
                )
                .map(lst -> new Duplet(lst.get(0), lst.get(1)))
                .map(
                        it -> Arrays.asList(
                                (double) Math.round(it.getA()),
                                (double) Math.round(it.getB())
                        )
                )
                .map(lst -> new Duplet(lst.get(0), lst.get(1)))
                .collect(Collectors.toList());
    }

}
