package com.travelport.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Travel {

	@JsonProperty("ID")
	private String id;
	
	@JsonProperty("Detail")
	private String detail;
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * @return the detail
	 */
	public String getDetail() {
		return detail;
	}
	/**
	 * @param details the detail to set
	 */
	public void setDetail(String detail) {
		this.detail = detail;
	}
	
	
}
