package com.anarghya.bank.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anarghya.bank.entity.PrivateClientChannel;
import com.anarghya.bank.repository.PrivateClientRepository;

@Service
public class PrivateClientServiceImp implements PrivateClientService{

	@Autowired
	private PrivateClientRepository pvtclientRepo;
	

	@Override
	public PrivateClientChannel getById(Integer pvtclientid) {
		// TODO Auto-generated method stub
		return pvtclientRepo.findById(pvtclientid).get();
	}

	@Override
	public List<PrivateClientChannel> getAll() {
		// TODO Auto-generated method stub
		return pvtclientRepo.findAll();
	}

	@Override
	public String deleteById(Integer pvtclientid) {
		// TODO Auto-generated method stub
		pvtclientRepo.deleteById(pvtclientid);
		return "Deleted Successfully";
	}

	@Override
	public PrivateClientChannel saveClient(PrivateClientChannel pvtclient) {
		// TODO Auto-generated method stub
		return pvtclientRepo.save(pvtclient);
	}

	@Override
	public PrivateClientChannel updateClient(Integer pvtclientid) {
		// TODO Auto-generated method stub
		return pvtclientRepo.findById(pvtclientid).get();
	}

}
