package com.cqu.occupation.global.annotation;

import com.cqu.occupation.global.constants.UserType;

import java.lang.annotation.*;

/**
 * @author sukaiyi
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface AuthorityRequired {
    UserType[] allow() default {UserType.ADMINISTRATOR, UserType.COMMONALTY, UserType.MANAGER};
}
