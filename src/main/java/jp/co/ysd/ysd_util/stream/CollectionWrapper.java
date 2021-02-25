package jp.co.ysd.ysd_util.stream;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *
 * @author yuichi
 *
 * @param <T>
 */
public class CollectionWrapper<T> {

	private Stream<T> stream;

	CollectionWrapper(Collection<T> list) {
		this.stream = list.stream();
	}

	private CollectionWrapper(Stream<T> stream) {
		this.stream = stream;
	}

	public Stream<T> getStream() {
		return stream;
	}

	public CollectionWrapper<T> concat(CollectionWrapper<T> other) {
		return new CollectionWrapper<T>(Stream.concat(stream, other.stream));
	}

	public long count() {
		return stream.count();
	}

	public CollectionWrapper<T> distinct() {
		return new CollectionWrapper<T>(stream.distinct());
	}

	public boolean every(Predicate<T> predicate) {
		return stream.allMatch(predicate);
	}

	public CollectionWrapper<T> filter(Predicate<T> predicate) {
		return new CollectionWrapper<T>(stream.filter(predicate));
	}

	public T find(Predicate<T> predicate) {
		return find(predicate, null);
	}

	public T find(Predicate<T> predicate, T orElse) {
		return stream.filter(predicate).findFirst().orElse(orElse);
	}

	public <R> CollectionWrapper<R> flatMap(Function<T, Stream<R>> mapper) {
		return new CollectionWrapper<R>(stream.flatMap(mapper));
	}

	public void forEach(Consumer<T> action) {
		stream.forEach(action);
	}

	public <R> Map<R, List<T>> grouping(Function<T, R> function) {
		return stream.collect(Collectors.groupingBy(function));
	}

	public <R> CollectionWrapper<R> map(Function<T, R> mapper) {
		return new CollectionWrapper<R>(stream.map(mapper));
	}

	public T max(Comparator<T> comparator) {
		return max(comparator, null);
	}

	public T max(Comparator<T> comparator, T orElse) {
		return stream.max(comparator).orElse(orElse);
	}

	public T min(Comparator<T> comparator) {
		return min(comparator, null);
	}

	public T min(Comparator<T> comparator, T orElse) {
		return stream.min(comparator).orElse(orElse);
	}

	public T reduce(BinaryOperator<T> accumulator) {
		return reduce(accumulator, null);
	}

	public T reduce(BinaryOperator<T> accumulator, T orElse) {
		return stream.reduce(accumulator).orElse(orElse);
	}

	public boolean some(Predicate<T> predicate) {
		return stream.anyMatch(predicate);
	}

	public CollectionWrapper<T> sort(Comparator<? super T> comparator) {
		return new CollectionWrapper<>(stream.sorted(comparator));
	}

	public List<T> end() {
		return stream.collect(Collectors.toList());
	}

	public <K> Map<K, T> end(Function<T, K> keyMapper) {
		return stream.collect(Collectors.toMap(keyMapper, t -> t));
	}

}
