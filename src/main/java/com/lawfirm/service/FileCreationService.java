package com.lawfirm.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.lawfirm.dto.FileCreationDTO;

public interface FileCreationService {

	public FileCreationDTO createFileCreation(FileCreationDTO fileCreationDTO, MultipartFile documents);

	public FileCreationDTO getFileCreationById(Integer fileId);

	public List<FileCreationDTO> getAllFileCreations();

	public FileCreationDTO updateFileCreation(Integer fileId, FileCreationDTO fileCreationDTO, MultipartFile documents);

	public String deleteFileCreation(Integer fileId);

}
