package com.hniu.entity.vo;

import com.hniu.entity.Permissions;

import java.util.ArrayList;
import java.util.List;

public class Menu {
	private Permissions permissions;
	private List<Permissions> list = new ArrayList<Permissions>();

	public Permissions getPermissions() {
		return permissions;
	}

	public void setPermissions(Permissions permissions) {
		this.permissions = permissions;
	}

	public List<Permissions> getList() {
		return list;
	}

	public void setList(List<Permissions> list) {
		this.list = list;
	}

}
