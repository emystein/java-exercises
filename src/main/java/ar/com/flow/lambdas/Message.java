package ar.com.flow.lambdas;

public class Message {
	private final String category;
	private final String message;
	private final int tick;

	public Message(String category, String message, int tick) {
		this.category = category;
		this.message = message;
		this.tick = tick;
	}

	public String getCategory() {
		return category;
	}

	public String getMessage() {
		return message;
	}

	public int getTick() {
		return tick;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Message message1 = (Message) o;

		if (tick != message1.tick) return false;
		if (!category.equals(message1.category)) return false;
		return message.equals(message1.message);
	}

	@Override
	public int hashCode() {
		int result = category.hashCode();
		result = 31 * result + message.hashCode();
		result = 31 * result + tick;
		return result;
	}
}
