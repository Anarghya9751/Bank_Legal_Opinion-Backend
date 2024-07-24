package com.anarghya.bank.service;

import com.anarghya.bank.entity.FileCreationEntity;
import com.anarghya.bank.entity.PropertyDetailsEntity;
import com.anarghya.bank.repository.FileCreationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class FileCreationServiceImpl implements FileCreationService {

    @Autowired
    private FileCreationRepository fileCreationRepository;

    @Override
    public FileCreationEntity saveFile(String branch, String clientName, Long mobile, String address,
                                       List<PropertyDetailsEntity> properties, MultipartFile documents,
                                       String documentName, String verifiedStatus) {
        FileCreationEntity fileCreationEntity = new FileCreationEntity();
        fileCreationEntity.setBranch(branch);
        fileCreationEntity.setClientName(clientName);
        fileCreationEntity.setMobile(mobile);
        fileCreationEntity.setAddress(address);
        fileCreationEntity.setProperties(properties);
        fileCreationEntity.setDocumentName(documentName);
        fileCreationEntity.setVerifiedStatus(verifiedStatus);

        try {
            if (documents != null && !documents.isEmpty()) {
                String base64String = Base64.getEncoder().encodeToString(documents.getBytes());
                fileCreationEntity.setDocuments(base64String);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return fileCreationRepository.save(fileCreationEntity);
    }

    @Override
    public FileCreationEntity updateFile(Integer fileId, String branch, String clientName, Long mobile, String address,
                                         List<PropertyDetailsEntity> properties, MultipartFile documents,
                                         String documentName, String verifiedStatus) {
        Optional<FileCreationEntity> fileCreationEntityOptional = fileCreationRepository.findById(fileId);
        if (fileCreationEntityOptional.isPresent()) {
            FileCreationEntity fileCreationEntity = fileCreationEntityOptional.get();
            fileCreationEntity.setBranch(branch);
            fileCreationEntity.setClientName(clientName);
            fileCreationEntity.setMobile(mobile);
            fileCreationEntity.setAddress(address);
            fileCreationEntity.setProperties(properties);
            fileCreationEntity.setDocumentName(documentName);
            fileCreationEntity.setVerifiedStatus(verifiedStatus);

            try {
                if (documents != null && !documents.isEmpty()) {
                    String base64String = Base64.getEncoder().encodeToString(documents.getBytes());
                    fileCreationEntity.setDocuments(base64String);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            return fileCreationRepository.save(fileCreationEntity);
        } else {
            throw new IllegalArgumentException("File with ID " + fileId + " not found");
        }
    }

    @Override
    public FileCreationEntity getFileById(Integer fileId) {
        Optional<FileCreationEntity> fileCreationEntityOptional = fileCreationRepository.findById(fileId);
        return fileCreationEntityOptional.orElse(null);
    }

    @Override
    public List<FileCreationEntity> getAllFiles() {
        return fileCreationRepository.findAll();
    }

    @Override
    public String deleteFileById(Integer fileId) {
        Optional<FileCreationEntity> fileCreationEntityOptional = fileCreationRepository.findById(fileId);
        if (fileCreationEntityOptional.isPresent()) {
            fileCreationRepository.deleteById(fileId);
            return "File with ID " + fileId + " deleted successfully";
        } else {
            return "File with ID " + fileId + " not found";
        }
    }
}
