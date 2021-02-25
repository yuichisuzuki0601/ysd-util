package jp.co.ysd.ysd_util.stream;

import java.util.Arrays;
import java.util.Collection;
import java.util.Map;

/**
 *
 * @author yuichi
 *
 */
public final class StreamWrapperFactory {

	private StreamWrapperFactory() {
	}

	public static <T> CollectionWrapper<T> stream(Collection<T> list) {
		return new CollectionWrapper<>(list);
	}

	public static <T> CollectionWrapper<T> stream(T[] array) {
		return new CollectionWrapper<>(Arrays.asList(array));
	}

	public static <K, V> MapWrapper<K, V> stream(Map<K, V> map) {
		return new MapWrapper<>(map);
	}

}
