package year2022.day01.star02;

import org.apache.commons.io.IOUtils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ElfCalculator {


    public static void main(String[] args) throws IOException {
        FileInputStream inputStream = new FileInputStream("/Users/jlemsky/adventofcode/src/main/resources/year2022.day01/input.txt");
        List<String> lines = IOUtils.readLines(inputStream, "UTF-8");

        List<Elf> elfs = new ArrayList<>();
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

        Comparator<Elf> comparator = (elf1, elf2) -> elf2.compareTo(elf1);
        Collections.sort(elfs, comparator);

        System.out.println(elfs.get(0).getSumCalories() + elfs.get(1).getSumCalories() + elfs.get(2).getSumCalories());
    }

    private static int calculateMaximum(List<Elf> elfs) {
        int maximum = 0;
        for(Elf elf : elfs) {
            int caloriesSum = calculateCaloriesSumForElf(elf.getInventory());
            elf.setSumCalories(caloriesSum);

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
