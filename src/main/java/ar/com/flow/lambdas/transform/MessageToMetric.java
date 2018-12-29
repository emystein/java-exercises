package ar.com.flow.lambdas.transform;

import java.util.function.Function;
import ar.com.flow.lambdas.DefaultMetric;
import ar.com.flow.lambdas.Message;
import ar.com.flow.lambdas.Metric;

public class MessageToMetric implements Function<Message, Metric> {
	@Override
	public Metric apply(Message message) {
		return new DefaultMetric(message.getMessage(), message.getTick());
	}
}
