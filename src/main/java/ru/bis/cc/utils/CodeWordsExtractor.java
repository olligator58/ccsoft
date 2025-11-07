package ru.bis.cc.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CodeWordsExtractor {
    private static final Pattern innPattern = Pattern.compile("(»ÕÕœÀ|INNPAY)(\\d+)(/\\d+)?///");

    public static String getInn(String purpose) {
        Matcher matcher = innPattern.matcher(purpose);
        if (matcher.find()) {
            return matcher.group(2);
        }
        return "";
    }

    public static String removeInn(String purpose) {
        Matcher matcher = innPattern.matcher(purpose);
        if (matcher.find()) {
            return purpose.replace(matcher.group(0), "");
        }
        return purpose;
    }
}
