package year2022.day01.star01;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Elf {

    private List<Integer> inventory = new ArrayList<>();

    public void addFood(int calories) {
        inventory.add(calories);
    }
}
