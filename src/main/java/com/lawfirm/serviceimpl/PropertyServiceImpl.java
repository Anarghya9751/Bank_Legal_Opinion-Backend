package com.lawfirm.serviceimpl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.lawfirm.dto.PropertyDTO;
import com.lawfirm.entity.PropertyDetailsEntity;
import com.lawfirm.exception.ResourceNotFoundException;
import com.lawfirm.repo.PropertyDetailsRepository;
import com.lawfirm.service.PropertyService;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PropertyServiceImpl implements PropertyService {

    @Autowired
    private PropertyDetailsRepository propertyRepository;

    @Override
    public PropertyDTO saveProperty(PropertyDTO propertyDTO, MultipartFile registeredDocumentType) {
        if (registeredDocumentType != null && !registeredDocumentType.isEmpty()) {
            try {
                propertyDTO.setRegisteredDocumentType(registeredDocumentType.getBytes());
            } catch (IOException e) {
                throw new RuntimeException("Error saving document", e);
            }
        }

        PropertyDetailsEntity propertyDetailsEntity = new PropertyDetailsEntity();
        BeanUtils.copyProperties(propertyDTO, propertyDetailsEntity);
        PropertyDetailsEntity savedProperty = propertyRepository.save(propertyDetailsEntity);
        PropertyDTO savedPropertyDTO = new PropertyDTO();
        BeanUtils.copyProperties(savedProperty, savedPropertyDTO);

        return savedPropertyDTO;
    }


    @Override
    public PropertyDTO getPropertyById(Long propertyId) {
        PropertyDetailsEntity propertyDetailsEntity = propertyRepository.findById(propertyId)
                .orElseThrow(() -> new ResourceNotFoundException("Property not found with id: " + propertyId));
        PropertyDTO propertyDTO = new PropertyDTO();
        BeanUtils.copyProperties(propertyDetailsEntity, propertyDTO);

        return propertyDTO;
    }

    @Override
    public PropertyDTO updateProperty(Long propertyId, PropertyDTO propertyDTO, MultipartFile registeredDocumentType) {
        PropertyDetailsEntity existingProperty = propertyRepository.findById(propertyId)
                .orElseThrow(() -> new ResourceNotFoundException("Property not found with id: " + propertyId));

        if (registeredDocumentType != null && !registeredDocumentType.isEmpty()) {
            try {
                existingProperty.setRegisteredDocumentType(registeredDocumentType.getBytes());
            } catch (IOException e) {
                throw new RuntimeException("Error saving document", e);
            }
        }

        BeanUtils.copyProperties(propertyDTO, existingProperty, "registeredDocumentType"); // Exclude document type
        PropertyDetailsEntity updatedProperty = propertyRepository.save(existingProperty);
        PropertyDTO updatedPropertyDTO = new PropertyDTO();
        BeanUtils.copyProperties(updatedProperty, updatedPropertyDTO);

        return updatedPropertyDTO;
    }

    @Override
    public String deleteProperty(Long propertyId) {
        if (!propertyRepository.existsById(propertyId)) {
            throw new ResourceNotFoundException("Property not found with id: " + propertyId);
        }
        propertyRepository.deleteById(propertyId);
        return "Property deleted successfully";
    }

    @Override
    public List<PropertyDTO> getAllProperties() {
        List<PropertyDetailsEntity> properties = propertyRepository.findAll();
        return properties.stream()
                .map(property -> {
                    PropertyDTO propertyDTO = new PropertyDTO();
                    BeanUtils.copyProperties(property, propertyDTO);
                    return propertyDTO;
                })
                .collect(Collectors.toList());
    }
}
