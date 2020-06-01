package com.cts.superstore.entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.annotations.NaturalId;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "customer")
@AllArgsConstructor
@NoArgsConstructor
public @Data class CustomerEntity implements Serializable {

	private static final long serialVersionUID = 394014962190928933L;

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
