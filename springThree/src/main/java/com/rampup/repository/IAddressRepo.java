package com.rampup.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rampup.entities.Address;

public interface IAddressRepo extends JpaRepository<Address, String> {

}
