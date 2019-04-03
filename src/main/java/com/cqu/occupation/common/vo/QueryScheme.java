package com.cqu.occupation.common.vo;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author sukaiyi
 * @date 2019/3/22
 */
@Data
@NoArgsConstructor
public class QueryScheme {
    private Integer pageNum = 0;
    private Integer pageSize = 10;

    private List<QueryCondition> condition;
    private List<QuerySort> sort;
}
