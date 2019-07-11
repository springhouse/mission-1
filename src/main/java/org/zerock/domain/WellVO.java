package org.zerock.domain;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor

public class WellVO {
	private Integer well_supply;
	private String username;
	private Integer amount;
	private Integer total;
	private Boolean status;
	private Date dateEntered;
	private Date dateUpdated; 
}
