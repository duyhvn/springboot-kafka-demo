package com.javainuse.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "guest")
@Getter
@Setter
public class Guest extends AuditModel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8869919559225908736L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long guestId;

	@Column(columnDefinition = "VARCHAR", length = 100)
	private String name;
	@Column(columnDefinition = "VARCHAR", length = 200)
	private String email;
	@Column(columnDefinition = "SMALLINT")
	private int noAttendance;

	@Column(columnDefinition = "VARCHAR", length = 20)
	private String eventType;
	@Column(columnDefinition = "TEXT", length = 1000)
	private String message;

	private Boolean isPublishMessage;
}
