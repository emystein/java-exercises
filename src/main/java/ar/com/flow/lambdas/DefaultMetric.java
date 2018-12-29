package ar.com.flow.lambdas;

public class DefaultMetric implements Metric {
    private String name;
    private int value;

    public DefaultMetric(String name, int value) {
        this.name = name;
        this.value = value;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getValue() {
        return value;
    }

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		DefaultMetric that = (DefaultMetric) o;

		if (value != that.value) return false;
		return name != null ? name.equals(that.name) : that.name == null;
	}

	@Override
	public int hashCode() {
		int result = name != null ? name.hashCode() : 0;
		result = 31 * result + value;
		return result;
	}
}
