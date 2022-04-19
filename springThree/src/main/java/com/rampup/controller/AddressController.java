package com.rampup.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rampup.entities.Address;
import com.rampup.service.AddressService;

@RestController
public class AddressController {

	
	@Autowired
	AddressService  addressService;
	
	@RequestMapping("/address")
	public List<Address> getAddress(){
		return addressService.readAllAddress();
	}
	
	@PostMapping("/address")
	public Address postAddress(@RequestBody Address payload) {
		return addressService.saveAddress(payload);
	}
	
	
}
