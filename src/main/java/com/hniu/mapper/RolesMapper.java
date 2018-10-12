package com.hniu.mapper;

import com.hniu.entity.Roles;
import com.hniu.entity.vo.RolesVo;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Repository
public interface RolesMapper extends Mapper<Roles> {

    //查询所有角色
    public List<RolesVo> selectAllVo();

    //查询指定角色
    public RolesVo selectByPrimaryKeyVo(Integer roleId);
}