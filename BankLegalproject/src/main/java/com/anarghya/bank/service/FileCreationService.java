package com.anarghya.bank.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.anarghya.bank.entity.FileCreationEntity;
import com.anarghya.bank.entity.PropertyDetailsEntity;

public interface FileCreationService {

	public FileCreationEntity saveFile(String branch, String clientName, Long mobile, String address,
			List<PropertyDetailsEntity> properties, MultipartFile documents, String documentName,
			String verifiedStatus);

	public FileCreationEntity updateFile(Integer fileId, String branch, String clientName, Long mobile, String address,
			List<PropertyDetailsEntity> properties, MultipartFile documents, String documentName,
			String verifiedStatus);

	public FileCreationEntity getFileById(Integer fileId);

	public List<FileCreationEntity> getAllFiles();

	public String deleteFileById(Integer fileId);
}
