package com.hniu.mapper;

import com.hniu.entity.Permissions;
import com.hniu.entity.vo.PermissionsVo;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Repository
public interface PermissionsMapper extends Mapper<Permissions> {

    public List<PermissionsVo> test();
}