package mess.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Duplet {

    private Double a;

    private Double b;

    public void round() {
        this.a = (double) Math.round(this.a);
        this.b = (double) Math.round(this.b);
    }

}
