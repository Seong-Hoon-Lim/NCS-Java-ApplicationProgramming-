package com.kudangtang.jv200.mod009;

import java.util.HashSet;
import java.util.Set;

public class SetExample {
	@SuppressWarnings({ "rawtypes", "unchecked", "deprecation" })
	public static void main(String[] args) {
		Set set = new HashSet();
		set.add("one");
		set.add("second");
		set.add("3rd");
		set.add(new Integer(4));
		set.add(new Float(5.0f));
		set.add("second");
		set.add(new Integer(4));
		System.out.println(set);
	}
}
