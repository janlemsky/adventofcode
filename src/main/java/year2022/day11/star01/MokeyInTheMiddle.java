package year2022.day11.star01;

import utils.SharedUtils;

import java.util.ArrayList;
import java.util.List;

public class MokeyInTheMiddle {

    public static void main(String[] args) {
        String data = SharedUtils.loadDataFromInput("year2022/day11/input.txt");

        String[] monkeysInput = data.split("\n\n");

        List<Monkey> monkeys = new ArrayList<>();
        // Parse monkeys
        for (String monkeyInput : monkeysInput) {
            String[] monkeyLines = monkeyInput.split("\n");

            int id = Integer.parseInt(monkeyLines[0].replaceAll("[^\\d]", ""));
            String[] items = monkeyLines[1].replaceAll("[^\\d,]", "").split(",");
            List<Integer> itemList = new ArrayList<>();
            for (String item : items) {
                itemList.add(Integer.parseInt(item));
            }
            String operation = monkeyLines[2].replaceAll("[^*+]", "");
            String operationFactor = monkeyLines[2].substring(monkeyLines[2].indexOf(operation) + 1).trim();
            int divisor = Integer.parseInt(monkeyLines[3].replaceAll("[^\\d]", ""));
            int trueMonkey = Integer.parseInt(monkeyLines[4].replaceAll("[^\\d]", ""));
            int falseMonkey = Integer.parseInt(monkeyLines[5].replaceAll("[^\\d]", ""));

            monkeys.add(new Monkey(id, itemList, operation, operationFactor, divisor, trueMonkey, falseMonkey));
        }

        for(int round = 0; round < 20; ++round) {
            for (Monkey monkey : monkeys) {
                List<Integer> items = monkey.getItems();
                for (int i = 0; i < items.size(); ++i) {
                    // Calculate worry level
                    int worryLevel = monkey.calculateWorryLevel(i);
                    // Monkey bored
                    worryLevel = Math.round(worryLevel / 3);
                    // Decide who to throw the item to
                    int nextMonkey = -1;
                    if (worryLevel % monkey.getDivisor() == 0) {
                        nextMonkey = monkey.getTrueMonkey();
                    } else {
                        nextMonkey = monkey.getFalseMonkey();
                    }
                    monkeys.get(nextMonkey).getItems().add(worryLevel);
                }
                monkey.getItems().removeAll(items);
            }
        }
        System.out.println(monkeys);
    }
}
