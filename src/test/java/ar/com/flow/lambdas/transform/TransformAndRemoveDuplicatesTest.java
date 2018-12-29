package ar.com.flow.lambdas.transform;

import static com.google.common.collect.Lists.newArrayList;
import static org.junit.Assert.assertEquals;

import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import ar.com.flow.lambdas.DefaultMetric;
import ar.com.flow.lambdas.Message;
import ar.com.flow.lambdas.Metric;

public class TransformAndRemoveDuplicatesTest {
	TransformAndDeduplicate function = new DefaultTransformAndDeduplicate();

	@Test
	public void transformAndRemoveDuplicates() throws Exception {
		Message message1 = new Message("automobile", "Change tires", 1);
		Message message2 = new Message("automobile", "Paint bumpers", 2);
		Message message3 = new Message("automobile", "Paint bumpers", 2);

		List<Metric> result = function.apply(newArrayList(message1, message2, message3));

		assertEquals(2, result.size());
		Assert.assertEquals(new DefaultMetric(message1.getMessage(), message1.getTick()), result.get(0));
		assertEquals(new DefaultMetric(message2.getMessage(), message2.getTick()), result.get(1));
	}
}
