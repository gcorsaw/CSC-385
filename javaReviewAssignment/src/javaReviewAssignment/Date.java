package javaReviewAssignment;

import java.lang.String;

public class Date implements Comparable<Date> {
	private int year;
	private int month;
	private int day;

	public Date(int year, int month, int day) throws IllegalArgumentException {
		this.year = year;
		this.month = month;
		this.day = day;

		if (!isValidDate(year, month, day)) {
			throw new IllegalArgumentException("You must choose a valid date");
		}
	}

	public int getYear() {
		return year;
	}

	public int getMonth() {
		return month;
	}

	public int getDay() {
		return day;
	}

	@Override
	public boolean equals(Object ob) {
		if (ob == null) {
			return false;
		}
		if (!(ob instanceof Date)) {
			return false;
		}
		if (this == ob) {
			return true;
		}
		Date otherDate = (Date) ob;
		if (this.compareTo(otherDate) == 0) {
			return true;
		} else {
			return false;
		}
	}

	private String dateTo9601(Date obj) {
		String formatted = zeroPad(obj.getYear(), 4);
		formatted = formatted + zeroPad(obj.getMonth(), 2);
		formatted = formatted + zeroPad(obj.getDay(), 2);
		return formatted;
	}

	private boolean isValidDate(int year, int month, int day) {
		if (year < 2021 || year > 2600) {
			return false;
		}
		if (month < 1 || month > 12) {
			return false;
		}
		switch (month) {
		case 1:
			return day <= 31 && day >= 1;
		case 2:
			return isValidFebruary(year, day);
		case 3:
			return day <= 31 && day >= 1;
		case 4:
			return day <= 30 && day >= 1;
		case 5:
			return day <= 31 && day >= 1;
		case 6:
			return day <= 30 && day >= 1;
		case 7:
			return day <= 31 && day >= 1;
		case 8:
			return day <= 31 && day >= 1;
		case 9:
			return day <= 30 && day >= 1;
		case 10:
			return day <= 31 && day >= 1;
		case 11:
			return day <= 30 && day >= 1;
		case 12:
			return day <= 31 && day >= 1;
		}
		return false;
	}

	private boolean isValidFebruary(int year, int day) {
		int maxDays = 28;
		if (year % 4 == 0 && year % 100 != 0) {
			maxDays = 29;
		}
		if (year % 400 == 0) {
			maxDays = 29;
		}
		return day <= maxDays && day >= 1;
	}

	private String zeroPad(int pad, int length) {
		String padded = String.valueOf(pad);
		while (padded.length() < length) {
			padded = "0" + padded;
		}
		return padded;
	}

	public int compareTo(Date otherDate) {
		String this9601 = dateTo9601(this);
		String other9601 = dateTo9601(otherDate);
		return this9601.compareTo(other9601);
	}

	public String toString() {
		return month + "/" + day + "/" + year;
	}
}