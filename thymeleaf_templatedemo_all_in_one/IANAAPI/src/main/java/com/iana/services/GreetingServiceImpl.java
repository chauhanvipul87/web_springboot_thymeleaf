package com.iana.services;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iana.repository.GreetingDAO;

@Service
public class GreetingServiceImpl implements GreetingService{

	
	@Autowired
	private GreetingDAO greetingDAO;
	   
	@Override
	public String getConnectedDatabaseProductName() throws Exception {
		return greetingDAO.getConnectedDatabaseProductName();
	}

	@Override
	public Map<String, Object> getUserDetailsFromUIIA() throws Exception {
		return greetingDAO.getUserDetailsFromUIIA();
	}

	@Override
	public Map<String, Object> getUserDetailsFromEquipReturn() throws Exception {
		return greetingDAO.getUserDetailsFromEquipReturn();
	}

	@Override
	public Map<String, Object> getUserDetailsFromGIER() throws Exception {
		return greetingDAO.getUserDetailsFromGIER();
	}

}
