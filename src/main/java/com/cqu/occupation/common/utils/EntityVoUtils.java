package com.cqu.occupation.common.utils;

import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author sukaiyi
 * @date 2019/3/26
 */
public class EntityVoUtils {


    /**
     * {@link EntityVoUtils#convert(Object, Class)} 的批量版本
     *
     * @param vs     被复制的对象
     * @param eClazz 要复制成的类型
     * @param <T>    复制成的对象的类型
     * @param <V>    被复制的对象的类型
     * @return 包含了复制的结果的list
     */
    public static <T, V> List<T> convert(List<V> vs, Class<T> eClazz) {
        return vs.stream()
                .map(v -> convert(v, eClazz))
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }

    /**
     * 复制对象的属性
     *
     * @param v      被复制的对象
     * @param eClazz 要将该对象复制成什么类型
     * @param <T>    复制成的对象的类型
     * @param <V>    被复制的对象的类型
     * @return 一个新的 T 类型的对象，这个对象和 v 有相同的属性值
     */
    public static <T, V> T convert(V v, Class<T> eClazz) {
        try {
            T entity = eClazz.newInstance();
            BeanUtils.copyProperties(v, entity);
            return entity;
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
            throw new NullPointerException();
        }
    }
}
