package jp.co.ysd.ysd_util.date;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author yuichi
 *
 */
public final class YsdDateUtil {

	public static String date(Date date) {
		return YsdCalendarUtil.date(YsdCalendarUtil.getCalendar(date));
	}

	public static Date date(String s) throws ParseException {
		return YsdCalendarUtil.date(s).getTime();
	}

	public static String time(Date date) {
		return YsdCalendarUtil.time(YsdCalendarUtil.getCalendar(date));
	}

	public static Date time(String s) throws ParseException {
		return YsdCalendarUtil.time(s).getTime();
	}

	public static String datetime(Date date) {
		return YsdCalendarUtil.datetime(YsdCalendarUtil.getCalendar(date));
	}

	public static Date datetime(String s) throws ParseException {
		return YsdCalendarUtil.datetime(s).getTime();
	}

	public static Date add(Date date, int field, int amount) {
		Calendar cal = YsdCalendarUtil.getCalendar(date);
		cal.add(field, amount);
		return cal.getTime();
	}

	public static Date addMonth(Date date, int amount) {
		return add(date, Calendar.MONTH, amount);
	}

	public static Date addDate(Date date, int amount) {
		return add(date, Calendar.DATE, amount);
	}

	public static Date getLastDatetimeOfMonthDate(Date date) {
		return YsdCalendarUtil.getLastDatetimeOfMonthCalendar(YsdCalendarUtil.getCalendar(date)).getTime();
	}

}
