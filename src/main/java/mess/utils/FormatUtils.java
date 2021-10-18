package mess.utils;

import mess.model.Duplet;

import java.util.List;

public class FormatUtils {

    public void prettifyOutput(List<Duplet> objects) {
        System.out.println("---------------------------");
        System.out.println("THE RESULT  IS:");
        System.out.println("---------------------------");

        for (Duplet item : objects) {
            System.out.println(item);
        }

        System.out.println("---------------------------");
    }

}
