package jp.co.ysd.ysd_util.tuple;

/**
 *
 * @author yuichi
 *
 * @param <A>
 * @param <B>
 * @param <C>
 * @param <D>
 */
public class Tuple4<A, B, C, D> extends Tuple3<A, B, C> {

	protected final D four;

	public Tuple4(A one, B two, C three, D four) {
		super(one, two, three);
		this.four = four;
	}

	public Tuple4(Tuple2<A, B> t, C three, D four) {
		super(t.one, t.two, three);
		this.four = four;
	}

	public Tuple4(A one, Tuple2<B, C> t, D four) {
		super(one, t.one, t.two);
		this.four = four;
	}

	public Tuple4(A one, B two, Tuple2<C, D> t) {
		super(one, two, t.one);
		this.four = t.two;
	}

	public Tuple4(Tuple3<A, B, C> t, D four) {
		super(t.one, t.two, t.three);
		this.four = four;
	}

	public Tuple4(A one, Tuple3<B, C, D> t) {
		super(one, t.one, t.two);
		this.four = t.three;
	}

	public D four() {
		return four;
	}

	@Override
	public String toString() {
		return "(" + one + ", " + two + ", " + three + ", " + four + ")";
	}

}
