package com.spring.rest.provider.dto;

import io.swagger.annotations.ApiModelProperty;

public class CustomerDTO {
	@ApiModelProperty(value = "This is the first name of a customer", required = true)
	private String firstname;
	
	@ApiModelProperty(value = "This represents the last name of a customer.", required = true)
	private String lastname;
	
	private String customerUrl;
	
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getCustomerUrl() {
		return customerUrl;
	}
	public void setCustomerUrl(String customerUrl) {
		this.customerUrl = customerUrl;
	}
}
