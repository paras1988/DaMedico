package com.JavaQues;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class CharOrdersByFrequency {
	public static void main(String[] args) {
		String s="oomar";
		char[] ch=s.toCharArray();

		Map<Character,Integer> map=new HashMap<Character,Integer>();
		for(int i=0;i<ch.length;i++){
			if(map.get(ch[i])!=null){
				map.put(ch[i],map.get(ch[i])+1);
			}else{
				map.put(ch[i],1);
			}
		}
		map=sortMapByValue(map);

		for(Character a='z';a>='a';a--){
			if(map.get(a)==null){
				System.out.print(a+" ");
			}
		}

		for(Entry<Character, Integer> e:map.entrySet()){
			System.out.print(e.getKey()+" ");
		}
		System.out.println();

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
		int res=((Integer) o1.getValue()).compareTo((Integer)o2.getValue());
		if(res==0){
			return ((Character) o2.getKey()).compareTo((Character)o1.getKey());
		}else{
			return res;
		}
	}
}
