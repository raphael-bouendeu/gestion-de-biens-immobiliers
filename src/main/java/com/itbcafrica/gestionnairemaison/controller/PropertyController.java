package com.itbcafrica.gestionnairemaison.controller;

import com.itbcafrica.gestionnairemaison.dto.PropertyDTO;
import com.itbcafrica.gestionnairemaison.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class PropertyController {
    @Value("${psm.dummy}")
    private String dummy2;

    @Autowired
    private PropertyService propertyService;

    @GetMapping("/hello")
    public String sayHello() {
        return "hello";
    }

    @PostMapping("/properties")
    public ResponseEntity<PropertyDTO> saveProperty(@RequestBody PropertyDTO propertyDTO) {
        PropertyDTO dto = propertyService.saveProperty(propertyDTO);
        return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }

    @GetMapping("/properties")
    public ResponseEntity<List<PropertyDTO>> getAllProperties() {
        List<PropertyDTO> list = propertyService.getAllProperties();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/properties/users/{user_id}")
    public ResponseEntity<List<PropertyDTO>> getAllPropertiesByUser(@PathVariable("user_id") Long user_id) {
        List<PropertyDTO> list = propertyService.getAllProperties();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @PutMapping("/properties/{propertyId}")
    public ResponseEntity<PropertyDTO> updateProperty(@RequestBody PropertyDTO propertyDTO, @PathVariable Long propertyId) {
        PropertyDTO dto = propertyService.updateProperty(propertyDTO, propertyId);
        return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }

    @PatchMapping("/properties/update-price/{propertyId}")
    public ResponseEntity<PropertyDTO> updatePropertyPrice(@RequestBody PropertyDTO propertyDTO, @PathVariable Long propertyId) {
        PropertyDTO dto = propertyService.updatePropertyPrice(propertyDTO, propertyId);
        return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }

    @PatchMapping("/properties/update-description/{propertyId}")
    public ResponseEntity<PropertyDTO> updatePropertyDescription(@RequestBody PropertyDTO propertyDTO, @PathVariable Long propertyId) {
        PropertyDTO dto = propertyService.updatePropertyDescription(propertyDTO, propertyId);
        return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }

    @DeleteMapping("/properties/{propertyId}")
    public ResponseEntity<Void> deleteProperty(@Nullable @PathVariable Long propertyId) {
        propertyService.deleteProperty(propertyId);
        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }
}
