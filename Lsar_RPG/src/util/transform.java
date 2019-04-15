package util;

import java.util.HashMap;
import java.util.Map;

public class transform {
	public static String skill_f(String format) {
		Map<String,String> trans = new HashMap<>();
		trans.put("sword", "검술");
		trans.put("spell", "마법");
		trans.put("divine", "신성");
		trans.put("earth", "땅");
		trans.put("fire", "불");
		trans.put("wind", "바람");
		trans.put("water", "물");
		trans.put("mind", "마음");
		
		return trans.get(format);
	}
}
