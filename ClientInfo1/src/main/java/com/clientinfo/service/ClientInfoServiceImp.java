package com.clientinfo.service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.clientinfo.entity.ClientInfoEntity;
import com.clientinfo.excepction.IdNotFoundException;
import com.clientinfo.repository.ClientInfoRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ClientInfoServiceImp implements ClientInfoService {

	@Autowired
	private ClientInfoRepository clientrepo;

	@Override
	public ClientInfoEntity saveclientinfo(ClientInfoEntity clientInfo, MultipartFile adharcard, MultipartFile panCard,
			MultipartFile passport) {
		try {
			// Handle files and convert them to byte arrays
			if (adharcard != null && !adharcard.isEmpty()) {
				clientInfo.setAdharcard(adharcard.getBytes());
			}
			if (panCard != null && !panCard.isEmpty()) {
				clientInfo.setPanCard(panCard.getBytes());
			}
			if (passport != null && !passport.isEmpty()) {
				clientInfo.setPassport(passport.getBytes());
			}
		} catch (IOException e) {
			// Handle file conversion errors
			throw new RuntimeException("Error while processing files: " + e.getMessage(), e);
		}

		return clientrepo.save(clientInfo);

	}

	@Override
	public ClientInfoEntity updateClientInfo(Long id, ClientInfoEntity clientInfo, MultipartFile adharcard,
			MultipartFile panCard, MultipartFile passport) {
// Check if the entity with the given ID exists
		Optional<ClientInfoEntity> existingEntityOpt = clientrepo.findById(id);
		if (existingEntityOpt.isEmpty()) {
			throw new EntityNotFoundException("ClientInfoEntity with id " + id + " not found");
		}

		ClientInfoEntity existingEntity = existingEntityOpt.get();

// Update the existing entity with the new values
		existingEntity.setName(clientInfo.getName());
		existingEntity.setFatherName(clientInfo.getFatherName());
		existingEntity.setMotherName(clientInfo.getMotherName());
		existingEntity.setGender(clientInfo.getGender());
		existingEntity.setMarkOfIdentity(clientInfo.getMarkOfIdentity());
		existingEntity.setMobileNumber(clientInfo.getMobileNumber());
		existingEntity.setEmail(clientInfo.getEmail());
		existingEntity.setAddress(clientInfo.getAddress());
		existingEntity.setDateOfBirth(clientInfo.getDateOfBirth());

       // Handle the file uploads
		try {
			if (adharcard != null && !adharcard.isEmpty()) {
				existingEntity.setAdharcard(adharcard.getBytes());
			}
			if (panCard != null && !panCard.isEmpty()) {
				existingEntity.setPanCard(panCard.getBytes());
			}
			if (passport != null && !passport.isEmpty()) {
				existingEntity.setPassport(passport.getBytes());
			}
		} catch (IOException e) {
			throw new RuntimeException("Failed to process files", e);
		}
		return clientrepo.save(existingEntity);
	}

	
	
	
	@Override
	public ClientInfoEntity getClientInfoById(Long id) {
		return clientrepo.findById(id).orElseThrow(() -> new IdNotFoundException("IdNotFound" + id));
		// TODO Auto-generated method stub

	}

	@Override
	public List<ClientInfoEntity> getAllclients() {
		// TODO Auto-generated method stub
		return clientrepo.findAll();
	}

	@Override
	public String deleteById(Long id) {
		if (clientrepo.existsById(id)) {
			clientrepo.deleteById(id);
			return "deleted sucessfully";

		}
		return "No user found";
	}

}
