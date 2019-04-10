package com.cqu.occupation.workexp.vo;

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
public class WorkExpVO {
	private Integer no;
	private BigInteger userInfoId;
	private BigInteger cmpId;
	private String cmpName;
	private String position;
	private String cmpUrl;
	private String cmpLogo;
	private String start;
	private String end;
	private String startDate;
	private String endDate;
	private String tags;
	private String cur;
	private Integer status;
	private String description;
	@JsonFormat(pattern="yyyy-MM-dd hh:mm:ss",timezone="GMT+8")
	private Date critime;
	@JsonFormat(pattern="yyyy-MM-dd hh:mm:ss",timezone="GMT+8")
	private Date uptime;
	@JsonFormat(pattern="yyyy-MM-dd hh:mm:ss",timezone="GMT+8")
	private Date sysUptime;

}
