package com.tech.busroute.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tech.busroute.model.RouteSchedule;

public interface RouteScheduleRepository extends JpaRepository<RouteSchedule, Integer> {
	
	RouteSchedule save(RouteSchedule routeSchedule);

}
