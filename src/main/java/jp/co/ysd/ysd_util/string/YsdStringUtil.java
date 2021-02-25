package jp.co.ysd.ysd_util.string;

/**
 *
 * @author yuichi
 *
 */
public final class YsdStringUtil {

	private YsdStringUtil() {
	}

	/**
	 * 改行、タブ、連続スペースなどを全て半角スペースに変換します
	 *
	 * @param org
	 * @return
	 */
	public static String strip(String org) {
		String dest = org.replaceAll("[\\r|\\n|\\\t]", " ");
		dest = dest.trim();
		dest = dest.replaceAll(" {2,}", " ");
		return dest;
	}

	/**
	 * 0埋めします
	 *
	 * @param org
	 * @param digit
	 * @return
	 */
	public static String zeroPadding(String org, int digit) {
		return String.format("%" + digit + "s", org).replace(" ", "0");
	}

	/**
	 * 先頭の連続した0を除去します
	 *
	 * @param org
	 * @return
	 */
	public static String zeroSuppress(Object org) {
		String result = org.toString().replaceFirst("^0+", "");
		return result != null && !result.equals("") ? result : "0";
	}

}
