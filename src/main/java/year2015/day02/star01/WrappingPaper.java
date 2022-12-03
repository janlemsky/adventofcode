package year2015.day02.star01;

import utils.SharedUtils;

import java.io.IOException;

public class WrappingPaper {

    public static void main(String[] args) throws IOException {
        String data = SharedUtils.loadDataFromInput("year2015.day02/input.txt");

        String[] presents = data.split("\n");
        int amountOfPaper = 0;
        for(String present : presents) {
            String[] measures = present.split("x");
            amountOfPaper += calculatePaperForPresent(
                    (Integer.parseInt(measures[0])),
                    (Integer.parseInt(measures[1])),
                    (Integer.parseInt(measures[2])));
        }

        System.out.println(amountOfPaper);
    }

    private static int calculatePaperForPresent(int length, int width, int height) {
        int smallestSide = Math.min(Math.min(length * width, width * height), height * length);

        return 2 * ((length * width) + (width * height) + (height * length)) + smallestSide;
    }
}
