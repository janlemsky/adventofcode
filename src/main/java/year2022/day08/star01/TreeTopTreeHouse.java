package year2022.day08.star01;

import utils.SharedUtils;

import java.util.Arrays;

public class TreeTopTreeHouse {

    public static void main(String[] args) {
        String data = SharedUtils.loadDataFromInput("year2022/day08/input.txt");

        String[] lines = data.split("\n");
        // Parse the input into an n x m-array
        int[][] trees = new int[lines.length][lines[0].length()];
        for(int n = 0; n < lines.length; ++n) {
            for(int m = 0; m < lines[0].length(); ++m) {
                trees[n][m] = Character.getNumericValue(lines[n].charAt(m));
            }
        }
        int result = 0;
        // Calculate visible trees
        for(int n = 0; n < trees.length; ++n) {
            for(int m = 0; m < trees[0].length; ++m) {
                // Check if edge
                if(n == 0 || m == 0 || n == trees.length-1 || m == trees[0].length-1) {
                    result ++;
                } else {
                    boolean alreadyFound = false;
                    // Look up
                    for(int i = n-1; i >= 0; --i) {
                        if(trees[n][m] <= trees[i][m]) {
                            break;
                        }
                        if(i == 0 && !alreadyFound) {
                            ++result;
                            alreadyFound = true;
                        }
                    }
                    // Look down
                    for(int i = n+1; i < trees.length; ++i) {
                        if(trees[n][m] <= trees[i][m]) {
                            break;
                        }
                        if(i == trees.length-1 && !alreadyFound) {
                            ++result;
                            alreadyFound = true;
                        }
                    }
                    // Look left
                    for(int i = m-1; i >= 0; --i) {
                        if(trees[n][m] <= trees[n][i]) {
                            break;
                        }
                        if(i == 0 && !alreadyFound) {
                            ++result;
                            alreadyFound = true;
                        }
                    }
                    // Look right
                    for(int i = m+1; i < trees[0].length; ++i) {
                        if(trees[n][m] <= trees[n][i]) {
                            break;
                        }
                        if(i == trees[0].length-1 && !alreadyFound) {
                            ++result;
                            alreadyFound = true;
                        }
                    }
                }
            }
        }

        System.out.println(Arrays.deepToString(trees));
        System.out.println("Visible trees: " + result);
    }
}
