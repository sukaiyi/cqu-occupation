package com.cqu.occupation.workexp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.Date;

public class WorkExp {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "no")
    private Integer number;

    @Column(name = "id")
    private BigInteger id;

    @Column(name = "id")
    private BigInteger cmpId;

    @Column(name = "cmp_name")
    private String cmpName;

    @Column(name = "position")
    private String position;

    @Column(name = "cmp_url")
    private String cmpUrl;

    @Column(name = "cmp_logo")
    private String cmpLogo;

    @Column(name = "start")
    private String start;

    @Column(name = "end")
    private String end;

    @Column(name = "start_date")
    private String startDate;

    @Column(name = "end_date")
    private String endDate;

    @Column(name = "tags")
    private String tags;

    @Column(name = "cur")
    private String cur;

    @Column(name = "status")
    private Integer status;

    @Column(name = "description")
    private String description;

    @Column(name = "critime")
    private Date critime;

    @Column(name = "uptime")
    private Date uptime;

    @Column(name = "sys_uptime")
    private Date sysUptime;



}

