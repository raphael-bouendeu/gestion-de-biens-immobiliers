package com.itbcafrica.gestionnairemaison.service;

import com.itbcafrica.gestionnairemaison.dto.UserDTO;
import com.itbcafrica.gestionnairemaison.exception.BusinessException;

public interface UserService {
    UserDTO register(UserDTO userDTO);

    UserDTO login(String email, String password) throws BusinessException;
}
