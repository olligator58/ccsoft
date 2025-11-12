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

        return dto;
    }
}
