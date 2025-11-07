package ru.bis.cc.document;

import ru.bis.cc.utils.CodeWordsExtractor;
import ru.bis.cc.utils.PayerInfo;
import ru.bis.cc.utils.PayerInfoType;

import java.time.LocalDate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Document {
    private static final String OUR_CORR_ACCT = "30102810300000000101";
    private static final Pattern taxPattern1 = Pattern.compile("//(\\d*)/(\\d*)/(\\d*)/(\\d*)/([А-Я]*)/([А-Я\\d.]*)/([\\d;\\-№]*)/([\\d.]*)/?(.*)?/");
    //проверить нужна ли здесь обработка поля 110
    private static final Pattern taxPattern2 = Pattern.compile("\\\\\\\\(\\d*)\\\\(\\d*)\\\\(\\d*)\\\\(\\d*)\\\\([А-Я]*)\\\\([А-Я\\d\\.]*)\\\\([\\d;\\-№]*)\\\\([\\d\\.]*)\\\\");

    private String number;
    private LocalDate date;
    private String deliveryType;
    private String debitAcct;
    private String creditAcct;
    private String amount;
    private String payerAccount;
    private String payerName;
    private String payerInn;
    private String dirtyPurpose;
    private String purpose;
    private String tax101;
    private String tax102;
    private String tax103;
    private String tax104;
    private String tax105;
    private String tax106;
    private String tax107;
    private String tax108;
    private String tax109;
    private String tax110;

    public Document buildDocument(String line) {
        Document document = new Document();
        number = line.substring(370, 380).trim();
        date = parseDate(line.substring(336, 344).trim());
        deliveryType = (line.startsWith("CLMOS")) ? "Электронно" : "Срочно";
        debitAcct = line.substring(380, 400).trim();
        creditAcct = OUR_CORR_ACCT;
        amount = formatAmount(line.substring(115, 133).trim());
        payerAccount = debitAcct;
        payerName = line.substring(592, 752).trim();
        dirtyPurpose = line.substring(2124, Math.min(line.length(), 2264)).trim() + line.substring(1364, 1564).trim();
        payerInn = CodeWordsExtractor.getInn(dirtyPurpose);
        if (payerInn.isBlank()) {
            payerInn = PayerInfo.getPayerInfo(payerAccount, PayerInfoType.INN);
        }
        purpose = CodeWordsExtractor.removeInn(dirtyPurpose);

        return document;
    }

    private LocalDate parseDate(String str) {
        int year = Integer.parseInt(str.substring(0, 4));
        int month = Integer.parseInt(str.substring(4, 6));
        int day = Integer.parseInt(str.substring(6));
        LocalDate date = LocalDate.of(year, month, day);
        return date;
    }

    private String formatAmount(String amount) {
        Double doubleAmount = (Double.parseDouble(amount) / 1000);
        return String.format("%.2f", doubleAmount).replace(",", ".");
    }

    /*private String parseTax(String purpose) {
        Matcher matcher1 = taxPattern1.matcher(purpose);
        Matcher matcher2 = taxPattern2.matcher(purpose);
        Matcher mt = (matcher1.find()) ? matcher1 : (matcher2.find()) ? matcher2 : null;
        if (mt != null) {

        }
    }*/

    @Override
    public String toString() {
        return "Document{" +
                "number='" + number + '\'' +
                ", payerInn='" + payerInn + '\'' +
                ", dirtyPurpose='" + dirtyPurpose + '\'' +
                ", purpose='" + purpose + '\'' +
                '}';
    }
}
