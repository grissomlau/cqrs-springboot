package com.grissom.cqrsspringboot.query.service;

import com.grissom.cqrsspringboot.query.dto.UserQueryDTO;

/**
 * @author Grissom
 * @date 2/3/2021 11:52 AM
 **/
public interface UserQueryService {
    String getName(Long id);
    UserQueryDTO getUser(Long id);
}
