package com.cqu.occupation.user.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @author sukaiyi
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserVO {
	Integer id;
	String name;
	String username;
	String password;
	String avatar;
	Integer type;
}
