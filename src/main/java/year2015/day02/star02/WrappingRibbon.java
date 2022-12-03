package year2015.day02.star02;

import utils.SharedUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class WrappingRibbon {

    public static void main(String[] args) throws IOException {
        String data = SharedUtils.loadDataFromInput("year2015.day02/input.txt");

        String[] presents = data.split("\n");
        int amountOfRibbon = 0;
        for(String present : presents) {
            String[] measures = present.split("x");
            amountOfRibbon += calculateRibbonForPresent(
                    (Integer.parseInt(measures[0])),
                    (Integer.parseInt(measures[1])),
                    (Integer.parseInt(measures[2])));
        }

        System.out.println(amountOfRibbon);
    }

    private static int calculateRibbonForPresent(int length, int width, int height) {
        Integer longestSide = Math.max(Math.max(length, width), height);
        List<Integer> sides = new ArrayList<>(List.of(length, width, height));
        sides.remove(longestSide);

        return 2 * sides.get(0) + 2 * sides.get(1) + length * width * height;
    }
}
