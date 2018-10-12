package com.hniu.entity.vo;

import com.hniu.entity.Permissions;

import java.util.List;

public class PermissionsVo extends Permissions {
    private List<Permissions> permissions;

    public List<Permissions> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<Permissions> permissions) {
        this.permissions = permissions;
    }

}
