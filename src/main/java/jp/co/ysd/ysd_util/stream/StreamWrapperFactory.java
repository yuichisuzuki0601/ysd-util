package jp.co.ysd.ysd_util.stream;

import java.util.Arrays;
import java.util.Collection;
import java.util.Map;
import java.util.Map.Entry;

/**
 *
 * @author yuichi
 *
 */
public final class StreamWrapperFactory {

	private StreamWrapperFactory() {
	}

	public static <T> StreamWrapper<T> stream(T[] array) {
		return new StreamWrapper<>(Arrays.asList(array));
	}

	public static <T> StreamWrapper<T> stream(Collection<T> collection) {
		return new StreamWrapper<>(collection);
	}

	public static <K, V> StreamWrapper<Entry<K, V>> stream(Map<K, V> map) {
		return new StreamWrapper<>(map.entrySet());
	}

}
