package year2022.day09.star01;

import utils.SharedUtils;

import java.util.HashMap;
import java.util.Map;

public class RopeBridge {

    public static void main(String[] args) {
        String data = SharedUtils.loadDataFromInput("year2022/day09/input.txt");

        Map<Position, Integer> tailVisits = new HashMap<>();
        Knot head = new Knot(0, 0);
        Knot tail = new Knot(0, 0);

        String[] commands = data.split("\n");

        for (String command : commands) {
            String direction = command.split(" ")[0];
            int steps = Integer.parseInt(command.split(" ")[1]);

            for (int i = 0; i < steps; ++i) {
                int oldHeadX = head.getX();
                int oldHeadY = head.getY();

                if (direction.equals("U")) {
                    head.moveUp();
                } else if (direction.equals("D")) {
                    head.moveDown();
                } else if (direction.equals("L")) {
                    head.moveLeft();
                } else if (direction.equals("R")) {
                    head.moveRight();
                }
                if (!isAdjacent(head, tail)) {
                    tail.setX(oldHeadX);
                    tail.setY(oldHeadY);
                    Position position = new Position(tail.getX(), tail.getY());
                    Integer visits = tailVisits.get(position);
                    if (visits != null) tailVisits.put(position, ++visits);
                    else {
                        tailVisits.put(position, 1);
                    }
                }
            }
        }
        System.out.println("tailVisits: " + (tailVisits.size() + 1));
    }

    private static boolean isAdjacent(Knot head, Knot tail) {
        if (Math.abs(head.getX() - tail.getX()) <= 1 && Math.abs(head.getY() - tail.getY()) <= 1) {
            return true;
        }
        return false;
    }
}
