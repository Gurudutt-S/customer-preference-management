package com.cts.superstore.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public @Data class GenerateReportModel {

	private int id;
	private int custId;
	private String name;
	private String preferedContact;
	private String preferedAddress;
	private String deliveryTimings;
	private boolean offerUpdates;
	private boolean availableOnSunday;
	private LocalDate updated;
	private String updatedBy;

}
