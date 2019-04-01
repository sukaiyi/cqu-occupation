package com.cqu.occupation.user.vo;

import com.cqu.occupation.common.vo.SuperVO;
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
	String username;
	String password;
	Integer type;
}
