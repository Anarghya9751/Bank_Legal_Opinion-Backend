package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Channel;
import com.example.exception.ChannelNotFoundException;
import com.example.exception.InvalidChannelException;
import com.example.service.ChannelService;

@RestController
@ControllerAdvice
@RequestMapping("/api/channel")

public class ChannelController 
{
	  @Autowired
	    private ChannelService channelService;

	    @GetMapping("/getall")
	    public List<Channel> getAllChannels() 
	    {
	        return channelService.getAllChannels();
	    }

	    @GetMapping("/{id}")
	    public ResponseEntity <Channel> getChannelById(@PathVariable Long id)
	    {
	    	 try {
	             
	    	Channel channel = channelService.getChannelById(id);
	             return ResponseEntity.ok(channel);
	         } 
	    	 catch (ChannelNotFoundException e)
	    	 {
	             return ResponseEntity.notFound().build();
	         }
	
	    }

	    @PostMapping("/create")
	    public ResponseEntity<Channel> createchannel(@RequestBody Channel channel)
	    {
	    	try 
	    	{
	    		Channel channel1 = channelService.createChannel(channel);
	    		 return ResponseEntity.ok(channel1);
	    	}
	    	catch(InvalidChannelException ex)
	    	{
	    		return ResponseEntity.badRequest().body(null);
	    }
	    }
	    @PutMapping("/{id}")
	 public ResponseEntity <Channel> updateChannel(@PathVariable Long id, @RequestBody Channel channel)
	    {
	       // channel.setId(id);
	        //return channelService.createChannel(channel);
	    	try
	    	{
	            Channel existingChannel = channelService.getChannelById(id);
	            channel.setId(id);
	            Channel updatedChannel = channelService.createChannel(channel);
	            return ResponseEntity.ok(updatedChannel);
	        } 
	    	catch (ChannelNotFoundException e) 
	    	{
	            return ResponseEntity.notFound().build();
	        }
	    	catch (InvalidChannelException e)
	    	{
	        	
	            return ResponseEntity.badRequest().body(null);
	        }
	    
	       }

	    @DeleteMapping("/{id}")
	    public ResponseEntity<Object> deletechannel(@PathVariable Long id) {
	        //channelService.deleteChannel(id)
	    
	    	try {
	            channelService.deleteChannel(id);
	            return ResponseEntity.noContent().build();
	        } catch (InvalidChannelException e) {
	            return ResponseEntity.notFound().build();
	        }
	    }
	    }
	



