package com.anarghya.bank.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anarghya.bank.entity.DirectBankChannel;
import com.anarghya.bank.exception.IdNotFoundException;
import com.anarghya.bank.repository.DirectBankRepository;

@Service
public class DirectBankServiceImp implements DirectBankService {

    @Autowired
    private DirectBankRepository directBankChannelRepository;

    @Override
    public DirectBankChannel saveDirectBankChannel(DirectBankChannel directBankChannel) {
        // Save the DirectBankChannel entity
        DirectBankChannel savedChannel = directBankChannelRepository.save(directBankChannel);

        // Return the saved entity with all associated data
        return savedChannel;
    }

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

        // Update branches and pricing
        existingDirectBankChannel.setBranches(directBankChannelDetails.getBranches());
        existingDirectBankChannel.setPricing(directBankChannelDetails.getPricing());

        // Save and return the updated entity
        return directBankChannelRepository.save(existingDirectBankChannel);
    }

    @Override
    public String deleteDirectBankChannel(Integer bankId) {
        DirectBankChannel directBankChannel = directBankChannelRepository.findById(bankId)
                .orElseThrow(() -> new IdNotFoundException("DirectBankChannel not found with id: " + bankId));

        directBankChannelRepository.delete(directBankChannel);
        return "DirectBankChannel with id " + bankId + " has been deleted successfully.";
    }
}
