package com.cqu.occupation.user.service.impl;

import com.auth0.jwt.interfaces.DecodedJWT;
import com.cqu.occupation.common.utils.EntityVoUtils;
import com.cqu.occupation.common.utils.MD5Util;
import com.cqu.occupation.global.exception.exceptions.BusinessException;
import com.cqu.occupation.global.jwt.JwtUtils;
import com.cqu.occupation.user.entity.User;
import com.cqu.occupation.user.repository.UserRepository;
import com.cqu.occupation.user.service.UserService;
import com.cqu.occupation.user.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author sukaiyi
 */
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository repository;

    @Autowired
    public UserServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public void clear() {
        repository.deleteAll();
    }

    @Override
    public Page<UserVO> findAll(Pageable pageable) {
        Page<User> page = repository.findAll(pageable);
        List<User> entities = page.getContent();
        List<UserVO> vos = EntityVoUtils.convert(entities, UserVO.class);
        return new PageImpl<>(vos, pageable, page.getTotalElements());
    }

    @Override
    public UserVO insert(UserVO vo) {
        User entity = EntityVoUtils.convert(vo, User.class);
        User savedEntity = repository.save(entity);
        return EntityVoUtils.convert(savedEntity, UserVO.class);
    }

    @Override
    public List<UserVO> insert(List<UserVO> vos) {
        List<User> entities = EntityVoUtils.convert(vos, User.class);
        List<User> savedEntities = repository.saveAll(entities);
        return EntityVoUtils.convert(savedEntities, UserVO.class);
    }

    @Override
    public Map<String, Object> login(UserVO vo) {
        User user = repository.findByUsername(vo.getUsername()).orElse(null);
        if (user == null) {
            throw new BusinessException("用户不存在");
        }
        String md5Password = MD5Util.encode(vo.getPassword());
        if (md5Password.equals(user.getPassword())) {
            return new HashMap<String, Object>() {{
                put("token", JwtUtils.createToken(user));
                put("userType", user.getType());
            }};
        }
        throw new BusinessException("用户名或密码错误");
    }

    @Override
    public UserVO currentUser(String token) {
        DecodedJWT jwt = JwtUtils.decodeJWT(token);
        if (jwt == null) {
            throw new BusinessException("token 不存在或已过期");
        }
        String userName = jwt.getClaim("username").as(String.class);
        User user = repository.findByUsername(userName).orElse(null);
        if (user == null) {
            throw new BusinessException("用户不存在");
        }
        UserVO vo = EntityVoUtils.convert(user,UserVO.class);
        vo.setAvatar("https://gw.alipayobjects.com/zos/antfincdn/XAosXuNZyF/BiazfanxmamNRoxxVxka.png");
        vo.setName(vo.getUsername());
        return vo;
    }
}
