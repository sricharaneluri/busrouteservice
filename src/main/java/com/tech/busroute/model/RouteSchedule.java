package com.tech.busroute.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "route_scheduler")
public class RouteSchedule implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int scheduleid;
	
//	@Column(name = "busrouteid")
//	private int busrouteid;
//	
	@Column(name = "date_scheduled")
	private String dateScheduled;
	
	@Column(name = "status")
	private String status;
	
	@Column(name = "fare")
	private BigDecimal fare;
	
	@Column(name = "available_seats")
	private int availableSeats;
	
	@ManyToOne
    private BusRoute route;
	

}
