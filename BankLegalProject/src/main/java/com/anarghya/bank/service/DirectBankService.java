package com.anarghya.bank.service;

import java.util.List;

import com.anarghya.bank.entity.DirectBankChannel;

public interface DirectBankService {

	public DirectBankChannel saveDirectBankChannel(DirectBankChannel directBankChannel);

	public List<DirectBankChannel> getAllDirectBankChannels();

	public DirectBankChannel getDirectBankChannelById(Integer bankId);

	public DirectBankChannel updateDirectBankChannel(Integer bankId, DirectBankChannel directBankChannelDetails);

	public String deleteDirectBankChannel(Integer bankId);

}
