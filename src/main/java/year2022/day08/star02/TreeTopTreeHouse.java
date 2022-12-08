package year2022.day08.star02;

import utils.SharedUtils;

import java.util.Arrays;

public class TreeTopTreeHouse {

    public static void main(String[] args) {
        String data = SharedUtils.loadDataFromInput("year2022/day08/input.txt");

        String[] lines = data.split("\n");
        // Parse the input into an n x m-array
        int[][] trees = new int[lines.length][lines[0].length()];
        for (int n = 0; n < lines.length; ++n) {
            for (int m = 0; m < lines[0].length(); ++m) {
                trees[n][m] = Character.getNumericValue(lines[n].charAt(m));
            }
        }
        int scenicScore = 0;
        // Calculate visible trees
        for (int n = 0; n < trees.length; ++n) {
            for (int m = 0; m < trees[0].length; ++m) {
                // Look up
                int up = 0;
                for (int i = n - 1; i >= 0; --i) {
                    if (trees[n][m] <= trees[i][m]) {
                        ++up;
                        break;
                    }
                    ++up;
                }
                // Look down
                int down = 0;
                for (int i = n + 1; i < trees.length; ++i) {
                    if (trees[n][m] <= trees[i][m]) {
                        ++down;
                        break;
                    }
                    ++down;
                }
                // Look left
                int left = 0;
                for (int i = m - 1; i >= 0; --i) {
                    if (trees[n][m] <= trees[n][i]) {
                        ++left;
                        break;
                    }
                    ++left;
                }
                // Look right
                int right = 0;
                for (int i = m + 1; i < trees[0].length; ++i) {
                    if (trees[n][m] <= trees[n][i]) {
                        ++right;
                        break;
                    }
                    ++right;
                }
                int newScenicScore = up * down * left * right;
                scenicScore = newScenicScore >= scenicScore ? newScenicScore : scenicScore;
            }
        }
        System.out.println(Arrays.deepToString(trees));
        System.out.println("Highest scenic score: " + scenicScore);
    }
}
