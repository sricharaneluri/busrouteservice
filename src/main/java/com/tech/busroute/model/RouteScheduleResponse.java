package com.tech.busroute.model;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class RouteScheduleResponse {
	private int busRouteId;
	private String source;
	private String destination;
	private String dateScheduled;
	private String departureTime;
	private String arrivalTime;
	private String status;
	private BigDecimal fare;
	private int availableSeats;

}
