package com.github.zhangkaitao.shiro.chapter15.realm;

import com.github.zhangkaitao.shiro.chapter15.service.UserService;

import java.util.HashSet;
import java.util.Set;

import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.cas.CasRealm;
import org.apache.shiro.subject.PrincipalCollection;

/**
 * <p>User: Zhang Kaitao
 * <p>Date: 14-2-13
 * <p>Version: 1.0
 */
public class MyCasRealm extends CasRealm {

    private UserService userService;

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        String username = (String)principals.getPrimaryPrincipal();

        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        Set<String> roles = new HashSet<>();
        roles.add("admin");
        roles.add("role2");
		authorizationInfo.setRoles(roles );
		Set<String> stringPermissions = new HashSet<>();
		stringPermissions.add("permission1");
		stringPermissions.add("permission2");
		authorizationInfo.setStringPermissions(stringPermissions );
        
//        authorizationInfo.setRoles(userService.findRoles(username));
//        authorizationInfo.setStringPermissions(userService.findPermissions(username));

        return authorizationInfo;
    }
}
