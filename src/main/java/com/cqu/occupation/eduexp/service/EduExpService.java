package com.cqu.occupation.eduexp.service;

import com.cqu.occupation.eduexp.entity.EduExp;
import com.cqu.occupation.eduexp.vo.EduExpVO;

import java.util.List;

/**
 * @author sukaiyi
 */
public interface EduExpService {

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
    EduExpVO insert(EduExpVO vo);

    /**
     * 批量的新增
     *
     * @param vos users
     * @return users
     */
    List<EduExpVO> insert(List<EduExpVO> vos);

    /**
     * 通过 UserInfo 查询
     * @param userInfoId userInfoId
     * @return List<WorkExpVO>
     */
    List<EduExpVO> findByUserInfo(Integer userInfoId);

    /**
     * 获取最高学历
     * @return 最高学历
     */
    List<EduExp> findHighestDegree();
}
