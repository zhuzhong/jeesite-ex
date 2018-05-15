package com.z.jeesite.sys.api.dto;

import java.io.Serializable;

public class CasConfig implements Serializable{

	
	/**
     * 
     */
    private static final long serialVersionUID = 3060677377804243370L;

    private String casUrl;
	
	private String clientUrl;

	public String getCasUrl() {
		return casUrl;
	}

	public void setCasUrl(String casUrl) {
		this.casUrl = casUrl;
	}

	public String getClientUrl() {
		return clientUrl;
	}

	public void setClientUrl(String clientUrl) {
		this.clientUrl = clientUrl;
	}
	
	
	
}
