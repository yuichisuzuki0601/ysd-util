package jp.co.ysd.ysd_util.date;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

/**
 * 
 * @author yuichi
 *
 */
public final class YsdTimezoneUtil {

	private static final String DEFAULT_FORMAT_PATTERN = "yyyy-MM-dd HH:mm:ss";

	/**
	 * <pre>
	 * 第一引数に渡された日時を
	 * 第二引数のタイムゾーンの日時と見做して
	 * 第三引数のタイムゾーンの日時に
	 * 変換します
	 * </pre>
	 * 
	 * @param datetime
	 * @param fromZoneId
	 * @param toZoneId
	 * @return 変換後の日時
	 */
	public static String calculate(String datetime, String fromZoneId, String toZoneId) {
		return calculate(datetime, fromZoneId, toZoneId, DEFAULT_FORMAT_PATTERN);
	}

	public static String calculate(String datetime, String fromZoneId, String toZoneId, String formatPattern) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(formatPattern);
		LocalDateTime ldt = LocalDateTime.parse(datetime, formatter);
		ZonedDateTime from = ldt.atZone(ZoneId.of(fromZoneId));
		ZonedDateTime to = from.withZoneSameInstant(ZoneId.of(toZoneId));
		return to.format(formatter);
	}

}
