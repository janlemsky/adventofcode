package year2022.day01.star02;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Elf implements Comparable<Elf> {

    private List<Integer> inventory = new ArrayList<>();

    private int sumCalories;

    public void addFood(int calories) {
        inventory.add(calories);
    }

    @Override
    public int compareTo(Elf elf) {
        return this.sumCalories - elf.getSumCalories();
    }
}
