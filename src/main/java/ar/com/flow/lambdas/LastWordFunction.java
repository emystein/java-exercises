package ar.com.flow.lambdas;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class LastWordFunction implements Function<String, String> {
	@Override
	public String apply(String input) {
		Map<Integer, List<String>> wordsByLength = Arrays.stream(input.split("\\s+"))
				.collect(Collectors.groupingBy(s -> s.length(), Collectors.toList()));

		Integer max = wordsByLength.keySet().stream().mapToInt(v -> v).max().getAsInt();

		// get last word from the list of words with max length
		return wordsByLength.get(max).stream().reduce((a, b) -> b).get();
	}

	public class WordAndLength {
		private final String word;
		private final int length;

		public WordAndLength(int length, String word) {
			this.word = word;
			this.length = length;
		}

		public String getWord() {
			return word;
		}

		public int getLength() {
			return length;
		}
	}

	public class WordAndLengthComparator implements Comparator<WordAndLength> {

		@Override
		public int compare(WordAndLength o1, WordAndLength o2) {
			return Integer.valueOf(o1.length).compareTo(Integer.valueOf(o2.length));
		}
	}

}
