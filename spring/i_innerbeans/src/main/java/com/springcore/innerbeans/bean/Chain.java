package com.springcore.innerbeans.bean;

public class Chain {
	private String chainCode;
	private int pitchCount;

	public String getChainCode() {
		return chainCode;
	}

	public void setChainCode(String chainCode) {
		this.chainCode = chainCode;
	}

	public int getPitchCount() {
		return pitchCount;
	}

	public void setPitchCount(int pitchCount) {
		this.pitchCount = pitchCount;
	}

	@Override
	public String toString() {
		return "Chain [chainCode=" + chainCode + ", pitchCount=" + pitchCount + "]";
	}
}
