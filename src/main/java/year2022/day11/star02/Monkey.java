package year2022.day11.star02;

import lombok.Data;

import java.math.BigInteger;
import java.util.List;

@Data
public class Monkey {
    private int id;
    private List<BigInteger> items;
    private String operation;
    private String operationFactor;
    private int divisor;
    private int trueMonkey;
    private int falseMonkey;
    private int inspects;

    public Monkey(int id, List<BigInteger> items, String operation, String operationFactor, int divisor, int trueMonkey, int falseMonkey) {
        this.id = id;
        this.items = items;
        this.operation = operation;
        this.operationFactor = operationFactor;
        this.divisor = divisor;
        this.trueMonkey = trueMonkey;
        this.falseMonkey = falseMonkey;
    }

    public BigInteger calculateWorryLevel(int item) {
        BigInteger value = items.get(item);
        switch (operation) {
            case "*":
                if (operationFactor.equals("old")) {
                    value = value.multiply(value);
                } else {
                    value = value.multiply(new BigInteger(operationFactor));
                }
                break;
            case "+":
                if (operationFactor.equals("old")) value = value.add(value);
                else {
                    value = value.add(new BigInteger(operationFactor));
                }
                break;
        }
        ++inspects;
        return value;
    }

    @Override
    public String toString() {
        return "Monkey " + id + " inspects: " + inspects;
    }
}
