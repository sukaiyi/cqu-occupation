package com.cqu.occupation.common.vo;

import com.cqu.occupation.common.constant.Sort;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author sukaiyi
 * @date 2019/3/25
 */
@Data
@NoArgsConstructor
public class QuerySort {
    private String field;
    private Sort sort = Sort.ASC;
}
