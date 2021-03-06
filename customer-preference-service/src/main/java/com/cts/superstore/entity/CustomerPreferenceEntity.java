package com.cts.superstore.entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "customer")
@NoArgsConstructor
@AllArgsConstructor
public @Data class CustomerPreferenceEntity implements Serializable {

	private static final long serialVersionUID = -8370977052740734405L;
	@Id
	@GeneratedValue
	private int id;
	private int custId;
	private String name;
	private long phone;
	private String email;
	private String preferedContact;
	private String workAddress;
	private String homeAddress;
	private String preferedAddress;
	private String deliveryTimings;
	private boolean offerUpdates=false;
	private boolean availableOnSunday=false;
	private LocalDate created;
	private String createdBy;
	private LocalDate updated;
	private String updatedBy;
	private boolean isActive;

}