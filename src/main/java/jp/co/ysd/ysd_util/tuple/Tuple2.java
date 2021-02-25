package jp.co.ysd.ysd_util.tuple;

/**
 *
 * @author yuichi
 *
 * @param <A>
 * @param <B>
 */
public class Tuple2<A, B> {

	protected final A one;
	protected final B two;

	public Tuple2(A one, B two) {
		this.one = one;
		this.two = two;
	}

	public A one() {
		return one;
	}

	public B two() {
		return two;
	}

	@Override
	public String toString() {
		return "(" + one + ", " + two + ")";
	}

}
