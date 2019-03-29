package com.cqu.occupation.crawler.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author sukaiyi
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CrawlerVO {
	private Integer crawlId;
	private String dataSource;
	private String function;
	private String strategy;
	private Integer sleepManner;
	private Integer sleepT1;
	private Integer sleepT2;
	private String describe;
	private Date update;
	private Integer status;
}
