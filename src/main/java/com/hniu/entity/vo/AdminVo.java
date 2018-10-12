package com.hniu.entity.vo;

import com.hniu.entity.Admin;
import com.hniu.entity.Roles;

public class AdminVo extends Admin {

private Roles role;

public Roles getRole() {
    return role;
}

public void setRole(Roles role) {
    this.role = role;
}

}
