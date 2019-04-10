package com.cqu.occupation.eduexp.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;
import java.util.Date;

/**
 * @author sukaiyi
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EduExpVO {
	private Integer no;
	private BigInteger userInfoId;
	private BigInteger schId;
	private String school;
	private String department;
	private String schUrl;
	private String start;
	private String end;
	private String startMonth;
	private String endMonth;
	private String startDate;
	private String endDate;
	private String tags;
	private String cur;
	private Integer degree;
	private String description;
	private Integer schFriends;
	@JsonFormat(pattern="yyyy-MM-dd hh:mm:ss",timezone="GMT+8")
	private Date uptime;
	@JsonFormat(pattern="yyyy-MM-dd hh:mm:ss",timezone="GMT+8")
	private Date sysUptime;
}
