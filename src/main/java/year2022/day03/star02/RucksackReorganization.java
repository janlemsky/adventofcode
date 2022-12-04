package year2022.day03.star02;

import utils.SharedUtils;

public class RucksackReorganization {

    private static String alphabet = "0abcdefghijklmnopqrstuvwxyz";

    public static void main(String[] args) {
        String data = SharedUtils.loadDataFromInput("year2022/day03/input.txt");

        String[] rucksacks = data.split("\n");

        int priorities = 0;
        for (int i = 0; i < rucksacks.length; i = i + 3) {
            String firstRucksack = rucksacks[0 + i];
            String secondRucksack = rucksacks[1 + i];
            String thirdRucksack = rucksacks[2 + i];

            for (char c : firstRucksack.toCharArray()) {
                int priority = 0;

                if (secondRucksack.indexOf(c) != -1 && thirdRucksack.indexOf(c) != -1) {
                    priority += alphabet.indexOf(Character.toLowerCase(c));
                    if (Character.isUpperCase(c)) priority += 26;
                    priorities += priority;
                    break;
                }
            }
        }
        System.out.println(priorities);
    }
}
