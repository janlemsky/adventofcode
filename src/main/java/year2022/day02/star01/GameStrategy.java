package year2022.day02.star01;

import utils.SharedUtils;

public class GameStrategy {

    public static void main(String[] args) {
        String data = SharedUtils.loadDataFromInput("year2022.day02/input.txt");

        int totalScore = 0;
        String[] rounds = data.split("\n");

        for(String round : rounds) {
            String[] shapes = round.split(" ");

            String enemyShape = shapes[0];
            String myShape = shapes[1];

            switch(enemyShape) {
                case "A":
                    if(myShape.equals("X")) totalScore += 1 + 3;
                    if(myShape.equals("Y")) totalScore += 2 + 6;
                    if(myShape.equals("Z")) totalScore += 3;
                    break;
                case "B":
                    if(myShape.equals("X")) totalScore += 1;
                    if(myShape.equals("Y")) totalScore += 2 + 3;
                    if(myShape.equals("Z")) totalScore += 3 + 6;
                    break;
                case "C":
                    if(myShape.equals("X")) totalScore += 1 + 6;
                    if(myShape.equals("Y")) totalScore += 2;
                    if(myShape.equals("Z")) totalScore += 3 + 3;
                    break;
            }
        }
        System.out.println(totalScore);
    }
}
