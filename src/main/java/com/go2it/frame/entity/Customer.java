package com.go2it.frame.entity;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;

import com.go2it.frame.config.converter.PersonTypeConverter;
import com.go2it.frame.config.converter.StringToIntAttributeConverter;

/**
 * @author Alex Ryzhkov
 */
@Entity
@Table(name = "Persons", uniqueConstraints = { @UniqueConstraint(columnNames = { "PID" }) })
public class Customer {
	//TODO clarify whether ID is required
	//	@GeneratedValue(strategy = GenerationType.AUTO) @Column(name = "id", updatable = false, nullable = false) private int id;
	@Transient private int id;
	@Id @Column(name = "PID", updatable = false, nullable = false, unique = true) private String personId;
	@Column(name = "PName", nullable = false) private String name;
	@Column(name = "PAddress", nullable = false) private String address;
	//TODO clarify the best way to do it
	@Column(name = "PICHID", nullable = false) private String personInChargeId;
	@Column(name = "PPhone", nullable = false) private String phoneNumber;
	@Column(name = "PEmail") private String email;
	@Column(name = "DOBDOI", nullable = false) private LocalDate dateOfBirth;
	//to preserve the String value of enum (default ordinal)
	@Column(name = "Gender", nullable = false) @Convert(converter = PersonTypeConverter.class) private Type type;

	@Column(name = "Auth") @org.hibernate.annotations.Type(type = "numeric_boolean") private boolean hasProvidedAuthorization;
	@Column(name = "Gone") @org.hibernate.annotations.Type(type = "numeric_boolean") private boolean isActiveClient;
	@Column(name = "T1Done", length = 4) @Convert(converter = StringToIntAttributeConverter.class) private int yearT1Done;
	//TODO clarify what does it stand for
	@Column(name = "PEmailC") private String corporationEmail;
	@Column(name = "T2Books") private LocalDate t2Books;
	@Column(name = "FName") private String fullName;
	@Column(name = "MStatus", nullable = false) @Enumerated(EnumType.STRING) private MaritalStatus maritalStatus;
	@Column(name = "Citizen", nullable = false) @org.hibernate.annotations.Type(type = "numeric_boolean") private boolean isCitizen;
	//TODO clarify what it is
	@Column(name = "DepQty") private Short numberOfDependants;
	//TODO check cascade
	@OneToOne(cascade = CascadeType.ALL) @JoinColumn(name = "SPID", referencedColumnName = "PID") private Customer spouse;
	@Column(name = "LoginName") private String loginName;
	@Column(name = "LoginPW") private String password;
	@Column(name = "WebAccess", columnDefinition = "boolean false") @org.hibernate.annotations.Type(type = "numeric_boolean") private boolean hasWebAccess;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPersonId() {
		return personId;
	}

	public void setPersonId(String personId) {
		this.personId = personId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPersonInChargeId() {
		return personInChargeId;
	}

	public void setPersonInChargeId(String personInChargeId) {
		this.personInChargeId = personInChargeId;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public boolean isHasProvidedAuthorization() {
		return hasProvidedAuthorization;
	}

	public void setHasProvidedAuthorization(boolean hasProvidedAuthorization) {
		this.hasProvidedAuthorization = hasProvidedAuthorization;
	}

	public boolean isActiveClient() {
		return isActiveClient;
	}

	public void setActiveClient(boolean activeClient) {
		isActiveClient = activeClient;
	}

	public int getYearT1Done() {
		return yearT1Done;
	}

	public void setYearT1Done(int yearT1Done) {
		this.yearT1Done = yearT1Done;
	}

	public String getCorporationEmail() {
		return corporationEmail;
	}

	public void setCorporationEmail(String corporationEmail) {
		this.corporationEmail = corporationEmail;
	}

	public LocalDate getT2Books() {
		return t2Books;
	}

	public void setT2Books(LocalDate t2Books) {
		this.t2Books = t2Books;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public MaritalStatus getMaritalStatus() {
		return maritalStatus;
	}

	public void setMaritalStatus(MaritalStatus maritalStatus) {
		this.maritalStatus = maritalStatus;
	}

	public boolean isCitizen() {
		return isCitizen;
	}

	public void setCitizen(boolean citizen) {
		isCitizen = citizen;
	}

	public short getNumberOfDependants() {
		return numberOfDependants;
	}

	public void setNumberOfDependants(Short numberOfDependants) {
		this.numberOfDependants = numberOfDependants;
	}

	public Customer getSpouse() {
		return spouse;
	}

	public void setSpouse(Customer spouse) {
		this.spouse = spouse;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isHasWebAccess() {
		return hasWebAccess;
	}

	public void setHasWebAccess(boolean hasWebAccess) {
		this.hasWebAccess = hasWebAccess;
	}

	public enum Type {
		MALE("Male"), FEMALE("Female"), CORPORATION("Corporation");

		private String title;

		Type(String title) {
			this.title = title;
		}

		public String getTitle() {
			return title;
		}

		public static Type getByTitle(String title) {
			for (Type type : Type.values()) {
				if (type.getTitle().equals(title)) {
					return type;
				}
			}
			return null;
		}
	}

	public enum MaritalStatus {
		MARRIED("Married"), COMMON_LAW("Common-law"), WIDOWED("Widowed"), DIVORCED("Divorced"), SEPARATED(
				"Separated"), SINGLE("Sngle");

		private String title;

		MaritalStatus(String title) {
			this.title = title;
		}

		public String getTitle() {
			return title;
		}

		public static MaritalStatus getByTitle(String title) {
			for (MaritalStatus type : MaritalStatus.values()) {
				if (type.getTitle().equals(title)) {
					return type;
				}
			}
			return null;
		}
	}
}