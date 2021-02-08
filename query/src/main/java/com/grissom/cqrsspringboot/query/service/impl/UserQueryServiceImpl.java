package com.grissom.cqrsspringboot.query.service.impl;

import com.grissom.cqrsspringboot.query.dao.UserQueryMapper;
import com.grissom.cqrsspringboot.query.dto.UserQueryDTO;
import com.grissom.cqrsspringboot.query.service.UserQueryService;
import org.springframework.stereotype.Service;

/**
 * @author Grissom
 * @date 2/3/2021 11:53 AM
 **/
@Service
public class UserQueryServiceImpl implements UserQueryService {
    private UserQueryMapper userQueryMapper;
    public UserQueryServiceImpl(UserQueryMapper userQueryMapper){
        this.userQueryMapper = userQueryMapper;
    }
    @Override
    public String getName(Long id) {
        return "my name is grissom" + id;
    }

    @Override
    public UserQueryDTO getUser(Long id) {
        return this.userQueryMapper.getUserById(id);
    }
}
