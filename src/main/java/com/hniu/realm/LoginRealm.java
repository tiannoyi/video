package com.hniu.realm;

import com.hniu.entity.Admin;
import com.hniu.entity.Permissions;
import com.hniu.exception.PassWordIsNullException;
import com.hniu.exception.UserNameIsNullException;
import com.hniu.mapper.AdminMapper;
import com.hniu.service.PermissionsService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.List;

public class LoginRealm extends AuthorizingRealm {

	@Autowired
	private AdminMapper am;

	@Autowired
	private PermissionsService ps;

	Session session;



	// 权限验证
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		List<Permissions> permissions = ps.selectPermissions(((Admin) session.getAttribute("admin")).getRoleId());
		for (Permissions p : permissions) {
			info.addStringPermission(p.getPermissionStr());
		}
		return info;
	}

	// 登陆验证
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		UsernamePasswordToken uptoken = (UsernamePasswordToken) token;
		// 账号为空
		if (StringUtils.isEmpty(uptoken.getUsername())) {
			throw new UserNameIsNullException();
		}
		// 密码为空
		if (StringUtils.isEmpty((uptoken.getPassword()))) {
			throw new PassWordIsNullException();
		}
		Example example = new Example(Admin.class);
		Example.Criteria criteria = example.createCriteria();
		criteria.andEqualTo("adminName", uptoken.getUsername());
		Admin admin = am.selectOneByExample(example);

		// 账号不存在
		if (admin == null) {
			throw new UnknownAccountException();
		}
		session = SecurityUtils.getSubject().getSession();
		session.setAttribute("admin", admin);
		//加盐
		ByteSource bs = ByteSource.Util.bytes(admin.getSalt());
		SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(uptoken.getPrincipal(), admin.getPassword(), bs,
				getName());

		return info;
	}
}
