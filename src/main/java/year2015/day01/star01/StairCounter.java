package year2015.day01.star01;

import utils.SharedUtils;

import java.io.IOException;

public class StairCounter {

    public static void main(String[] args) throws IOException {
        String data = SharedUtils.loadDataFromInput("year2015.day01/input.txt");

        int result = 0;
        for(char c : data.toCharArray()) {
            if(c == '(') ++result;
            if(c == ')') --result;
        }
        System.out.println(result);
    }
}
