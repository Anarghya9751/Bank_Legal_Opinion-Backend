package com.tejaswi.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.tejaswi.entity.FileCreationEntity;
import com.tejaswi.entity.PropertyDetailsEntity;



public interface FileCreationService 
{
	public FileCreationEntity saveFile(String entity,String branch, String clientName, String mobile, String address,
			List<PropertyDetailsEntity> properties, MultipartFile documents, String documentName,
			String verifiedStatus);

	public FileCreationEntity updateFile(Integer fileId,String entity, String branch, String clientName, String mobile, String address,
			List<PropertyDetailsEntity> properties, MultipartFile documents, String documentName,
			String verifiedStatus);

	public FileCreationEntity getFileById(Integer fileId);

	public List<FileCreationEntity> getAllFiles();

	public String deleteFileById(Integer fileId);
}
