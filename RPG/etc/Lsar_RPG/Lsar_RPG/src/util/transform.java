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
	public static String itemtype_f(String format) {
		Map<String,String> trans = new HashMap<>();
		trans.put("1", "검");
		trans.put("2", "도끼");
		trans.put("3", "창");
		trans.put("4", "활");
		trans.put("5", "지팡이");
		trans.put("6", "투구");
		trans.put("7", "방패");
		trans.put("8", "갑옷");
		trans.put("9", "다리");
		trans.put("10", "장갑");
				
		return trans.get(format);
	}
	public static String itemop_f(String type,int format) {
		Map<Integer,String> trans = new HashMap<>();
		if(Integer.parseInt(type)<=5) {
			trans.put(1, "물리공격력");
			trans.put(2, "마법력");
			trans.put(3, "신성력");
			trans.put(4, "방어 무시");
		}else if(Integer.parseInt(type)>=6) {
			trans.put(1, "방어력");
			trans.put(2, "hp");
			trans.put(3, "mp");
			trans.put(4, "dp");
		}
		return trans.get(format);
	}
}
