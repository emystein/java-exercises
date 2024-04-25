package ar.com.flow.kata;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class RussianDollsTest {
    @Test
    public void sortedArray() {
        assertEquals(Lists.newArrayList(3, 3), solveList(Lists.newArrayList(2, 2, 3, 3)));
    }

    @Test
    public void unsortedArray() {
        assertEquals(Lists.newArrayList(3, 3), solveList(Lists.newArrayList(3, 2, 3, 2)));
    }

    @Test
    public void moreThanOneFill() {
        assertEquals(Lists.newArrayList(3, 4), solveList(Lists.newArrayList(3, 2, 3, 4)));
    }

    @Test
    public void allTheSame() {
        assertEquals(Lists.newArrayList(2, 2, 2), solveList(Lists.newArrayList(2, 2, 2)));
    }

    @Test
    public void emptyArray() {
        assertEquals(0, solve(Lists.newArrayList()));
    }

    public List<Integer> solveList(List<Integer> doll) {
        doll.sort(Comparator.naturalOrder());
        List<Bucket> dollsInBuckets = doll.stream().map(d -> new Bucket(d, d - 1)).toList();
        return solveRecursive(dollsInBuckets, true).stream().map(Bucket::number).toList();
    }

    public int solve(List<Integer> doll) {
        return solveList(doll).size();
    }

    public List<Bucket> solveRecursive(List<Bucket> doll, boolean keepIterating) {
        if (!keepIterating || doll.isEmpty() || doll.stream().allMatch(a -> a.number() == doll.get(0).number())) {
            return doll;
        }
        List<Bucket> collected = new ArrayList<>();
        for (int i = 0; i < doll.size() - 1; i++) {
            if (doll.get(i + 1).accepts(doll.get(i))) {
                collected.add(doll.get(i + 1).add(doll.get(i)));
            } else {
                collected.add(doll.get(i));
            }
        }
        keepIterating = collected.stream().anyMatch(b -> !b.isFilled());
        return solveRecursive(collected, keepIterating);
    }

    record Bucket(int number, int minimumAccepted) {
        boolean isFilled() {
            return number <= minimumAccepted;
        }

        public boolean accepts(Bucket other) {
            return minimumAccepted >= other.number;
        }

        public Bucket add(Bucket other) {
            return new Bucket(number, other.number + 1);
        }
    }
}

