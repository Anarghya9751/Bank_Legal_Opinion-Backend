package com.lawfirm.serviceimpl;

import java.io.IOException;
import java.util.Base64;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.lawfirm.dto.FileCreationDTO;
import com.lawfirm.entity.FileCreationEntity;
import com.lawfirm.entity.PropertyDetailsEntity;
import com.lawfirm.entity.BankEntity;
import com.lawfirm.exception.InvalidInputException;
import com.lawfirm.exception.ResourceNotFoundException;
import com.lawfirm.repo.FileCreationRepository;
import com.lawfirm.repo.PropertyDetailsRepository;
import com.lawfirm.repo.BankRepository;
import com.lawfirm.service.FileCreationService;

@Service
public class FileCreationServiceImpl implements FileCreationService {

    @Autowired
    private FileCreationRepository fileCreationRepository;

    @Autowired
    private PropertyDetailsRepository propertyDetailsRepository;

    @Autowired
    private BankRepository bankRepository;

    @Override
    public FileCreationDTO createFileCreation(FileCreationDTO fileCreationDTO, MultipartFile documents) {
        FileCreationEntity fileCreationEntity = new FileCreationEntity();
        BeanUtils.copyProperties(fileCreationDTO, fileCreationEntity);

        if (documents != null && !documents.isEmpty()) {
            try {
                // Encode document file to Base64 string
                String encodedImage = Base64.getEncoder().encodeToString(documents.getBytes());
                fileCreationEntity.setDocuments(encodedImage);
            } catch (IOException e) {
                throw new InvalidInputException("Error encoding the document to Base64", e);
            }
        } else {
            throw new InvalidInputException("Document file must be provided");
        }

        if (fileCreationDTO.getProperty() != null) {
            PropertyDetailsEntity property = propertyDetailsRepository.findById(fileCreationDTO.getProperty().getPropertyId())
                .orElseThrow(() -> new ResourceNotFoundException("Property not found with id: " + fileCreationDTO.getProperty().getPropertyId()));
            fileCreationEntity.setProperty(property);
        }

        if (fileCreationDTO.getBank() != null && fileCreationDTO.getBank().getBankId() != null) {
            BankEntity bank = bankRepository.findById(fileCreationDTO.getBank().getBankId())
                .orElseThrow(() -> new ResourceNotFoundException("Bank not found with id: " + fileCreationDTO.getBank().getBankId()));
            fileCreationEntity.setBank(bank);
        }

        FileCreationEntity savedEntity = fileCreationRepository.save(fileCreationEntity);
        FileCreationDTO savedFileCreationDTO = new FileCreationDTO();
        BeanUtils.copyProperties(savedEntity, savedFileCreationDTO);
        return savedFileCreationDTO;
    }

    @Override
    public FileCreationDTO getFileCreationById(Integer fileId) {
        FileCreationEntity fileCreationEntity = fileCreationRepository.findById(fileId)
            .orElseThrow(() -> new ResourceNotFoundException("File creation record not found with id: " + fileId));
        FileCreationDTO fileCreationDTO = new FileCreationDTO();
        BeanUtils.copyProperties(fileCreationEntity, fileCreationDTO);
        return fileCreationDTO;
    }

    @Override
    public List<FileCreationDTO> getAllFileCreations() {
        List<FileCreationEntity> fileCreationEntities = fileCreationRepository.findAll();
        return fileCreationEntities.stream().map(entity -> {
            FileCreationDTO dto = new FileCreationDTO();
            BeanUtils.copyProperties(entity, dto);
            return dto;
        }).collect(Collectors.toList());
    }

    @Override
    public FileCreationDTO updateFileCreation(Integer fileId, FileCreationDTO fileCreationDTO, MultipartFile documents) {
        FileCreationEntity fileCreationEntity = fileCreationRepository.findById(fileId)
            .orElseThrow(() -> new ResourceNotFoundException("File creation record not found with id: " + fileId));

        BeanUtils.copyProperties(fileCreationDTO, fileCreationEntity, "fileId");

        if (documents != null && !documents.isEmpty()) {
            try {
                // Encode document file to Base64 string
                String encodedImage = Base64.getEncoder().encodeToString(documents.getBytes());
                fileCreationEntity.setDocuments(encodedImage);
            } catch (IOException e) {
                throw new InvalidInputException("Error encoding the document to Base64", e);
            }
        }

        if (fileCreationDTO.getProperty() != null) {
            PropertyDetailsEntity property = propertyDetailsRepository.findById(fileCreationDTO.getProperty().getPropertyId())
                .orElseThrow(() -> new ResourceNotFoundException("Property not found with id: " + fileCreationDTO.getProperty().getPropertyId()));
            fileCreationEntity.setProperty(property);
        }

        if (fileCreationDTO.getBank() != null && fileCreationDTO.getBank().getBankId() != null) {
            BankEntity bank = bankRepository.findById(fileCreationDTO.getBank().getBankId())
                .orElseThrow(() -> new ResourceNotFoundException("Bank not found with id: " + fileCreationDTO.getBank().getBankId()));
            fileCreationEntity.setBank(bank);
        }

        FileCreationEntity updatedEntity = fileCreationRepository.save(fileCreationEntity);
        FileCreationDTO updatedFileCreationDTO = new FileCreationDTO();
        BeanUtils.copyProperties(updatedEntity, updatedFileCreationDTO);
        return updatedFileCreationDTO;
    }

    @Override
    public String deleteFileCreation(Integer fileId) {
        if (!fileCreationRepository.existsById(fileId)) {
            throw new ResourceNotFoundException("File creation record not found with id: " + fileId);
        }
        fileCreationRepository.deleteById(fileId);
        return "File creation record deleted successfully";
    }
}
