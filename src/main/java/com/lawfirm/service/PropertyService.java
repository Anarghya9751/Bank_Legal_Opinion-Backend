package com.lawfirm.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.lawfirm.dto.PropertyDTO;

public interface PropertyService {

	public PropertyDTO saveProperty(PropertyDTO propertyDTO, MultipartFile registeredDocumentType);

	public PropertyDTO updateProperty(Long propertyId, PropertyDTO propertyDTO, MultipartFile registeredDocumentType);

	public PropertyDTO getPropertyById(Long propertyId);

	public List<PropertyDTO> getAllProperties();

	public String deleteProperty(Long propertyId);
}
