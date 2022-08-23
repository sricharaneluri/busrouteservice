package com.tech.busroute.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.tech.busroute.model.BaseResponse;
import com.tech.busroute.model.BusRoute;
import com.tech.busroute.service.BusRouteService;

import lombok.extern.slf4j.Slf4j;


@RestController
@Slf4j
public class BusRouteController {
	
	public static final String SUCCESS_MSG = "Bus Information retrieved successfully";
	public static final String ERROR_MSG = "Failed to retrieve Bus Information ";

	@Autowired
	BusRouteService busRouteService;
	
	@GetMapping("/busRoutes/from/{source}/to/{destination}")
	public ResponseEntity<BaseResponse> getRoute(@PathVariable String source, @PathVariable String destination) {
		BaseResponse response = new BaseResponse();
		try {
			List<BusRoute> busRouteResponse = busRouteService.getRoute(source,destination);
			if(busRouteResponse != null) {
				log.info("Route retrieved successfully");
				response.setCode(200);
				response.setResponseData(busRouteResponse);
				response.setDescription(SUCCESS_MSG);
			} else {
				response.setCode(200);
				response.setResponseData("No Bus routes Available for the Source: " +source + " and Destination: "+destination);
				response.setDescription("Please check later");
			}
			
		} catch(Exception e) {
			log.info("Failed to get route details with Exception :", e);
			response.setCode(500);
			response.setResponseData(e.getMessage());
			response.setDescription(ERROR_MSG);
			
		}
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@GetMapping("/busRoutes/AllAvailableRoutes")
	public ResponseEntity<BaseResponse> getRoute() {
		BaseResponse response = new BaseResponse();
		try {
			List<BusRoute> busRouteResponse = busRouteService.getAllRoutes();
			if(busRouteResponse.size() > 0) {
				response.setCode(200);
				response.setResponseData(busRouteResponse);
				response.setDescription(SUCCESS_MSG);
			} else {
				response.setCode(200);
				response.setResponseData("No Bus routes Available");
				response.setDescription("Please check later");
			}
			
		} catch(Exception e) {
			log.info("Failed to get route details with Exception :", e);
			response.setCode(500);
			response.setResponseData(e.getMessage());
			response.setDescription(ERROR_MSG);
			return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@PostMapping("/busRoutes/createRoute")
	public ResponseEntity<BaseResponse> createRoute(@RequestBody BusRoute busRoute) {
		BaseResponse response = new BaseResponse();
		try {
			BusRoute busRouteResponse = busRouteService.createRoute(busRoute);
			
			response.setCode(200);
			response.setResponseData(busRouteResponse);
			response.setDescription("New route has been successfully created");
			log.info("Route created successfully");
		}catch(Exception e) {
			log.info("Failed to create route details with Exception :", e);
			response.setCode(500);
			response.setResponseData(e.getMessage());
			response.setDescription("Failed to create route details");
			return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(response, HttpStatus.CREATED);
		
	}

}
