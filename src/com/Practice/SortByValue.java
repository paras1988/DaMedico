package com.Practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class SortByValue {
	public static void main(String[] args) {
		Map<Integer,Integer> map=new HashMap<Integer,Integer>();
		map.put(23, 23);
		map.put(45, 23);
		map.put(656, 4);
		map.put(233, 90);
		map.put(78, 88);
		map.put(66, 0);

		Map<Integer,Integer> sortedMap=new HashMap<Integer,Integer>();
		sortedMap=sortMapByValue(map);
		System.out.println(sortedMap);
	}

	private static<K,V> Map<K,V> sortMapByValue(
			Map<K,V> map) {
		List<Map.Entry<K,V>> list=new ArrayList<Map.Entry<K,V>>(map.entrySet());
		MyComparator<K,V> mc=new MyComparator<K,V>();
		Collections.sort(list, mc);

		Map<K,V> res=new LinkedHashMap<K,V>();
		for(Map.Entry<K,V> e:list){
			res.put(e.getKey(),e.getValue());
		}
		return res;
	}
}

class MyComparator<K,V>  implements Comparator<Map.Entry<K,V>>{
	@Override
	public int compare(Map.Entry<K,V> o1, Map.Entry<K,V> o2) {
		return ((Integer) o1.getValue()).compareTo( (Integer) o2.getValue() );
	}
}
