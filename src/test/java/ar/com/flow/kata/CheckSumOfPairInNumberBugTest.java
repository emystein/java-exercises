package ar.com.flow.kata;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CheckSumOfPairInNumberBugTest {
    @Test
    public void shouldPassWhenTwoElementsSumsUp() {
        NumberBag bag = new NumberBag();
        bag.add(2);
        bag.add(5);
        boolean sumsUp = bag.checkSum(7);
        assertTrue(sumsUp);
    }

    @Test
    public void shouldNotSumSameElement() {
        NumberBag bag = new NumberBag();
        bag.add(2);
        bag.add(5);
        boolean sumsUp = bag.checkSum(4);
        assertFalse(sumsUp);
    }

    @Test
    public void shouldNotPassWhenEmptyBag() {
        NumberBag bag = new NumberBag();
        boolean sumsUp = bag.checkSum(4);
        assertFalse(sumsUp);
    }

    @Test
    public void shouldNotPassWhenTheBagHasASingleItem() {
        NumberBag bag = new NumberBag();
        bag.add(2);
        boolean sumsUp = bag.checkSum(4);
        assertFalse(sumsUp);
    }
}

class NumberBag {
    private final List<Integer> numbers = new ArrayList<>();

    public void add(int numberToAdd) {
        this.numbers.add(numberToAdd);
    }

    public boolean checkSum(Integer numberToCheck) {
        for (int i = 0; i < numbers.size(); i++) {
            for (int j = i + 1; j < numbers.size(); j++) {
                Integer currentSum = numbers.get(i) + numbers.get(j);
                if (currentSum.equals(numberToCheck)) {
                    return true;
                }
            }
        }
        return false;
    }
}
