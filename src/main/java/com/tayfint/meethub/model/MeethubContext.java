package com.tayfint.meethub.model;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

@Scope(value="session", proxyMode=ScopedProxyMode.TARGET_CLASS)
@Component
public class MeethubContext {
	
	private String fullName;

	public MeethubContext(String fullName) {
		super();
		this.fullName = fullName;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

}
