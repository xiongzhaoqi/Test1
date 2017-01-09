package org.softedu.file.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
	public static String dateManager() {
		Date d = new Date();
		SimpleDateFormat f = new SimpleDateFormat("yyyy年MM月dd日 E");
		return f.format(d);
	}
}