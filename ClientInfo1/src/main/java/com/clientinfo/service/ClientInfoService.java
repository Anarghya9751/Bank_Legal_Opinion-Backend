package com.clientinfo.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.clientinfo.entity.ClientInfoEntity;

public interface ClientInfoService {
	public ClientInfoEntity saveclientinfo(ClientInfoEntity clientInfo, MultipartFile adharcard, MultipartFile panCard,
			MultipartFile passport);

	public ClientInfoEntity getClientInfoById(Long id);

	public List<ClientInfoEntity> getAllclients();

	public ClientInfoEntity updateClientInfo(Long id , ClientInfoEntity clientInfo, MultipartFile adharcard, MultipartFile panCard,
			MultipartFile passport);

	public String deleteById(Long id);

//	ClientInfoEntity updateClientInfo(ClientInfoEntity clientInfo);
//	ClientInfoEntity getClientInfoEntity(Long id);
//	Optional<ClientInfoEntity> getById(Long id);
//	Optional<ClientInfoEntity> ClientInfoById(Long id);
//	void deleteClientInfo(Long id);
//		
}

//    void deleteClientInfo(Long id);
//    ClientInfoEntity updateClientInfo(ClientInfoEntity clientInfo);
//    List<ClientInfoEntity> getAllclients();
