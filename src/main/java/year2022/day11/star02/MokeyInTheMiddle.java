package year2022.day11.star02;

import utils.SharedUtils;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MokeyInTheMiddle {

    public static void main(String[] args) {
        String data = SharedUtils.loadDataFromInput("year2022/day11/input.txt");

        BigInteger a = new BigInteger("2916");
        BigInteger b = new BigInteger("54");
        System.out.println(b.mod(new BigInteger("19")));

        String[] monkeysInput = data.split("\n\n");

        List<Monkey> monkeys = new ArrayList<>();
        // Parse monkeys
        for (String monkeyInput : monkeysInput) {
            String[] monkeyLines = monkeyInput.split("\n");

            int id = Integer.parseInt(monkeyLines[0].replaceAll("[^\\d]", ""));
            String[] items = monkeyLines[1].replaceAll("[^\\d,]", "").split(",");
            List<BigInteger> itemList = new ArrayList<>();
            for (String item : items) {
                itemList.add(new BigInteger(item));
            }
            String operation = monkeyLines[2].replaceAll("[^*+]", "");
            String operationFactor = monkeyLines[2].substring(monkeyLines[2].indexOf(operation) + 1).trim();
            int divisor = Integer.parseInt(monkeyLines[3].replaceAll("[^\\d]", ""));
            int trueMonkey = Integer.parseInt(monkeyLines[4].replaceAll("[^\\d]", ""));
            int falseMonkey = Integer.parseInt(monkeyLines[5].replaceAll("[^\\d]", ""));

            monkeys.add(new Monkey(id, itemList, operation, operationFactor, divisor, trueMonkey, falseMonkey));
        }
        // Calculate the worry level manager 2000
        List<Integer> divisors = new ArrayList<>();
        monkeys.forEach(monkey -> divisors.add(monkey.getDivisor()));
        long zooKeeper = divisors.stream().reduce(1, (div1, div2) -> div1 * div2);

        for (int round = 0; round < 10000; ++round) {
            System.out.println("Round: " + round);
            for (Monkey monkey : monkeys) {
                List<BigInteger> items = monkey.getItems();
                for (int i = 0; i < items.size(); ++i) {
                    // Calculate worry level
                    BigInteger worryLevel = monkey.calculateWorryLevel(i);
                    // Decide who to throw the item to
                    int nextMonkey;
                    // Manage worry level
                    worryLevel = worryLevel.mod(BigInteger.valueOf(zooKeeper));

                    if (worryLevel.mod(BigInteger.valueOf(monkey.getDivisor())).equals(BigInteger.ZERO)) {
                        nextMonkey = monkey.getTrueMonkey();
                    } else {
                        nextMonkey = monkey.getFalseMonkey();
                    }
                    monkeys.get(nextMonkey).getItems().add(worryLevel);
                }
                monkey.getItems().removeAll(items);
            }
        }
        List<Integer> inspections = new ArrayList<>();
        monkeys.forEach(monkey -> {
            inspections.add(monkey.getInspects());
            System.out.println(monkey);
        });
        inspections.sort(Comparator.reverseOrder());

        System.out.println(BigInteger.valueOf(inspections.get(0)).multiply(BigInteger.valueOf(inspections.get(1))));
    }
}
