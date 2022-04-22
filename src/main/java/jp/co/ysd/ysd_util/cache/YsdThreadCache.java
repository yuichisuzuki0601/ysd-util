package jp.co.ysd.ysd_util.cache;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 *
 * @author yuichi
 *
 */
public final class YsdThreadCache {

	private static Map<Thread, Map<String, Object>> threadMaps = new ConcurrentHashMap<>();

	private static void invalidateDeadThreadCache() {
		for (Iterator<Thread> it = threadMaps.keySet().iterator(); it.hasNext();) {
			Thread thread = it.next();
			if (!thread.isAlive()) {
				threadMaps.remove(thread);
			}
		}
	}

	public static void invalidateCurrentThreadCache() {
		threadMaps.remove(Thread.currentThread());
	}

	public static Object get(String key) {
		invalidateDeadThreadCache();
		Map<String, Object> map = threadMaps.get(Thread.currentThread());
		if (map == null) {
			return null;
		} else {
			return map.get(key);
		}
	}

	@SuppressWarnings("unchecked")
	public static <T> T getOrDefault(String key, T defaultValue) {
		T value = (T) get(key);
		return value != null ? value : defaultValue;
	}

	public static void put(String key, Object value) {
		invalidateDeadThreadCache();
		Thread thread = Thread.currentThread();
		Map<String, Object> map = threadMaps.get(thread);
		if (map == null) {
			map = new HashMap<>();
		}
		map.put(key, value);
		threadMaps.put(thread, map);
	}

}
