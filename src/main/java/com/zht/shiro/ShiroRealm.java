/*
package com.zht.shiro;

import com.zht.entity.shiro.Permission;
import com.zht.entity.shiro.Role;
import com.zht.entity.shiro.User;
import com.zht.entity.shiro.UserRepository;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

import java.util.HashSet;
import java.util.Set;

*/
/**
 * Created by masterzht on 2018/4/9.
 *//*

public class ShiroRealm extends AuthorizingRealm {

    private UserRepository userRepository;


    */
/*认证：用户身份的识别，如登陆，检查用户信息是否符合登陆要求*//*

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {


        System.out.println("MyShiroRealm.doGetAuthenticationInfo()");
        //获取前端登陆的用户传过来的账号.
        String username = (String)token.getPrincipal();
        System.out.println(token.getCredentials());
        //通过username从数据库中查找 User对象，如果找到，没找到.
        //实际项目中，这里可以根据实际情况做缓存，如果不做，Shiro自己也是有时间间隔机制，2分钟内不会重复执行该方法
        User userInfo = userRepository.findByUsername(username);
        System.out.println("----->>userInfo="+userInfo);
        //如果没有这个名字，用户就是不存在
        if(userInfo == null){
            return null;
        }
        //用户存在，返回一个封装了用户信息的AuthenticationInfo实例
        */
/*SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                userInfo, //用户名
                userInfo.getPassword(), //密码
                ByteSource.Util.bytes(userInfo.getCredentialsSalt()),//salt=username+salt
                getName()  //realm name
        );
        return authenticationInfo;*//*

        */
/**
         * 交给AuthenticatingRealm使用CredentialsMatcher进行密码匹配，如果觉得人家的不好可以在此判断或自定义实现
         *//*

        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(
                userInfo, userInfo.getPassword(), getName());

        return info;



    }

    */
/*授权，检测用户是否具有某操作的使用权限*//*

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        */
/*还不怎么懂登陆协议，先套一层low的吧*//*

*/
/*        System.out.println("权限配置-->MyShiroRealm.doGetAuthorizationInfo()");
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        User userInfo  = (User)principals.getPrimaryPrincipal();
        for(Role role:userInfo.getRoleList()){
            authorizationInfo.addRole(role.getRole());
            for(Permission p:role.getPermissions()){
                authorizationInfo.addStringPermission(p.getPermission());
            }
        }
        return authorizationInfo;*//*

        // 角色名的集合
        Set<String> roles = new HashSet<String>();
        // 权限名的集合
        Set<String> permissions = new HashSet<String>();

        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();

        authorizationInfo.addRoles(roles);
        authorizationInfo.addStringPermissions(permissions);

        return authorizationInfo;
    }


}
*/
