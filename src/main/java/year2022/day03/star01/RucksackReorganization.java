package year2022.day03.star01;

import utils.SharedUtils;

public class RucksackReorganization {

    private static String alphabet = "0abcdefghijklmnopqrstuvwxyz";

    public static void main(String[] args) {
        String data = SharedUtils.loadDataFromInput("year2022.day03/input.txt");

        String[] rucksacks = data.split("\n");

        int priorities = 0;
        for (String rucksack : rucksacks) {
            String firstCompartment = rucksack.substring(0, rucksack.length() / 2);
            String secondCompartment = rucksack.substring(rucksack.length() / 2);

            for (char c : firstCompartment.toCharArray()) {
                int priority = 0;
                if (secondCompartment.indexOf(c) != -1) {
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
