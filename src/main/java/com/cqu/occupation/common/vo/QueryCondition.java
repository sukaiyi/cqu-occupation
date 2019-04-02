package com.cqu.occupation.common.vo;

import com.cqu.occupation.common.constant.Comparator;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author sukaiyi
 * @date 2019/3/22
 */
@Data
@NoArgsConstructor
public class QueryCondition {
    private String field;
    private String value;
    private Comparator comparator = Comparator.EQ;
}
