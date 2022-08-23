package com.tech.busroute.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tech.busroute.model.BaseResponse;
import com.tech.busroute.model.BusRoute;
import com.tech.busroute.model.RouteSchedule;
import com.tech.busroute.service.RouteSchedulerService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class RouteSchedulerController {
	
	@Autowired
	RouteSchedulerService schedulerService;
	
	@GetMapping("/routeSchedule/getRouteSchedule/{id}")
	public ResponseEntity<BaseResponse> getRouteSchedule(@PathVariable int id){
		BaseResponse response = new BaseResponse();
		try {
//			List<BusRoute> busRouteResponse = busRouteService.getRoute(source,destination);
			
		}catch(Exception e) {
			log.info("Failed to get route schedule with Exception :", e);
			response.setCode(500);
			response.setResponseData(e.getMessage());
			response.setDescription("Error");
			
		}
		return new ResponseEntity<>(response, HttpStatus.OK);
		
	}
	
	
	@PostMapping("/routeSchedule/createSchedule")
	public ResponseEntity<BaseResponse> creatSchedule(@RequestBody RouteSchedule routeSchedule) {
		BaseResponse response = new BaseResponse();
		try {
			RouteSchedule scheduleResponse = schedulerService.createSchedule(routeSchedule);
			if(scheduleResponse != null) {
				response.setCode(201);
				response.setResponseData(scheduleResponse);
				response.setDescription("Route Scheduled successfully");
			}
		}catch(Exception e) {
			log.info("Failed to create route schedule with Exception :", e);
			response.setCode(500);
			response.setResponseData(e.getMessage());
			response.setDescription("Error");
		}
		return new ResponseEntity<>(response, HttpStatus.OK);
		
	}

}
