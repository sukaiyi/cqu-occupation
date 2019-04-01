package com.cqu.occupation.crawleraccount.vo;

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
public class CrawlerAccountVO {
	private Integer id;
	private String accountNumber;
	private String password;
	private String sourceId;
	private Integer status;
	private Date updateTime;
}
