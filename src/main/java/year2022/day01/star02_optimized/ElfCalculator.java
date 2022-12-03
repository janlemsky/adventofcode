package year2022.day01.star02_optimized;

import utils.SharedUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class ElfCalculator {

    public static void main(String[] args) throws IOException {
        String data = SharedUtils.loadDataFromInput("year2022.day01/input.txt");

        List<Integer> elfCalories = new ArrayList<>();
        for(String elf : data.split("\n\n")) {
            int calories = Arrays.stream(elf.split("\n")).map(value -> Integer.parseInt(value)).reduce(0, Integer::sum);
            elfCalories.add(calories);
        }
        elfCalories.sort(Comparator.reverseOrder());

        System.out.println(elfCalories);
    }
}
