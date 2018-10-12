package com.hniu.entity.vo;

import com.hniu.entity.Permissions;
import com.hniu.entity.Roles;

import java.util.List;

public class RolesVo extends Roles {

	private List<Permissions> permissions;

	public List<Permissions> getPermissions() {
		return permissions;
	}

	public void setPermissions(List<Permissions> permissions) {
		this.permissions = permissions;
	}


}
