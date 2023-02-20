package com.itbcafrica.gestionnairemaison.converter;

import com.itbcafrica.gestionnairemaison.dto.PropertyDTO;
import com.itbcafrica.gestionnairemaison.entity.PropertyEntity;
import org.springframework.stereotype.Component;

@Component
public class PropertyConverter {
    public PropertyEntity convertDTOtoEntity(PropertyDTO propertyDTO) {
        PropertyEntity propertyEntity = new PropertyEntity();
        propertyEntity.setTitle(propertyDTO.getTitle());
        propertyEntity.setAddress(propertyDTO.getAddress());
        propertyEntity.setDescription(propertyDTO.getDescription());
        propertyEntity.setPrice(propertyDTO.getPrice());
        return propertyEntity;
    }

    public PropertyDTO convertEntityToDTO(PropertyEntity propertyEntity) {
        PropertyDTO propertyDTO = new PropertyDTO();
        propertyDTO.setId(propertyEntity.getId());
        propertyDTO.setTitle(propertyEntity.getTitle());
        propertyDTO.setAddress(propertyEntity.getAddress());
        propertyDTO.setDescription(propertyEntity.getDescription());
        propertyDTO.setPrice(propertyEntity.getPrice());
        propertyDTO.setUserId(propertyEntity.getUserEntity().getId());
        return propertyDTO;
    }

}
