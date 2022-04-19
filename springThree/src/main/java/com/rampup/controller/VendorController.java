package com.rampup.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rampup.entities.Vendor;
import com.rampup.service.VendorService;

@RestController

public class VendorController {

	@Autowired
	VendorService vendorService;

	@RequestMapping("/vendor")
	public List<Vendor> getVendors() {
		return vendorService.readAllVendors();
	}

	@RequestMapping("/vendor/{vendorCode}")
	public Vendor getVendorById(@PathVariable("vendorCode") String code) {
		Optional<Vendor> searchResult = vendorService.getSingleVendor(code);
		if(!searchResult.isPresent()) {
			return new Vendor((String)"", "","","","","","", null);
		}
		return searchResult.get();
	}

	@PostMapping("/vendor")
	public Vendor createVendor(@RequestBody Vendor myPostBody) {
		return vendorService.createVendor(myPostBody);
	};
	
	@RequestMapping("/vendor/search")
	public List<Vendor> searchByCompany(@RequestParam String company) {
		return vendorService.searchByCompanyName(company);
	}
	
	@RequestMapping("/vendor/lookup/{GSTNo}")
	public List<Vendor> searchVendorByGST(@PathVariable("GSTNo") String GSTNo) {
		return vendorService.lookupVendorByGST(GSTNo);
	}
	
	

	@RequestMapping(method = RequestMethod.PUT, value = "/changeVendor")
	public Vendor updateVendor(@RequestBody Vendor vendor) {
		return vendorService.changeVendor(vendor);
	};

	@DeleteMapping("/vendor/{vendorCode}")
	public String deleteVendor(@PathVariable("vendorCode") String code) {
		return vendorService.deleteVendor(code);

	}
}
