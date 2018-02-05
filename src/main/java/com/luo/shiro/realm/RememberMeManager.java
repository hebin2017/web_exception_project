package com.luo.shiro.realm;

import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.subject.SubjectContext;
import org.apache.shiro.web.mgt.CookieRememberMeManager;

/**
 * Created by Administrator on 2017/9/4.
 */

public class RememberMeManager extends CookieRememberMeManager {
    public RememberMeManager() {
        super();
    }

    @Override
    protected boolean isRememberMe(AuthenticationToken token) {
        return false;
    }

    @Override
    protected byte[] getRememberedSerializedIdentity(SubjectContext subjectContext) {
        return null;
    }
}
