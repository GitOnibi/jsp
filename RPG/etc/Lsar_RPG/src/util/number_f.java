package util;

import java.text.DecimalFormat;

public class number_f {
	public static String num(double num, String pattern) {
		DecimalFormat format = new DecimalFormat(pattern);
		return format.format(num);
	}
}
