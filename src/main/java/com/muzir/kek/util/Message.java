package com.muzir.kek.util;

import java.io.Serializable;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * @author erhun.baycelik
 *
 */
public class Message implements Serializable {
	private static final long serialVersionUID = 2246405858029614639L;
	private MessageType type;
	private String value;

	public Message(MessageType type, String value) {
		this.type = type;
		this.value = value;
	}

	public MessageType getType() {
		return type;
	}

	public String getValue() {
		return value;
	}

	public boolean equals(final Object obj) {
		if (obj instanceof Message) {
			Message other = (Message) obj;
			return new EqualsBuilder().append(type, other.getType()).append(value, other.getValue()).isEquals();
		}
		return false;
	}

	public int hashCode() {
		return new HashCodeBuilder().append(type).append(value).hashCode();
	}

	@Override
	public String toString() {
		return "Message [type=" + type + ", value=" + value + "]";
	}
}
