package year2015.day01.star02;

import utils.SharedUtils;

import java.io.IOException;

public class StairCounter {

    public static void main(String[] args) throws IOException {
        String data = SharedUtils.loadDataFromInput("year2015/day01/input.txt");

        int result = 0;
        int firstDown = -1;
        int position = 1;
        for(char c : data.toCharArray()) {
            if(c == '(') ++result;
            if(c == ')') --result;
            if(result == -1 && firstDown == -1) firstDown = position;
            ++position;
        }
        System.out.println(result);
        System.out.println(firstDown);
    }
}
