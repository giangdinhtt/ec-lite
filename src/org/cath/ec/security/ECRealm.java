package org.cath.ec.security;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.cache.CacheManager;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

public class ECRealm extends AuthorizingRealm {

//    protected UserDAO userDAO = null;

    public ECRealm() {
        super();
        //setName("ECRealm"); //This name must match the name in the User class's getPrincipals() method
        //setCredentialsMatcher(new Md5CredentialsMatcher());
    }

    public ECRealm(CacheManager cacheManager, CredentialsMatcher matcher) {
        super(cacheManager, matcher);
    }

    public ECRealm(CacheManager cacheManager) {
        super(cacheManager);
    }

    public ECRealm(CredentialsMatcher matcher) {
        super(matcher);
    }

/*    @Autowired
    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }*/

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection arg0) {
/*        Long userId = (Long) principals.fromRealm(getName()).iterator().next();
        User user = userDAO.getUser(userId);
        if( user != null ) {
            SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
            for( Role role : user.getRoles() ) {
                info.addRole(role.getName());
                info.addStringPermissions( role.getPermissions() );
            }
            return info;
        } else {
            return null;
        }*/
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken arg0) throws AuthenticationException {
        /*UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
        User user = userDAO.findUser(token.getUsername());
        if( user != null ) {
            return new SimpleAuthenticationInfo(user.getId(), user.getPassword(), getName());
        } else {
            return null;
        }*/
        return null;
    }
}
