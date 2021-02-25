package jp.co.ysd.ysd_util.tuple;

/**
 *
 * @author yuichi
 *
 * @param <A>
 * @param <B>
 * @param <C>
 */
public class Tuple3<A, B, C> extends Tuple2<A, B> {

	protected final C three;

	public Tuple3(A one, B two, C three) {
		super(one, two);
		this.three = three;
	}

	public Tuple3(Tuple2<A, B> t, C three) {
		super(t.one, t.two);
		this.three = three;
	}

	public Tuple3(A one, Tuple2<B, C> t) {
		super(one, t.one);
		this.three = t.two;
	}

	public C three() {
		return three;
	}

	@Override
	public String toString() {
		return "(" + one + ", " + two + ", " + three + ")";
	}

}
