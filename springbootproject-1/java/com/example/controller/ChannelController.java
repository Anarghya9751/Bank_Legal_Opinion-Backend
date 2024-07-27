package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.entity.Channel;
import com.example.service.ChannelService;

public class ChannelController {
	  @Autowired
	    private ChannelService channelService;

	    @GetMapping
	    public List<Channel> getAllChannels() {
	        return channelService.getAllChannels();
	    }

	    @GetMapping("/{id}")
	    public Channel getChannelById(@PathVariable Long id) {
	        return channelService.getChannelById(id)
	;
	    }

	    @PostMapping
	    public Channel createChannel(@RequestBody Channel channel) {
	        return channelService.saveChannel(channel);
	    }

	    @PutMapping("/{id}")
	    public Channel updateChannel(@PathVariable Long id, @RequestBody Channel channel) {
	        channel.setId(id)
	;
	        return channelService.saveChannel(channel);
	    }

	    @DeleteMapping("/{id}")
	    public void deleteChannel(@PathVariable Long id) {
	        channelService.deleteChannel(id)
	;
	    }
	


}
