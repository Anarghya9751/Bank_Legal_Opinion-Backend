package com.anarghya.bank.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anarghya.bank.entity.BranchEntity;
import com.anarghya.bank.entity.DirectBankChannel;
import com.anarghya.bank.entity.PricingEntity;
import com.anarghya.bank.exception.IdNotFoundException;
import com.anarghya.bank.repository.BranchRepository;
import com.anarghya.bank.repository.DirectBankRepository;

import jakarta.transaction.Transactional;

@Service
public class DirectBankServiceImp implements DirectBankService {

	@Autowired
	private DirectBankRepository directBankChannelRepository;
	@Autowired
	private BranchRepository branchEntityRepository;

//	@Override
//	@Transactional
//	public DirectBankChannel saveDirectBankChannel(DirectBankChannel directBankChannel) {
//		
//		List<BranchEntity> branches = directBankChannel.getBranches().stream()
//				.map(branch -> branchEntityRepository.findById(branch.getBranchId()).orElseThrow(
//						() -> new IllegalArgumentException("Branch with id " + branch.getBranchId() + " not found")))
//				.collect(Collectors.toList());
//
//		for (BranchEntity branch : branches) {
//			branch.setDirectbank(directBankChannel);
//		}
////		directBankChannel.setBranches(branches);
////
////		
////		for (PricingEntity pricing : directBankChannel.getPricing()) {
////			pricing.setDirectbank(directBankChannel);
////		}
//
//		return directBankChannelRepository.save(directBankChannel);
//	}

	@Override
	public List<DirectBankChannel> getAllDirectBankChannels() {
		return directBankChannelRepository.findAll();
	}

	@Override
	public DirectBankChannel getDirectBankChannelById(Integer bankId) {
		return directBankChannelRepository.findById(bankId)
				.orElseThrow(() -> new IdNotFoundException("DirectBankChannel not found with id: " + bankId));
	}

	@Override
	public DirectBankChannel updateDirectBankChannel(Integer bankId, DirectBankChannel directBankChannelDetails) {
		DirectBankChannel existingDirectBankChannel = directBankChannelRepository.findById(bankId)
				.orElseThrow(() -> new IdNotFoundException("DirectBankChannel not found with id: " + bankId));

		existingDirectBankChannel.setBankName(directBankChannelDetails.getBankName());
		existingDirectBankChannel.setBranchManagerName(directBankChannelDetails.getBranchManagerName());
		existingDirectBankChannel.setPhoneNumber(directBankChannelDetails.getPhoneNumber());
		existingDirectBankChannel.setEmail(directBankChannelDetails.getEmail());
		existingDirectBankChannel.setRegistrationDate(directBankChannelDetails.getRegistrationDate());
		existingDirectBankChannel.setReferenceNumber(directBankChannelDetails.getReferenceNumber());

		
//        existingDirectBankChannel.setBranches(directBankChannelDetails.getBranches());
//        existingDirectBankChannel.setPricing(directBankChannelDetails.getPricing());

		
		return directBankChannelRepository.save(existingDirectBankChannel);
	}

	@Override
	public String deleteDirectBankChannel(Integer bankId) {
		DirectBankChannel directBankChannel = directBankChannelRepository.findById(bankId)
				.orElseThrow(() -> new IdNotFoundException("DirectBankChannel not found with id: " + bankId));

		directBankChannelRepository.delete(directBankChannel);
		return "DirectBankChannel with id " + bankId + " has been deleted successfully.";
	}

	@Override
	public DirectBankChannel saveDirectBankChannel(DirectBankChannel directBankChannel) {
		return directBankChannelRepository.save(directBankChannel);
	}
}
