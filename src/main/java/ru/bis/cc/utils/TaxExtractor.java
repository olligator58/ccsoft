package ru.bis.cc.utils;

import ru.bis.cc.document.Document;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaxExtractor {
    //    private static final Pattern taxPattern1 = Pattern.compile("//(\\d*)/(\\d*)/(\\d*)/(\\d*)/([А-Я]*)/([А-Я\\d.]*)/([\\d;\\-№]*)/([\\d.]*)(/)?(.*)?/");
    private static final Pattern taxPattern1 = Pattern.compile("//([^/]*)/([^/]*)/([^/]*)/([^/]*)/([^/]*)/([^/]*)/([^/]*)/([^/]*)(/)?([^/]*)?/");
    //    private static final Pattern taxPattern2 = Pattern.compile("\\\\\\\\(\\d*)\\\\(\\d*)\\\\(\\d*)\\\\(\\d*)\\\\([А-Я]*)\\\\([А-Я\\d\\.]*)\\\\([\\d;\\-№]*)\\\\([\\d\\.]*)(\\\\)?(.*)?\\\\");
//    private static final Pattern taxPattern2 = Pattern.compile("\\\\\\\\(.*)\\\\(.*)\\\\(.*)\\\\(.*)\\\\(.*)\\\\(.*)\\\\(.*)\\\\(.*)(\\\\)?(.*)?\\\\");
    private static final Pattern taxPattern2 = Pattern.compile("\\\\\\\\([^\\\\]*)\\\\([^\\\\]*)\\\\([^\\\\]*)\\\\([^\\\\]*)\\\\([^\\\\]*)\\\\([^\\\\]*)\\\\([^\\\\]*)\\\\([^\\\\]*)(\\\\)?([^\\\\]*)?\\\\");

    public static String parseTaxRegExp(String purpose, Document document) {
        Matcher matcher1 = taxPattern1.matcher(purpose);
        Matcher matcher2 = taxPattern2.matcher(purpose);
        Matcher mt = (matcher1.find()) ? matcher1 : (matcher2.find()) ? matcher2 : null;
        if (mt != null) {
            document.setTax101(nullIfBlank(mt.group(2)));
            document.setTax102(nullIfBlank(mt.group(1)));
            document.setTax104(nullIfBlank(mt.group(3)));
            document.setTax105(nullIfBlank(mt.group(4)));
            document.setTax106(nullIfBlank(mt.group(5)));
            document.setTax107(nullIfBlank(mt.group(6)));
            document.setTax108(nullIfBlank(mt.group(7)));
            document.setTax109(nullIfBlank(mt.group(8)));
            document.setTax110(nullIfBlank(mt.group(10)));
            document.setTax(true);
            return purpose.replace(mt.group(0), "");
        }
        return purpose;
    }

    public static String parseTax(String purpose, Document document) {
        if (purpose.startsWith("//") || purpose.startsWith("\\\\")) {
            String delimiter = (purpose.startsWith("//")) ? "/" : "\\";
            purpose = purpose.substring(2);

            List<String> values = new ArrayList<>();
            for (int i = 0; i < 9; i++) {
                if (!purpose.contains(delimiter)) {
                    break;
                }
                int pos = purpose.indexOf(delimiter);
                values.add(purpose.substring(0, pos));
                purpose = purpose.substring(pos + 1);
            }
            if (values.size() > 0) {
                document.setTax102(nullIfBlank(values.get(0)));
            }
            if (values.size() > 1) {
                document.setTax101(nullIfBlank(values.get(1)));
            }
            if (values.size() > 2) {
                document.setTax104(nullIfBlank(values.get(2)));
            }
            if (values.size() > 3) {
                document.setTax105(nullIfBlank(values.get(3)));
            }
            if (values.size() > 4) {
                document.setTax106(nullIfBlank(values.get(4)));
            }
            if (values.size() > 5) {
                document.setTax107(nullIfBlank(values.get(5)));
            }
            if (values.size() > 6) {
                document.setTax108(nullIfBlank(values.get(6)));
            }
            if (values.size() > 7) {
                document.setTax109(nullIfBlank(values.get(7)));
            }
            if (values.size() > 8) {
                document.setTax110(nullIfBlank(values.get(8)));
            }
            document.setTax(true);
            return purpose;
        }
        return purpose;
    }

    private static String nullIfBlank(String tax) {
        if (tax == null || tax.isBlank()) {
            return null;
        }
        return tax;
    }


/*
    public static void main(String[] args) {
        String purpose = "//0/01/18210101011011000110/45286560/ТП/МС.04.2020/0/07.05.2020/13/Страховые взносы";
        String purpose1 = "\\\\770522235\\01\\18210301000012000110\\45286585\\ЗД\\0\\0\\0\\08.04.2020\\ПЕ/";
        Document document = new Document();
        System.out.println(parseTax(purpose1, document));
        System.out.println(document);
        Matcher matcher = taxPattern2.matcher(purpose1);
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
            System.out.println(matcher.group(10));
        }
    }
*/

}
