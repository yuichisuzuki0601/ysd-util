package jp.co.ysd.ysd_util.map;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.StringJoiner;

/**
 *
 * @author yuichi
 *
 */
public class DoubleKeyMap<K1, K2, V> {

	private Map<K1, Map<K2, V>> parent = new HashMap<>();

	public DoubleKeyMap<K1, K2, V> put(K1 key1, K2 key2, V value) {
		Map<K2, V> child = parent.get(key1);
		if (child == null) {
			child = new HashMap<>();
		}
		child.put(key2, value);
		parent.put(key1, child);
		return this;
	}

	public V get(K1 key1, K2 key2) {
		Map<K2, V> child = parent.get(key1);
		if (child == null) {
			return null;
		}
		return child.get(key2);
	}

	@Override
	public String toString() {
		StringJoiner sj = new StringJoiner(", ", "{", "}");
		for (Entry<K1, Map<K2, V>> e1 : parent.entrySet()) {
			for (Entry<K2, V> e2 : e1.getValue().entrySet()) {
				sj.add(e1.getKey() + "-" + e2.getKey() + ": " + e2.getValue());
			}
		}
		return sj.toString();
	}

}
