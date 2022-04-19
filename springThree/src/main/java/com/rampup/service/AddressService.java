package com.rampup.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rampup.entities.Address;
import com.rampup.repository.IAddressRepo;

@Service
public class AddressService {

	@Autowired
	IAddressRepo oAddressRepo;
	
	public List<Address> readAllAddress(){
		 return oAddressRepo.findAll();
	}
	
	public Address saveAddress(Address payload) {
		return oAddressRepo.save(payload);
	}
}
