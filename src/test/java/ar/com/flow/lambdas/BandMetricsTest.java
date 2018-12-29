package ar.com.flow.lambdas;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.summingInt;
import static org.junit.Assert.assertEquals;

public class BandMetricsTest {
    private Collection<Metric> metrics;

    @Before
    public void setUp() {
        metrics = new ArrayList<>();
        Metric oasisMetric1 = new DefaultMetric("Oasis", 1);
        metrics.add(oasisMetric1);
        Metric oasisMetric2 = new DefaultMetric("Oasis", 2);
        metrics.add(oasisMetric2);
        Metric blurMetric = new DefaultMetric("Blur", 1);
        metrics.add(blurMetric);
    }

    @Test
    public void sumValueGroupByName() {
        Map<String, Integer> collect = metrics.stream()
                .collect(groupingBy(Metric::getName, summingInt(Metric::getValue)));

        assertEquals(collect.size(), 2);
        assertEquals(new Integer(3), collect.get("Oasis"));
        assertEquals(new Integer(1), collect.get("Blur"));
    }
}
