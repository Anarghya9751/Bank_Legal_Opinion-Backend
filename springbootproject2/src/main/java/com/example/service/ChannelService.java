package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Channel;
import com.example.repository.ChannelRepository;

@Service
public class ChannelService {
	 @Autowired
	    private ChannelRepository channelRepository;

	    public List<Channel> getAllChannels() {
	        return channelRepository.findAll();
	    }

	    public Channel getChannelById(Long id) {
	        return channelRepository.findById(id).orElse(null);
	    }

	    public Channel saveChannel(Channel channel) {
	        return channelRepository.save(channel);
	    }

	    public void deleteChannel(Long id) {
	        channelRepository.deleteById(id);
	    }

}
