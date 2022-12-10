package year2022.day09.star01;

import lombok.Data;

@Data
public class Knot {

    private int x;
    private int y;

    public Knot(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void moveUp() {
        ++y;
    }
    public void moveDown() {
        --y;
    }
    public void moveLeft() {
        --x;
    }
    public void moveRight() {
        ++x;
    }
}
