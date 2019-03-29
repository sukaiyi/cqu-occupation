package com.cqu.occupation.global.constants;

/**
 * @author sukaiyi
 * @date 2019/3/28
 */
public enum UserType {
    /**
     * 游客
     */
    TOURIST(0, "游客"),
    /**
     * 平民
     */
    COMMONALTY(1, "普通用户"),
    /**
     * 普通的管理员
     */
    MANAGER(2, "管理员"),
    /**
     * 超级管理员
     */
    ADMINISTRATOR(3, "超级管理员");

    private Integer code;
    private String name;

    public Integer getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    UserType(Integer code, String name) {
        this.code = code;
        this.name = name;
    }
}
