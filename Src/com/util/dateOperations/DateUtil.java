package com.util.dateOperations;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DateUtil {

	private DateUtil() {
	}

	// Month's name – for printing
	public static String strMonths[] = { "Jan", "Feb", "Mar", "Apr", "May",
			"Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec" };

	public static String strDays[] = { "Sunday", "Monday", "Tuesday",
			"Wednesday", "Thursday", "Friday", "Saturday" };

	// Number of days in each month (for non-leap years)
	public static int daysInMonths[] = { 31, 28, 31, 30, 31, 30, 31, 31, 30,
			31, 30, 31 };

	public static int tableNonLeap[] = { 0, 3, 3, 6, 1, 4, 6, 2, 5, 0, 3, 5 };

	public static int tableLeap[] = { 6, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2 };

	// Returns true if the given year is a leap year
	public static boolean isLeapYear(int year) {
		if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0)
			return true;
		return false;
	}

	/**
	 * Return true if the given year, month, day is a valid date
	 * 
	 * @param year
	 *            : 1-9999
	 * @param month
	 *            : 1(Jan)-12(Dec)
	 * @param day
	 *            : 1-28|29|30|31. The last day depends on year and month
	 * @return
	 */
	public static boolean isValidDate(int year, int month, int day) {
		boolean flag = true;
		if (!(year > 0 && year <= 9999)) {
			flag = false;
			return flag;
		}
		if ((month == 2 && day == 29) && isLeapYear(year)) {
			flag = true;
			return flag;
		}

		if (!(month > 0 && month <= 12)) {
			flag = false;
			return flag;
		}
		if (!(day > 0 && day <= daysInMonths[month - 1]))
			flag = false;

		return flag;
	}

	/**
	 * Return the day of the week, 0:Sun, 1:Mon, ..., 6:Sat
	 */
	public static int getDayOfWeek(int year, int month, int day) {
		if (!isValidDate(year, month, day)) {
			System.out.println("Invalid Date!");
			return -1;
		}
		int sum = 0;
		int last_2 = 0;

		if (year % 400 < 100)
			sum = 6;
		else if (year % 400 > 300)
			sum = 0;
		else if (year % 400 > 200)
			sum = 2;
		else if (year % 400 > 100)
			sum = 4;

		String ystr = String.valueOf(year);
		int l = ystr.length();
		if (l >= 2) {
			String last2 = ystr.substring(l - 2, l);
			last_2 = Integer.valueOf(last2);
		} else if (l == 1)
			last_2 = Integer.valueOf(year);

		sum += last_2;
		sum += last_2 / 4;

		if (isLeapYear(year))
			sum += tableLeap[month - 1];
		else
			sum += tableNonLeap[month - 1];

		sum += day;

		return sum % 7;
	}

	// Return String "xxxday d mmm yyyy" (e.g., Wednesday 29 Feb 2012)
	public static String printDate(int year, int month, int day) {
		if (!isValidDate(year, month, day))
			return "Invalid Date";
		return strDays[getDayOfWeek(year, month, day)] + " "
				+ String.valueOf(day) + " " + strMonths[month - 1] + " "
				+ String.valueOf(year);
	}

	public static String toString(int year, int month, int day) {
		// TODO Auto-generated method stub
		return printDate(year, month, day);
	}

	public static String getYesterdayDateString() {
		DateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, -1);
		return dateFormat.format(cal.getTime());
	}

}
