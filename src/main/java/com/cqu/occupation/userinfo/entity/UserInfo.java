package com.cqu.occupation.userinfo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.Date;

/**
 * @author sukaiyi
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user_info")
public class UserInfo {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "realname")
    private String realname;

    @Column(name = "gender")
    private String gender;

    @Column(name = "mobile")
    private String mobile;

    @Column(name = "birthday")
    private String birthday;

    @Column(name = "avatar")
    private String avatar;

    @Column(name = "company")
    private String company;

    @Column(name = "cmp_id")
    private BigInteger cmpId;

    @Column(name = "cmp_url")
    private String cmpUrl;

    @Column(name = "cmp_address")
    private String cmpAddress;

    @Column(name = "cmp_logo")
    private String cmpLogo;

    @Column(name = "is_cmp_owner")
    private Integer isCmpOwner;

    @Column(name = "field")
    private String field;

    @Column(name = "field2")
    private String field2;

    @Column(name = "profession")
    private String profession;

    @Column(name = "position")
    private String position;

    @Column(name = "province")
    private String province;

    @Column(name = "location")
    private String location;

    @Column(name = "address")
    private String address;

    @Column(name = "ht_province")
    private String htProvince;

    @Column(name = "ht_city")
    private String htCity;

    @Column(name = "xingzuo")
    private String xingzuo;

    @Column(name = "interactions")
    private Integer interactions;

    @Column(name = "dongtai")
    private Integer dongtai;

    @Column(name = "guandian")
    private Integer guandian;

    @Column(name = "zhuanlan")
    private Integer zhuanlan;

    @Column(name = "dianping")
    private Integer dianping;

    @Column(name = "likes")
    private Integer likes;

    @Column(name = "views")
    private Integer views;

    @Column(name = "recent_feeds")
    private Integer recentFeeds;

    @Column(name = "influence")
    private Integer influence;

    @Column(name = "inf_defeat")
    private Integer infDefeat;

    @Column(name = "job_count")
    private Integer jobCount;

    @Column(name = "work_exp_num")
    private Integer workExpNum;

    @Column(name = "edu_exp_num")
    private Integer eduExpNum;

    @Column(name = "imp_tag_num")
    private Integer impTagNum;

    @Column(name = "imp_tags")
    private String impTags;

    @Column(name = "pro_tag_num")
    private Integer proTagNum;

    @Column(name = "pro_tags")
    private String proTags;

    @Column(name = "one_sentence")
    private String oneSentence;

    @Column(name = "headline")
    private String headline;

    @Column(name = "info_ratio")
    private Integer infoRatio;

    @Column(name = "uptime")
    private Date uptime;

    @Column(name = "dimission_risk")
    private Integer dimissionRisk;


}
