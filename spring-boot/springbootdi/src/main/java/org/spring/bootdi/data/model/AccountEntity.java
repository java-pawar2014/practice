package org.spring.bootdi.data.model;

import java.io.Serializable;

public class AccountEntity implements Serializable {

	private static final long serialVersionUID = 4776647536209636055L;

	private String accountNumber;
	private String accountHolderFirstName;
	private String accountHolderLastName;
	private String pancardNumber;
	private String accountType;
	private String mobileNumber;

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getAccountHolderFirstName() {
		return accountHolderFirstName;
	}

	public void setAccountHolderFirstName(String accountHolderFirstName) {
		this.accountHolderFirstName = accountHolderFirstName;
	}

	public String getAccountHolderLastName() {
		return accountHolderLastName;
	}

	public void setAccountHolderLastName(String accountHolderLastName) {
		this.accountHolderLastName = accountHolderLastName;
	}

	public String getPancardNumber() {
		return pancardNumber;
	}

	public void setPancardNumber(String pancardNumber) {
		this.pancardNumber = pancardNumber;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((accountHolderFirstName == null) ? 0 : accountHolderFirstName.hashCode());
		result = prime * result + ((accountHolderLastName == null) ? 0 : accountHolderLastName.hashCode());
		result = prime * result + ((accountNumber == null) ? 0 : accountNumber.hashCode());
		result = prime * result + ((accountType == null) ? 0 : accountType.hashCode());
		result = prime * result + ((mobileNumber == null) ? 0 : mobileNumber.hashCode());
		result = prime * result + ((pancardNumber == null) ? 0 : pancardNumber.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AccountEntity other = (AccountEntity) obj;
		if (accountHolderFirstName == null) {
			if (other.accountHolderFirstName != null)
				return false;
		} else if (!accountHolderFirstName.equals(other.accountHolderFirstName))
			return false;
		if (accountHolderLastName == null) {
			if (other.accountHolderLastName != null)
				return false;
		} else if (!accountHolderLastName.equals(other.accountHolderLastName))
			return false;
		if (accountNumber == null) {
			if (other.accountNumber != null)
				return false;
		} else if (!accountNumber.equals(other.accountNumber))
			return false;
		if (accountType == null) {
			if (other.accountType != null)
				return false;
		} else if (!accountType.equals(other.accountType))
			return false;
		if (mobileNumber == null) {
			if (other.mobileNumber != null)
				return false;
		} else if (!mobileNumber.equals(other.mobileNumber))
			return false;
		if (pancardNumber == null) {
			if (other.pancardNumber != null)
				return false;
		} else if (!pancardNumber.equals(other.pancardNumber))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "AccountEntity [accountNumber=" + accountNumber + ", accountHolderFirstName=" + accountHolderFirstName
				+ ", accountHolderLastName=" + accountHolderLastName + ", pancardNumber=" + pancardNumber
				+ ", accountType=" + accountType + ", mobileNumber=" + mobileNumber + "]";
	}
}
