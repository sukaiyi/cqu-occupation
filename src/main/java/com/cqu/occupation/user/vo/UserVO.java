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
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
public class UserVO extends SuperVO {
	Integer id;
	String username;
	String password;
	Integer type;
}
