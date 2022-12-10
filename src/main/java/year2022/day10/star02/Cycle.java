package year2022.day10.star02;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode
@Data
public class Cycle {

    private int id;
    private int start;
    private int during;
    private int finish;

    public Cycle() {
    }

    public Cycle(int id, int start, int during, int finish) {
        this.id = id;
        this.start = start;
        this.during = during;
        this.finish = finish;
    }

    @Override
    public String toString() {
        return "(Cycle: " + id + ", start: " + start + ", during: " + during + ", finish: " + finish + ")";
    }
}
