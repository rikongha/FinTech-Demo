package com.decagon.fintech_demo.pojo;

import java.io.Serializable;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CardMessage implements Serializable{/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String scheme;
	private String type;
	private String bank;

}
