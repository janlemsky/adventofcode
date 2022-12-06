package year2022.day06.star01;

import utils.SharedUtils;

public class TuningTrouble {

    public static void main(String[] args) {
        String data = SharedUtils.loadDataFromInput("year2022/day06/input.txt");

        String workingData = data;
        String marker = "";

        int i = 0;
        while (marker.length() < 4) {
            char c = workingData.charAt(i);

            int indexOfC = marker.indexOf(c);
            if (indexOfC != -1) {
                workingData = workingData.substring(indexOfC + 1);
                marker = marker.substring(indexOfC + 1);
                i = marker.length();
            } else {
                marker += c;
                ++i;
            }
        }
        System.out.println("position: " + (data.indexOf(marker) + 4) + " sequence: " + marker);
    }
}
