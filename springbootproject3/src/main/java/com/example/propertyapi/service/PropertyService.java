package com.example.propertyapi.service;

import com.example.propertyapi.model.Property;
import com.example.propertyapi.repository.PropertyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PropertyService {

    @Autowired
    private PropertyRepository propertyRepository;

    public Property saveProperty(Property property) {
        return propertyRepository.save(property);
    }

    public Optional<Property> getPropertyById(Long id) {
        return propertyRepository.findById(id);
    }

    public void deleteProperty(Long id) {
        propertyRepository.deleteById(id);
    }

    public Property updateProperty(Long id, Property propertyDetails) {
        Property property = propertyRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Property not found"));

        property.setPropertyType(propertyDetails.getPropertyType());
        property.setExtentInSqYds(propertyDetails.getExtentInSqYds());
        property.setAddress(propertyDetails.getAddress());
        property.setEast(propertyDetails.getEast());
        property.setWest(propertyDetails.getWest());
        property.setNorth(propertyDetails.getNorth());
        property.setSouth(propertyDetails.getSouth());
        property.setCurrentOwnerName(propertyDetails.getCurrentOwnerName());
        property.setDocumentType(propertyDetails.getDocumentType());
        property.setDocumentNumber(propertyDetails.getDocumentNumber());
        property.setYearOfPurchase(propertyDetails.getYearOfPurchase());
        property.setSellerName(propertyDetails.getSellerName());
        property.setRegistrationDate(propertyDetails.getRegistrationDate());
        property.setRegistrarOffice(propertyDetails.getRegistrarOffice());

        return propertyRepository.save(property);
    }
}