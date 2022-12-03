package year2022.day01.star01;

import org.apache.commons.io.IOUtils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ElfCalculator {


    public static void main(String[] args) throws IOException {
        FileInputStream inputStream = new FileInputStream("/Users/jlemsky/adventofcode/src/main/resources/year2022.day01/input.txt");
        List<Elf> elfs = new ArrayList<>();


        List<String> lines = IOUtils.readLines(inputStream, "UTF-8");

        int elfsCounter = 0;
        if(lines.size() > 0) {
            elfs.add(new Elf());
        }
        for(int i = 0; i < lines.size(); ++i) {
            if(lines.get(i).equals("")) {
                elfs.add(new Elf());
                ++elfsCounter;
            } else {
                int currentFood = Integer.parseInt(lines.get(i));
                elfs.get(elfsCounter).addFood(currentFood);
            }
        }
        int max = calculateMaximum(elfs);

        System.out.println(max);
    }

    private static int calculateMaximum(List<Elf> elfs) {
        int maximum = 0;
        for(Elf elf : elfs) {
            int caloriesSum = calculateCaloriesSumForElf(elf.getInventory());
            if(maximum < caloriesSum) {
                maximum = caloriesSum;
            }
        }
        return maximum;
    }

    private static int calculateCaloriesSumForElf(List<Integer> calories) {
        return calories.stream().reduce(0, Integer::sum);
    }
}
