package com.tayfint.meethub.model;

public interface Auditable {
	
	Audit getAudit();

    void setAudit(Audit audit);
}
