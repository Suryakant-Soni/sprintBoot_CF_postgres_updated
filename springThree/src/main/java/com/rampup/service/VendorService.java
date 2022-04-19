package com.rampup.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rampup.entities.Vendor;
import com.rampup.repository.IVendorRepo;

@Service
public class VendorService {

	@Autowired
	IVendorRepo vendor;

	public List<Vendor> readAllVendors() {
		List<Vendor> vendors = vendor.findAll();
		return vendors;
	};

//	public Vendor getSingleVendorById(String vendorCode) {
//		fillVendor();
//		return vendors.get(vendorCode);
//	};

	public Vendor changeVendor(Vendor payload) {
		Optional<Vendor> singleVendor = vendor.findById(payload.getId());
		if (!singleVendor.isPresent()) {
			return new Vendor((String)"", "","","","","","", null);
		}
		return vendor.save(payload);
	}

	public Vendor createVendor(Vendor myPostBody) {
		return vendor.save(myPostBody);
	};
	
	public List<Vendor> searchByCompanyName(String companyName) {
		return vendor.findByCompanyName(companyName);
	}
	
	public List<Vendor> lookupVendorByGST(String GSTNo){
		return vendor.lookupVendorByGST(GSTNo);
	}

	public Optional<Vendor> getSingleVendor(String code) {
		return vendor.findById(code);
	}

	public String deleteVendor(String code) {
		vendor.deleteById(code);
		return "Vendor Deleted";
	}
}
