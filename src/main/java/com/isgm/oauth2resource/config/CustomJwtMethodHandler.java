package com.isgm.oauth2resource.config;

import org.aopalliance.intercept.MethodInvocation;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import org.springframework.security.access.expression.method.DefaultMethodSecurityExpressionHandler;
import org.springframework.security.core.Authentication;

public class CustomJwtMethodHandler extends DefaultMethodSecurityExpressionHandler {
    @Override
    public StandardEvaluationContext createEvaluationContextInternal(Authentication authentication, MethodInvocation mi) {
        StandardEvaluationContext ec = super.createEvaluationContextInternal(authentication, mi);
        ec.setVariable("jwt", new CustomSecurityMethods(authentication));
        return ec;
    }
}
