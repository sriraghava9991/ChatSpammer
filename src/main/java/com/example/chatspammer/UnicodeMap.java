package com.example.chatspammer;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.lang3.StringEscapeUtils;

public class UnicodeMap {
	static Map<String, String> map = new HashMap<String, String>();
	static Map<String, Integer> mapp = new HashMap<String, Integer>();

	static Map<String, Integer> decimalMap = new HashMap<String, Integer>();

	public static Map<String, String> languageMap = new HashMap<String, String>();
	public static String unicodeValue;
	public static int offset = 0;
	static {
		languageMap.put("Telugu", "C");
		languageMap.put("Hindi", "9");
		languageMap.put("Oriya", "B");

		decimalMap.put("Hindi", 2306);
		decimalMap.put("Kashmiri", 2306);
		decimalMap.put("Konkani", 2306);
		decimalMap.put("Maithili", 2306);
		decimalMap.put("Marathi", 2306);
		decimalMap.put("Nepali", 2306);
		decimalMap.put("Sanskrit", 2306);
		decimalMap.put("Sindhi", 2306);
		decimalMap.put("Bengali", 2434);
		decimalMap.put("Assamese", 2434);
		decimalMap.put("Punjabi", 2562);
		decimalMap.put("Gujarati", 2690);
		decimalMap.put("Oriya", 2818);
		decimalMap.put("Tamil", 2946);
		decimalMap.put("Telugu", 3074);
		decimalMap.put("Kannada", 3202);
		decimalMap.put("Malayalam", 3330);
		decimalMap.put("Sinhala", 3458);

		map.put("a", "\u0000");

	}

	/*
	 * public static void generateDefaultMap() { map = new HashMap<String,
	 * String>(); map.put(" a", " \\u0x05"); map.put(" A", " \\u0x06");
	 * map.put(" i", " \\u0x07"); map.put(" I", " \\u0x08"); map.put(" u",
	 * " \\u0x09"); map.put(" U", " \\u0x0A"); map.put(" e", " \\u0x0E");
	 * map.put(" E", " \\u0x0F"); map.put(" ai", " \\u0x10"); map.put(" o",
	 * " \\u0x12"); map.put(" O", " \\u0x13"); map.put(" ou", " \\u0x14");
	 * map.put("M", "\\u0x02");
	 * 
	 * map.put("A", "\\u0x3e"); map.put("i", "\\u0x3f"); map.put("I", "\\u0x40");
	 * map.put("u", "\\u0x41"); map.put("U", "\\u0x42"); map.put("e", "\\u0x46");
	 * map.put("E", "\\u0x47"); map.put("ai", "\\u0x48"); map.put("o", "\\u0x4a");
	 * map.put("O", "\\u0x4b"); map.put("ou", "\\u0x4c");
	 * 
	 * map.put("k", "\\u0x15"); map.put("K", "\\u0x16"); map.put("g", "\\u0x17");
	 * map.put("G", "\\u0x18"); map.put("~m", "\\u0x19"); map.put("c", "\\u0x1a");
	 * map.put("C", "\\u0x1b"); map.put("j", "\\u0x1c"); map.put("J", "\\u0x1d");
	 * map.put("~n", "\\u0x1e"); map.put("T", "\\u0x1f"); map.put("Th", "\\u0x20");
	 * map.put("D", "\\u0x21"); map.put("Dh", "\\u0x22"); map.put("N", "\\u0x23");
	 * map.put("t", "\\u0x24"); map.put("th", "\\u0x25"); map.put("d", "\\u0x26");
	 * map.put("dh", "\\u0x27"); map.put("n", "\\u0x28"); map.put("p", "\\u0x2A");
	 * map.put("P", "\\u0x2B"); map.put("b", "\\u0x2C"); map.put("B", "\\u0x2D");
	 * map.put("m", "\\u0x2E"); map.put("y", "\\u0x2F"); map.put("r", "\\u0x30");
	 * map.put("R", "\\u0x31"); map.put("l", "\\u0x32"); map.put("L", "\\u0x33");
	 * map.put("v", "\\u0x35"); map.put("S", "\\u0x36"); map.put("sh", "\\u0x37");
	 * map.put("s", "\\u0x38"); map.put("h", "\\u0x39");
	 * 
	 * }
	 */
	public static void generateDefaultMap() {
		mapp.put("dh", 37);
		mapp.put("Th", 30);
		mapp.put(" A", 4);
		mapp.put("\nA", 4);
		mapp.put("Dh", 32);
		mapp.put(" E", 13);
		mapp.put("\nE", 13);
		mapp.put("ai", 70);
		mapp.put(" I", 6);
		mapp.put("\nI", 6);
		mapp.put(" O", 17);
		mapp.put("\nO", 17);
		mapp.put("~m", 23);
		mapp.put("~n", 28);
		mapp.put(" U", 8);
		mapp.put("\nU", 8);
		mapp.put(" a", 3);
		mapp.put("\na", 3);
		mapp.put("\na", 3);
		mapp.put("A", 60);
		mapp.put("B", 43);
		mapp.put("C", 25);
		mapp.put("D", 31);
		mapp.put(" e", 12);
		mapp.put("\ne", 12);
		mapp.put("E", 69);
		mapp.put("G", 22);
		mapp.put(" ai", 14);
		mapp.put("\nai", 14);
		mapp.put(" i", 5);
		mapp.put("\ni", 5);
		mapp.put("I", 62);
		mapp.put("J", 27);
		mapp.put("K", 20);
		mapp.put("L", 49);
		mapp.put("M", 0);
		mapp.put("N", 33);
		mapp.put(" o", 16);
		mapp.put("\no", 16);
		mapp.put("O", 73);
		mapp.put("P", 41);
		mapp.put("R", 47);
		mapp.put("S", 52);
		mapp.put(" ou", 18);
		mapp.put("\nou", 18);
		mapp.put("T", 29);
		mapp.put(" u", 7);
		mapp.put("\nu", 7);
		mapp.put("sh", 53);
		mapp.put("U", 64);
		mapp.put("b", 42);
		mapp.put("c", 24);
		mapp.put("d", 36);
		mapp.put("e", 68);
		mapp.put("ou", 74);
		mapp.put("g", 21);
		mapp.put("h", 55);
		mapp.put("i", 61);
		mapp.put("j", 26);
		mapp.put("k", 19);
		mapp.put("l", 48);
		mapp.put("m", 44);
		mapp.put("n", 38);
		mapp.put("o", 72);
		mapp.put("p", 40);
		mapp.put("r", 46);
		mapp.put("s", 54);
		mapp.put("t", 34);
		mapp.put("th", 35);
		mapp.put("u", 63);
		mapp.put("v", 51);
		mapp.put("y", 45);
	}

	/*
	 * mapp.put(" a",3077); mapp.put(" A",3078); mapp.put(" i",3079);
	 * mapp.put(" I",3080); mapp.put(" u",3081); mapp.put(" U",3082);
	 * mapp.put(" e",3086); mapp.put(" E",3087); mapp.put(" ai",3088);
	 * mapp.put(" o",3090); mapp.put(" O",3091); mapp.put(" au",3092);
	 * mapp.put("M",3074);
	 * 
	 * 
	 * 
	 * mapp.put("k",3093); mapp.put("K",3094); mapp.put("g",3095);
	 * mapp.put("G",3096); mapp.put("~m",3097); mapp.put("c",3098);
	 * mapp.put("C",3099); mapp.put("j",3100); mapp.put("J",3101);
	 * mapp.put("~n",3102); mapp.put("T",3103); mapp.put("Th",3104);
	 * mapp.put("D",3105); mapp.put("Dh",3106); mapp.put("N",3107);
	 * mapp.put("t",3108); mapp.put("th",3109); mapp.put("d",3110);
	 * mapp.put("dh",3111); mapp.put("n",3112); mapp.put("p",3114);
	 * mapp.put("P",3115); mapp.put("b",3116); mapp.put("B",3117);
	 * mapp.put("m",3118); mapp.put("y",3119); mapp.put("r",3120);
	 * mapp.put("R",3121); mapp.put("l",3122); mapp.put("L",3123);
	 * mapp.put("v",3125); mapp.put("S",3126); mapp.put("sh",3127);
	 * mapp.put("s",3128); mapp.put("h",3129);
	 * 
	 * mapp.put("A",3134); mapp.put("i",3135); mapp.put("I",3136);
	 * mapp.put("u",3137); mapp.put("U",3138); mapp.put("e",3142);
	 * mapp.put("E",3143); mapp.put("ai",3144); mapp.put("o",3146);
	 * mapp.put("O",3147); mapp.put("ou",3148);
	 */

	public static void generateUnicodeMap() {
		for (Entry<String, String> entry : map.entrySet()) {
			String key = entry.getKey();
			String value = entry.getValue();
			map.put(key, StringEscapeUtils.unescapeJava(value.replace("x", unicodeValue)));
		}
	}

	public static void generateUnicodeFromOffset() {
		for (Entry<String, Integer> entry : mapp.entrySet()) {
			int decimalValue = entry.getValue() + offset;
			String unicodeprefix = "\\u0";
			if (entry.getKey().substring(0, 1).equals(" "))
				unicodeprefix = " " + unicodeprefix;
			if (entry.getKey().substring(0, 1).equals("\n"))
				unicodeprefix = "\n" + unicodeprefix;
			map.put(entry.getKey(), StringEscapeUtils.unescapeJava(unicodeprefix + Integer.toHexString(decimalValue)));

		}
	}
	/*
	 * public static void main(String[] args) { generateDefaultMap();
	 * generateDefaultt(); System.out.println(Integer.toHexString(3077));
	 * System.out.println(convertToDecimal("\u0c05")); // generateUnicodeMap();
	 * 
	 * int offset = 2690; for (Entry<String, Integer> entry : mapp.entrySet()) { int
	 * decimalValue = entry.getValue() + offset; //
	 * System.out.println("mapp.put(\""+entry.getKey()+"\","+(entry.getValue()- //
	 * 3074)+");"); System.out.println(entry.getKey() + "\\u0" +
	 * Integer.toHexString(decimalValue)); map.put(entry.getKey(), "\\u0" +
	 * Integer.toHexString(decimalValue));
	 * 
	 * }
	 * 
	 * }
	 *//*
		 * public static int convertToDecimal(String str) { for (int i = 0; i <
		 * str.length(); i++) { char ch = str.charAt(i); if
		 * (Character.isHighSurrogate(ch)) { System.out.println("Codepoint: " +
		 * Character.toCodePoint(ch, str.charAt(i + 1))); i++; }
		 * System.out.println("Codepoint: " + (int) ch); return (int) ch;
		 * 
		 * } return 0; }
		 */
}
