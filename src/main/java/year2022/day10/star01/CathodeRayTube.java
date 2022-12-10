package year2022.day10.star01;

import utils.SharedUtils;

import java.util.HashMap;
import java.util.Map;

public class CathodeRayTube {

    public static void main(String[] args) {
        String data = SharedUtils.loadDataFromInput("year2022/day10/input.txt");

        Map<Integer, Cycle> map = new HashMap<>();

        String[] lines = data.split("\n");
        int registerX = 1;
        Cycle zero = new Cycle(0,registerX,registerX,registerX);
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
                Cycle second = new Cycle(counter, registerX, registerX, registerX  + value);
                map.put(counter++, second);
                registerX = newRegisterX;
            }
        }
        for(Integer key : map.keySet()) {
            System.out.println(map.get(key));
        }

        System.out.println(20 * map.get(20).getDuring() +
                60 * map.get(60).getDuring() +
                100 * map.get(100).getDuring() +
                140 * map.get(140).getDuring() +
                180 * map.get(180).getDuring() +
                220 * map.get(220).getDuring()
         );
    }
}
