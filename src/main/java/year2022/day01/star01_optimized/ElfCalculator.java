package year2022.day01.star01_optimized;

import utils.SharedUtils;

import java.io.IOException;
import java.util.Arrays;

public class ElfCalculator {

    public static void main(String[] args) throws IOException {
        String data = SharedUtils.loadDataFromInput("year2022/day01/input.txt");

        String[] elfs = data.split("\n\n");

        int max = 0;
        for(String elf : elfs) {
            int calories = Arrays.stream(elf.split("\n")).map(value -> Integer.parseInt(value)).reduce(0, Integer::sum);
            max = max < calories ? calories : max;
        }
        System.out.println(max);
    }
}
