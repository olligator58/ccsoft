package ru.bis.cc.document;

import ru.bis.cc.utils.*;

import java.time.LocalDate;

public class Document {
    private static final String OUR_CORR_ACCT = "30102810300000000101";
    private static final String OUR_BANK_NAME = "ООО \"Дойче Банк\"";
    private static final String OUR_BANK_BIC = "044525101";

    private String number;
    private LocalDate date;
    private String deliveryType;
    private boolean isUrgent;
    private String debitAcct;
    private String creditAcct;
    private String amount;
    private String payerAccount;
    private String payerName;
    private String payerInn;
    private String payerBankName;
    private String payerBankBic;
    private String payeeBankBic;
    private String payeeBankName;
    private String payeeBankAccount;
    private String payeeAccount;
    private String payeeName;
    private String payeeInn;
    private String dirtyPurpose;
    private String purpose;
    private String uin;
    private String priority;
    private String codePurpose;
    private String reference;
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
    private boolean isTax;

    public String getNumber() {
        return number;
    }

    public String getAmount() {
        return amount;
    }

    public String getPayerInn() {
        return payerInn;
    }

    public String getPayerName() {
        return payerName;
    }

    public String getPayerAccount() {
        return payerAccount;
    }

    public String getPayerBankName() {
        return payerBankName;
    }

    public String getPayerBankBic() {
        return payerBankBic;
    }

    public String getPayeeName() {
        return payeeName;
    }

    public String getPayeeInn() {
        return payeeInn;
    }

    public String getPayeeAccount() {
        return payeeAccount;
    }

    public String getPayeeBankBic() {
        return payeeBankBic;
    }

    public String getPayeeBankName() {
        return payeeBankName;
    }

    public String getPayeeBankAccount() {
        return payeeBankAccount;
    }

    public LocalDate getDate() {
        return date;
    }

    public boolean isUrgent() {
        return isUrgent;
    }

    public boolean isTax() {
        return isTax;
    }

    public String getTax110() {
        return tax110;
    }

    public void setTax101(String tax101) {
        this.tax101 = tax101;
    }

    public void setTax102(String tax102) {
        this.tax102 = tax102;
    }

    public void setTax104(String tax104) {
        this.tax104 = tax104;
    }

    public void setTax105(String tax105) {
        this.tax105 = tax105;
    }

    public void setTax106(String tax106) {
        this.tax106 = tax106;
    }

    public void setTax107(String tax107) {
        this.tax107 = tax107;
    }

    public void setTax108(String tax108) {
        this.tax108 = tax108;
    }

    public void setTax109(String tax109) {
        this.tax109 = tax109;
    }

    public void setTax110(String tax110) {
        this.tax110 = tax110;
    }

    public void setTax(boolean tax) {
        isTax = tax;
    }

    public Document buildDocument(String line) {
        Document document = new Document();
        number = line.substring(370, 380).trim();
        date = extractDate(line);
        deliveryType = (line.startsWith("CLMOS")) ? "Электронно" : "Срочно";
        isUrgent = "Срочно".equals(deliveryType);
        debitAcct = line.substring(380, 400).trim();
        creditAcct = OUR_CORR_ACCT;
        amount = extractAmount(line);
        payerAccount = debitAcct;
        payerName = line.substring(592, 752).trim();
        payerBankName = OUR_BANK_NAME;
        payerBankBic = OUR_BANK_BIC;
        dirtyPurpose = line.substring(2124, Math.min(line.length(), 2264)).trim() + line.substring(1364, 1564).trim();
        payerInn = CodeWordsExtractor.extractInn(dirtyPurpose);
        if (payerInn == null || payerInn.isBlank()) {
            payerInn = PayerInfo.getPayerInfo(payerAccount, PayerInfoType.INN);
        }
        payeeBankBic = line.substring(1595, 1604).trim();
        payeeBankAccount = line.substring(1564, 1584).trim();
        payeeAccount = line.substring(1764, 1784).trim();
        payeeBankName = BankInfo.getBankName(payeeBankBic);
        payeeInn = extractPayeeInn(line);
        payeeName = line.substring(1827, 2124).trim();
        purpose = CodeWordsExtractor.removeInn(dirtyPurpose);
        purpose = TaxExtractor.parseTax(purpose, this);
        //перезаписываем поле 110 значением из кодового слова
        if (CodeWordsExtractor.extractTax110(purpose) != null) {
            tax110 = CodeWordsExtractor.extractTax110(purpose);
            purpose = CodeWordsExtractor.removeTax110(purpose);
        }
        tax103 = extractTax103(line);
        uin = extractUin(line);
        if (uin == null || uin.isBlank()) {
            uin = CodeWordsExtractor.extractUin(purpose);
        }
        purpose = CodeWordsExtractor.removeUin(purpose);
        codePurpose = CodeWordsExtractor.extractCodePurpose(purpose);
        purpose = CodeWordsExtractor.removeCodePurpose(purpose);
        priority = line.substring(484, 486).trim();
        reference = extractReference(line);

        return document;
    }

    private LocalDate extractDate(String line) {
        String str = line.substring(336, 344).trim();
        int year = Integer.parseInt(str.substring(0, 4));
        int month = Integer.parseInt(str.substring(4, 6));
        int day = Integer.parseInt(str.substring(6));
        return LocalDate.of(year, month, day);
    }

    private String extractAmount(String line) {
        String amount = line.substring(115, 133).trim();
        Double doubleAmount = (Double.parseDouble(amount) / 1000);
        return String.format("%.2f", doubleAmount).replace(",", ".");
    }

    private String extractTax103(String line) {
        String str = line.substring(1795, 1827).trim();
        if (str.contains("/")) {
            return str.substring(str.indexOf('/') + 4);
        }
        return null;
    }

    private String extractPayeeInn(String line) {
        String str = line.substring(1795, 1827).trim();
        if (str.contains("/")) {
            return str.substring(0, str.indexOf("/"));
        }
        return str;
    }

    private String extractUin(String line) {
        if (line.length() > 2264) {
            String str = line.substring(2264, Math.min(line.length(), 2294)).trim();
            if (str.startsWith("/ROC/")) {
                return str.substring(5);
            }
        }
        return null;
    }

    private String extractReference(String line) {
        if (line.length() > 2574) {
            return line.substring(2574).trim();
        }
        return null;
    }

    @Override
    public String toString() {
        return "Document{" +
                "number='" + number + '\'' +
                ", date=" + date +
                ", deliveryType='" + deliveryType + '\'' +
                ", debitAcct='" + debitAcct + '\'' +
                ", creditAcct='" + creditAcct + '\'' +
                ", amount='" + amount + '\'' +
                ", payerAccount='" + payerAccount + '\'' +
                ", payerName='" + payerName + '\'' +
                ", payerInn='" + payerInn + '\'' +
                ", payeeBankBic='" + payeeBankBic + '\'' +
                ", payeeBankAccount='" + payeeBankAccount + '\'' +
                ", payeeAccount='" + payeeAccount + '\'' +
                ", payeeName='" + payeeName + '\'' +
                ", payeeInn='" + payeeInn + '\'' +
                ", purpose='" + purpose + '\'' +
                ", uin='" + uin + '\'' +
                ", priority='" + priority + '\'' +
                ", codePurpose='" + codePurpose + '\'' +
                ", reference='" + reference + '\'' +
                ", tax101='" + tax101 + '\'' +
                ", tax102='" + tax102 + '\'' +
                ", tax103='" + tax103 + '\'' +
                ", tax104='" + tax104 + '\'' +
                ", tax105='" + tax105 + '\'' +
                ", tax106='" + tax106 + '\'' +
                ", tax107='" + tax107 + '\'' +
                ", tax108='" + tax108 + '\'' +
                ", tax109='" + tax109 + '\'' +
                ", tax110='" + tax110 + '\'' +
                ", isTax='" + isTax + '\'' +
                '}';
    }
}
