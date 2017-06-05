package demo.jpa.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: User
 */
@Entity
@Table(name = "UserEntity")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = "ID")
	private Long id;

	@Column(name = "Username")
	private String username;

	@Column(name = "SigninDate")
	private Date signinDate;

	public User() {
	}

	public User(String username) {
		this();
		this.username = username;
		this.signinDate = new Date(System.currentTimeMillis());
	}

	public User(String username, Date signinDate) {
		this(username);
		this.signinDate = signinDate;
	}

	@Override
	public String toString() {
		return "This is " + username + ", signed up since " + signinDate;
	}
}
