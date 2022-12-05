package year2022.day05.star01;

import utils.SharedUtils;

import java.util.*;

public class CrateRearrangement {

    public static void main(String[] args) {
        String data = SharedUtils.loadDataFromInput("year2022/day05/input.txt");

        String[] procedure = data.split("\n\n");

        String crates = procedure[0];
        String moves[] = procedure[1].split("\n");

        List<Stack<Character>> stacks = new ArrayList();

        List<String> lines = new ArrayList(Arrays.asList(crates.split("\n")));

        // Initialize List with stacks and remove the index line from lines object
        int stackAmount = lines.get(lines.size() - 1).replace(" ", "").length();
        for(int i = 0; i < stackAmount; ++i) {
            stacks.add(new Stack<>());
        }
        lines.remove(lines.size() - 1);

        // Fill stacks with crates starting from the bottom
        for(int i = lines.size() - 1; i >= 0; --i) {
        //for(String line : lines) {
            int cursorPosition = 0;
            String line = lines.get(i);
            for(char c : line.toCharArray()) {
                if(!Character.isLetter(c)) {
                    ++cursorPosition;
                } else {
                    ++cursorPosition;
                    int index = cursorPosition / 4;
                    Stack<Character> stack = stacks.get(index);
                    stack.add(Character.valueOf(c));

                    stacks.set(index, stack);
                }
            }
        }
        moveCrates(stacks, moves);

        stacks.forEach(stack -> System.out.print(stack.pop().toString()));
    }

    private static void moveCrates(List<Stack<Character>> stacks, String[] moves) {
        for(String move : moves) {
            move = move.replace("move ", "")
                    .replace("from ", "")
                    .replace("to ", "");

            int[] commands = Arrays.stream(move.split(" ")).mapToInt(Integer::parseInt).toArray();

            Stack<Character> stack = stacks.get(commands[1] - 1);
            for(int i = 0; i < commands[0]; ++i) {
                stacks.get(commands[2] - 1).add(stack.pop());
            }
        }
    }
}
