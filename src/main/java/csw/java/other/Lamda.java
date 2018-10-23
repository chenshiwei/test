package csw.java.other;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Lamda {

	public static <K, V extends Comparable<? super V>> List<K> getTopNSortByValue(Map<K, V> map) {
		List<Map.Entry<K, V>> list = new LinkedList<Map.Entry<K, V>>(map.entrySet());
		// Collections.sort(list,(o1, o2) ->
		// (o2.getValue()).compareTo(o1.getValue()));
		Collections.sort(list, Comparator.comparing(Map.Entry<K, V>::getValue));
		List<K> keyList = new ArrayList<K>();
		for (Map.Entry<K, V> entry : list) {
			keyList.add(entry.getKey());
		}
		return keyList;
	}

	public static void main(String[] args) {
		Map<String, Integer> map = new HashMap<>();
		map.put("1", 1);
		map.put("3", 3);
		map.put("6", 6);
		map.put("4", 4);
		map.put("5", 5);
		map.put("2", 2);
		System.out.println(getTopNSortByValue(map));
	}

}
