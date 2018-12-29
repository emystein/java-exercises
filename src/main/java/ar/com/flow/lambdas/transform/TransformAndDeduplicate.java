package ar.com.flow.lambdas.transform;

import java.util.List;
import ar.com.flow.lambdas.Message;
import ar.com.flow.lambdas.Metric;

public interface TransformAndDeduplicate {
	List<Metric> apply(List<Message> input);
}
