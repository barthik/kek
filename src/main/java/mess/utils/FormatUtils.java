package mess.utils;

import mess.model.Duplet;
import org.apache.commons.collections4.CollectionUtils;

import java.util.List;

public class FormatUtils {

    public void prettifyOutput(List<Duplet> duplets) {
        if(CollectionUtils.isEmpty(duplets)) {
            return;
        }

        System.out.println("---------------------------");
        System.out.println("THE RESULT  IS:");
        System.out.println("---------------------------");

        for (Duplet item : duplets) {
            System.out.println(item);
        }

        System.out.println("---------------------------");
    }

}
