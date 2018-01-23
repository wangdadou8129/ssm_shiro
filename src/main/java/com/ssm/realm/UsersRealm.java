package com.ssm.realm;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import com.ssm.entity.Permissions;
import com.ssm.entity.Roles;
import com.ssm.entity.Users;
import com.ssm.service.UsersService;

public class UsersRealm extends AuthorizingRealm {
	// 保存登录的用户
	private Users user;
	@Autowired
	private UsersService usersServiceImp;
	// 授权
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection arg0) {
		// 获取用户名
		SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
		// 根据用户名查询当前用户拥有的角色
		ArrayList<Roles> roles = user.getRoles();
		//必须把所有的角色名和授权名放到Set集合中
		Set<String> roleNames = new HashSet<String>();
		Set<String> permissionNames = new HashSet<String>();
		for (Roles role : roles) {
			roleNames.add(role.getRoleName());
			ArrayList<Permissions> perms = role.getPermissions();
			for (Permissions perm : perms) {
				permissionNames.add(perm.getPermissionName());
			}
		}
		// 将权限名称提供给info
		authorizationInfo.setStringPermissions(permissionNames);
		// 将角色名称提供给info
		authorizationInfo.setRoles(roleNames);
		// 根据用户名查询当前用户权限
		return authorizationInfo;
	}

	// 认证
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken arg0) throws AuthenticationException {
		// 1.获取用户名
		String username = (String) arg0.getPrincipal();
		user = new Users();
		user.setUserName(username);
		// 2.根据用户名返回整个对象
		user = usersServiceImp.login(user);
		// 3.如果返回的是空对象则用户名都没有找到
		if (null == user) {
			throw new UnknownAccountException();
		}
		// 4.如果没有抛异常则返回带用户名和密码的基本信息给subject去认证
		SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(user.getUserName(),
				user.getUserPassword(), "usersRealm");
		return authenticationInfo;
	}

}
