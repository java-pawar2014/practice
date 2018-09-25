package com.agsft.droolinsurance.model;

import java.util.Date;

import com.agsft.droolinsurance.model.enums.PolicyType;

/**
 * @author bpawar
 * @since 13-Aug-2018
 */
public class Policy {

	private long id;
	private String name;
	private Date insuredFrom;
	private Date expiresOn;
	private PolicyType policyType;

	private Person policyHolder;

	private double premium;

	public Policy() {
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getInsuredFrom() {
		return insuredFrom;
	}

	public void setInsuredFrom(Date insuredFrom) {
		this.insuredFrom = insuredFrom;
	}

	public Date getExpiresOn() {
		return expiresOn;
	}

	public void setExpiresOn(Date expiresOn) {
		this.expiresOn = expiresOn;
	}

	public PolicyType getPolicyType() {
		return policyType;
	}

	public void setPolicyType(PolicyType policyType) {
		this.policyType = policyType;
	}

	public Person getPolicyHolder() {
		return policyHolder;
	}

	public void setPolicyHolder(Person policyHolder) {
		this.policyHolder = policyHolder;
	}

	public double getPremium() {
		return premium;
	}

	public void setPremium(double premium) {
		this.premium = premium;
	}

	@Override
	public String toString() {
		return "Policy [id=" + id + ", name=" + name + ", insuredFrom=" + insuredFrom + ", expiresOn=" + expiresOn
				+ ", policyType=" + policyType + ", policyHolder=" + policyHolder + ", premium=" + premium + "]";
	}

}
