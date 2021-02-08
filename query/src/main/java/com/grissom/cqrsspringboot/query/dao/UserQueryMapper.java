package com.grissom.cqrsspringboot.query.dao;

import com.grissom.cqrsspringboot.query.dto.UserQueryDTO;
import org.springframework.stereotype.Repository;

/**
 * @author Grissom
 * @date 2/3/2021 7:09 PM
 **/
@Repository
public interface UserQueryMapper {
    UserQueryDTO getUserById(Long id);
}
