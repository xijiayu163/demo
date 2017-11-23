package com.github.zhangkaitao.shiro.chapter15.realm;

import java.util.HashSet;
import java.util.Set;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.Permission;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.authz.permission.AllPermission;
import org.apache.shiro.cas.CasRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;

import com.github.zhangkaitao.shiro.chapter15.service.UserService;

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
    	authorizationInfo.setObjectPermissions(new HashSet<Permission>());
    	authorizationInfo.setStringPermissions(new HashSet<String>());
    	generateRoles(authorizationInfo,username);
		generatePermissions(authorizationInfo);

//      authorizationInfo.setRoles(userService.findRoles(username));
//      authorizationInfo.setStringPermissions(userService.findPermissions(username));
        return authorizationInfo;
    }
    
    private void generateRoles(SimpleAuthorizationInfo authorizationInfo,String userName){
    	Set<String> roles = new HashSet<>();
        roles.add("admin");
        roles.add("normal");
		authorizationInfo.setRoles(roles);
    }
    
    private void generatePermissions(SimpleAuthorizationInfo authorizationInfo){
    	for(String role:authorizationInfo.getRoles()){
    		addPermissionToRole(authorizationInfo,role);
    	}
    }
    
    private void addPermissionToRole(SimpleAuthorizationInfo authorizationInfo,String role){
    	if("admin".equals(role) && !isRememberMe()){
    		addAllPermissonToAdminIfAuthenticated(authorizationInfo);
    	}else if("normal".equals(role)){
    		authorizationInfo.getStringPermissions().add("/test");
    	}else if("admin".equals("role") && isRememberMe()){
    		addAllPermissonToAdminIfRemembered(authorizationInfo);
    	}
    	
    	removeNeedAuthPermissionIfRemembered(authorizationInfo);
    	
    	authorizationInfo.getStringPermissions().add("/noauth.jsp");
    	authorizationInfo.getStringPermissions().add("/index.jsp");
    	authorizationInfo.getStringPermissions().add("/casFailure.jsp");
    }
    
    private void addAllPermissonToAdminIfAuthenticated(SimpleAuthorizationInfo authorizationInfo){
    	authorizationInfo.getObjectPermissions().add(new AllPermission());
    }
    
    private void addAllPermissonToAdminIfRemembered(SimpleAuthorizationInfo authorizationInfo){
    	authorizationInfo.getStringPermissions().add("/test");
    	authorizationInfo.getStringPermissions().add("/noauth.jsp");
    	authorizationInfo.getStringPermissions().add("/index.jsp");
    	authorizationInfo.getStringPermissions().add("/casFailure.jsp");
    	authorizationInfo.getStringPermissions().remove("/needauth.jsp");
    }
    
    private void removeNeedAuthPermissionIfRemembered(SimpleAuthorizationInfo authorizationInfo){
    	Subject subject = SecurityUtils.getSubject();
    	if(subject.isRemembered()){
    		authorizationInfo.getStringPermissions().remove("/needauth.jsp");
    	}
    }
    
    private boolean isRememberMe(){
    	Subject subject = SecurityUtils.getSubject();
    	return subject.isRemembered();
    }
}
