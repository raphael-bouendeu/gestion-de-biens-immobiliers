package com.itbcafrica.gestionnairemaison.service;

import com.itbcafrica.gestionnairemaison.dto.UserDTO;

public interface UserService {
    UserDTO register(UserDTO userDTO);

    UserDTO login(String email, String password);
}
