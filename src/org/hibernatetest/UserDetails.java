package org.hibernatetest;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
@NamedQuery(name = "UserDetails.byId", query = "from UserDetails where userId=:userId")
@Table(name = "USER_DETAILS")
public class UserDetails {

	/*
	 * @EmbeddedId if ID has multiple fields
	 */
	@Id
	@GeneratedValue
	private int userId;
	private String userName;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
}
