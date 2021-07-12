package jp.co.ysd.ysd_util.stream;

import java.util.Collection;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
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
public class StreamWrapper<T> {

	private Stream<T> stream;

	StreamWrapper(Collection<T> list) {
		this.stream = list.stream();
	}

	private StreamWrapper(Stream<T> stream) {
		this.stream = stream;
	}

	public Stream<T> getStream() {
		return stream;
	}

	public StreamWrapper<T> concat(StreamWrapper<T> other) {
		return new StreamWrapper<T>(Stream.concat(stream, other.stream));
	}

	public long count() {
		return stream.count();
	}

	public StreamWrapper<T> distinct() {
		return new StreamWrapper<T>(stream.distinct());
	}

	public boolean every(Predicate<T> predicate) {
		return stream.allMatch(predicate);
	}

	public StreamWrapper<T> filter(Predicate<T> predicate) {
		return new StreamWrapper<T>(stream.filter(predicate));
	}

	public T find(Predicate<T> predicate) {
		return find(predicate, null);
	}

	public T find(Predicate<T> predicate, T orElse) {
		return stream.filter(predicate).findFirst().orElse(orElse);
	}

	public <R> StreamWrapper<R> flatMap(Function<T, Stream<R>> mapper) {
		return new StreamWrapper<R>(stream.flatMap(mapper));
	}

	public void forEach(Consumer<T> action) {
		stream.forEach(action);
	}

	public <R> Map<R, List<T>> grouping(Function<T, R> function) {
		return stream.collect(Collectors.groupingBy(function));
	}

	// alias for filter
	public StreamWrapper<T> is(Predicate<T> predicate) {
		return filter(predicate);
	}

	// alias for unfilter
	public StreamWrapper<T> isNot(Predicate<T> predicate) {
		return unfilter(predicate);
	}

	public <R> StreamWrapper<R> map(Function<T, R> mapper) {
		return new StreamWrapper<R>(stream.map(mapper));
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

	public StreamWrapper<T> sort(Comparator<? super T> comparator) {
		return new StreamWrapper<>(stream.sorted(comparator));
	}

	public <V extends Comparable<V>> StreamWrapper<T> sortAsc(Function<T, V> mapper) {
		return sort((l, r) -> mapper.apply(l).compareTo(mapper.apply(r)));
	}

	public <V extends Comparable<V>> StreamWrapper<T> sortDesc(Function<T, V> mapper) {
		return sort((l, r) -> mapper.apply(r).compareTo(mapper.apply(l)));
	}

	public StreamWrapper<T> unfilter(Predicate<T> predicate) {
		return filter(predicate.negate());
	}

	public List<T> end() {
		return stream.collect(Collectors.toList());
	}

	public <K> Map<K, T> end(Function<T, K> keyMapper) {
		return stream.collect(Collectors.toMap(keyMapper, t -> t, (e1, e2) -> e1, LinkedHashMap::new));
	}

	public <K, V> Map<K, V> end(Function<T, K> keyMapper, Function<T, V> valueMapper) {
		return stream.collect(Collectors.toMap(keyMapper, valueMapper, (e1, e2) -> e1, LinkedHashMap::new));
	}

	@SuppressWarnings("unchecked")
	public <K, V> Map<K, V> remap() {
		return end(t -> ((Entry<K, V>) t).getKey(), t -> ((Entry<K, V>) t).getValue());
	}

}
