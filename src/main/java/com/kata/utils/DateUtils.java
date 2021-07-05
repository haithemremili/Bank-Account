package com.kata.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

	private static final String DATE_FORMAT = "dd/MM/yyyy";
	private static SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
	
	public static String dateAsString(Date date) {
		return sdf.format(date);
	}
}
