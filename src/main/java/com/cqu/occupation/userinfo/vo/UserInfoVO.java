package com.cqu.occupation.userinfo.vo;

import com.cqu.occupation.eduexp.vo.EduExpVO;
import com.cqu.occupation.workexp.vo.WorkExpVO;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;

/**
 * @author sukaiyi
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserInfoVO {
	private Integer id;
	private String name;
	private String realname;
	private String gender;
	private String mobile;
	private String birthday;
	private String avatar;
	private String company;
	private BigInteger cmpId;
	private String cmpUrl;
	private String cmpAddress;
	private String cmpLogo;
	private Integer isCmpOwner;
	private String field;
	private String field2;
	private String profession;
	private String position;
	private String province;
	private String location;
	private String address;
	private String htProvince;
	private String htCity;
	private String xingzuo;
	private String city;
	private Integer interactions;
	private Integer dongtai;
	private Integer guandian;
	private Integer zhuanlan;
	private Integer dianping;
	private Integer likes;
	private Integer views;
	private Integer recentFeeds;
	private Integer influence;
	private Integer infDefeat;
	private Integer jobCount;
	private Integer workExpNum;
	private Integer eduExpNum;
	private Integer impTagNum;
	private String impTags;
	private List<String> impTagList;
	private Integer proTagNum;
	private String proTags;
	private List<String> proTagList;
	private String oneSentence;
	private String headline;
	private Integer infoRatio;
	@JsonFormat(pattern="yyyy-MM-dd hh:mm:ss",timezone="GMT+8")
	private Date uptime;
	private String dimissionRisk;
	private List<WorkExpVO> workExp;
	private List<EduExpVO> eduExp;

}
