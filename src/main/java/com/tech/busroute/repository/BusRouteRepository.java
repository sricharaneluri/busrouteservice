package com.tech.busroute.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tech.busroute.model.BusRoute;

public interface BusRouteRepository extends JpaRepository<BusRoute, Integer> {
	  List<BusRoute> findBySourceAndDestination(String source, String destination);
	  List<BusRoute> findAll();
	  BusRoute save(BusRoute busRoute);
	}