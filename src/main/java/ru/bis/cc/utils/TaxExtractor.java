package ru.bis.cc.utils;

import ru.bis.cc.document.Document;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaxExtractor {
    private static final Pattern taxPattern1 = Pattern.compile("//(\\d*)/(\\d*)/(\\d*)/(\\d*)/([А-Я]*)/([А-Я\\d.]*)/([\\d;\\-№]*)/([\\d.]*)/?(.*)?/");
    private static final Pattern taxPattern2 = Pattern.compile("\\\\\\\\(\\d*)\\\\(\\d*)\\\\(\\d*)\\\\(\\d*)\\\\([А-Я]*)\\\\([А-Я\\d\\.]*)\\\\([\\d;\\-№]*)\\\\([\\d\\.]*)\\\\");

    /*public static String parseTax(String purpose, Document document) {
        Matcher matcher1 = taxPattern1.matcher(purpose);
        Matcher matcher2 = taxPattern2.matcher(purpose);
        Matcher mt = (matcher1.find()) ? matcher1 : (matcher2.find()) ? matcher2 : null;
        if (mt != null) {

        }
    }*/


    public static void main(String[] args) {
        String purpose = "//0/01/18210101011011000110/45286560/ТП/МС.04.2020/0/07.05.2020/Страховые взносы";
        String purpose1 = "\\\\770522235\\01\\18210301000012000110\\45286585\\ЗД\\0\\0\\0\\08.04.2020/ПЕ/";
        Matcher matcher = taxPattern1.matcher(purpose);
        if (matcher.find()) {
            System.out.println(matcher.group(0));
            System.out.println(matcher.group(1));
            System.out.println(matcher.group(2));
            System.out.println(matcher.group(3));
            System.out.println(matcher.group(4));
            System.out.println(matcher.group(5));
            System.out.println(matcher.group(6));
            System.out.println(matcher.group(7));
            System.out.println(matcher.group(8));
            System.out.println(matcher.group(9));
        }
    }

}
