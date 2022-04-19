package com.rampup.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.rampup.entities.Vendor;

public interface IVendorRepo extends JpaRepository<Vendor, String> {

	
	List<Vendor> findByCompanyName(String companyName);
	
	//Custom query API
	@Query(nativeQuery = true, value = "SELECT * FROM public.vendor where lower(GST_NO) like %?1%")
	List<Vendor> lookupVendorByGST(String GSTNo);
}
