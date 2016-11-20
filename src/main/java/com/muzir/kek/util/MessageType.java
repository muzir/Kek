package com.muzir.kek.util;

/**
 * @author erhun.baycelik
 *
 */
public enum MessageType {
	SUCCESSFUL("success"), //
	INFORMATION("info"), //
	WARNING("warning"), //
	ERROR("danger");

	private MessageType(String _value) {
		value = _value;
	}

	private String value;

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	/**
	 * Get the array of notification Types
	 * 
	 * @return
	 */
	public static MessageType[] getNotificationType() {
		MessageType[] notificationTypes = new MessageType[3];
		notificationTypes[0] = MessageType.SUCCESSFUL;
		notificationTypes[1] = MessageType.INFORMATION;
		notificationTypes[2] = MessageType.WARNING;

		return notificationTypes;
	}
}
