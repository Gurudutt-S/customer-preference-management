package com.cts.superstore.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.superstore.entity.GenerateReport;
import com.cts.superstore.model.GenerateReportModel;
import com.cts.superstore.repository.GenerateReportRepository;
import com.cts.superstore.validator.GenerateReportValidator;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class GenerateReportServiceImplemenation {

	@Autowired
	GenerateReportRepository generateReportRepo;

	@Autowired
	GenerateReportValidator validator;

	public List<GenerateReportModel> getCustomerUpdatedByDate() {

		List<GenerateReport> entities = generateReportRepo.findAll();
		List<GenerateReportModel> customerList = new ArrayList<GenerateReportModel>();
		Stream<GenerateReport> list = entities.stream();
		Stream<GenerateReport> todaysList = list.filter(a -> a.getUpdated().equals(LocalDate.now()));
		todaysList.forEach(entity -> {
			if (validator.validate(entity)) {
				GenerateReportModel generateReportModel = new GenerateReportModel();
				BeanUtils.copyProperties(entity, generateReportModel);
				customerList.add(generateReportModel);
			}
		});
		log.info("The entities-->{}", entities);
		log.info("The Used fields table is--->{}", customerList);
		LocalDate b = LocalDate.now();
		return customerList;
	}

}
