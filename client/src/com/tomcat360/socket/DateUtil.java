package com.tomcat360.socket;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Logger;

public class DateUtil {

	/** new a Calendar instance */
	static GregorianCalendar cldr = new GregorianCalendar();

	/** the milli second of a day */
	public static final long DAYMILLI = 24 * 60 * 60 * 1000;

	/** the milli seconds of an hour */
	public static final long HOURMILLI = 60 * 60 * 1000;

	/** the milli seconds of a minute */
	public static final long MINUTEMILLI = 60 * 1000;

	/** the milli seconds of a second */
	public static final long SECONDMILLI = 1000;

	/** added time */
	public static final String TIMETO = " 23:59:59";

	/** added time */
	public static final String TIMEFROM = " 00:00:00";

	/**
	 * set the default time zone
	 */
	static {
		cldr.setTimeZone(java.util.TimeZone.getTimeZone("GMT+9:00"));
	}

	/** flag before */
	public static final transient int BEFORE = 1;

	/** flag after */
	public static final transient int AFTER = 2;

	/** flag equal */
	public static final transient int EQUAL = 3;

	/** date format dd/MMM/yyyy:HH:mm:ss +0900 */
	public static final String TIME_PATTERN_LONG = "dd/MMM/yyyy:HH:mm:ss +0900";

	/** date format dd/MM/yyyy:HH:mm:ss +0900 */
	public static final String TIME_PATTERN_LONG2 = "dd/MM/yyyy:HH:mm:ss +0900";

	/** date format yyyy-MM-dd HH:mm:ss */
	public static final String TIME_PATTERN = "yyyy-MM-dd HH:mm";

	/** date format YYYY-MM-DD HH24:MI:SS */
	public static final String DB_TIME_PATTERN = "YYYY-MM-DD HH24:MI:SS";

	/** date format dd/MM/yy HH:mm:ss */
	public static final String TIME_PATTERN_SHORT = "dd/MM/yy HH:mm:ss";

	/** date format dd/MM/yy HH24:mm */
	public static final String TIME_PATTERN_SHORT_1 = "yyyy/MM/dd HH:mm";

	/** date format yyyyMMddHHmmss */
	public static final String TIME_PATTERN_SESSION = "yyyyMMddHHmmss";

	/** date format yyyyMMdd */
	public static final String DATE_FMT_0 = "yyyyMMdd";

	/** date format yyyy/MM/dd */
	public static final String DATE_FMT_1 = "yyyy/MM/dd";

	/** date format yyyy/MM/dd hh:mm:ss */
	public static final String DATE_FMT_2 = "yyyy/MM/dd hh:mm:ss";

	/** date format yyyy-MM-dd */
	public static final String DATE_FMT_3 = "yyyy-MM-dd";

	/** date format YYYYMMDD */
	public static final String DATE_FMT_4 = "YYYYMMDD";

	/** date format yyyy-MM-dd HH:mm:ss */
	public static final String DATE_FMT_5 = "yyyy-MM-dd HH:mm:ss";

	/**
	 * 比较日期是否介于两者之间
	 * 
	 * @param date
	 *            the specified date
	 * @param begin
	 *            date1
	 * @param end
	 *            date2
	 * 
	 * @return true - between date1 and date2 false - not between date1 and
	 *         date2
	 */
	public static boolean isDateBetween(Date date, Date begin, Date end) {
		int c1 = compareTwoDate(begin, date);
		int c2 = compareTwoDate(date, end);

		return (((c1 == BEFORE) && (c2 == BEFORE)) || (c1 == EQUAL) || (c2 == EQUAL));
	}

	/**
	 * 比较两个日期的先后顺序
	 * 
	 * @param first
	 *            date1
	 * @param second
	 *            date2
	 * 
	 * @return EQUAL - if equal BEFORE - if before than date2 AFTER - if over
	 *         than date2
	 */
	public static int compareTwoDate(Date first, Date second) {
		if ((first == null) && (second == null)) {
			return EQUAL;
		} else if (first == null) {
			return BEFORE;
		} else if (second == null) {
			return AFTER;
		} else if (first.before(second)) {
			return BEFORE;
		} else if (first.after(second)) {
			return AFTER;
		} else {
			return EQUAL;
		}
	}

}
