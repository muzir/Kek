package com.muzir.kek.enums;

/**
 * @author erhun.baycelik
 *
 */
public enum DoneStatus {

	TODO("0"), DONE("1");

	private DoneStatus(String _value) {
		value = _value;
	}

	public String getValue() {
		return value;
	}

	private String value;
}
