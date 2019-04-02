package com.cqu.occupation.eduexp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.Date;

/**
 * @author HTtech
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "edu_exp")
public class EduExp {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "no")
    private Integer no;

    @Column(name = "id")
    private BigInteger userInfoId;

    @Column(name = "sch_id")
    private BigInteger schId;

    @Column(name = "school")
    private String school;

    @Column(name = "department")
    private String department;

    @Column(name = "sch_url")
    private String schUrl;

    @Column(name = "start")
    private String start;

    @Column(name = "end")
    private String end;

    @Column(name = "start_month")
    private String startMonth;

    @Column(name = "end_month")
    private String endMonth;

    @Column(name = "start_date")
    private String startDate;

    @Column(name = "end_date")
    private String endDate;

    @Column(name = "tags")
    private String tags;

    @Column(name = "cur")
    private String cur;

    @Column(name = "degree")
    private Integer degree;

    @Column(name = "description")
    private String description;

    @Column(name = "sch_friends")
    private Integer schFriends;

    @Column(name = "uptime")
    private Date uptime;

    @Column(name = "sys_uptime")
    private Date sysUptime;

}
