package com.hniu.service.imp;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hniu.entity.Admin;
import com.hniu.entity.vo.AdminVo;
import com.hniu.entity.wrap.PageWrap;
import com.hniu.exception.NotLoginException;
import com.hniu.exception.PassWordErrorException;
import com.hniu.exception.SystemErrorException;
import com.hniu.exception.UserNameExistException;
import com.hniu.mapper.AdminMapper;
import com.hniu.service.AdminService;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

import static com.hniu.util.EncryptUtil.encryption;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminMapper am;

    @Resource
    private com.hniu.entity.System system;

    @Override
    public AdminVo selectByPrimaryKeyVo(Integer adminId) {
       return am.selectByPrimaryKeyVo(adminId);
    }

    @Override
    public PageWrap selectAllVo(Integer pageNum, Integer pageSize) {
        if(pageSize == null)
            pageSize = system.getPageLine().intValue();
        if (pageNum == null)
            pageNum = 1;
        PageHelper.startPage(pageNum, pageSize);
        List<AdminVo> list = am.selectAllVo();
        PageInfo pageInfo = new PageInfo(list);
        return new PageWrap(pageInfo);
    }

    @Override
    public int update(Admin admin) {
        admin.setSalt(null);
        if (!StringUtils.isEmpty(admin.getPassword())) {
            Map<String, String> map = encryption(admin.getPassword());
            admin.setSalt(map.get("salt"));
            admin.setPassword(map.get("password"));
        }
        return am.updateByPrimaryKeySelective(admin);
    }

    @Override
    public int changePassword(Map<String,String> map) throws NotLoginException, PassWordErrorException {
        Admin admin = (Admin) SecurityUtils.getSubject().getSession().getAttribute("admin");
        int i = 0;
        if (admin != null) {
            //把输入的密码加密和session里的密码对比
            Map<String, String> old_map = encryption(map.get("oldPassword"), admin.getSalt());
            String old_password = old_map.get("password");
            if (admin.getPassword().equals(old_password)) {
                i = update(new Admin(admin.getAdminId(), null, null, map.get("newPassword"), null, null));
            } else {
                throw new PassWordErrorException("密码错误");
            }
        } else {
            throw new NotLoginException("重新登录");
        }
        return i;
    }

    @Override
    public Admin insert(Admin admin) throws SystemErrorException, UserNameExistException {
        admin.setAdminId(null);
        Example example = new Example(Admin.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("adminName", admin.getAdminName());
        if (am.selectCountByExample(example) != 0) {
            throw new UserNameExistException("用户名已经存在");
        } else {
            Map<String, String> map = encryption(admin.getPassword());
            admin.setPassword(map.get("password"));
            admin.setSalt(map.get("salt"));

            if (am.insertSelective(admin) > 0) {
                return admin;
            } else {
                throw new SystemErrorException("插入失败");
            }
        }
    }

    @Override
    public int delete(Integer id) {
        int i = am.deleteByPrimaryKey(id);
        return i;
    }
}
