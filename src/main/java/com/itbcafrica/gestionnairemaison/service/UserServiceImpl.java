package com.itbcafrica.gestionnairemaison.service;

import com.itbcafrica.gestionnairemaison.converter.UserConverter;
import com.itbcafrica.gestionnairemaison.dto.UserDTO;
import com.itbcafrica.gestionnairemaison.entity.UserEntity;
import com.itbcafrica.gestionnairemaison.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserConverter userConverter;

    @Override
    public UserDTO register(UserDTO userDTO) {
        UserEntity userEntity = userConverter.convertDTOtoEntity(userDTO);
        userEntity = userRepository.save(userEntity);
        return userConverter.convertEntityToDTO(userEntity);
    }

    @Override
    public UserDTO login(String email, String password) {
        return null;
    }
}
