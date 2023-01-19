package com.kudangtang.jv200.mod009;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapExample {
	@SuppressWarnings({ "rawtypes", "unchecked", "deprecation" })
	public static void main(String[] args) {
		Map map = new HashMap();
		map.put("one", "1st");
		map.put("second", new Integer(2));
		map.put("third", "3rd");
		map.put("third", "III");
		System.out.println(map);
		
		Set<String> keySet = map.keySet();
		for(String key : keySet) {
			System.out.println(key + " : " + map.get(key));
		}
		
		
	}
}
