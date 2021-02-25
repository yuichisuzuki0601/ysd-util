package jp.co.ysd.ysd_util.stream;

import java.util.Map;
import java.util.Map.Entry;

/**
 *
 * @author yuichi
 *
 * @param <K>
 * @param <V>
 */
public class MapWrapper<K, V> extends CollectionWrapper<Entry<K, V>> {

	MapWrapper(Map<K, V> map) {
		super(map.entrySet());
	}

}
