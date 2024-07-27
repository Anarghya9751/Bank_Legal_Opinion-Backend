package com.anarghya.bank.service;

import java.util.List;
import org.springframework.web.multipart.MultipartFile;
import com.anarghya.bank.entity.DSCChannel;

public interface DSCService {

	public DSCChannel saveDSC(DSCChannel dsc, MultipartFile mou);

	public DSCChannel getById(Integer dscid);

	public List<DSCChannel> getAll();

	public String deleteById(Integer dscid);

	public DSCChannel updateDSC(Integer dscid, DSCChannel dscDetails, MultipartFile mou);
	
	
	
}
