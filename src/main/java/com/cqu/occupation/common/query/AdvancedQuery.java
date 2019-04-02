package com.cqu.occupation.common.query;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.ReflectUtil;
import com.cqu.occupation.common.constant.Comparator;
import com.cqu.occupation.common.vo.QueryCondition;
import com.cqu.occupation.common.vo.QueryScheme;
import com.cqu.occupation.global.exception.exceptions.BusinessException;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author sukaiyi
 * @date 2019/3/25
 */
@Component
public class AdvancedQuery<T> {

    /**
     * 通过 QueryScheme 对象进行复杂的过滤查询
     *
     * @param clazz       查询的对象
     * @param repository  repository
     * @param queryScheme 查询条件
     * @return 按 queryScheme 条件查询的结果
     */
    public Page<T> query(Class<T> clazz, JpaRepository<T, Integer> repository, QueryScheme queryScheme) {
        T t = null;
        try {
            t = clazz.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
            throw new BusinessException(e.getMessage());
        }
        ExampleMatcher matcher = ExampleMatcher.matching();
        List<QueryCondition> conditions = queryScheme.getCondition();
        if (conditions != null && conditions.size() > 0) {
            for (QueryCondition condition : conditions) {
                ReflectUtil.setFieldValue(t, condition.getField(), condition.getValue());
                if (condition.getComparator() == Comparator.CN) {
                    matcher = matcher.withMatcher(condition.getField(), ExampleMatcher.GenericPropertyMatchers.contains());
                } else {
                    matcher = matcher.withMatcher(condition.getField(), ExampleMatcher.GenericPropertyMatchers.exact());
                }
            }
        }
        Example<T> example = Example.of(t, matcher);
        Pageable pageable = PageRequest.of(queryScheme.getPageNum() - 1, queryScheme.getPageSize());
        return repository.findAll(example, pageable);
    }
}
