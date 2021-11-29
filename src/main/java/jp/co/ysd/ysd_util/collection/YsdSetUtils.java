package jp.co.ysd.ysd_util.collection;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * 
 * @author yuichi
 *
 */
public final class YsdSetUtils {

	public static <E> Set<E> subtract(final Set<E> set1, final Set<E> set2) {
		final ArrayList<E> result = new ArrayList<>(set1);
		final Iterator<E> iterator = set2.iterator();
		while (iterator.hasNext()) {
			result.remove(iterator.next());
		}
		return new HashSet<>(result);
	}

	public static <E> Set<E> intersection(final Set<E> set1, final Set<E> set2) {
		final ArrayList<E> result = new ArrayList<>();
		final Iterator<E> iterator = set2.iterator();
		while (iterator.hasNext()) {
			final E o = iterator.next();
			if (set1.contains(o)) {
				result.add(o);
			}
		}
		return new HashSet<>(result);
	}

}
