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
	// �����¼���û�
	private Users user;
	@Autowired
	private UsersService usersServiceImp;
	// ��Ȩ
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection arg0) {
		// ��ȡ�û���
		SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
		// �����û�����ѯ��ǰ�û�ӵ�еĽ�ɫ
		ArrayList<Roles> roles = user.getRoles();
		//��������еĽ�ɫ������Ȩ���ŵ�Set������
		Set<String> roleNames = new HashSet<String>();
		Set<String> permissionNames = new HashSet<String>();
		for (Roles role : roles) {
			roleNames.add(role.getRoleName());
			ArrayList<Permissions> perms = role.getPermissions();
			for (Permissions perm : perms) {
				permissionNames.add(perm.getPermissionName());
			}
		}
		// ��Ȩ�������ṩ��info
		authorizationInfo.setStringPermissions(permissionNames);
		// ����ɫ�����ṩ��info
		authorizationInfo.setRoles(roleNames);
		// �����û�����ѯ��ǰ�û�Ȩ��
		return authorizationInfo;
	}

	// ��֤
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken arg0) throws AuthenticationException {
		// 1.��ȡ�û���
		String username = (String) arg0.getPrincipal();
		user = new Users();
		user.setUserName(username);
		// 2.�����û���������������
		user = usersServiceImp.login(user);
		// 3.������ص��ǿն������û�����û���ҵ�
		if (null == user) {
			throw new UnknownAccountException();
		}
		// 4.���û�����쳣�򷵻ش��û���������Ļ�����Ϣ��subjectȥ��֤
		SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(user.getUserName(),
				user.getUserPassword(), "usersRealm");
		return authenticationInfo;
	}

}
