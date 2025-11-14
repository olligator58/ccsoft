package ru.bis.cc.document;

import ru.bis.cc.dto.*;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DocumentToDtoConverter {
    private static final int MAX_PAYEE_NAME = 140;
    private static final String PAYEE_BANK_NAME_COUNTRY = "RU";
    private static final int MAX_PURPOSE_LENGTH = 140;

    public DocumentDto convert(Document document) {
        DocumentDto dto = new DocumentDto();
        CstmrCdtTrfInitn cstmrCdtTrfInitn = new CstmrCdtTrfInitn();
        GrpHdr grpHdr = new GrpHdr();
        PmtInf pmtInf = new PmtInf();
        PmtTpInf pmtTpInf = new PmtTpInf();
        SvcLvl svcLvl = new SvcLvl();
        CtgyPurp ctgyPurp = new CtgyPurp();
        Dbtr dbtr = new Dbtr();
        Id id = new Id();
        OrgId orgId = new OrgId();
        Othr othr = new Othr();
        DbtrAcct dbtrAcct = new DbtrAcct();
        Id id1 = new Id();
        Othr othr1 = new Othr();
        DbtrAgt dbtrAgt = new DbtrAgt();
        FinInstnId finInstnId = new FinInstnId();
        ClrSysMmbId clrSysMmbId = new ClrSysMmbId();
        CdtTrfTxInf cdtTrfTxInf = new CdtTrfTxInf();
        PmtId pmtId = new PmtId();
        Amt amt = new Amt();
        CdtrAgt cdtrAgt = new CdtrAgt();
        FinInstnId finInstnId1 = new FinInstnId();
        ClrSysMmbId clrSysMmbId1 = new ClrSysMmbId();
        PstlAdr pstlAdr = new PstlAdr();
        CdtrAgtAcct cdtrAgtAcct = new CdtrAgtAcct();
        Id id2 = new Id();
        Othr othr2 = new Othr();
        Cdtr cdtr = new Cdtr();
        PstlAdr pstlAdr1 = new PstlAdr();
        Id id3 = new Id();
        OrgId orgId1 = new OrgId();
        Othr othr3 = new Othr();
        SchmeNm schmeNm = new SchmeNm();
        CdtrAcct cdtrAcct = new CdtrAcct();
        Id id4 = new Id();
        Othr othr4 = new Othr();
        Purp purp = new Purp();
        RgltryRptg rgltryRptg = new RgltryRptg();
        Dtls dtls = new Dtls();
        Tax tax = new Tax();
        TaxCdtr taxCdtr = new TaxCdtr();
        TaxDbtr taxDbtr = new TaxDbtr();
        Rcrd rcrd = new Rcrd();
        Prd prd = new Prd();
        FrToDt frToDt = new FrToDt();
        RmtInf rmtInf = new RmtInf();
        Strd strd = new Strd();
        CdtrRefInf cdtrRefInf = new CdtrRefInf();

        dto.setCstmrCdtTrfInitn(cstmrCdtTrfInitn);
        cstmrCdtTrfInitn.setGrpHdr(grpHdr);
        grpHdr.setMsgId(cstmrCdtTrfInitn.getUuid());
        grpHdr.setCreDtTm(document.getDate());
        cstmrCdtTrfInitn.setPmtInf(pmtInf);
        pmtInf.setPmtInfId(cstmrCdtTrfInitn.getUuid());
        pmtInf.setReqdExctnDt(document.getDate());
        pmtInf.setPmtTpInf(pmtTpInf);
        svcLvl.setCd(document.isUrgent());
        pmtTpInf.setSvcLvl(svcLvl);
        ctgyPurp.setCd(document.isTax());
        pmtTpInf.setCtgyPurp(ctgyPurp);
        pmtInf.setDbtr(dbtr);
        dbtr.setNm(document.getPayerName());
        dbtr.setId(id);
        id.setOrgId(orgId);
        othr.setId(document.getPayerInn());
        orgId.setOthr(othr);
        pmtInf.setDbtrAcct(dbtrAcct);
        dbtrAcct.setId(id1);
        othr1.setId(document.getPayerAccount());
        id1.setOthr(othr1);
        pmtInf.setDbtrAgt(dbtrAgt);
        dbtrAgt.setFinInstnId(finInstnId);
        clrSysMmbId.setMmbId(document.getPayerBankBic());
        finInstnId.setClrSysMmbId(clrSysMmbId);
        finInstnId.setNm(document.getPayerBankName());
        pmtInf.setCdtTrfTxInf(cdtTrfTxInf);
        cdtTrfTxInf.setPmtId(pmtId);
        pmtId.setInstrId(document.getNumber());
        cdtTrfTxInf.setAmt(amt);
        amt.setInstdAmt(document.getAmount());
        cdtTrfTxInf.setCdtrAgt(cdtrAgt);
        cdtrAgt.setFinInstnId(finInstnId1);
        finInstnId1.setClrSysMmbId(clrSysMmbId1);
        clrSysMmbId1.setMmbId(document.getPayeeBankBic());
        finInstnId1.setNm(document.getPayeeBankName());
        finInstnId1.setPstlAdr(pstlAdr);
        pstlAdr.setCtry(PAYEE_BANK_NAME_COUNTRY);
        cdtTrfTxInf.setCdtrAgtAcct(cdtrAgtAcct);
        cdtrAgtAcct.setId(id2);
        id2.setOthr(othr2);
        othr2.setId(document.getPayeeBankAccount());
        cdtTrfTxInf.setCdtr(cdtr);
        cdtr.setNm(getFirstNSymbols(document.getPayeeName(), MAX_PAYEE_NAME));

        if (getSymbolsAfterN(document.getPayeeName(), MAX_PAYEE_NAME) != null) {
            cdtr.setPstlAdr(pstlAdr1);
            pstlAdr1.setAdrLine(getSymbolsAfterN(document.getPayeeName(), MAX_PAYEE_NAME));
        }

        cdtr.setId(id3);
        id3.setOrgId(orgId1);
        orgId1.setOthr(othr3);
        othr3.setId(document.getPayeeInn());
        othr3.setSchmeNm(schmeNm);
        cdtTrfTxInf.setCdtrAcct(cdtrAcct);
        cdtrAcct.setId(id4);
        id4.setOthr(othr4);
        othr4.setId(document.getPayeeAccount());
        cdtTrfTxInf.setPurp(purp);
        purp.setPrtry(document.getPriority());

        if (document.getCodePurpose() != null) {
            cdtTrfTxInf.setRgltryRptg(rgltryRptg);
            rgltryRptg.setDtls(dtls);
            dtls.setCd(document.getCodePurpose());
        }


        if (document.getTax103() != null) {
            tax.setTaxCdtr(taxCdtr);
            taxCdtr.setTaxTp(document.getTax103());
        }

        if (isRegnIdNeeded(document.getTax107())) {
            taxCdtr.setRegnId(document.getTax107());
        }

        if (document.getTax102() != null) {
            tax.setTaxDbtr(taxDbtr);
            taxDbtr.setTaxTp(document.getTax102());
        }

        if (document.getTax105() != null) {
            tax.setAdmstnZn(document.getTax105());
        }

        if (document.getTax108() != null) {
            tax.setRefNb(document.getTax108());
        }

        if (convertTax109(document.getTax109()) != null) {
            tax.setDt(convertTax109(document.getTax109()));
        }


        if (document.getTax110() != null) {
            rcrd.setTp(document.getTax110());
        }

        if (document.getTax106() != null) {
            rcrd.setCtgy(document.getTax106());
        }

        if (document.getTax104() != null) {
            rcrd.setCtgyDtls(document.getTax104());
        }

        if (document.getTax101() != null) {
            rcrd.setDbtrSts(document.getTax101());
        }


        if (convertToYr(document.getTax107()) != null) {
            prd.setYr(convertToYr(document.getTax107()));
        }

        if (convertToTp(document.getTax107()) != null) {
            prd.setTp(convertToTp(document.getTax107()));
        }

        if (convertToFrToDt(document.getTax107()) != null) {
            prd.setFrToDt(frToDt);
            frToDt.setFrDt(convertToFrToDt(document.getTax107()));
            frToDt.setToDt(convertToFrToDt(document.getTax107()));
        }

        if (prd.isPrdToOutput()) {
            rcrd.setPrd(prd);
        }

        if (rcrd.isRcrdToOutput()) {
            tax.setRcrd(rcrd);
        }

        if (tax.isTaxToOutput()) {
            cdtTrfTxInf.setTax(tax);
        }

        cdtTrfTxInf.setRmtInf(rmtInf);
        rmtInf.setUstrd(prepareUstrd(document.getPurpose()));

        if (document.getUin() != null) {
            rmtInf.setStrd(strd);
            strd.setCdtrRefInf(cdtrRefInf);
            cdtrRefInf.setRef(document.getUin());
        }

        return dto;
    }

    private String getFirstNSymbols(String name, int n) {
        return name.substring(0, Math.min(name.length(), n));
    }

    private String getSymbolsAfterN(String name, int n) {
        if (name.length() > n) {
            return name.substring(n);
        }
        return null;
    }

    private boolean isRegnIdNeeded(String tax107) {
        if (tax107 != null) {
            Pattern pattern = Pattern.compile("^(0|\\d{8})$");
            Matcher matcher = pattern.matcher(tax107);
            return matcher.find();
        }
        return false;
    }

    private String convertTax109(String tax109) {
        if (tax109 != null) {
            Pattern pattern = Pattern.compile("^(\\d+)\\.(\\d+)\\.(\\d+)$");
            Matcher matcher = pattern.matcher(tax109);
            if (matcher.find()) {
                return matcher.group(3) + "-" + matcher.group(2) + "-" + matcher.group(1);
            }
            return tax109;
        }
        return null;
    }

    private String convertToYr(String tax107) {
        if (tax107 != null) {
            Pattern pattern = Pattern.compile("^(ÌÑ|ÊÂ|ÏË|ÃÄ)\\.(\\d+)\\.(\\d+)$");
            Matcher matcher = pattern.matcher(tax107);
            if (matcher.find()) {
                return matcher.group(3) + "-01-01";
            }
        }
        return null;
    }

    private String convertToTp(String tax107) {
        if (tax107 != null) {
            Pattern pattern = Pattern.compile("^(ÌÑ|ÊÂ|ÏË)\\.(\\d+)\\.(\\d+)$");
            Matcher matcher = pattern.matcher(tax107);
            if (matcher.find()) {
                if ("ÌÑ".equals(matcher.group(1))) {
                    return "MM" + matcher.group(2);
                } else if ("ÊÂ".equals(matcher.group(1))) {
                    return "QTR" + matcher.group(2).substring(1);
                } else {    //ÏË
                    return "HLF" + matcher.group(2).substring(1);
                }
            }

        }
        return null;
    }

    private String convertToFrToDt(String tax107) {
        if (tax107 != null) {
            Pattern pattern1 = Pattern.compile("^(ÌÑ|ÊÂ|ÏË|ÃÄ)\\.(\\d+)\\.(\\d+)$");
            Pattern pattern2 = Pattern.compile("^(.{2})\\.(.{2})\\.(.{4})$");
            Matcher bad = pattern1.matcher(tax107);
            Matcher good = pattern2.matcher(tax107);
            if (!bad.find() && good.find()) {
                return good.group(3) + "-" + good.group(2) + "-" + good.group(1);
            }
        }
        return null;
    }

    private List<String> prepareUstrd(String purpose) {
        List<String> lines = new ArrayList<>();
        while (purpose.length() > 0) {
            int index = Math.min(purpose.length(), MAX_PURPOSE_LENGTH);
            lines.add(purpose.substring(0, index));
            if (index == purpose.length()) {
                break;
            }
            purpose = purpose.substring(index);
        }
        return lines;
    }
}
