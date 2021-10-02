package com.example.chatspammer;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringEscapeUtils;

public class TranslateText {

	public static String devTranslate(String englishText) {
		String virama="\\u0" + Integer.toHexString(UnicodeMap.offset+75).toUpperCase();
		if (!"".equals(englishText) && isVowel(englishText.charAt(0)+"")) {
			englishText = UnicodeMap.map.get(" " + englishText.charAt(0)) + englishText.substring(1);
		}

		for (Entry<String, String> entry : UnicodeMap.map.entrySet()) {
			if (entry.getKey().length() > 1) {
				englishText = englishText.replace(entry.getKey(), entry.getValue());

			}
		}
		for (Entry<String, String> entry : UnicodeMap.map.entrySet()) {
			if (entry.getKey().length() == 1 && isVowel(entry.getKey())) {

				englishText = englishText.replace(entry.getKey(), entry.getValue());

			}
		}

		for (Entry<String, String> entry : UnicodeMap.map.entrySet()) {
			if (entry.getKey().length() == 1 && !isVowel(entry.getKey())) {

				englishText = englishText.replace(entry.getKey(), entry.getValue() + StringEscapeUtils.unescapeJava(virama));

			}
		}

		for (Entry<String, String> entry : UnicodeMap.map.entrySet()) {
			if (entry.getKey().length() == 1 && isVowel(entry.getKey())) {

				englishText = englishText.replace(entry.getKey(), entry.getValue());

			}
		}
		//System.out.println(StringEscapeUtils.escapeJava(englishText));

		englishText = StringEscapeUtils.escapeJava(englishText)
						.replace(new String(convert(" a")+convert("i")), convert(" ai"))
						.replace(new String(convert(" o")+convert("u")), convert(" ou"))
						.replace(new String(convert("a")+convert("i")), convert("ai"))
						.replace(new String(convert("o")+convert("u")), convert("ou"))
						.replace(new String(virama+convert("a")), convert("a"))
						.replace(new String(virama+convert("e")), convert("e"))
						.replace(new String(virama+convert("i")), convert("i"))
						.replace(new String(virama+convert("o")), convert("o"))
						.replace(new String(virama+convert("u")), convert("u"))
						.replace(new String(virama+convert("A")), convert("A"))
						.replace(new String(virama+convert("E")), convert("E"))
						.replace(new String(virama+convert("I")), convert("I"))
						.replace(new String(virama+convert("O")), convert("O"))
						.replace(new String(virama+convert("U")), convert("U"))
						.replace(new String(convert("M")+virama), convert("M")
								
						);
		//englishText=englishText.replace(convert("a"), "");
		String convertedText=StringEscapeUtils.unescapeJava(englishText);

		return convertedText;

	}

	public static boolean isVowel(String str) {
		return str.toLowerCase().contains("a") || str.toLowerCase().contains("e") || str.toLowerCase().contains("i")
				|| str.toLowerCase().contains("o") || str.toLowerCase().contains("u")
				|| str.toLowerCase().contains("M");
	}
	
	public static String convert(String letter) {
		if("a".equals(letter)) {
			return "\\u0000";
		}
		return StringEscapeUtils.escapeJava(UnicodeMap.map.get(letter));
	}
	/*
	public static void main(String[] args) {
		UnicodeMap.generateDefaultt();
		UnicodeMap.offset=2306;
		UnicodeMap.generateUnicodeFromOffset();
		String s="\u0917\u0941 \u0905";
		System.out.println(teluguTranslate(s));
	}
	*/

}