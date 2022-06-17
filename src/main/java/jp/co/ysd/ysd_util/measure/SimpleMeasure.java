package jp.co.ysd.ysd_util.measure;

public final class SimpleMeasure {

	private long startTime = System.currentTimeMillis();
	private long stopTime = 0;

	private SimpleMeasure() {
	}

	public static SimpleMeasure start() {
		return new SimpleMeasure();
	}

	public void stop() {
		this.stopTime = System.currentTimeMillis();
	}

	public String result() {
		long time = stopTime - startTime;
		return time + "[ms]";
	}

	public void show() {
		System.out.println();
		System.out.println();
		System.out.println(result());
		System.out.println();
		System.out.println();
	}

}
