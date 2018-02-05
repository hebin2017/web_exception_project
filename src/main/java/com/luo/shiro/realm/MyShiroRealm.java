package com.luo.shiro.realm;

import com.luo.util.DecriptUtil;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import java.util.HashSet;
import java.util.Set;

public class MyShiroRealm extends AuthorizingRealm {
	
	//������Ϊû�е��ú�̨��ֱ��Ĭ��ֻ��һ���û�("luoguohui"��"123456")
	private static final String USER_NAME = "admin";
	private static final String PASSWORD = "1234";
	
	/* 
	 * ��Ȩ
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) { 
        Set<String> roleNames = new HashSet<String>();  
        Set<String> permissions = new HashSet<String>();  
        roleNames.add("administrator");//��ӽ�ɫ
        permissions.add("newPage.jhtml");  //���Ȩ��
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo(roleNames);  
        info.setStringPermissions(permissions);  
        return info;  
	}
	
	
	/* 
	 * ��¼��֤
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken authcToken) throws AuthenticationException {
		UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
		if(token.getUsername().equals(USER_NAME)){
			return new SimpleAuthenticationInfo(USER_NAME, DecriptUtil.MD5(PASSWORD), getName());  
		}else{
			return null;
			//throw new AuthenticationException();
		}
	}

}
