package com.itbcafrica.gestionnairemaison.service;

import com.itbcafrica.gestionnairemaison.converter.UserConverter;
import com.itbcafrica.gestionnairemaison.dto.UserDTO;
import com.itbcafrica.gestionnairemaison.entity.UserEntity;
import com.itbcafrica.gestionnairemaison.exception.BusinessException;
import com.itbcafrica.gestionnairemaison.exception.ErrorModel;
import com.itbcafrica.gestionnairemaison.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserConverter userConverter;

    @Override
    public UserDTO register(UserDTO userDTO) {
        Optional<UserEntity> userEntityOptional = userRepository.findByOwnerEmail(userDTO.getOwnerEmail());
        if (userEntityOptional.isPresent()) {
            List<ErrorModel> errorModelList = new ArrayList<>();
            ErrorModel errorModel = new ErrorModel();
            errorModel.setCode("EMAIL_ALREADY_EXIST");
            errorModel.setMessage("The email with  which you are trying to register already exist");
            errorModelList.add(errorModel);
            throw new BusinessException(errorModelList);
        }
        UserEntity userEntity = userConverter.convertDTOtoEntity(userDTO);
        userEntity = userRepository.save(userEntity);
        return userConverter.convertEntityToDTO(userEntity);
    }

    @Override
    public UserDTO login(String email, String password) {
        UserDTO userDTO = null;
        Optional<UserEntity> userEntityOptional = userRepository.findByOwnerEmailAndPassword(email, password);
        if (userEntityOptional.isPresent()) {
            userDTO = userConverter.convertEntityToDTO(userEntityOptional.get());
        } else {
            List<ErrorModel> errorModelList = new ArrayList<>();
            ErrorModel errorModel = new ErrorModel();
            errorModel.setCode("INVALID_LOGIN");
            errorModel.setMessage("Incorrect Email or Password");
            errorModelList.add(errorModel);
            throw new BusinessException(errorModelList);
        }
        return userDTO;
    }
}
