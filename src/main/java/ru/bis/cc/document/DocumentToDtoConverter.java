package ru.bis.cc.document;

import ru.bis.cc.dto.*;

public class DocumentToDtoConverter {

    public DocumentDto convert(Document document) {
        DocumentDto dto = new DocumentDto();
        CstmrCdtTrfInitn cstmrCdtTrfInitn = new CstmrCdtTrfInitn();
        GrpHdr grpHdr = new GrpHdr(cstmrCdtTrfInitn.getUuid(), document.getDate());
        PmtInf pmtInf = new PmtInf(cstmrCdtTrfInitn.getUuid(), document.getDate());
        PmtTpInf pmtTpInf = new PmtTpInf();
        SvcLvl svcLvl = new SvcLvl(document.isUrgent());
        CtgyPurp ctgyPurp = new CtgyPurp(document.isTax());
        Dbtr dbtr = new Dbtr(document.getPayerName());
        Id id = new Id();
        OrgId orgId = new OrgId();
        Othr othr = new Othr(document.getPayerInn());
        DbtrAcct dbtrAcct = new DbtrAcct();
        Id id1 = new Id();
        Othr othr1 = new Othr(document.getPayerAccount());

        dto.setCstmrCdtTrfInitn(cstmrCdtTrfInitn);
        cstmrCdtTrfInitn.setGrpHdr(grpHdr);
        cstmrCdtTrfInitn.setPmtInf(pmtInf);
        pmtInf.setPmtTpInf(pmtTpInf);
        pmtTpInf.setSvcLvl(svcLvl);
        pmtTpInf.setCtgyPurp(ctgyPurp);
        pmtInf.setDbtr(dbtr);
        dbtr.setId(id);
        id.setOrgId(orgId);
        orgId.setOthr(othr);
        pmtInf.setDbtrAcct(dbtrAcct);
        dbtrAcct.setId(id1);
        id1.setOthr(othr1);
        return dto;
    }
}
