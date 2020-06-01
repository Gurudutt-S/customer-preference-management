package com.cts.superstore.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.superstore.entity.CustomerPreferenceEntity;
import com.cts.superstore.model.CustomerPreference;
import com.cts.superstore.repository.CustomerPreferenceRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CustomerPreferenceService {

	@Autowired
	CustomerPreferenceRepository customerPreferenceRepo;

	public CustomerPreferenceEntity updateCustomerPreference(CustomerPreference customerPreference) {

		log.info(customerPreference.getName());
		Optional<CustomerPreferenceEntity> customerDetail = customerPreferenceRepo.findById(customerPreference.getId());
		CustomerPreferenceEntity customerPreferenceEntity = customerDetail.get();
		log.info(customerPreferenceEntity.getName());
		customerPreferenceEntity.setName(customerPreference.getName());
		customerPreferenceEntity.setDeliveryTimings(customerPreference.getDeliveryTimings());
		customerPreferenceEntity.setEmail(customerPreference.getEmail());
		customerPreferenceEntity.setPhone(customerPreference.getPhone());
		customerPreferenceEntity.setPreferedContact(customerPreference.getPreferedContact());
		customerPreferenceEntity.setHomeAddress(customerPreference.getHomeAddress());
		customerPreferenceEntity.setWorkAddress(customerPreference.getWorkAddress());
		customerPreferenceEntity.setPreferedAddress(customerPreference.getPreferedAddress());
		customerPreferenceEntity.setOfferUpdates(customerPreference.isOfferUpdates());
		customerPreferenceEntity.setAvailableOnSunday(customerPreference.isAvailableOnSunday());
		customerPreferenceEntity.setUpdated(LocalDate.now());
		String updatedBy = customerPreferenceEntity.getName();
		customerPreferenceEntity.setUpdatedBy(updatedBy);
		customerPreferenceEntity.setActive(true);
		customerPreferenceRepo.save(customerPreferenceEntity);
		return customerPreferenceEntity;
	}

	public List<CustomerPreferenceEntity> getAllCustomers() {
		List<CustomerPreferenceEntity> entities = customerPreferenceRepo.findAll();
		List<CustomerPreferenceEntity> allCustomersList = new ArrayList<CustomerPreferenceEntity>();
		for (CustomerPreferenceEntity entity : entities) {
			CustomerPreferenceEntity customerPreferenceEntity = new CustomerPreferenceEntity();
			BeanUtils.copyProperties(entity, customerPreferenceEntity);
			allCustomersList.add(customerPreferenceEntity);
		}
		return allCustomersList;
	}

}
