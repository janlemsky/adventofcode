package year2022.day04.star01;

import utils.SharedUtils;

public class Cleanup {

    public static void main(String[] args) {
        String data = SharedUtils.loadDataFromInput("year2022/day04/input.txt");

        String[] pairs = data.split("\n");

        int result = 0;
        for (String pair : pairs) {
            String[] assignedSections = pair.split(",");

            int firstElfFirstSection = Integer.parseInt(assignedSections[0].split("-")[0]);
            int firstElfSecondSection = Integer.parseInt(assignedSections[0].split("-")[1]);
            int secondElfFirstSection = Integer.parseInt(assignedSections[1].split("-")[0]);
            int secondElfSecondSection = Integer.parseInt(assignedSections[1].split("-")[1]);

            if ((firstElfFirstSection <= secondElfFirstSection && firstElfSecondSection >= secondElfSecondSection) ||
                    (secondElfFirstSection <= firstElfFirstSection && secondElfSecondSection >= firstElfSecondSection)) {
                ++result;
            }
        }
        System.out.println(result);
    }
}
