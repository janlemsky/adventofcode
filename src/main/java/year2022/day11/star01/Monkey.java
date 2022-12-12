package year2022.day11.star01;

import lombok.Data;

import java.util.List;

@Data
public class Monkey {

    private int id;
    private List<Integer> items;
    private String operation;
    private String operationFactor;
    private int divisor;
    private int trueMonkey;
    private int falseMonkey;
    private int inspects;

    public Monkey(int id, List<Integer> items, String operation, String operationFactor, int divisor, int trueMonkey, int falseMonkey) {
        this.id = id;
        this.items = items;
        this.operation = operation;
        this.operationFactor = operationFactor;
        this.divisor = divisor;
        this.trueMonkey = trueMonkey;
        this.falseMonkey = falseMonkey;
    }

    public int calculateWorryLevel(int item) {
        int value = items.get(item);
        switch (operation) {
            case "*":
                if (operationFactor.equals("old")) value = value * value;
                else {
                    value = value * Integer.parseInt(operationFactor);
                }
                break;
            case "+":
                if (operationFactor.equals("old")) value = value + value;
                else {
                    value = value + Integer.parseInt(operationFactor);
                }
                break;
        }
        ++inspects;
        return value;
    }

    @Override
    public String toString() {
        return "Monkey " + id + ":" + items.toString() + " inspects: " + inspects;
    }
}
