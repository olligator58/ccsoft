package ru.bis.cc.document;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class Document {
    private static final String OUR_CORR_ACCT = "30102810300000000101";
    private final Map<String, String> payerData = new HashMap<>();

    enum DataType {
        NAME, INN
    }

    private String number;
    private LocalDate date;
    private String deliveryType;
    private String debitAcct;
    private String creditAcct;
    private String amount;
    private String payerName;
    private String payerInn;

    public Document buildDocument(String line) {
        preparePayersRequisites();
        Document document = new Document();
        this.number = line.substring(370, 380).trim();
        this.date = parseDate(line.substring(336, 344).trim());
        this.deliveryType = (line.startsWith("CLMOS")) ? "Электронно" : "Срочно";
        this.debitAcct = line.substring(380, 400).trim();
        this.creditAcct = OUR_CORR_ACCT;
        this.amount = formatAmount(line.substring(115, 133).trim());
        this.payerName = getPayerData(this.debitAcct, DataType.NAME);
        this.payerInn = getPayerData(this.debitAcct, DataType.INN);
        return document;
    }

    private String getPayerData(String account, DataType dataType) {
        String result = "";
        String value = payerData.get(account);
        if (value != null) {
            String[] data = value.split(";");
            int index = (dataType == DataType.NAME) ? 0 : 1;
            result = data[index];
        }
        return result;
    }

    private void preparePayersRequisites() {
        payerData.put("40817810800000000009", "Дорохов Иван Петрович;776521543603");
        payerData.put("42301810900000000002", "Дорохов Иван Петрович;776521543603");
        payerData.put("40817810200000000010", "Строганова Алла Васильевна;776589845449");
        payerData.put("40820810000000000003", "Мусагалиев Галымжан Орынбасарович;773265856597");
        payerData.put("40820810300000000004", "Тэйвз Джонатан;774325653268");
        payerData.put("40817810100000000013", "Кривко Жанна Аркадьевна;770565351400");
        payerData.put("40802810400000000003", "Кривко Жанна Аркадьевна;770565351400");
        payerData.put("40802810700000000004", "Балоян Фрунзик Ашотович;770165258750");
        payerData.put("40817810400000000014", "Балоян Фрунзик Ашотович;770165258750");
        payerData.put("40802810000000000005", "Клименко Тарас Семенович;770863254530");
        payerData.put("40820810600000000005", "Клименко Тарас Семенович;770863254530");
        payerData.put("40702810100000001350", "АО открытого типа Вертикаль;7705625484");
        payerData.put("40701810400000000201", "АО открытого типа Вертикаль;7705625484");
        payerData.put("40702810400000001351", "АО открытого типа Вертикаль;7705625484");
        payerData.put("40702810500000001361", "АО открытого типа Вертикаль;7705625484");
        payerData.put("40702810700000001352", "Закрытое акционерное общество Веселый молочник;5834652323");
        payerData.put("40702810000000001353", "Закрытое акционерное общество Веселый молочник;5834652323");
        payerData.put("40701810700000000202", "Закрытое акционерное общество Веселый молочник;5834652323");
        payerData.put("40807810900000000045", "Совместное предприятие Фаргус;7728651480");
        payerData.put("40807810200000000046", "Совместное предприятие Фаргус;7728651480");
        payerData.put("40807810600000000701", "Совместное предприятие Фаргус;7728651480");
        payerData.put("40807810100000000049", "Товарищество с огранич. ответственностью Ситфарм;7733652546");
        payerData.put("40807810500000000050", "Товарищество с огранич. ответственностью Ситфарм;7733652546");
        payerData.put("30109810200000000013", "ПАО БАНК \"КУЗНЕЦКИЙ\";5836900162");
        payerData.put("30109810500000000014", "АО \"Россельхозбанк\";7725114488");
        payerData.put("30603810900000000000", "ООО \"Дойче Банк\";7702216772");
        payerData.put("40702810900000001097", "Открытое акционерное общество \"Старомосковский государственный завод" +
                " по изготовлению стеклянных, оловянных, деревянных, металлических, а также пластиковых изделий" +
                " повышенной прочности\";7529690285");
        payerData.put("40702810900000001084", "Закрытое акционерное общество Веселый молочник, занимающееся" +
                " производством, переработкой и сбытом молочной продукции, такой как молоко, кефир, ряженка," +
                " творог, йогурт и прочее;7393443311");
        payerData.put("30231810000000000000", "DEUTSCHE BANK  AG LONDON;8446808825");
        payerData.put("30402810100000000001", "DEUTSCHE BANK  AG LONDON;8446808825");
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

    @Override
    public String toString() {
        return "Document{" +
                "number='" + number + '\'' +
                ", payerName='" + payerName + '\'' +
                ", payerInn='" + payerInn + '\'' +
                '}';
    }
}
