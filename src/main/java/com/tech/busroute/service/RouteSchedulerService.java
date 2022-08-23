package com.tech.busroute.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tech.busroute.model.RouteSchedule;
import com.tech.busroute.repository.RouteScheduleRepository;

@Service
public class RouteSchedulerService {
	
	@Autowired
	RouteScheduleRepository scheduleRepo;

	public RouteSchedule createSchedule(RouteSchedule routeSchedule) {
		// TODO Auto-generated method stub
		return scheduleRepo.save(routeSchedule);
	}

}
