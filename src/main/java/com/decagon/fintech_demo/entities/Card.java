package com.decagon.fintech_demo.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Card implements Serializable{/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@Column(unique = true)
	private String number;
	private boolean hasData;
	private String scheme;
	private String type;
	private String bank;
	@Column(updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateAdded;
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateUpdated;
	
	@PrePersist
	private void setAddedDate() {
		this.dateAdded = new Date();
	}
	
	@PreUpdate
	private void setUpdatedDate() {
		this.dateUpdated = new Date();
	}
	
	@Override
	public boolean equals(Object obj) {

		return this.id.equals(((Card) obj).getId());

	}

}
