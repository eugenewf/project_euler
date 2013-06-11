package pe19;

import java.util.GregorianCalendar;
import java.util.Locale;

/*
 * 
 * You are given the following information, but you may prefer to do some
 * research for yourself.
 * 
 * 1 Jan 1900 was a Monday. Thirty days has September, April, June and November.
 * All the rest have thirty-one, Saving February alone, Which has twenty-eight,
 * rain or shine. And on leap years, twenty-nine. A leap year occurs on any year
 * evenly divisible by 4, but not on a century unless it is divisible by 400.
 * 
 * How many Sundays fell on the first of the month during the twentieth century
 * (1 Jan 1901 to 31 Dec 2000)?
 */
public class PE19 {
	public static void main(String[] args) {
		GregorianCalendar day = new GregorianCalendar(1901,
				GregorianCalendar.JANUARY, 1);
		int count = 0;
		//printDate(day);
		while (day.get(GregorianCalendar.YEAR) < 2001) {
			if (day.get(GregorianCalendar.DAY_OF_WEEK) == GregorianCalendar.SUNDAY
					&& day.get(GregorianCalendar.DAY_OF_MONTH) == 1) {
				count++;
			}
			day.add(GregorianCalendar.DAY_OF_MONTH, 1);
		}
		System.out.println(count);
	}

	private static void printDate(GregorianCalendar day) {
		System.out.println(day.getDisplayName(
				GregorianCalendar.DAY_OF_WEEK,
				GregorianCalendar.LONG, Locale.ENGLISH)
				+ ", "
				+ day.getDisplayName(GregorianCalendar.MONTH, GregorianCalendar.LONG,Locale.ENGLISH)
				+ " "
				+ day.get(GregorianCalendar.DAY_OF_MONTH)
				+ ", " + day.get(GregorianCalendar.YEAR));
	}
}