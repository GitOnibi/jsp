package com.test;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class StreamEx {
	List<String> list = Arrays.asList("good", "night", "bye", "kind");
	Iterator<String> iter = list.iterator();
	while(iter.hasNext()) {
		System.out.println(iter.next());
	}

	for(String items : list) {
		System.out.println(items);
	}
	
	
	Stream<String> stream = list.stream();
	stream.forEach(str - > System.out.println(str));
}
