package mess;

import mess.model.Duplet;

import java.util.List;

public interface DataProcessor {

    List<Duplet> doSomething(List<Duplet> duplets, double momentum);

}
