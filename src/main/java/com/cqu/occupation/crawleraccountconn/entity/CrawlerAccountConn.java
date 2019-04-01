package com.cqu.occupation.crawleraccountconn.entity;

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
@Table(name = "connection")
public class CrawlerAccountConn {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "crawler_id")
    private Integer crawlerId;

    @Column(name = "account_id")
    private Integer accountId;

}
