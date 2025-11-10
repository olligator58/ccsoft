package ru.bis.cc.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CodeWordsExtractor {
    private static final Pattern innPattern = Pattern.compile("(хммок|INNPAY)(\\d+)(/\\d+)?///");
    private static final Pattern uinPattern = Pattern.compile("(схм|UIN)(\\d+)///");
    private static final Pattern tax110Pattern = Pattern.compile("(йндбшо)(\\d+)///");
    private static final Pattern codePurposePattern = Pattern.compile("(йндбд)(\\d+)///");

    public static String extractInn(String purpose) {
        return extractField(innPattern.matcher(purpose));
    }

    public static String removeInn(String purpose) {
        return removeField(innPattern.matcher(purpose), purpose);
    }

    public static String extractUin(String purpose) {
        return extractField(uinPattern.matcher(purpose));
    }

    public static String removeUin(String purpose) {
        return removeField(uinPattern.matcher(purpose), purpose);
    }

    public static String extractTax110(String purpose) {
        return extractField(tax110Pattern.matcher(purpose));
    }

    public static String removeTax110(String purpose) {
        return removeField(tax110Pattern.matcher(purpose), purpose);
    }

    public static String extractCodePurpose(String purpose) {
        return extractField(codePurposePattern.matcher(purpose));
    }

    public static String removeCodePurpose(String purpose) {
        return removeField(codePurposePattern.matcher(purpose), purpose);
    }

    private static String extractField(Matcher matcher) {
        if (matcher.find()) {
            return matcher.group(2);
        }
        return null;
    }

    private static String removeField(Matcher matcher, String purpose) {
        if (matcher.find()) {
            return purpose.replace(matcher.group(0), "");
        }
        return purpose;
    }
}
