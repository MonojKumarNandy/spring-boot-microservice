package com.demo.authentication.entitity;

import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Entity
@Table(name = "role")
public class Role {
	private static final Logger LOGGER = LoggerFactory.getLogger(Role.class);
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ro_id")
	private long roleId;
	@Column(name = "ro_name")
	private String roleName;
	@ManyToMany(mappedBy = "roleList", fetch = FetchType.EAGER)
	private Set<User> userList;

	public Role() {
		super();
		LOGGER.debug("Inside Role default  Constructor");
	}

	public Role(long roleId, String roleName, Set<User> userList) {
		super();
		this.roleId = roleId;
		this.roleName = roleName;
		this.userList = userList;
		LOGGER.debug("Inside Role paramaterized Constructor");

	}

	public long getRoleId() {
		return roleId;
	}

	public void setRoleId(long roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public Set<User> getUserList() {
		return userList;
	}

	public void setUserList(Set<User> userList) {
		this.userList = userList;
	}

}
