package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Channel;
import com.example.exception.ChannelNotFoundException;
import com.example.exception.InvalidChannelException;
import com.example.repository.ChannelRepository;
@Service

public class ChannelService {
	 @Autowired
	    private ChannelRepository channelRepository;

	    public List<Channel> getAllChannels() {
	        return channelRepository.findAll();
	    }

	    //public Channel getChannelById(Long id) {
	       // return channelRepository.findById(id).orElse(null);
	   // }
	    public Channel getChannelById(Long id) {
	        Optional<Channel> channel = channelRepository.findById(id);
	        if (channel.isEmpty()) {
	            throw new InvalidChannelException("Channel with ID " + id + " not found.");
	        }
	        return channel.get();
	    }
	    
	    
	    
	    public Channel createChannel(Channel channel) {
	       
	    	
	    	if (channel.getName() == null || channel.getName().isEmpty()) {
	            throw new ChannelNotFoundException("Channel name cannot be null or empty.");
	        }
	       
	        return channelRepository.save(channel);
	        }


	   
	    public void deleteChannel(Long id) {
	        //channelRepository.deleteById(id);
	    	if (!channelRepository.existsById(id)) {
	            throw new ChannelNotFoundException("Channel not found with id: " + id);
	        }
	        channelRepository.deleteById(id);
	    }
	}

