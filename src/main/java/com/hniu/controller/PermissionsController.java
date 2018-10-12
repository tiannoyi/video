package com.hniu.controller;

import com.hniu.constan.StateCode;
import com.hniu.controller.base.Base;
import com.hniu.service.PermissionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PermissionsController extends Base {

    @Autowired
    PermissionsService ps;

    @GetMapping("/permissions")
    public Object selectAll( Integer pageNum, Integer pageSize){
        return packaging(StateCode.SUCCESS, ps.selectAll(pageNum,pageSize ));
    }

    @GetMapping("/permissions/{permissionId}")
    public Object selectByPrimaryKey(@PathVariable Integer permissionId){
        return packaging(StateCode.SUCCESS, ps.selectPrimaryKey(permissionId));
    }


}
