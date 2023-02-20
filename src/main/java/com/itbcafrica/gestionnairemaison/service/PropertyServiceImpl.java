package com.itbcafrica.gestionnairemaison.service;

import com.itbcafrica.gestionnairemaison.converter.PropertyConverter;
import com.itbcafrica.gestionnairemaison.dto.PropertyDTO;
import com.itbcafrica.gestionnairemaison.entity.PropertyEntity;
import com.itbcafrica.gestionnairemaison.entity.UserEntity;
import com.itbcafrica.gestionnairemaison.exception.BusinessException;
import com.itbcafrica.gestionnairemaison.exception.ErrorModel;
import com.itbcafrica.gestionnairemaison.repository.PropertyRepository;
import com.itbcafrica.gestionnairemaison.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PropertyServiceImpl implements PropertyService {
    @Autowired
    private PropertyRepository propertyRepository;

    @Autowired
    private PropertyConverter converter;
    @Autowired
    private UserRepository userRepository;

    @Override
    public PropertyDTO saveProperty(PropertyDTO propertyDTO) {
        PropertyDTO dto = null;
        Optional<UserEntity> userEntity = userRepository.findById(propertyDTO.getUserId());
        if (userEntity.isPresent()) {
            PropertyEntity propertyEntity = converter.convertDTOtoEntity(propertyDTO);
            propertyEntity.setUserEntity(userEntity.get());
            propertyEntity = propertyRepository.save(propertyEntity);
            dto = converter.convertEntityToDTO(propertyEntity);
        } else {
            List<ErrorModel> errorModelList = new ArrayList<>();
            ErrorModel errorModel = new ErrorModel();
            errorModel.setCode("USER_ID_NOT_EXIST");
            errorModel.setMessage("User does not exist");
            errorModelList.add(errorModel);
            throw new BusinessException(errorModelList);
        }

        return dto;
    }

    @Override
    public List<PropertyDTO> getAllProperties() {
        List<PropertyEntity> entities = (List<PropertyEntity>) propertyRepository.findAll();
        List<PropertyDTO> dtoList = new ArrayList<>();
        for (PropertyEntity pe : entities) {
            dtoList.add(converter.convertEntityToDTO(pe));
        }
        return dtoList;
    }

    @Override
    public PropertyDTO updateProperty(PropertyDTO propertyDTO, Long propertyId) {
        Optional<PropertyEntity> optionalPropertyEntity = propertyRepository.findById(propertyId);
        PropertyDTO dto = null;
        if (optionalPropertyEntity.isPresent()) {
            PropertyEntity propertyEntity = optionalPropertyEntity.get();
            propertyEntity.setTitle(propertyDTO.getTitle());
            propertyEntity.setAddress(propertyDTO.getAddress());
            propertyEntity.setDescription(propertyDTO.getDescription());
            propertyEntity.setPrice(propertyDTO.getPrice());
            PropertyEntity entity = propertyRepository.save(propertyEntity);
            dto = converter.convertEntityToDTO(entity);

        }
        return dto;
    }

    @Override
    public PropertyDTO updatePropertyPrice(PropertyDTO propertyDTO, Long propertyId) {
        Optional<PropertyEntity> optionalPropertyEntity = propertyRepository.findById(propertyId);
        PropertyDTO dto = null;
        if (optionalPropertyEntity.isPresent()) {
            PropertyEntity propertyEntity = optionalPropertyEntity.get();
            propertyEntity.setPrice(propertyDTO.getPrice());
            PropertyEntity entity = propertyRepository.save(propertyEntity);
            dto = converter.convertEntityToDTO(entity);

        }
        return dto;
    }

    @Override
    public PropertyDTO updatePropertyDescription(PropertyDTO propertyDTO, Long propertyId) {
        Optional<PropertyEntity> optionalPropertyEntity = propertyRepository.findById(propertyId);
        PropertyDTO dto = null;
        if (optionalPropertyEntity.isPresent()) {
            PropertyEntity propertyEntity = optionalPropertyEntity.get();
            propertyEntity.setDescription(propertyDTO.getDescription());
            PropertyEntity entity = propertyRepository.save(propertyEntity);
            dto = converter.convertEntityToDTO(entity);

        }
        return dto;
    }

    @Override
    public void deleteProperty(Long propertyId) {
        propertyRepository.deleteById(propertyId);
    }

    @Override
    public List<PropertyDTO> getAllPropertiesByUser(Long user_id) {
        List<PropertyEntity> entities = (List<PropertyEntity>) propertyRepository.findALlByUserEntityId(user_id);
        List<PropertyDTO> dtoList = new ArrayList<>();
        for (PropertyEntity pe : entities) {
            dtoList.add(converter.convertEntityToDTO(pe));
        }
        return dtoList;
    }
}
