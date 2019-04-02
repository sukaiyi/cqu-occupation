package com.cqu.occupation.workexp.service;

import com.cqu.occupation.workexp.vo.WorkExpVO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Map;

/**
 * @author sukaiyi
 */
public interface WorkExpService {

    /**
     * 删除全部
     */
    void clear();

    /**
     * 单个插入
     *
     * @param vo vo
     * @return EduExpVO
     */
    WorkExpVO insert(WorkExpVO vo);

    /**
     * 批量的新增
     *
     * @param vos users
     * @return users
     */
    List<WorkExpVO> insert(List<WorkExpVO> vos);

    /**
     * 通过 UserInfo 查询
     * @param userInfoId userInfoId
     * @return List<WorkExpVO>
     */
    List<WorkExpVO> findByUserInfo(Integer userInfoId);
}
