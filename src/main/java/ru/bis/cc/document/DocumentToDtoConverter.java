package ru.bis.cc.document;

import ru.bis.cc.dto.*;

public class DocumentToDtoConverter {

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
        Id id3 = new Id();
        OrgId orgId1 = new OrgId();
        Othr othr3 = new Othr();
        SchmeNm schmeNm = new SchmeNm();

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
        cdtTrfTxInf.setCdtrAgtAcct(cdtrAgtAcct);
        cdtrAgtAcct.setId(id2);
        id2.setOthr(othr2);
        othr2.setId(document.getPayeeBankAccount());
        cdtTrfTxInf.setCdtr(cdtr);
        cdtr.setNm(document.getPayeeName());
        cdtr.setId(id3);
        id3.setOrgId(orgId1);
        orgId1.setOthr(othr3);
        othr3.setId(document.getPayeeInn());
        othr3.setSchmeNm(schmeNm);

        return dto;
    }
}
