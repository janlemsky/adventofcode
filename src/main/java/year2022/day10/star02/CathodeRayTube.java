package year2022.day10.star02;

import utils.SharedUtils;

import java.util.HashMap;
import java.util.Map;

public class CathodeRayTube {

    public static void main(String[] args) {
        String data = SharedUtils.loadDataFromInput("year2022/day10/input.txt");

        Map<Integer, Cycle> map = new HashMap<>();

        String[] lines = data.split("\n");
        int registerX = 1;
        Cycle zero = new Cycle(0, registerX, registerX, registerX);
        map.put(0, zero);
        int counter = 1;
        for (String line : lines) {
            String instruction = line.split(" ")[0];

            if (instruction.equals("noop")) {
                Cycle cycle = new Cycle(counter, registerX, registerX, registerX);
                map.put(counter, cycle);
                ++counter;
            }
            if (instruction.equals("addx")) {
                int value = Integer.parseInt(line.split(" ")[1]);

                Cycle first = new Cycle(counter, registerX, registerX, registerX);
                map.put(counter++, first);
                int newRegisterX = registerX + value;
                Cycle second = new Cycle(counter, registerX, registerX, registerX + value);
                map.put(counter++, second);
                registerX = newRegisterX;
            }
        }
        for (Integer key : map.keySet()) {
            System.out.println(map.get(key));
        }
        int position = 0;
        for (int i = 1; i <= 240; ++i) {
            if (i % 40 != 0) {
                Cycle currentCycle = map.get(i);
                if ((i % 2 == 0 && Math.abs(currentCycle.getDuring() - position) <= 1) || (i % 2 == 1 && Math.abs(currentCycle.getStart() - position) <= 1)) {
                    System.out.print("#");
                } else {
                    System.out.print(".");
                }
                ++position;
            }
            else {
                System.out.println();
                position /= 40;
            }
        }
    }
}
