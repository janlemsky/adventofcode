package year2015.day03.star02;

import utils.SharedUtils;

import java.util.HashMap;

public class PresentDelivery {

    public static void main(String[] args) {
        String data = SharedUtils.loadDataFromInput("year2015/day03/input.txt");

        HashMap<Key, Integer> deliveries = new HashMap<>();

        String pathSanta = "";
        String pathRoboSanta = "";
        for(int i = 0; i < data.length(); ++i) {
            if ((i % 2 == 0)) {
                pathSanta += data.charAt(i);
            } else {
                pathRoboSanta += data.charAt(i);
            }
        }

        calculateDeliveries(pathSanta.trim().toCharArray(), deliveries);
        calculateDeliveries(pathRoboSanta.trim().toCharArray(), deliveries);

        System.out.println(deliveries.size());
    }

    private static void calculateDeliveries(char[] directions, HashMap<Key, Integer> deliveries) {
        int x = 0;
        int y = 0;
        deliveries.put(new Key(0, 0), 1);
        for (char direction : directions) {
            if(direction == '^') ++y;
            if(direction == '>') ++x;
            if(direction == 'v') --y;
            if(direction == '<') --x;

            Key coordinates = new Key(x, y);
            Integer value = deliveries.get(coordinates);

            if(value == null) {
                deliveries.put(coordinates, 1);
            } else {
                deliveries.put(coordinates, ++value);
            }
        }
    }
}
