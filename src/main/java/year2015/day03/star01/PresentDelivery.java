package year2015.day03.star01;

import utils.SharedUtils;

import java.util.HashMap;

public class PresentDelivery {

    public static void main(String[] args) {
        String data = SharedUtils.loadDataFromInput("year2015.day03/input.txt");

        char[] directions = data.toCharArray();

        int x = 0;
        int y = 0;

        HashMap<year2015.day03.star01.Key, Integer> deliveries = new HashMap<>();
        deliveries.put(new year2015.day03.star01.Key(x, y), 1);

        for (char direction : directions) {
            if(direction == '^') ++y;
            if(direction == '>') ++x;
            if(direction == 'v') --y;
            if(direction == '<') --x;

            year2015.day03.star01.Key coordinates = new Key(x, y);
            Integer value = deliveries.get(coordinates);

            if(value == null) {
                deliveries.put(coordinates, 1);
            } else {
                deliveries.put(coordinates, ++value);
            }
        }
        System.out.println(deliveries.size());
    }
}
