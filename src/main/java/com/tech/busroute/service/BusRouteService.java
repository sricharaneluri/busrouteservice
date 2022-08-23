package com.tech.busroute.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tech.busroute.model.BusRoute;
import com.tech.busroute.repository.BusRouteRepository;

@Service
public class BusRouteService {
	
	@Autowired
	BusRouteRepository repo;

	public List<BusRoute> getRoute(String source, String destination) {
		
		return repo.findBySourceAndDestination(source, destination);
		
	}

	public List<BusRoute> getAllRoutes() {
		return repo.findAll();
	}

	public BusRoute createRoute(BusRoute busRoute) throws Exception {
//		throw new Exception("testing");
		return repo.save(busRoute);
		
	}

}
