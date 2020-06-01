package com.cts.superstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cts.superstore.entity.CustomerPreferenceEntity;

@Repository
public interface CustomerPreferenceRepository extends JpaRepository<CustomerPreferenceEntity, Integer> {

}
