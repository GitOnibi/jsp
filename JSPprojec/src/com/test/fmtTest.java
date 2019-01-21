package com.test;

import java.util.ListResourceBundle;

public class fmtTest extends ListResourceBundle {
	public Object[][] getContents() {
		return cont;
	}
	static final Object[][] cont = {
			{"intro.name", "용지혁"},
			{"intro.age", "33"},
			{"intro.national", "한국"}
	};
}