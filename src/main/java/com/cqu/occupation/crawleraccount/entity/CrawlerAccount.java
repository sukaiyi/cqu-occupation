package com.cqu.occupation.crawleraccount.entity;

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
@Table(name = "crawl_account")
public class CrawlerAccount {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "account_number")
    private String accountNumber;

    @Column(name = "password")
    private String password;

    @Column(name = "source_id")
    private String sourceId;

    @Column(name = "status")
    private Integer status;

    @Column(name = "[update_time]")
    private Date updateTime;
}
