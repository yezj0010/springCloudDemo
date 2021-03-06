package com.tomcat360.admin.util;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 提供日期的加减转换等功能 包含多数常用的日期格式
 * 
 * @author tongyi
 * @date Jul 29, 2013
 * 
 */
public class CalendarUtil {

	private static final Logger logger = LoggerFactory.getLogger(CalendarUtil.class);

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
	 * change string to string 将String类型的unix时间戳转成String类型的日期
	 * 
	 * @throws ParseException
	 * 
	 */
	public static String unixToString(String unixtime) throws ParseException {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(TIME_PATTERN);
		Date date = simpleDateFormat.parse(unixtime);
		return date.toString();
	}

	/**
	 * Java将Unix时间戳转换成指定格式日期字符串
	 * 
	 * @param timestampString
	 *            时间戳 如："1473048265";
	 *            要格式化的格式 默认："yyyy-MM-dd HH:mm:ss";
	 *
	 * @return 返回结果 如："2016-09-05 16:06:42";
	 */
	public static String TimeStamp2Date(String timestampString) {
		String formats = TIME_PATTERN;
		Long timestamp = Long.parseLong(timestampString) * 1000;
		String date = new SimpleDateFormat(formats).format(new Date(timestamp));
		return date;
	}

	/**
	 * change string to date 将String类型的日期转成Date类型
	 * 
	 * @param sDate
	 *            the date string
	 * @param sFmt
	 *            the date format
	 * 
	 * @return Date object
	 */
	public static Date toDate(String sDate, String sFmt) {
		if (StringUtils.isBlank(sDate) || StringUtils.isBlank(sFmt)) {
			return null;
		}

		SimpleDateFormat sdfFrom = null;
		Date dt = null;
		try {
			sdfFrom = new SimpleDateFormat(sFmt);
			dt = sdfFrom.parse(sDate);
		} catch (Exception ex) {
			logger.error("CalendarUtil toDate(String, String) error." + ex.getMessage());
			return null;
		} finally {
			sdfFrom = null;
		}

		return dt;
	}

	/**
	 * change date to string 将日期类型的参数转成String类型
	 * 
	 * @param dt
	 *            a date
	 * 
	 * @return the format string
	 */
	public static String toString(Date dt) {
		return toString(dt, DATE_FMT_0);
	}

	/**
	 * change date object to string 将String类型的日期转成Date类型
	 * 
	 * @param dt
	 *            date object
	 * @param sFmt
	 *            the date format
	 * 
	 * @return the formatted string
	 */
	public static String toString(Date dt, String sFmt) {
		if (null == dt || StringUtils.isBlank(sFmt)) {
			return null;
		}

		SimpleDateFormat sdfFrom = null;
		String sRet = null;
		try {
			sdfFrom = new SimpleDateFormat(sFmt);
			sRet = sdfFrom.format(dt).toString();
		} catch (Exception ex) {
			logger.error("CalendarUtil toString(Date, String) error." + ex.getMessage());
			return null;
		} finally {
			sdfFrom = null;
		}

		return sRet;
	}

	/**
	 * 获取Date所属月的最后一天日期
	 * 
	 * @param date
	 * @return Date 默认null
	 */
	public static Date getMonthLastDate(Date date) {
		if (null == date) {
			return null;
		}

		Calendar ca = Calendar.getInstance();
		ca.setTime(date);
		ca.set(Calendar.HOUR_OF_DAY, 23);
		ca.set(Calendar.MINUTE, 59);
		ca.set(Calendar.SECOND, 59);
		ca.set(Calendar.DAY_OF_MONTH, 1);
		ca.add(Calendar.MONTH, 1);
		ca.add(Calendar.DAY_OF_MONTH, -1);

		Date lastDate = ca.getTime();
		return lastDate;
	}

	/**
	 * 获取Date所属月的最后一天日期
	 * 
	 * @param date
	 * @param pattern
	 * @return String 默认null
	 */
	public static String getMonthLastDate(Date date, String pattern) {
		Date lastDate = getMonthLastDate(date);
		if (null == lastDate) {
			return null;
		}

		if (StringUtils.isBlank(pattern)) {
			pattern = TIME_PATTERN;
		}

		return toString(lastDate, pattern);
	}

	/**
	 * 获取Date所属月的第一天日期
	 * 
	 * @param date
	 * @return Date 默认null
	 */
	public static Date getMonthFirstDate(Date date) {
		if (null == date) {
			return null;
		}

		Calendar ca = Calendar.getInstance();
		ca.setTime(date);
		ca.set(Calendar.HOUR_OF_DAY, 0);
		ca.set(Calendar.MINUTE, 0);
		ca.set(Calendar.SECOND, 0);
		ca.set(Calendar.DAY_OF_MONTH, 1);

		Date firstDate = ca.getTime();
		return firstDate;
	}

	/**
	 * 获取Date所属月的第一天日期
	 * 
	 * @param date
	 * @param pattern
	 * @return String 默认null
	 */
	public static String getMonthFirstDate(Date date, String pattern) {
		Date firstDate = getMonthFirstDate(date);
		if (null == firstDate) {
			return null;
		}

		if (StringUtils.isBlank(pattern)) {
			pattern = TIME_PATTERN;
		}

		return toString(firstDate, pattern);
	}

	/**
	 * 获取昨天的日期
	 * 
	 * @param pattern
	 * @return String 默认null
	 */
	public static String getYesterdayDate(String pattern) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		cal.add(Calendar.DATE, -1);

		if (StringUtils.isBlank(pattern)) {
			pattern = TIME_PATTERN;
		}

		return toString(cal.getTime(), pattern);
	}

	/**
	 * 计算两个日期间隔的天数
	 * 
	 * @param firstDate
	 *            小者
	 * @param lastDate
	 *            大者
	 * @return int 默认-1
	 */
	public static int getIntervalDays(Date firstDate, Date lastDate) {
		if (null == firstDate || null == lastDate) {
			return -1;
		}

		long intervalMilli = lastDate.getTime() - firstDate.getTime();
		return (int) (intervalMilli / (24 * 60 * 60 * 1000));
	}

	/**
	 * 计算两个日期间隔的小时数
	 * 
	 * @param firstDate
	 *            小者
	 * @param lastDate
	 *            大者
	 * @return int 默认-1
	 */
	public static int getTimeIntervalHours(Date firstDate, Date lastDate) {
		if (null == firstDate || null == lastDate) {
			return -1;
		}

		long intervalMilli = lastDate.getTime() - firstDate.getTime();
		return (int) (intervalMilli / (60 * 60 * 1000));
	}

	/**
	 * 计算两个日期间隔的分钟数
	 * 
	 * @param firstDate
	 *            小者
	 * @param lastDate
	 *            大者
	 * @return int 默认-1
	 */
	public static int getTimeIntervalMins(Date firstDate, Date lastDate) {
		if (null == firstDate || null == lastDate) {
			return -1;
		}

		long intervalMilli = lastDate.getTime() - firstDate.getTime();
		return (int) (intervalMilli / (60 * 1000));
	}

	/**
	 * format the date in given pattern 格式化日期
	 * 
	 * @param d
	 *            date
	 * @param pattern
	 *            time pattern
	 * @return the formatted string
	 */
	public static String formatDate(Date d, String pattern) {
		if (null == d || StringUtils.isBlank(pattern)) {
			return null;
		}

		SimpleDateFormat formatter = (SimpleDateFormat) DateFormat.getDateInstance();

		formatter.applyPattern(pattern);
		return formatter.format(d);
	}

	/**
	 * 比较两个日期的先后顺序
	 * 
	 * @param src
	 * @param desc
	 * @return
	 */
	public static int compareDate(Date src, Date desc) {
		if ((src == null) && (desc == null)) {
			return EQUAL;
		} else if (desc == null) {
			return BEFORE;
		} else if (src == null) {
			return AFTER;
		} else {
			long timeSrc = src.getTime();
			long timeDesc = desc.getTime();

			if (timeSrc == timeDesc) {
				return EQUAL;
			} else {
				return (timeDesc > timeSrc) ? AFTER : BEFORE;
			}
		}
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
	 * 比较日期是否介于当前日期的前后数天内
	 * 
	 * @param myDate
	 * @param begin
	 * @param end
	 * @return
	 */
	public static boolean isDateBetween(Date myDate, int begin, int end) {
		return isDateBetween(myDate, getCurrentDateTime(), begin, end);
	}

	/**
	 * 比较日期是否介于指定日期的前后数天内
	 * 
	 * @param utilDate
	 * @param dateBaseLine
	 * @param begin
	 * @param end
	 * @return
	 */
	public static boolean isDateBetween(Date utilDate, Date dateBaseLine, int begin, int end) {
		String pattern = TIME_PATTERN;

		String my = toString(utilDate, pattern);
		Date myDate = toDate(my, pattern);

		String baseLine = toString(dateBaseLine, pattern);

		// Date baseLineDate = parseString2Date(baseLine, pattern);
		String from = addDays(baseLine, begin);
		Date fromDate = toDate(from, pattern);

		String to = addDays(baseLine, end);
		Date toDate = toDate(to, pattern);

		return isDateBetween(myDate, fromDate, toDate);
	}

	/**
	 * 增加天数
	 * 
	 * @param date
	 * @param day
	 * @return Date
	 */
	public static Date addDate(Date date, int day) {
		if (null == date) {
			return null;
		}
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.DAY_OF_MONTH, calendar.get(Calendar.DAY_OF_MONTH) + day);
		return calendar.getTime();
	}

	/**
	 * 增加天数
	 * 
	 * @param date
	 * @param day
	 * @param pattern
	 * @return
	 */
	public static String addDays(Date date, int day, String pattern) {
		return addDays(toString(date, pattern), day, pattern);
	}

	/**
	 * 增加天数
	 * 
	 * @param date
	 * @param day
	 * @return
	 */
	public static String addDays(Date date, int day) {
		return addDays(toString(date, TIME_PATTERN), day);
	}

	/**
	 * 增加天数
	 * 
	 * @param date
	 * @param day
	 * @return
	 */
	public static String addDays(String date, int day) {
		return addDays(date, day, TIME_PATTERN);
	}

	/**
	 * get the time of the specified date after given days
	 * 
	 * @param date
	 *            the specified date
	 * @param day
	 *            day distance
	 * 
	 * @return the format string of time
	 */
	public static String addDays(String date, int day, String pattern) {
		if (date == null) {
			return "";
		}

		if (date.equals("")) {
			return "";
		}

		if (day == 0) {
			return date;
		}

		try {
			SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
			Calendar calendar = dateFormat.getCalendar();

			calendar.setTime(dateFormat.parse(date));
			calendar.set(Calendar.DAY_OF_MONTH, calendar.get(Calendar.DAY_OF_MONTH) + day);
			return dateFormat.format(calendar.getTime());
		} catch (Exception ex) {
			logger.error("CalendarUtil addDays(String, int, String) error." + ex.getMessage());
			return "";
		}
	}

	/**
	 * change timestamp to formatted string
	 * 
	 * @param t
	 *            Timestamp
	 * @param sFmt
	 *            date format
	 * 
	 * @return formatted string
	 */
	public static String formatTimestamp(Timestamp t, String sFmt) {
		if (t == null || StringUtils.isBlank(sFmt)) {
			return "";
		}

		t.setNanos(0);

		DateFormat ft = new SimpleDateFormat(sFmt);
		String str = "";

		try {
			str = ft.format(t);
		} catch (NullPointerException ex) {
			logger.error("CalendarUtil formatTimestamp error." + ex.getMessage());
		}

		return str;
	}

	/**
	 * return current date
	 * 
	 * @return current date
	 */
	public static Date getCurrentDate() {
		return new Date(System.currentTimeMillis());
	}

	/**
	 * return current calendar instance
	 * 
	 * @return Calendar
	 */
	public static Calendar getCurrentCalendar() {
		return Calendar.getInstance();
	}

	/**
	 * return current time
	 * 
	 * @return current time
	 */
	public static Timestamp getCurrentDateTime() {
		return new Timestamp(System.currentTimeMillis());
	}

	/**
	 * 获取年份
	 * 
	 * @param date
	 *            Date
	 * @return int
	 */
	public static final int getYear(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar.get(Calendar.YEAR);
	}

	/**
	 * 获取年份
	 * 
	 * @param millis
	 *            long
	 * @return int
	 */
	public static final int getYear(long millis) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(millis);
		return calendar.get(Calendar.YEAR);
	}

	/**
	 * 获取月份
	 * 
	 * @param date
	 *            Date
	 * @return int
	 */
	public static final int getMonth(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar.get(Calendar.MONTH) + 1;
	}

	/**
	 * 获取月份
	 * 
	 * @param millis
	 *            long
	 * @return int
	 */
	public static final int getMonth(long millis) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(millis);
		return calendar.get(Calendar.MONTH) + 1;
	}

	/**
	 * 获取日期
	 * 
	 * @param date
	 *            Date
	 * @return int
	 */
	public static final int getDate(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar.get(Calendar.DATE);
	}

	/**
	 * 获取日期
	 * 
	 * @param millis
	 *            long
	 * @return int
	 */
	public static final int getDate(long millis) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(millis);
		return calendar.get(Calendar.DATE);
	}

	/**
	 * 获取小时
	 * 
	 * @param date
	 *            Date
	 * @return int
	 */
	public static final int getHour(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar.get(Calendar.HOUR_OF_DAY);
	}

	/**
	 * 获取小时
	 * 
	 * @param millis
	 *            long
	 * @return int
	 */
	public static final int getHour(long millis) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(millis);
		return calendar.get(Calendar.HOUR_OF_DAY);
	}

	/**
	 * 把日期后的时间归0 变成(yyyy-MM-dd 00:00:00:000)
	 *
	 *            Date
	 * @return Date
	 */
	public static final Date zerolizedTime(Date fullDate) {
		Calendar cal = Calendar.getInstance();
		System.err.println("测试-----------------" + fullDate);
		cal.setTime(fullDate);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		return cal.getTime();
	}

	
	public static String getDateDistanceTime(Date currentTime, Date firstTime){
		long diff = currentTime.getTime() - firstTime.getTime();// 这样得到的差值是微秒级别
		Calendar currentTimes = dataToCalendar(currentTime);// 当前系统时间转Calendar类型
		Calendar firstTimes = dataToCalendar(firstTime);// 查询的数据时间转Calendar类型
		int year = currentTimes.get(Calendar.YEAR) - firstTimes.get(Calendar.YEAR);// 获取年
		int month = currentTimes.get(Calendar.MONTH) - firstTimes.get(Calendar.MONTH);
		int day = currentTimes.get(Calendar.DAY_OF_MONTH) - firstTimes.get(Calendar.DAY_OF_MONTH);
		if (day < 0) {
			month -= 1;
			currentTimes.add(Calendar.MONTH, -1);
			day = day + currentTimes.getActualMaximum(Calendar.DAY_OF_MONTH);// 获取日
		}
		if (month < 0) {
			month = (month + 12) % 12;// 获取月
			year--;
		}
		long days = diff / (1000 * 60 * 60 * 24);
		long hours = (diff - days * (1000 * 60 * 60 * 24)) / (1000 * 60 * 60); // 获取时
		long minutes = (diff - days * (1000 * 60 * 60 * 24) - hours * (1000 * 60 * 60)) / (1000 * 60); // 获取分钟
		long s = (diff / 1000 - days * 24 * 60 * 60 - hours * 60 * 60 - minutes * 60);// 获取秒
		String countTime = "" + year + "年" + month + "月" + day + "天" + hours + "小时" + minutes + "分" + s + "秒";

		int indexOf = countTime.indexOf("年");
		if (countTime.substring(0, indexOf) != null && countTime.substring(0, indexOf).equals("0")) {
			countTime = countTime.substring(indexOf + 1, countTime.length());

			int indexOf2 = countTime.indexOf("月");
			if (countTime.substring(0, indexOf2) != null && countTime.substring(0, indexOf2).equals("0")) {
				countTime = countTime.substring(indexOf2 + 1, countTime.length());
				int indexOf3 = countTime.indexOf("天");
				if(countTime.substring(0, indexOf3)!=null && countTime.substring(0, indexOf3).equals("0")){
					countTime = countTime.substring(indexOf3 + 1, countTime.length());
					int indexOf4 = countTime.indexOf("小时");
					if(countTime.substring(0, indexOf4)!=null && countTime.substring(0, indexOf4).equals("0")){
						countTime = countTime.substring(indexOf4 + 2, countTime.length());
						int indexOf5 = countTime.indexOf("分");
						if(countTime.substring(0, indexOf5)!=null && countTime.substring(0, indexOf5).equals("0")){
							countTime = countTime.substring(indexOf5 + 1, countTime.length());
						}
					}
				}
			}
		}
		return countTime;
	}

	// Date类型转Calendar类型
	public static Calendar dataToCalendar(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar;
	}
	/**
	 * 将0时区时间转成配置的timeZone时间
	 * @param dateStr 日期字符串
	 * @param timeType 日期字符串格式
	 * @return
	 */
	public static Date correctDate(String dateStr,String timeType) {
		if(org.springframework.util.StringUtils.isEmpty(dateStr)){
			return null;
		}

		SimpleDateFormat sdf = new SimpleDateFormat(timeType);
		sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
		Date date = new Date();
		try {
			date = sdf.parse(dateStr);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return date;
	}

	/**
	 * 将0时区时间转成配置的timeZone时间
	 * @param dateStr 日期字符串
	 * @param timeType 日期字符串格式
	 * @return
	 */
	public static Date correctDateNextDay(String dateStr ,String timeType) {
		if(org.springframework.util.StringUtils.isEmpty(dateStr)){
			return null;
		}

		SimpleDateFormat sdf = new SimpleDateFormat(timeType);
		sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
		Date date = new Date();
		Date nextDay = new Date();
		try {
			date = sdf.parse(dateStr);
			Calendar cal = Calendar.getInstance();
			cal.setTime(date);
			cal.add(Calendar.DATE,1);
			nextDay = cal.getTime();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return nextDay;
	}
	/**
	 * 将0时区时间转成配置的timeZone时间
	 * @param dateStr 日期字符串
	 * @param timeZone 时区
	 * @param timeType 日期字符串格式
	 * @return
	 */
	public static Date correctDate2(String dateStr, String timeZone,String timeType) {
		SimpleDateFormat sdf = new SimpleDateFormat(timeType);
		sdf.setTimeZone(TimeZone.getTimeZone(timeZone));
		Date date = new Date();
		try {
			date = sdf.parse(dateStr);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return date;
	}

	/**
	 * 将0时区时间转成配置的timeZone时间字符串
	 * @param dateStr 日期字符串
	 * @param timeZone 时区
	 * @param timeType 日期字符串格式
	 * @return
	 */
	public static String correctDateStr(String dateStr, String timeZone,String timeType) {
		SimpleDateFormat sdf = new SimpleDateFormat(timeType);
		sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
		String newDateStr ="";
		try {

		Date ZeroDate = sdf.parse(dateStr);

		SimpleDateFormat sdf2 = new SimpleDateFormat(timeType);
		sdf2.setTimeZone(TimeZone.getTimeZone(timeZone));

			newDateStr = sdf2.format(ZeroDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return newDateStr;
	}
	
	/**
	 * 将0时区时间转成配置的timeZone时间字符串
	 * @param dateStr 日期字符串
	 * @param timeZone 时区
	 * @param timeType 日期字符串格式
	 * @return
	 */
	public static String correctDateStrNextDay(String dateStr, String timeZone,String timeType) {
		SimpleDateFormat sdf = new SimpleDateFormat(timeType);
		sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
		String newDateStr ="";
		try {

		Date ZeroDate = sdf.parse(dateStr);
		Calendar cal = Calendar.getInstance();
		cal.setTime(ZeroDate);
		cal.add(Calendar.DATE,1);
		Date nextDay = cal.getTime();
		
		SimpleDateFormat sdf2 = new SimpleDateFormat(timeType);
		sdf2.setTimeZone(TimeZone.getTimeZone(timeZone));

			newDateStr = sdf2.format(nextDay);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return newDateStr;
	}

	/**
	 * 将服务器时间转换成对应的utc字符串
	 * @param date 本地时间
	 * @param timeType 格式
	 * @return
	 */
	public static String localDateToUTCStr(Date date, String timeType) {
		if(date==null){
			return null;
		}
		String newDateStr ="";
		try {

			SimpleDateFormat sdf2 = new SimpleDateFormat(timeType);
			sdf2.setTimeZone(TimeZone.getTimeZone("UTC"));

			newDateStr = sdf2.format(date);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return newDateStr +" UTC";
	}


	public static void main(String[] args) {
//		System.out.println(correctDate("2018-10-22 00:00:00","yyyy-MM-dd HH:mm:ss"));
//		System.out.println(correctDateNextDay("2018-10-22 00:00:00", "yyyy-MM-dd HH:mm:ss"));
//		Date date = correctDate("2018-10-22 10:42:00","GMT+8","yyyy-MM-dd HH:mm:ss");
//		System.out.println((date.getTime()-new Date().getTime())/1000/3600);
//		System.out.println(nextDayCorrectDate("2018-10-22 00:00:00","GMT+8","yyyy-MM-dd HH:mm:ss"));
		System.out.println(localDateToUTCStr(new Date(), "yyyy-MM-dd HH:mm:ss"));
	}
	
	/**
	 * 减少天数
	 * @param date 日期
	 * @param i 减少的天数
	 * @return
	 */
	public static Date reduceDay(Date date,Integer i){
		Calendar calendar = Calendar.getInstance();    
		calendar.setTime(date);  
		calendar.add(Calendar.DAY_OF_MONTH, i);  
		Date time = calendar.getTime();
		return time;
	}

}