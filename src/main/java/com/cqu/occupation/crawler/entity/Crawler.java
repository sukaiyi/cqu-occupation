package com.cqu.occupation.crawler.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

/**
 * @author sukaiyi
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "crawler")
public class Crawler {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "crawl_id")
    private Integer crawlId;

    @Column(name = "data_source")
    private String dataSource;

    @Column(name = "[function]")
    private String function;

    @Column(name = "strategy")
    private String strategy;

    @Column(name = "sleep_manner")
    private Integer sleepManner;

    @Column(name = "sleep_t1")
    private Integer sleepT1;

    @Column(name = "sleep_t2")
    private Integer sleepT2;

    @Column(name = "[describe]")
    private String describe;

    @Column(name = "[update]")
    private Date update;

    @Column(name = "status")
    private Integer status;
}
