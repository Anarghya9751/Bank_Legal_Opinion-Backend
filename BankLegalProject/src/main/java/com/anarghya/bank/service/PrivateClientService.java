package com.anarghya.bank.service;

import java.util.List;

import com.anarghya.bank.entity.PrivateClientChannel;



public interface PrivateClientService {

	public PrivateClientChannel saveClient(PrivateClientChannel pvtclient);
	public PrivateClientChannel getById(Integer pvtclientid);
	public List<PrivateClientChannel> getAll();
	public PrivateClientChannel updateClient(Integer pvtclientid);
	public String deleteById(Integer pvtclientid);
}
