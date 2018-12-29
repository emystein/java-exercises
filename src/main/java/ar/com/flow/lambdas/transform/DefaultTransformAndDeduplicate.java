package ar.com.flow.lambdas.transform;

import static java.util.stream.Collectors.toList;

import java.util.List;
import ar.com.flow.lambdas.Message;
import ar.com.flow.lambdas.Metric;

public class DefaultTransformAndDeduplicate implements TransformAndDeduplicate {
	@Override
	public List<Metric> apply(List<Message> input) {
		return input.stream().map(new MessageToMetric()).distinct().collect(toList());
	}
}
