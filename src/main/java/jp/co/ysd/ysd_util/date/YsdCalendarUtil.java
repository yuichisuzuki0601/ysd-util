package jp.co.ysd.ysd_util.date;

import static java.util.Calendar.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Calendar.Builder;
import java.util.Date;

/**
 *
 * @author yuichi
 *
 */
public final class YsdCalendarUtil {

	private static final String DATE_FORMAT_STR = "yyyy-MM-dd";
	private static final String TIME_FORMAT_STR = "HH:mm:ss";

	private static final DateFormat DATE_FORMAT = new SimpleDateFormat(DATE_FORMAT_STR);
	private static final DateFormat TIME_FORMAT = new SimpleDateFormat(TIME_FORMAT_STR);
	private static final DateFormat DATETIME_FORMAT = new SimpleDateFormat(DATE_FORMAT_STR + " " + TIME_FORMAT_STR);
	static {
		DATE_FORMAT.setLenient(false);
		TIME_FORMAT.setLenient(false);
		DATETIME_FORMAT.setLenient(false);
	}

	private YsdCalendarUtil() {
	}

	public static String date(Calendar c) {
		return DATE_FORMAT.format(c.getTime());
	}

	public static Calendar date(String s) throws ParseException {
		return new Builder().setInstant(DATE_FORMAT.parse(s)).build();
	}

	public static String time(Calendar c) {
		return TIME_FORMAT.format(c.getTime());
	}

	public static Calendar time(String s) throws ParseException {
		return new Builder().setInstant(TIME_FORMAT.parse(s)).build();
	}

	public static String datetime(Calendar c) {
		return DATETIME_FORMAT.format(c.getTime());
	}

	public static Calendar datetime(String s) throws ParseException {
		return new Builder().setInstant(DATETIME_FORMAT.parse(s)).build();
	}

	public static String diff(Calendar before, Calendar after) {
		long diff = (after.getTimeInMillis() - before.getTimeInMillis()) / 1000;
		long h = diff / 3600;
		diff %= 3600;
		long m = diff / 60;
		diff %= 60;
		long s = diff;
		return String.format("%02d:%02d:%02d", h, m, s);
	}

	public static Calendar getCalendar(long instant) {
		return new Builder().setInstant(instant).build();
	}

	public static Calendar getCalendar(Date instant) {
		return new Builder().setInstant(instant).build();
	}

	public static Calendar getCalendar(int y, int M, int d) {
		return getCalendarBuilder(y, M - 1, d).build();
	}

	public static Calendar getCalendar(int y, int M, int d, int h, int m, int s) {
		return getCalendarBuilder(y, M - 1, d).setTimeOfDay(h, m, s).build();
	}

	public static Calendar getFirstDatetimeOfMonthCalendar(Calendar cal) {
		Arrays.stream(new Integer[] { DATE, HOUR_OF_DAY, MINUTE, SECOND, MILLISECOND }).forEach((f) -> {
			cal.set(f, cal.getActualMinimum(f));
		});
		return cal;
	}

	public static Calendar getLastDatetimeOfMonthCalendar(Calendar cal) {
		Arrays.stream(new Integer[] { DATE, HOUR_OF_DAY, MINUTE, SECOND, MILLISECOND }).forEach((f) -> {
			cal.set(f, cal.getActualMaximum(f));
		});
		return cal;
	}

	private static Builder getCalendarBuilder(int y, int M, int d) {
		return new Builder().setDate(y, M, d);
	}

}
