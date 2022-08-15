package com.nam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.nam.entity.Donator;

public interface IDonatorRepository extends JpaRepository<Donator, Integer>, JpaSpecificationExecutor<Donator> {

	boolean existsByPhone(String phone);

	Donator findByPhone(String phone);

	Donator getByPhone(String phone);

	Donator findAllByPhone(String phone);

}
