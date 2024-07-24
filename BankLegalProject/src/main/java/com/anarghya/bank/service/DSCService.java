package com.anarghya.bank.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.anarghya.bank.entity.DSCChannel;
import com.anarghya.bank.entity.PricingEntity;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Lob;



public interface DSCService {

	public DSCChannel saveDSC(MultipartFile mou,Integer dscid,String dscname, String directorname,
	Long phnum, String email,List<PricingEntity> pricing);
	
	public DSCChannel getById(Integer dscid);
	public List<DSCChannel> getAll();
	public DSCChannel updateDSC(Integer dscid);
	public String deleteById(Integer dscid);
}
