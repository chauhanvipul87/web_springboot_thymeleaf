package com.iana.services;

import java.util.Map;

public interface GreetingService {

	String getConnectedDatabaseProductName() throws Exception;
	Map<String, Object> getUserDetailsFromUIIA() throws Exception;
	Map<String, Object> getUserDetailsFromEquipReturn() throws Exception;
	Map<String, Object> getUserDetailsFromGIER() throws Exception;

}
