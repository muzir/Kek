package com.muzir.kek.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotBlank;

/**
 * @author erhun.baycelik
 *
 */
@Entity
@Table(name = "kek_user")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;
	@Column(name = "name")
	private String name;
	@Column(name = "email", nullable = false)
	@NotBlank
	private String email;
	@Column(name = "passwordSha256")
	private String passwordSha256;
	@Column(name = "creationTs")
	private Date creationTs;

	@OneToMany(mappedBy = "user")
	private List<Todo> todos;

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPasswordSha256() {
		return passwordSha256;
	}

	public void setPasswordSha256(String passwordSha256) {
		this.passwordSha256 = passwordSha256;
	}

	public Date getCreationTs() {
		return creationTs;
	}

	public void setCreationTs(Date creationTs) {
		this.creationTs = creationTs;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((creationTs == null) ? 0 : creationTs.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((passwordSha256 == null) ? 0 : passwordSha256.hashCode());
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
		User other = (User) obj;
		if (creationTs == null) {
			if (other.creationTs != null)
				return false;
		} else if (!creationTs.equals(other.creationTs))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (passwordSha256 == null) {
			if (other.passwordSha256 != null)
				return false;
		} else if (!passwordSha256.equals(other.passwordSha256))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email + ", passwordSha256=" + passwordSha256
				+ ", creationTs=" + creationTs + ", todos=" + todos + "]";
	}

}
