package com.hniu.mapper;

import com.hniu.entity.Admin;
import com.hniu.entity.vo.AdminVo;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Repository
public interface AdminMapper extends Mapper<Admin> {

    /**
     * 关联角色查询全部
     */
    public List<AdminVo> selectAllVo();

    /**
     * 关联角色查询单个
     */
    public AdminVo selectByPrimaryKeyVo(Integer adminId);
}