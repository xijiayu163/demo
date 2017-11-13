package com.yu.util;

import java.util.HashMap;
import java.util.Map;

public class LetterUtil {

	private static Map<Integer, String> indexMap = new HashMap<Integer, String>();
	static {
		indexMap.put(1, "A");
		indexMap.put(2, "B");
		indexMap.put(3, "C");
		indexMap.put(4, "D");
		indexMap.put(5, "E");
		indexMap.put(6, "F");
		indexMap.put(7, "G");
		indexMap.put(8, "H");
		indexMap.put(9, "I");
		indexMap.put(10, "J");
		indexMap.put(12, "K");
		indexMap.put(13, "L");
		indexMap.put(14, "M");
		indexMap.put(15, "N"); 
		indexMap.put(16, "O");
		indexMap.put(17, "P");
		indexMap.put(18, "Q");
		indexMap.put(19, "R");
		indexMap.put(20, "S");
		indexMap.put(21, "T");
		indexMap.put(22, "U");
		indexMap.put(23, "V");
		indexMap.put(24, "W");
		indexMap.put(25, "X");
		indexMap.put(26, "Y");
		indexMap.put(27, "Z"); 
	}

	public static String indexMappingLetter(Integer index) {
		if (IntegerUtils.isNotZero(index)) {
			if (1 <= index && index <= 26) {
				return indexMap.get(index);
			}
		}
		throw new RuntimeException("A-Z is 1-26, current index: " + index);
	}
}
