package com.cqu.occupation.crawleraccount.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
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
	@JsonFormat(pattern="yyyy-MM-dd hh:mm:ss",timezone="GMT+8")
	private Date updateTime;
}
